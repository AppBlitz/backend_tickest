package com.example.uniquindio.spring.service.imp.invoice;

import com.example.uniquindio.spring.exception.invoice.ShoppingCartNullException;
import com.example.uniquindio.spring.model.documents.ShoppingCart;
import com.example.uniquindio.spring.model.documents.User;
import com.example.uniquindio.spring.model.vo.information.UserInformation;
import com.example.uniquindio.spring.model.vo.items.Item;
import com.example.uniquindio.spring.model.vo.items.Ticket;
import com.example.uniquindio.spring.repository.UserRepository;
import com.example.uniquindio.spring.service.imp.user.UserService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.uniquindio.spring.repository.ShoppingCartRepository;
import com.example.uniquindio.spring.service.interfaces.invoice.IShoppingCartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShoppingCartService implements IShoppingCartService {

    @Autowired
    ShoppingCartRepository shoppingCartRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(ShoppingCartService.class);

    @Override
    public boolean addItem(Ticket ticket, int cant, String idUser) {
        Optional<User> userOpt = userRepository.findById(idUser);
        if (!userOpt.isPresent()) {
            logger.error("User not found with ID: " + idUser);
            return false;
        }
        User user = userOpt.get();
        Optional<ShoppingCart> cartOptional = shoppingCartRepository.findById(user.getIdShoppingCart());

        if (cartOptional.isPresent()) {
            ShoppingCart cart = cartOptional.get();
            if (cart.getItems() == null) {
                cart.setItems(new ArrayList<>());  // Inicializa la lista si está vacía
            }
            Item item = new Item();
            item.setId(cart.getItems().size());
            item.setCant(cant);
            item.setTicket(ticket);
            cart.getItems().add(item);  // Agrega el item al carrito
            shoppingCartRepository.save(cart);  // Guarda el carrito actualizado
            return true;
        } else {
            logger.error("Shopping cart not found for user: " + user.getIdentificationNumber());
            return false;
        }
    }

    @Override
    public boolean deleteItem(Integer idItem, String idUser) throws ShoppingCartNullException {
        Optional<User> userOpt = userRepository.findById(idUser);
        if (!userOpt.isPresent()) {
            logger.error("User not found with ID: " + idUser);
            return false;
        }
        User user = userOpt.get();
        Optional<ShoppingCart> cartOptional = shoppingCartRepository.findById(user.getIdShoppingCart());

        if (cartOptional.isPresent()) {
            ShoppingCart cart = cartOptional.get();
            if (cart.getItems() == null || cart.getItems().isEmpty()) {
                throw new ShoppingCartNullException("No se puede eliminar el item: " + idItem + " porque el carrito está vacío");
            }
            // Busca el item por su ID, no por su índice en la lista
            cart.getItems().removeIf(item -> item.getId() == (idItem));
            cart.setItems(updateItemsIds(cart.getItems()));
            shoppingCartRepository.save(cart);  // Guarda el carrito actualizado
            return true;
        } else {
            logger.error("Shopping cart not found for user: " + user.getIdentificationNumber());
            return false;
        }
    }

    @Override
    public boolean addUser(String idCart, String idUser) {
        try {
            Optional<ShoppingCart> cartOpt = shoppingCartRepository.findById(idCart);
            if (!cartOpt.isPresent()) {
                logger.error("Cart not found with ID: " + idCart);
                return false;
            }

            Optional<User> userOpt = userRepository.findById(idUser);
            if (!userOpt.isPresent()) {
                logger.error("User not found with ID: " + idUser);
                return false;
            }

            ShoppingCart cart = cartOpt.get();
            User user = userOpt.get();
            UserInformation userInformation = userService.getInformation(user);
            cart.setUserInformation(userInformation);
            shoppingCartRepository.save(cart);
            return true;
        } catch (Exception e) {
            logger.error("Error adding user to cart: ", e);
            return false;
        }
    }

    private List<Item> updateItemsIds(@NonNull List<Item> items) {
        int i = 1;
        for (Item item : items) {
            item.setId(i);
            i++;
        }
        return items;
    }
}

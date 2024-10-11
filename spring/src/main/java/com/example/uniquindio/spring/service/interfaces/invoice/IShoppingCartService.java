package com.example.uniquindio.spring.service.interfaces.invoice;

import com.example.uniquindio.spring.exception.invoice.ShoppingCartNullException;
import com.example.uniquindio.spring.model.vo.items.Ticket;

/**
 * Interface for shopping cart services.
 * Defines methods for managing items within a shopping cart.
 */
public interface IShoppingCartService {

    /**
     * Adds an item to the shopping cart for a specified user.
     *
     * @param ticket the ticket to be added to the cart
     * @param cant the quantity of the ticket to add
     * @param idUser the ID of the user whose cart is being updated
     * @return true if the item is successfully added, false otherwise
     */
    boolean addItem(Ticket ticket, int cant, String idUser);

    /**
     * Deletes an item from the shopping cart for a specified user.
     *
     * @param idItem the ID of the item to delete
     * @param idUser the ID of the user whose cart is being updated
     * @throws ShoppingCartNullException if the shopping cart is null
     * @return true if the item is successfully deleted, false otherwise
     */
    boolean deleteItem(Integer idItem, String idUser) throws ShoppingCartNullException;

    /**
     * Adds a user to a specified shopping cart.
     *
     * @param idCart the ID of the shopping cart
     * @param idUser the ID of the user to add to the cart
     * @return true if the user is successfully added, false otherwise
     */
    boolean addUser(String idCart, String idUser);
}

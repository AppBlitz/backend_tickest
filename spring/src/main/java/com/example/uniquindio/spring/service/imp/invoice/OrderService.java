package com.example.uniquindio.spring.service.imp.invoice;

import com.example.uniquindio.spring.dto.emaildto.EmailDTO;
import com.example.uniquindio.spring.dto.invoicedto.OrderDTO;
import com.example.uniquindio.spring.dto.invoicedto.OrderInformationDTO;
import com.example.uniquindio.spring.dto.invoicedto.ShoppingCartDto;
import com.example.uniquindio.spring.exception.email.EmailInvalidException;
import com.example.uniquindio.spring.exception.invoice.QRGenerationException;
import com.example.uniquindio.spring.model.documents.Invoice;
import com.example.uniquindio.spring.model.documents.PurchaseOrder;
import com.example.uniquindio.spring.model.documents.ShoppingCart;
import com.example.uniquindio.spring.model.documents.User;
import com.example.uniquindio.spring.model.vo.information.UserInformation;
import com.example.uniquindio.spring.model.vo.items.Item;
import com.example.uniquindio.spring.model.vo.items.Ticket;
import com.example.uniquindio.spring.model.vo.payment.Coupon;
import com.example.uniquindio.spring.model.vo.payment.Pay;
import com.example.uniquindio.spring.repository.OrderRepository;
import com.example.uniquindio.spring.repository.ShoppingCartRepository;
import com.example.uniquindio.spring.repository.UserRepository;
import com.example.uniquindio.spring.service.imp.email.EmailService;
import com.example.uniquindio.spring.service.imp.user.UserService;
import com.example.uniquindio.spring.service.interfaces.invoice.IOrderService;
import com.example.uniquindio.spring.service.interfaces.utils.IQRGeneration;
import com.example.uniquindio.spring.utils.QRCodeGenerator;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.DecimalMin;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements IQRGeneration, IOrderService {

    @Autowired
    EmailService emailService;
    @Autowired
    QRCodeGenerator qrCodeGenerator;
    @Autowired
    UserService userService;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    ShoppingCartRepository shoppingCartRepository;

    @Override
    public boolean createOrder(@NonNull ShoppingCartDto shoppingCartDto) {
        try {
            User user = userService.findByEmail(shoppingCartDto.email()).get();
            PurchaseOrder order = new PurchaseOrder();
            ShoppingCart shoppingCart = new ShoppingCart();
            UserInformation userInformation = new UserInformation();


            userInformation.setId(shoppingCartDto.indentificationNumber());
            userInformation.setEmail(shoppingCartDto.email());
            userInformation.setPhoneNumber(shoppingCartDto.phoneNumber());
            userInformation.setAddress(shoppingCartDto.address());
            userInformation.setFullName(shoppingCartDto.nameUser());


            shoppingCart.setItems(shoppingCartDto.items());
            shoppingCart.setUserInformation(userInformation);
            order.setShoppingCart(shoppingCart);
            order.setCredit(calculateCredit(shoppingCartDto.items()));
            orderRepository.save(order);
            return true;

        } catch (EmailInvalidException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Double calculateCredit(@NonNull List<Item> itemList) {
        Double price=0.0;
        for (Item item: itemList){
            price += item.getCant() * item.getTicket().getLocality().getPrice();
        }
        return price;
    }

    @Override
    public Double calculateDebit(@NonNull List<Coupon> couponList, Double credit) {
        Double percentage = 0.0;
        Double discount = 0.0;
        for (Coupon coupon : couponList){
             percentage += coupon.getDiscount_percentage();
        }
        discount = credit*percentage;
        return discount;
    }

    @Override
    public boolean applyCoupon(Coupon coupon, String idUser) {
        try {
            User user = userRepository.findById(idUser).get();
            PurchaseOrder order = orderRepository.findByShoppingCart(shoppingCartRepository.findById(user.getIdShoppingCart()).get()).get();
            order.getCouponList().add(coupon);
            order.setDebit(calculateDebit(order.getCouponList(), order.getCredit()));
            order.setTotal(order.getCredit() - order.getDebit());
            orderRepository.save(order);
            return true;
        }catch (Exception e){
            return  false;
        }

    }



    @Override
    public OrderInformationDTO getOrderInformation(OrderDTO orderDTO) {
        return new OrderInformationDTO(
                orderDTO.purchaseOrderNumber(),
                orderDTO.debit(),
                orderDTO.credit(),
                orderDTO.total(),
                orderDTO.couponList(),
                orderDTO.shoppingCart().getItems(),
                orderDTO.shoppingCart().getUserInformation().getFullName()
        );

    }

    public PurchaseOrder getOrderById(String id) throws Exception {
        Optional<PurchaseOrder> order = orderRepository.findById(id);
        if(order.isPresent()){
            return order.get();
        }else{
            throw new Exception("orden no encontrada");
        }
    }

    public void saveOrder(PurchaseOrder order){

        orderRepository.save(order);

    }

    @Override
    public byte[] generateQR(String idOreder) throws QRGenerationException{

        try {
            byte[] qrCodeImage = qrCodeGenerator.generateQRCodeImage(idOreder, 250, 250);
            return qrCodeImage;
        } catch (Exception e) {
            e.printStackTrace();
            throw new QRGenerationException("");
        }


    }

    @Override
    public boolean saveQR(String QR) {
        return false;
    }
}

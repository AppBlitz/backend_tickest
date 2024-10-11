package com.example.uniquindio.spring.service.interfaces.invoice;

import com.example.uniquindio.spring.dto.invoicedto.OrderDTO;
import com.example.uniquindio.spring.dto.invoicedto.ShoppingCartDto;
import com.example.uniquindio.spring.model.documents.PurchaseOrder;
import com.example.uniquindio.spring.model.vo.items.Item;
import com.example.uniquindio.spring.model.vo.items.Ticket;
import com.example.uniquindio.spring.model.vo.payment.Coupon;
import com.example.uniquindio.spring.model.vo.payment.Pay;
import lombok.NonNull;

import java.util.List;

/**
 * Interface for order services.
 * Defines methods for creating and managing purchase orders.
 */
public interface IOrderService {

    /**
     * Creates a new order based on the provided shopping cart data.
     *
     * @param shoppingCartDto the data transfer object containing shopping cart details
     * @return true if the order is successfully created, false otherwise
     */
    boolean createOrder(ShoppingCartDto shoppingCartDto);

    /**
     * Calculates the total credit for a given list of items.
     *
     * @param itemList the list of items for which to calculate credit
     * @return the total credit amount
     */
    Double calculateCredit(List<Item> itemList);

    /**
     * Calculates the total debit based on the provided coupon list and initial debit amount.
     *
     * @param couponList the list of coupons to apply
     * @param debit the initial debit amount
     * @return the updated debit amount after applying the coupons
     */
    Double calculateDebit(List<Coupon> couponList, Double debit);

    /**
     * Applies a coupon to the user's order.
     *
     * @param coupon the coupon to apply
     * @param idUser the ID of the user applying the coupon
     * @return true if the coupon is successfully applied, false otherwise
     */
    boolean applyCoupon(Coupon coupon, String idUser);
}

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

public interface IOrderService {
    boolean createOrder(ShoppingCartDto shoppingCartDto);
    Double calculateCredit(List<Item> itemList);
    Double calculateDebit(List<Coupon> couponList, Double debit);
    boolean applyCoupon(Coupon coupon, String idUser);

}

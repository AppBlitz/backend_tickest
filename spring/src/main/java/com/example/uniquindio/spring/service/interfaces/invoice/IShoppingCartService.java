package com.example.uniquindio.spring.service.interfaces.invoice;

import com.example.uniquindio.spring.exception.invoice.ShoppingCartNullException;
import com.example.uniquindio.spring.model.vo.items.Ticket;

public interface IShoppingCartService {
    boolean addItem(Ticket ticket, int cant, String idUser);
    boolean deleteItem(Integer idItem, String idUuser) throws ShoppingCartNullException;
    boolean addUser(String idCart, String idUser);
}

package com.example.uniquindio.spring.model.documents;

import java.time.LocalDate;
import java.util.List;

import com.example.uniquindio.spring.model.vo.information.UserInformation;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.uniquindio.spring.model.vo.items.Item;

@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Document("shoppingCart")
@Builder
public class ShoppingCart {

    @Id
    String id;

    //user information
    @NonNull
    UserInformation userInformation;

    @NonNull
    List<Item> items;


}

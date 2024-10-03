package com.example.uniquindio.spring.model.vo.items;

import com.example.uniquindio.spring.model.enums.ItemType;
import lombok.*;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.Min;
import java.util.List;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Item {

    @NonNull
    ItemType type;

    @Builder.Default
    Coupon coupon = null;

    @Builder.Default
    Ticket ticket = null;
    @Min(1)
    Integer cant;


}
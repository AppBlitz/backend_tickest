package com.example.uniquindio.spring.dto.invoicedto;

import com.example.uniquindio.spring.model.vo.items.Item;
import com.example.uniquindio.spring.model.vo.payment.Coupon;
import lombok.Builder;
import lombok.NonNull;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.DecimalMin;
import java.util.List;

public record OrderInformationDTO(

        @NonNull
        String purchaseOrderNumber,

        @DecimalMin(value = "0.0", inclusive = true)
        Double debit,

        @DecimalMin(value = "0.0", inclusive = true)
        Double credit,

        @DecimalMin(value = "0.0", inclusive = true)
        Double total,

        @NonNull
        List<Coupon> couponList,

        @NonNull
        List<Item> itemList,

        @NonNull
        String nameUser
) {
}

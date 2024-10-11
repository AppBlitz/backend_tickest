package com.example.uniquindio.spring.dto.invoicedto;

import com.example.uniquindio.spring.model.documents.ShoppingCart;
import com.example.uniquindio.spring.model.vo.payment.Coupon;
import lombok.NonNull;
import javax.validation.constraints.DecimalMin;
import java.util.List;

public record OrderDTO(
        @NonNull
        String purchaseOrderNumber,

        @NonNull
        ShoppingCart shoppingCart,

        @DecimalMin(value = "0.0", inclusive = true)
        Double debit,

        @DecimalMin(value = "0.0", inclusive = true)
        Double credit,

        @DecimalMin(value = "0.0", inclusive = true)
        Double total,

        @NonNull
        List<Coupon> couponList
) {

}

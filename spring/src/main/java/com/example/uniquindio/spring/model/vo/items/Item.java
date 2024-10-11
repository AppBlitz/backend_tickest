package com.example.uniquindio.spring.model.vo.items;

import lombok.*;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.Min;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Item {

    @Id
    int id;

    @Builder.Default
    Ticket ticket = null;

    @Min(1)
    @Builder.Default
    Integer cant = 1;


}
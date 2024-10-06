package com.example.uniquindio.spring.model.vo.items;
import lombok.*;


@Data
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@Getter
@Setter

public class Locality {

    @NonNull
    private String nameLocality;

    @NonNull
    private String[] imageLocality;

    private double price;

    private int capacityMax;

    private int capacityActual;



}

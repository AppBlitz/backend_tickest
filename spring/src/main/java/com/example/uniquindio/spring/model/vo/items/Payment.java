package com.example.uniquindio.spring.model.vo.items;

import lombok.*;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@Getter
@Setter

public class Payment {

    @NonNull
    private String user;

    @NonNull
    private String preference;

    private Double amount;
}

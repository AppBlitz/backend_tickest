package com.example.uniquindio.spring.model.vo.items;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@Getter
@Setter

public class Pay {

    @NonNull
    private String codigo;
    @NonNull
    private LocalDateTime fecha;
    @NonNull
    private String estado;
    @NonNull
    private String detalleEstado;
    @NonNull
    private String tipoPago;
    @NonNull
    private String moneda;
    @NonNull
    private String codigoAutorizacion;
    @NonNull
    private float valorTransaccion;
}

package com.example.uniquindio.spring.service.imp.pay;

import com.example.uniquindio.spring.model.vo.payment.Pay;
import com.mercadopago.resources.payment.Payment;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:mercado-Pago.properties")
public class PaymentService {

    @Value("${mercado_pago_sample_access_token}")
    private String mercadoPagoAccessToken;

    //descomente y mire a ver

/*
    public Preference CreatePayment(String idOrden) throws MPException, MPApiException {

   // Obtener la orden guardada en la base de datos y los ítems de la orden
   PurchaseOrder order = OrderService.getById(idOrden);

   List<PreferenceItemRequest> itemsPasarela = new ArrayList<>();


   // Recorrer los items de la orden y crea los ítems de la pasarela
   for(Item item : order.getShoppingCart().getItems()){


       // Obtener el evento y la localidad del ítem
       Event event = item.getTicket().getEvento();
       Locality locality = item.getTicket().getLocality();


       // Crear el item de la pasarela
       PreferenceItemRequest itemRequest =
               PreferenceItemRequest.builder()
                       .id(event.getId())
                       .title(event.getNameEvent())
                       .pictureUrl(event.getImageEvent()[0])
                       .categoryId((event.getEventType().toString()))
                       .quantity(item.getCant())
                       .currencyId("COP")
                       .unitPrice(BigDecimal.valueOf(locality.getPrice()))
                       .build();


       itemsPasarela.add(itemRequest);
   }


   // Configurar las credenciales de MercadoPago
   MercadoPagoConfig.setAccessToken(mercadoPagoAccessToken);


   // Configurar las urls de retorno de la pasarela (Frontend)
   PreferenceBackUrlsRequest backUrls = PreferenceBackUrlsRequest.builder()
           .success("URL PAGO EXITOSO")
           .failure("URL PAGO FALLIDO")
           .pending("URL PAGO PENDIENTE")
           .build();

   //tomo la informacion del usuario del carrito
   UserInformation user=order.getShoppingCart().getUserInformation();

   // construir la preferencia del payer (usuario de la compra)
   PreferencePayerRequest payer = PreferencePayerRequest.builder()
           .name(user.getFullName())
           .email(user.getEmail())
           .identification(IdentificationRequest.builder().number(user.getId()).build())
           .phone(PhoneRequest.builder().number(user.getPhoneNumber()).build())
           .address(AddressRequest.builder().streetName(user.getAddress()).build())
           .build();

   // Construir la preferencia de la pasarela con los ítems, metadatos, payer y urls de retorno
   PreferenceRequest preferenceRequest = PreferenceRequest.builder()
           .backUrls(backUrls)
           .items(itemsPasarela)
           .payer(payer)
           .metadata(Map.of("id_orden", order.getById()))
           .notificationUrl("URL NOTIFICACION")
           .build();


   // Crear la preferencia en la pasarela de MercadoPago
   PreferenceClient client = new PreferenceClient();
   Preference preference = client.create(preferenceRequest);


   // Guardar el código de la pasarela en la orden
   order.setPurchaseOrderNumber( preference.getId() );
   //aqui abajo ponga donde vaya a guardar la orden
   //ordenRepo.save(order);


   return preference;
   }
 */

    //creo el pago
    private Pay createPay(Payment payment) {
        Pay pay = new Pay();
        pay.setCodigo(payment.getId().toString());
        pay.setFecha( payment.getDateCreated().toLocalDateTime() );
        pay.setEstado(payment.getStatus());
        pay.setDetalleEstado(payment.getStatusDetail());
        pay.setTipoPago(payment.getPaymentTypeId());
        pay.setMoneda(payment.getCurrencyId());
        pay.setCodigoAutorizacion(payment.getAuthorizationCode());
        pay.setValorTransaccion(payment.getTransactionAmount().floatValue());
        return pay;
    }

    //simplemente voy a poner este ejemplo de notificacion
/*
    public void recibirNotificacionMercadoPago(Map<String, Object> request) {
        try {


            // Obtener el tipo de notificación
            Object tipo = request.get("type");


            // Si la notificación es de un pago entonces obtener el pago y la orden asociada
            if ("payment".equals(tipo)) {


                // Capturamos el JSON que viene en el request y lo convertimos a un String
                String input = request.get("data").toString();


                // Extraemos los números de la cadena, es decir, el id del pago
                String idPago = input.replaceAll("\\D+", "");


                // Se crea el cliente de MercadoPago y se obtiene el pago con el id
                PaymentClient client = new PaymentClient();
                Payment payment = client.get( Long.parseLong(idPago) );


                // Obtener el id de la orden asociada al pago que viene en los metadatos
                String idOrden = payment.getMetadata().get("id_orden").toString();


                // Se obtiene la orden guardada en la base de datos y se le asigna el pago
                PurchaseOrder order = obtenerOrden(idOrden);
                Pay pay = createPay(payment);
                order.setPay(pay);
                ordenRepo.save(order);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
*/



}


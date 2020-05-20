package ro.esolacad.microservicesdemo.checkout.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.esolacad.microservicesdemo.checkout.entities.ShopOrder;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderModel {

    private String id;

    private String clientCode;

    private ShopOrder.State state;


    //Step 1.0 DO NOT REMOVE
    //Step 2.1 Remove from model
//    private BigDecimal totalValue;

    //Step 1.1 Add new fields
    private BigDecimal totalValueWithTax;
    private BigDecimal totalValueWithoutTax;

    private List<OrderItemModel> orderItems;

    private String address;
}

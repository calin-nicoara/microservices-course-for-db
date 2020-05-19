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

    private BigDecimal totalValue;

    private List<OrderItemModel> orderItems;
}

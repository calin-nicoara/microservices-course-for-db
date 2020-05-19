package ro.esolacad.microservicesdemo.acounting.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderModel {

    private String id;

    private String clientCode;

    private String state;

    private BigDecimal totalValue;

    private List<OrderItemModel> orderItems;
}

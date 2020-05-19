package ro.esolacad.microservicesdemo.acounting.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemModel {

    private String productCode;

    private Integer quantity;

    private BigDecimal totalLineValue;
}

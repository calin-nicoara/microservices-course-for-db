package ro.esolacad.microservicesdemo.store.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StockChangeModel {

    private String productCode;
    private Integer quantityToAdd;
}

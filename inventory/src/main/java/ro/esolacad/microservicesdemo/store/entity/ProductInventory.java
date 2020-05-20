package ro.esolacad.microservicesdemo.store.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductInventory {

    @Id
    private Long id;

    private String productCode;

    private BigDecimal price;

    private Integer extraStock;
}

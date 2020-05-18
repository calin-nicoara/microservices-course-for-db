package ro.esolacad.microservicesdemo.store.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.esolacad.microservicesdemo.store.entities.Category;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductModel {

    private Long id;
    private String code;
    private String name;
    private String description;
    private String categoryName;
    private String categoryCode;
    private BigDecimal price;
    private Integer stock;
}

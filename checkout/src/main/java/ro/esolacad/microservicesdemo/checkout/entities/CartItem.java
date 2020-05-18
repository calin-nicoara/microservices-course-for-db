package ro.esolacad.microservicesdemo.checkout.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {

    @Id
    @GeneratedValue
    private Long id;

    private String productCode;

    private Integer quantity;

    @ManyToOne
    private Cart cart;
}

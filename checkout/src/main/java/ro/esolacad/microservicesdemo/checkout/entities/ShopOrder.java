package ro.esolacad.microservicesdemo.checkout.entities;

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
public class ShopOrder {

    @Id
    @GeneratedValue
    private Long id;

    private String clientCode;

    private State state;

    // Step 1.2 Remove old value from code
    // WARNING! Do not delete column from database

    // Step 2.0 We can remove the column from the DB
//    private BigDecimal totalValue;

    private BigDecimal totalValueWithoutTax;

    private BigDecimal totalValueWithTax;

    public enum State {
        PENDING, PAYMENT_APPROVED, READY_FOR_DELIVERY, CANCELED
    }
}

package ro.esolacad.microservicesdemo.checkout.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

//@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderSaga {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private ShopOrder order;

    private Step step;

    public enum Step {
        RESERVE_STOCK, APPROVE_PAYMENT, SEND_DELIVERY
    }
}

package ro.esolacad.microservicesdemo.checkout.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentLogModel {

    private String clientCode;
    private Status status;
    private String orderId;

    public enum Status {
        APPROVED, DENIED
    }
}

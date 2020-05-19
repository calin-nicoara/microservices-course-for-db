package ro.esolacad.microservicesdemo.acounting.config;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.GatewayHeader;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.kafka.support.KafkaHeaders;
import ro.esolacad.microservicesdemo.acounting.models.PaymentLogModel;

@MessagingGateway
public interface KafkaGateway {

    @Gateway(requestChannel = "paymentChannel", headers =
            {@GatewayHeader(name = KafkaHeaders.MESSAGE_KEY, expression = "#args[0].clientCode")})
    void sendClientPaymentLog(PaymentLogModel paymentLogModel);

}

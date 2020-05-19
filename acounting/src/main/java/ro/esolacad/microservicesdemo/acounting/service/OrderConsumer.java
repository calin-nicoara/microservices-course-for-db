package ro.esolacad.microservicesdemo.acounting.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;
import ro.esolacad.microservicesdemo.acounting.config.KafkaGateway;
import ro.esolacad.microservicesdemo.acounting.models.OrderModel;
import ro.esolacad.microservicesdemo.acounting.models.PaymentLogModel;

import java.util.Random;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderConsumer {

    private final KafkaGateway kafkaGateway;

    @StreamListener("orderChannel")
    public void readOrders(Message<OrderModel> orderModelMessage) {
        log.info("Order received");
        // MAKE ACCOUNTING LOGIC
        PaymentLogModel.Status status = new Random().nextInt() % 2 == 0
                ? PaymentLogModel.Status.APPROVED
                : PaymentLogModel.Status.DENIED;

        PaymentLogModel paymentLogModel = PaymentLogModel.builder()
                .clientCode(orderModelMessage.getPayload().getClientCode())
                .status(status)
                .orderId(orderModelMessage.getPayload().getId())
                .build();

        kafkaGateway.sendClientPaymentLog(paymentLogModel);

        log.info("Payment sent");
    }
}

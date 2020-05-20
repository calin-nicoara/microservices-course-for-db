package ro.esolacad.microservicesdemo.checkout.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;
import ro.esolacad.microservicesdemo.checkout.entities.ShopOrder;
import ro.esolacad.microservicesdemo.checkout.models.OrderModel;
import ro.esolacad.microservicesdemo.checkout.models.PaymentLogModel;
import ro.esolacad.microservicesdemo.checkout.repository.OrderRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentConsumer {

    private final OrderRepository orderRepository;

    @StreamListener("paymentChannel")
    public void readPayment(Message<PaymentLogModel> paymentLogModelMessage) {
        log.info("PAyment received");

        PaymentLogModel payload = paymentLogModelMessage.getPayload();
        orderRepository.findById(Long.parseLong(payload.getOrderId()))
                .ifPresent(shopOrder -> {
                    if(payload.getStatus().equals(PaymentLogModel.Status.APPROVED)) {
                        shopOrder.setState(ShopOrder.State.PAYMENT_APPROVED);
                    } else {
                        shopOrder.setState(ShopOrder.State.CANCELED);
                    }

                    orderRepository.save(shopOrder);
                });
    }

    @StreamListener("orderChannelInV2")
    public void testInternalMessage(Message<OrderModel> orderModelMessage) {
        log.info("All good!");
    }
}

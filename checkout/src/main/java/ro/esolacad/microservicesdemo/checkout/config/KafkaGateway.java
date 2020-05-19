package ro.esolacad.microservicesdemo.checkout.config;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.GatewayHeader;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.kafka.support.KafkaHeaders;
import ro.esolacad.microservicesdemo.checkout.models.AddCartItemModel;
import ro.esolacad.microservicesdemo.checkout.models.OrderModel;

@MessagingGateway
public interface KafkaGateway {

    @Gateway(requestChannel = "stockChannelV2", headers =
            {@GatewayHeader(name = KafkaHeaders.MESSAGE_KEY, expression = "#args[0].productCode")})
    void sendCartItem(AddCartItemModel addCartItemModel);

    @Gateway(requestChannel = "orderChannelV2", headers =
            {@GatewayHeader(name = KafkaHeaders.MESSAGE_KEY, expression = "#args[0].id")})
    void sendOrder(OrderModel orderModel);
}

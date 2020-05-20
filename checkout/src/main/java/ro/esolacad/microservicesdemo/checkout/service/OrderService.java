package ro.esolacad.microservicesdemo.checkout.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import ro.esolacad.microservicesdemo.checkout.config.KafkaGateway;
import ro.esolacad.microservicesdemo.checkout.entities.OrderItem;
import ro.esolacad.microservicesdemo.checkout.entities.ShopOrder;
import ro.esolacad.microservicesdemo.checkout.models.OrderItemModel;
import ro.esolacad.microservicesdemo.checkout.models.OrderModel;
import ro.esolacad.microservicesdemo.checkout.repository.OrderItemRepository;
import ro.esolacad.microservicesdemo.checkout.repository.OrderRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;

    private final KafkaGateway kafkaGateway;

    public Long createOrder(final OrderModel orderModel) {

        ShopOrder shopOrder = ShopOrder.builder()
                .clientCode(orderModel.getClientCode())
                .state(ShopOrder.State.PENDING)

                .build();

        // Step 1.3 Use new values if present, if not use old value
        // Step 2.3 Remove business code for old value

        shopOrder.setTotalValueWithoutTax(orderModel.getTotalValueWithoutTax());
        shopOrder.setTotalValueWithTax(orderModel.getTotalValueWithTax());

        ShopOrder savedOrder = orderRepository.save(shopOrder);

        List<OrderItem> orderItems = orderModel.getOrderItems().stream().map(orderItemModel -> {
            return OrderItem.builder()
                    .order(savedOrder)
                    .productCode(orderItemModel.getProductCode())
                    .quantity(orderItemModel.getQuantity())
                    .totalLineValue(orderItemModel.getTotalLineValue())
                    .build();
        }).collect(Collectors.toList());

        orderItemRepository.saveAll(orderItems);


//        orderModel.setId(savedOrder.getId().toString());
//        orderModel.setState(savedOrder.getState());
//        orderModel.setClientCode(savedOrder.getClientCode());

//        kafkaGateway.sendOrder(orderModel);

        return savedOrder.getId();

    }

    public OrderModel getOrder(final Long orderId) {
        ShopOrder shopOrder = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Not found!"));

        return OrderModel.builder()
                .id(shopOrder.getId().toString())
                .totalValueWithoutTax(shopOrder.getTotalValueWithoutTax())
                .totalValueWithTax(shopOrder.getTotalValueWithTax())
                .build();
    }
}

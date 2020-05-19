package ro.esolacad.microservicesdemo.checkout.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
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

    public void createOrder(final OrderModel orderModel) {
        ShopOrder savedOrder = orderRepository.save(
                ShopOrder.builder()
                        .clientCode(orderModel.getClientCode())
                        .totalValue(orderModel.getTotalValue())
                        .state(ShopOrder.State.PENDING)
                        .build()
        );

        List<OrderItem> orderItems = orderModel.getOrderItems().stream().map(orderItemModel -> {
            return OrderItem.builder()
                    .order(savedOrder)
                    .productCode(orderItemModel.getProductCode())
                    .quantity(orderItemModel.getQuantity())
                    .totalLineValue(orderItemModel.getTotalLineValue())
                    .build();
        }).collect(Collectors.toList());

        orderItemRepository.saveAll(orderItems);

        orderModel.setId(savedOrder.getId().toString());
        orderModel.setState(savedOrder.getState());
        orderModel.setClientCode(savedOrder.getClientCode());

        kafkaGateway.sendOrder(orderModel);
    }
}

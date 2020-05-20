package ro.esolacad.microservicesdemo.checkout.resource;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.esolacad.microservicesdemo.checkout.models.AddCartItemModel;
import ro.esolacad.microservicesdemo.checkout.models.OrderModel;
import ro.esolacad.microservicesdemo.checkout.service.OrderService;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderResource {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Object> createOrder(@RequestBody OrderModel orderModel) {
        Long order = orderService.createOrder(orderModel);

        return ResponseEntity.ok(order);
    }

    @GetMapping(path = "/{order_id}")
    public ResponseEntity<OrderModel> getOrder(@PathVariable("order_id") Long orderId) {
        return ResponseEntity.ok(orderService.getOrder(orderId));
    }
}

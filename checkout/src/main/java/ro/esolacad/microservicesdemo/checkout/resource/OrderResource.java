package ro.esolacad.microservicesdemo.checkout.resource;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
        orderService.createOrder(orderModel);

        return ResponseEntity.ok().build();
    }
}

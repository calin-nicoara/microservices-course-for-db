package ro.esolacad.microservicesdemo.checkout.resource;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.esolacad.microservicesdemo.checkout.models.AddCartItemModel;
import ro.esolacad.microservicesdemo.checkout.service.CartService;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartResource {

    private final CartService cartService;

    @PostMapping("/addItem")
    public ResponseEntity<Object> addProductToCart(@RequestBody AddCartItemModel addCartItemModel) {
        Integer cartQunatity = cartService.addCartItem(addCartItemModel);

        return ResponseEntity.ok(cartQunatity);
    }
}

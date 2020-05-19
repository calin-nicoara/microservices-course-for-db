package ro.esolacad.microservicesdemo.checkout.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.esolacad.microservicesdemo.checkout.client.InventoryClient;
import ro.esolacad.microservicesdemo.checkout.client.InventoryFeignClient;
import ro.esolacad.microservicesdemo.checkout.config.KafkaGateway;
import ro.esolacad.microservicesdemo.checkout.entities.Cart;
import ro.esolacad.microservicesdemo.checkout.entities.CartItem;
import ro.esolacad.microservicesdemo.checkout.models.AddCartItemModel;
import ro.esolacad.microservicesdemo.checkout.repository.CartItemRepository;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CartService {

    private final InventoryFeignClient inventoryClient;
    private final CartItemRepository cartItemRepository;

    private final KafkaGateway kafkaGateway;

    public Integer addCartItem(final AddCartItemModel addCartItemModel) {
        // Add to  CART LOGIC
        CartItem cartItem1 = saveCartItemAndGet(addCartItemModel);

        inventoryClient.addStockQuantity(addCartItemModel);

        return cartItem1.getQuantity();
    }

    public Integer addCartItemAsync(final AddCartItemModel addCartItemModel) {
        CartItem cartItem1 = saveCartItemAndGet(addCartItemModel);

        kafkaGateway.sendCartItem(addCartItemModel);

        return cartItem1.getQuantity();
    }

    private CartItem saveCartItemAndGet(final AddCartItemModel addCartItemModel) {
        CartItem cartItem1 = cartItemRepository.findByCartIdAndProductCode(addCartItemModel.getCartId(),
                addCartItemModel.getProductCode())
                .map(cartItem -> {
                    cartItem.setQuantity(cartItem.getQuantity() + addCartItemModel.getQuantityToAdd());
                    return cartItem;
                })
                .orElseGet(() -> CartItem
                        .builder()
                        .cart(Cart.builder().id(addCartItemModel.getCartId()).build())
                        .productCode(addCartItemModel.getProductCode())
                        .quantity(addCartItemModel.getQuantityToAdd())
                        .build());

        cartItemRepository.save(cartItem1);

        addCartItemModel.setQuantityToAdd(-addCartItemModel.getQuantityToAdd());
        return cartItem1;
    }


}

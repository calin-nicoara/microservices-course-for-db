package ro.esolacad.microservicesdemo.checkout.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.esolacad.microservicesdemo.checkout.client.InventoryClient;
import ro.esolacad.microservicesdemo.checkout.entities.Cart;
import ro.esolacad.microservicesdemo.checkout.entities.CartItem;
import ro.esolacad.microservicesdemo.checkout.models.AddCartItemModel;
import ro.esolacad.microservicesdemo.checkout.repository.CartItemRepository;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CartService {

    private final InventoryClient inventoryClient;
    private final CartItemRepository cartItemRepository;

    public Integer addCartItem(final AddCartItemModel addCartItemModel) {
        // Add to  CART LOGIC
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
        inventoryClient.addStockQuantity(addCartItemModel);


        return cartItem1.getQuantity();
    }
}

package ro.esolacad.microservicesdemo.checkout.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.esolacad.microservicesdemo.checkout.entities.Cart;
import ro.esolacad.microservicesdemo.checkout.entities.CartItem;

import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    Optional<CartItem> findByCartIdAndProductCode(Long cartId, String productCode);
}

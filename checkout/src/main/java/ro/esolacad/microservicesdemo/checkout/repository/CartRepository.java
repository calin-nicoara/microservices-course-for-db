package ro.esolacad.microservicesdemo.checkout.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.esolacad.microservicesdemo.checkout.entities.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
}

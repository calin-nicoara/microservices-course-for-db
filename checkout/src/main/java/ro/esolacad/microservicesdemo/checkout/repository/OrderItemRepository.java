package ro.esolacad.microservicesdemo.checkout.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.esolacad.microservicesdemo.checkout.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}

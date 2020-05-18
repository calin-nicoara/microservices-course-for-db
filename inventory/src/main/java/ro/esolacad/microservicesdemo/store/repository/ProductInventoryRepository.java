package ro.esolacad.microservicesdemo.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.esolacad.microservicesdemo.store.entity.ProductInventory;

import java.util.Optional;

public interface ProductInventoryRepository extends JpaRepository<ProductInventory, Long> {
    Optional<ProductInventory> findByProductCode(String code);
}

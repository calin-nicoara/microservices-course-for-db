package ro.esolacad.microservicesdemo.checkout.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ro.esolacad.microservicesdemo.checkout.entities.ShopOrder;

@RepositoryRestResource
public interface OrderRepository extends JpaRepository<ShopOrder, Long> {
}

package ro.esolacad.microservicesdemo.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import ro.esolacad.microservicesdemo.store.entities.Category;
import ro.esolacad.microservicesdemo.store.entities.Product;

import java.util.Optional;

@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByCode(String code);
}

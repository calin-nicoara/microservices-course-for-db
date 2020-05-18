package ro.esolacad.microservicesdemo.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.esolacad.microservicesdemo.store.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}

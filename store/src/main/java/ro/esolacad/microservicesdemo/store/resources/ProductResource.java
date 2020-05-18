package ro.esolacad.microservicesdemo.store.resources;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ro.esolacad.microservicesdemo.store.entities.Product;
import ro.esolacad.microservicesdemo.store.models.ProductModel;
import ro.esolacad.microservicesdemo.store.repositories.ProductRepository;
import ro.esolacad.microservicesdemo.store.services.ProductService;

@RestController
@RequiredArgsConstructor
public class ProductResource {

    private final ProductService productService;

    @GetMapping("/product/{code}")
    public ResponseEntity<ProductModel> getProductByCode(@PathVariable("code") String code) {
        return productService.findByProductCode(code)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}

package ro.esolacad.microservicesdemo.store.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.esolacad.microservicesdemo.store.entities.Product;
import ro.esolacad.microservicesdemo.store.models.ProductInventoryModel;
import ro.esolacad.microservicesdemo.store.models.ProductModel;
import ro.esolacad.microservicesdemo.store.repositories.ProductRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final InventoryService inventoryService;

    public Optional<ProductModel> findByProductCode(final String code) {
        ProductInventoryModel productInventoryModel = inventoryService.findProductInventoryByCode(code);

        return productRepository.findByCode(code)
            .map(product -> ProductModel.builder()
                    .name(product.getName())
                    .code(product.getCode())
                    .categoryCode(product.getCategory().getCode())
                    .categoryName(product.getCategory().getName())
                    .price(productInventoryModel.getPrice())
                    .stock(productInventoryModel.getStock())
                    .build());
    }
}

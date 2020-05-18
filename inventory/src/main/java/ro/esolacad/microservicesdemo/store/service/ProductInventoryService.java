package ro.esolacad.microservicesdemo.store.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.esolacad.microservicesdemo.store.entity.ProductInventory;
import ro.esolacad.microservicesdemo.store.model.ProductInventoryModel;
import ro.esolacad.microservicesdemo.store.model.StockChangeModel;
import ro.esolacad.microservicesdemo.store.repository.ProductInventoryRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductInventoryService {

    private final ProductInventoryRepository productInventoryRepository;

    public Optional<ProductInventoryModel> findByProductCode(String code) {
        return productInventoryRepository.findByProductCode(code)
                .map(productInventory -> ProductInventoryModel.builder()
                        .productCode(productInventory.getProductCode())
                        .price(productInventory.getPrice())
                        .stock(productInventory.getStock())
                        .build());
    }

    public void modifyStock(final StockChangeModel stockChangeModel) {
        productInventoryRepository.findByProductCode(stockChangeModel.getProductCode())
               .ifPresent(productInventory -> {
                   productInventory.setStock(productInventory.getStock() + stockChangeModel.getQuantityToAdd());

                   // Product inventory saves anyway
                   productInventoryRepository.save(productInventory);
               });
    }
}

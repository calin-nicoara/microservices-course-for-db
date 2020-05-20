package ro.esolacad.microservicesdemo.store.service;

import ro.esolacad.microservicesdemo.store.model.ProductInventoryModel;
import ro.esolacad.microservicesdemo.store.model.StockChangeModel;

import java.util.Optional;

public interface ProductInventoryContract {
    Optional<ProductInventoryModel> findByProductCode(String code);
    void modifyStock(final StockChangeModel stockChangeModel);
}

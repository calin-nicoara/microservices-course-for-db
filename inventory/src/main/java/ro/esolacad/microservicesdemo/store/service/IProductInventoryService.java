package ro.esolacad.microservicesdemo.store.service;

import ro.esolacad.microservicesdemo.store.model.ProductInventoryModel;
import ro.esolacad.microservicesdemo.store.model.StockChangeModel;

import java.util.Optional;

public interface IProductInventoryService {
    public Optional<ProductInventoryModel> findByProductCode(String code);
    public void modifyStock(final StockChangeModel stockChangeModel);
}

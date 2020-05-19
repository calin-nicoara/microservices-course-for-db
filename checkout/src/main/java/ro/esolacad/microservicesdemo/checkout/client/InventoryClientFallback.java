package ro.esolacad.microservicesdemo.checkout.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import ro.esolacad.microservicesdemo.checkout.models.AddCartItemModel;

@Slf4j
@Component
public class InventoryClientFallback implements InventoryFeignClient{
    @Override
    public ResponseEntity<Void> addStockQuantity(final AddCartItemModel addCartItemModel) {
        log.warn("Add stock quantity did not work!");
        return ResponseEntity.ok().build();
    }
}

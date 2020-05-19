package ro.esolacad.microservicesdemo.checkout.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ro.esolacad.microservicesdemo.checkout.models.AddCartItemModel;

@FeignClient(name = "inventory-service", fallback = InventoryClientFallback.class)
public interface InventoryFeignClient {

    @RequestMapping(value = "/inventory/stock", method = RequestMethod.POST,
    produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Void> addStockQuantity(@RequestBody AddCartItemModel addCartItemModel);
}

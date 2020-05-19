package ro.esolacad.microservicesdemo.store.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ro.esolacad.microservicesdemo.store.models.ProductInventoryModel;


@FeignClient(name = "inventory-service", fallbackFactory = InventoryClientFallFactory.class)
public interface InventoryClient {

    @RequestMapping(value = "/inventory/{code}", method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ProductInventoryModel> getProductInventory(@PathVariable("code") String code);
}

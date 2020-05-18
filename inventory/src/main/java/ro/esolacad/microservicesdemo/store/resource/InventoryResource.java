package ro.esolacad.microservicesdemo.store.resource;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.esolacad.microservicesdemo.store.entity.ProductInventory;
import ro.esolacad.microservicesdemo.store.model.ProductInventoryModel;
import ro.esolacad.microservicesdemo.store.model.StockChangeModel;
import ro.esolacad.microservicesdemo.store.repository.ProductInventoryRepository;
import ro.esolacad.microservicesdemo.store.service.ProductInventoryService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class InventoryResource {

    private final ProductInventoryService productInventoryService;

    @GetMapping(value = "/{code}")
    public ResponseEntity<ProductInventoryModel> getProductByCode(@PathVariable("code") String code,
                                                                  @RequestHeader("X-Request-Id") String xREquest) {
        System.out.println();
        System.out.println(xREquest);
        System.out.println();

        return productInventoryService.findByProductCode(code)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(value = "/stock")
    public ResponseEntity<Void> modifyStock(@RequestBody StockChangeModel stockChangeModel) {
        productInventoryService.modifyStock(stockChangeModel);

        return ResponseEntity.ok().build();
    }
}

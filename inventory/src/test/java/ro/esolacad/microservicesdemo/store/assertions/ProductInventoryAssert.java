package ro.esolacad.microservicesdemo.store.assertions;

import org.assertj.core.api.AbstractAssert;
import ro.esolacad.microservicesdemo.store.entity.ProductInventory;

public class ProductInventoryAssert extends AbstractAssert<ProductInventoryAssert, ProductInventory> {

    public ProductInventoryAssert(final ProductInventory productInventory) {
        super(productInventory, ProductInventoryAssert.class);
    }

    public static ProductInventoryAssert assertThat(ProductInventory actual) {
        return new ProductInventoryAssert(actual);
    }

    public ProductInventoryAssert hasNoCode() {
        isNotNull();
        if(actual.getProductCode() != null) {
            failWithMessage("Product inventory has code");
        }

        return this;
    }
}

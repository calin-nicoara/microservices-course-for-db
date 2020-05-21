package ro.esolacad.microservicesdemo.store.assertions;

import org.assertj.core.api.AbstractAssert;
import ro.esolacad.microservicesdemo.store.model.ProductInventoryModel;

public class ProductInventoryAssertion extends AbstractAssert<ProductInventoryAssertion, ProductInventoryModel> {

    public ProductInventoryAssertion(final ProductInventoryModel productInventoryModel) {
        super(productInventoryModel, ProductInventoryAssertion.class);
    }

    public static ProductInventoryAssertion assertThat(ProductInventoryModel actual) {
        return new ProductInventoryAssertion(actual);
    }

    public ProductInventoryAssertion hasProductCodeEqualTo(String productCode) {
        isNotNull();
        if(!actual.getProductCode().equals(productCode)) {
            failWithMessage("Product inventory does not have code equal to " + productCode);
        }

        return this;
    }
}

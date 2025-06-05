package com.pharmacy.pharbrief.validation;

import com.pharmacy.pharbrief.model.ProductType;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ProductTypeValidator implements ConstraintValidator<ValidatProductType, ProductType> {
    public boolean isValid(ProductType productType, ConstraintValidatorContext constraintValidatorContext) {
        if (productType == null) return false;

        return productType == ProductType.PILL ||
                productType == ProductType.INJECTOR ||
                productType == ProductType.LIQUID;
    }
}

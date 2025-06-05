package com.pharmacy.pharbrief.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ProductTypeValidator.class)
public @interface ValidatProductType {

    String message() default "Invalide product Type, only allowed PILL, INJECTOR, LIQUID";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}

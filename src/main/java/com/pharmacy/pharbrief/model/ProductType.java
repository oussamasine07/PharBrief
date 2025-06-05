package com.pharmacy.pharbrief.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ProductType {

    LIQUID,
    INJECTOR,
    PILL;

    @JsonCreator
    public static ProductType fromString(String value) {
        try {
            return ProductType.valueOf(value.toUpperCase());
        } catch (Exception e) {
            return null;
        }
    }

    @JsonValue
    public String getValue() {
        return name();
    }

}

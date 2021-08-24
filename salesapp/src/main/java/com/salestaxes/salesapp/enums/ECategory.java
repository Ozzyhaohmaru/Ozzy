package com.salestaxes.salesapp.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum ECategory {
    BOOKS(1L, "BOOKS"),
    FOODS(2L, "FOODS"),
    MPS(3L, "MEDICAL PRODUCTS"),
    OtHERS(4l, "OTHERS");

    Long id;
    String name;

    public static ECategory valueOf(final Long id) {
        return Arrays.stream(ECategory.values())
                .filter(categoryId -> categoryId.getId().compareTo(id) == 0).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid category"));
    }

    public static ECategory valueOfId(final String instance) {
        return Arrays.stream(ECategory.values())
                .filter(categoryId -> categoryId.getName().equalsIgnoreCase(instance)).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid category"));
    }
}

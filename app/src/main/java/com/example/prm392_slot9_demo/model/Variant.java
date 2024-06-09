package com.example.prm392_slot9_demo.model;

import java.util.List;

public class Variant {
    private int variantId;
    private String title;
    private List<Value> values;

    // Constructor, getters and setters
    // Constructor, getters and setters
    public Variant(int variantId, String title, List<Value> values) {
        this.variantId = variantId;
        this.title = title;
        this.values = values;
    }

    public int getVariantId() {
        return variantId;
    }

    public String getTitle() {
        return title;
    }

    public List<Value> getValues() {
        return values;
    }
}

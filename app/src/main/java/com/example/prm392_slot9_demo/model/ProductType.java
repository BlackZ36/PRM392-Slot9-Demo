package com.example.prm392_slot9_demo.model;

public class ProductType {
    private int productTypeId;
    private String title;

    //
    //

    public ProductType(int productTypeId, String title) {
        this.productTypeId = productTypeId;
        this.title = title;
    }

    public int getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(int productTypeId) {
        this.productTypeId = productTypeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

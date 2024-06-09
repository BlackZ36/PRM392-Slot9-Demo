package com.example.prm392_slot9_demo.model;

import java.util.List;

public class Product {
    private int productId;
    private String title;
    private String metaTitle;
    private String content;
    private String slug;
    private String sku;
    private Category category;
    private ProductType productType;
    private Vendor vendor;
    private List<Item> items;

    // Constructor, getters and setters
    // Constructor, getters and setters
    public Product(int productId, String title, String metaTitle, String content, String slug, String sku, Category category, ProductType productType, Vendor vendor, List<Item> items) {
        this.productId = productId;
        this.title = title;
        this.metaTitle = metaTitle;
        this.content = content;
        this.slug = slug;
        this.sku = sku;
        this.category = category;
        this.productType = productType;
        this.vendor = vendor;
        this.items = items;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMetaTitle() {
        return metaTitle;
    }

    public void setMetaTitle(String metaTitle) {
        this.metaTitle = metaTitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}

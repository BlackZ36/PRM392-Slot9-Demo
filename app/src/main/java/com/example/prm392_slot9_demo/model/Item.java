package com.example.prm392_slot9_demo.model;

import java.util.List;

public class Item {
    private int itemId;
    private String title;
    private String metaTitle;
    private String content;
    private String slug;
    private String sku;
    private List<Variant> variants;

    // Constructor, getters and setters
    // Constructor, getters and setters
    public Item(int itemId, String title, String metaTitle, String content, String slug, String sku, List<Variant> variants) {
        this.itemId = itemId;
        this.title = title;
        this.metaTitle = metaTitle;
        this.content = content;
        this.slug = slug;
        this.sku = sku;
        this.variants = variants;
    }

    public int getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public String getMetaTitle() {
        return metaTitle;
    }

    public String getContent() {
        return content;
    }

    public String getSlug() {
        return slug;
    }

    public String getSku() {
        return sku;
    }

    public List<Variant> getVariants() {
        return variants;
    }
}

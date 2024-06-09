package com.example.prm392_slot9_demo.model;

public class Category {
    private int categoryId;
    private String title;
    private String slug;

    // Constructor, getters and setters
    // Constructor, getters and setters

    public Category(int categoryId, String title, String slug) {
        this.categoryId = categoryId;
        this.title = title;
        this.slug = slug;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }
}

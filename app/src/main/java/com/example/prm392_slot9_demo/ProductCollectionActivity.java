package com.example.prm392_slot9_demo;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;

import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.prm392_slot9_demo.DAO.ProductDAO;
import com.example.prm392_slot9_demo.model.Product;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class ProductCollectionActivity extends AppCompatActivity {
    private ListView lvCollections;
    ProductDAO productDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product_collection);

        productDAO = new ProductDAO(this);
        lvCollections = findViewById(R.id.lvCollections);

        String url = "https://blackz36.github.io/PRM392-Final-Project/product.json";
        productDAO.fetchProductList(url, this::displayToListview);
    }

    private void displayToListview(List<Product> productList) {
        // Create a list of product titles
        List<String> productTitles = new ArrayList<>();
        for (Product product : productList) {
            productTitles.add(product.getTitle());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, productTitles);

        // Set the adapter to the ListView
        lvCollections.setAdapter(adapter);

        // Set click listener for ListView items
        lvCollections.setOnItemClickListener((parent, view, position, id) -> {
            // Get the selected product
            Product selectedProduct = productList.get(position);

            // Navigate to ProductDetailActivity with product_id
            Intent intent = new Intent(ProductCollectionActivity.this, ProductListActivity.class);
            intent.putExtra("PRODUCT_ID", selectedProduct.getProductId());
            startActivity(intent);
        });
    }

}
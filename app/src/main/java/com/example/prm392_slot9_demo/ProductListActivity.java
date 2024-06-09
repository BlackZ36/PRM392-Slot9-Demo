package com.example.prm392_slot9_demo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.prm392_slot9_demo.DAO.ProductDAO;
import com.example.prm392_slot9_demo.model.Item;
import com.example.prm392_slot9_demo.model.Product;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class ProductListActivity extends AppCompatActivity {

    ListView lvProductListView;
    ProductDAO productDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product_list);

        productDAO = new ProductDAO(this);
        lvProductListView = findViewById(R.id.lvProductListView);
        String url = "https://blackz36.github.io/PRM392-Final-Project/product.json";


        //Check Intent
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("PRODUCT_ID")) {
            int productId = intent.getIntExtra("PRODUCT_ID", -1);
            if (productId != -1) {
                productDAO.fetchProductList(url, productList -> displayToListViewWithID(productList, productId));
            } else {
                Toast.makeText(this, "Invalid product id", Toast.LENGTH_SHORT).show();
            }
        } else {
            productDAO.fetchProductList(url, this::displayToListview);
        }


    }

    private void displayToListview(List<Product> productList) {
        // Create a list of product titles
        List<String> itemTitles = new ArrayList<>();

        for (Product product : productList) {
            for (Item item : product.getItems()) {
                itemTitles.add(item.getTitle());
            }
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itemTitles);

        // Set the adapter to the ListView
        lvProductListView.setAdapter(adapter);

        // Set click listener for ListView items
//        lvProductListView.setOnItemClickListener((parent, view, position, id) -> {
//            // Get the selected product
//            Item selectedItem = itemList.get(position);
//
//            // Navigate to ProductDetailActivity with product_id
//            Intent intent = new Intent(ProductListActivity.this, ProductDetailActivity.class);
//            intent.putExtra("ITEM_ID", selectedItem.getItemId());
//            startActivity(intent);
//        });
    }

    private void displayToListViewWithID(List<Product> productList, int id) {
        // Create a list of product titles
        List<Item> itemList = new ArrayList<>();
        List<String> itemTitles = new ArrayList<>();

        for (Product product : productList) {
            if (product.getProductId() == id) {
                itemList.addAll(product.getItems());
            }
        }

        if (!itemList.isEmpty()) {
            for (Item item : itemList) {
                itemTitles.add(item.getTitle());
            }
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itemTitles);

        // Set the adapter to the ListView
        lvProductListView.setAdapter(adapter);
    }

}
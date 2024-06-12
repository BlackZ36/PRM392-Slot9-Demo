package com.example.prm392_slot9_demo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class ProductDetailActivity extends AppCompatActivity {

    TextView txTextview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product_detail);

//        txTextview = findViewById(R.id.txTextView);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("ITEM_ID")) {
            int id = intent.getIntExtra("ITEM_ID", -1);
            // Chuyển id thành chuỗi trước khi gán cho TextView
            String itemIdString = String.valueOf(id);
//            txTextview.setText(itemIdString);
        }

    }
}
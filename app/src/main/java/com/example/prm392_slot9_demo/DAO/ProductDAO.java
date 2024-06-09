package com.example.prm392_slot9_demo.DAO;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.prm392_slot9_demo.model.Category;
import com.example.prm392_slot9_demo.model.Item;
import com.example.prm392_slot9_demo.model.Product;
import com.example.prm392_slot9_demo.model.ProductType;
import com.example.prm392_slot9_demo.model.Value;
import com.example.prm392_slot9_demo.model.Variant;
import com.example.prm392_slot9_demo.model.Vendor;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private Context context;

    public interface ProductListCallback {
        void onProductListReceived(List<Product> productList);
    }

    public ProductDAO(Context context) {
        this.context = context;
    }


    public void fetchProductList(String url, ProductListCallback callback) {
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        List<Product> productList = parseProductList(response);
                        callback.onProductListReceived(productList);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Handle error
                    }
                });

        requestQueue.add(request);
    }

    private List<Product> parseProductList(JSONObject jsonObject) {
        List<Product> productList = new ArrayList<>();
        try {
            JSONArray productsArray = jsonObject.getJSONArray("products");
            for (int i = 0; i < productsArray.length(); i++) {
                JSONObject productObject = productsArray.getJSONObject(i);
                int productId = productObject.getInt("product_id");
                String title = productObject.getString("title");
                String metaTitle = productObject.getString("metaTitle");
                String content = productObject.getString("content");
                String slug = productObject.getString("slug");
                String sku = productObject.getString("sku");

                // Parse category
                JSONObject categoryObject = productObject.getJSONObject("category");
                int categoryId = categoryObject.getInt("category_id");
                String categoryTitle = categoryObject.getString("title");
                String categorySlug = categoryObject.getString("slug");
                Category category = new Category(categoryId, categoryTitle, categorySlug);

                // Parse product type
                JSONObject productTypeObject = productObject.getJSONObject("productType");
                int productTypeId = productTypeObject.getInt("product_type_id");
                String productTypeTitle = productTypeObject.getString("title");
                ProductType productType = new ProductType(productTypeId, productTypeTitle);

                // Parse vendor
                JSONObject vendorObject = productObject.getJSONObject("vendor");
                int vendorId = vendorObject.getInt("vendor_id");
                String vendorTitle = vendorObject.getString("title");
                Vendor vendor = new Vendor(vendorId, vendorTitle);

                // Parse items
                JSONArray itemsArray = productObject.getJSONArray("items");
                List<Item> itemList = new ArrayList<>();
                for (int j = 0; j < itemsArray.length(); j++) {
                    JSONObject itemObject = itemsArray.getJSONObject(j);
                    int itemId = itemObject.getInt("item_id");
                    String itemTitle = itemObject.getString("title");
                    String itemMetaTitle = itemObject.getString("metaTitle");
                    String itemContent = itemObject.getString("content");
                    String itemSlug = itemObject.getString("slug");
                    String itemSku = itemObject.getString("sku");

                    // Parse variants
                    JSONArray variantsArray = itemObject.getJSONArray("variants");
                    List<Variant> variantList = new ArrayList<>();
                    for (int k = 0; k < variantsArray.length(); k++) {
                        JSONObject variantObject = variantsArray.getJSONObject(k);
                        int variantId = variantObject.getInt("variant_id");
                        String variantTitle = variantObject.getString("title");

                        // Parse values
                        JSONArray valuesArray = variantObject.getJSONArray("values");
                        List<Value> valueList = new ArrayList<>();
                        for (int l = 0; l < valuesArray.length(); l++) {
                            JSONObject valueObject = valuesArray.getJSONObject(l);
                            String value = valueObject.getString("value");
                            String imgUrl = valueObject.getString("img_url");
                            valueList.add(new Value(value, imgUrl));
                        }

                        variantList.add(new Variant(variantId, variantTitle, valueList));
                    }

                    itemList.add(new Item(itemId, itemTitle, itemMetaTitle, itemContent, itemSlug, itemSku, variantList));
                }

                productList.add(new Product(productId, title, metaTitle, content, slug, sku, category, productType, vendor, itemList));
            }
        } catch (JSONException e) {
            e.printStackTrace();
            // Handle parsing error
        }
        return productList;
    }

}

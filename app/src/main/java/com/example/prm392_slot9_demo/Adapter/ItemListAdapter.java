package com.example.prm392_slot9_demo.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.prm392_slot9_demo.R;
import com.example.prm392_slot9_demo.model.Item;

import java.util.List;

public class ItemListAdapter extends BaseAdapter {

    private List<Item> itemList;
    private Context context;

    public ItemListAdapter(List<Item> itemList, Context context) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return itemList.size();
    }
    @Override
    public Object getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return itemList.get(position).getItemId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewAX view;
        if (convertView == null) {
            view = new ViewAX();
            convertView = LayoutInflater.from(context).inflate(R.layout.product_item_listview, parent, false);
            view.itemImage = convertView.findViewById(R.id.itemImage);
            view.itemTitle = convertView.findViewById(R.id.itemTitle);
            view.itemSku = convertView.findViewById(R.id.itemSKU);
            view.itemDescription = convertView.findViewById(R.id.itemDescription);
            view.itemButton = convertView.findViewById(R.id.itemButton);
            convertView.setTag(view);
        } else {
            view = (ViewAX) convertView.getTag();
        }

        // Get the current item
        Item item = itemList.get(position);
        view.itemImage.setImageResource(R.drawable.android);
        view.itemTitle.setText(item.getTitle());
        view.itemSku.setText(item.getSku());
        view.itemDescription.setText(item.getContent());

        // Set any event listeners (e.g., button click)
        view.itemButton.setOnClickListener(v -> {
            // Handle button click
        });

        return convertView;
    }
}

class ViewAX{
    ImageView itemImage;
    TextView itemTitle;
    TextView itemSku;
    TextView itemDescription;
    Button itemButton;
}

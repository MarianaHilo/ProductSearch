package com.example.starteck.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.starteck.myapplication.R.id.imageView;

/**
 * Created by Starteck on 9/29/2017.
 */

public class SearchResultsRVAdapter extends RecyclerView.Adapter<SearchResultsRVAdapter.ViewHolder> {
    private ArrayList<Product> products;
    private String layoutType;

    public SearchResultsRVAdapter(ArrayList<Product> data, String layoutType) {
        this.products = data;
        this.layoutType= layoutType;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root;
        if(layoutType.equals("list") ) {
            root = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        }else{
            root = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_view, parent, false);

        }
        ViewHolder vholder = new ViewHolder(root);
        return vholder;    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Product product = products.get(position);
    holder.bind(product);
    }

    @Override
    public int getItemCount() {
        if (products == null) return 0;
        else {
            return products.size();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView productname;
        TextView productDesc;
        ImageView productImage;

        public ViewHolder(View itemView) {
            super(itemView);
            productname = (TextView) itemView.findViewById(R.id.rowline);
            productDesc = (TextView) itemView.findViewById(R.id.rowline2);
            productImage = (ImageView) itemView.findViewById(imageView);

            itemView.setOnClickListener(this);

        }

        public void bind(Product product) {

            productname.setText(product.getName());
            productDesc.setText(product.getDescription());
            String image = product.getImage();
            productImage.setTag(image);
            productImage.setImageResource(android.R.color.transparent);
            new ImageLoadTask(image, productImage).execute();


        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(v.getContext(), ProductPageActivity.class);
            Bundle bundle = new Bundle();

            Product product = products.get(getAdapterPosition());
            bundle.putString("image",product.getImage());
            bundle.putString("Description",product.getDescription());
            bundle.putString("ProductURL",product.getProductURL());
            bundle.putString("ProductId",product.getProductId());

            intent.putExtras(bundle);
            v.getContext().startActivity(intent);


        }
    }
}

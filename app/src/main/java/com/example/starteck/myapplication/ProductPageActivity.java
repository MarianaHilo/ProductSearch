package com.example.starteck.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Starteck on 10/21/2017.
 */

public class ProductPageActivity extends AppCompatActivity{

    private Button buttonBuy;
    private TextView etProductDetails;
    private ImageView ImProduct;
    Bundle aBundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_page);

        bindUI();
    }


    private void bindUI() {

        buttonBuy = (Button) findViewById(R.id.buttonBuy);
        etProductDetails = (TextView) findViewById(R.id.editTxProdyctDetails);
        ImProduct= (ImageView) findViewById(R.id.imageViewProduct);
        Intent intent = this.getIntent();
        aBundle = intent.getExtras();
        etProductDetails.setText(aBundle.getString("Description"));
        String productImage = aBundle.getString("image");
        String productURL = aBundle.getString("ProductURL");
        String ProductId = aBundle.getString("ProductId");

        ImProduct.setTag(productImage);
        ImProduct.setImageResource(android.R.color.transparent);
        new ImageLoadTask(productImage,ImProduct).execute();



        buttonBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductPageActivity.this, PurchaseActivity.class);
                Bundle bundle = new Bundle();

                bundle.putString("ProductURL", aBundle.getString("ProductURL"));
                bundle.putString("ProductId", aBundle.getString("ProductId"));

                intent.putExtras(bundle);
                v.getContext().startActivity(intent);
            }
        });


    }

}

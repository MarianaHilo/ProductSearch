package com.example.starteck.myapplication;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

 /*
  @BindView(R.id.searchEditText)
    TextView etSearch;
    @BindView(R.id.button)
    Button searchBtn;
    @BindView(R.id.my_recycler_view)
    RecyclerView recycleView;
    SearchResultsRVAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    */

    private Button searchBtn;
    private EditText etSearch;
    // private ArrayList<Product> data;
    private SearchResultsRVAdapter adapter;
    private RecyclerView recycleView;
    // private RecyclerView recycleView;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycleView = (RecyclerView) findViewById(R.id.my_recycler_view);
        searchBtn = (Button) findViewById(R.id.button);
        etSearch = (EditText) findViewById(R.id.searchEditText);

        // ArrayList<Product> productsArray = new ArrayList<>();
        //productsArray = productdatafetcher.fetchData();

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new AsyncTask<Void, Void, ArrayList<Product>>() {

                    @Override
                    protected void onPostExecute(ArrayList<Product> productsArray) {
                        super.onPostExecute(productsArray);
                        adapter = new SearchResultsRVAdapter(productsArray);
                        layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
                        recycleView.setLayoutManager(layoutManager);
                        recycleView.setAdapter(adapter);
                    }

                    @Override
                    protected ArrayList<Product> doInBackground(Void... params) {
                        ProductDataFetcher productdatafetcher = new ProductDataFetcher(MainActivity.this);
                        ArrayList<Product> productsArray = new ArrayList<>();
                        return productdatafetcher.fetchData();

                    }


                }.execute();


            }

        });
    }
}




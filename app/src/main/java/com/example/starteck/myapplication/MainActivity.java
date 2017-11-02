package com.example.starteck.myapplication;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
    private Button BtnList;
    private Button BtnGrid;
    private int coloumnNumber;

    private EditText etSearch;
    // private ArrayList<Product> data;
    private SearchResultsRVAdapter adapter;
    private RecyclerView recycleView;
    // private RecyclerView recycleView;
    private RecyclerView.LayoutManager layoutManager;
    ArrayList<Product> productsArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycleView = (RecyclerView) findViewById(R.id.my_recycler_view);
        searchBtn = (Button) findViewById(R.id.button);
        etSearch = (EditText) findViewById(R.id.searchEditText);
        BtnList = (Button) findViewById(R.id.buttonList);
        BtnGrid = (Button) findViewById(R.id.buttonGrid);

        SharedPreferences sharedP = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedP.edit();
        String thePreference = sharedP.getString("MyPref", "default");
        editor.putString("MyPref", "Elena").apply();
        Toast.makeText(this, thePreference, Toast.LENGTH_SHORT).show();
        // ArrayList<Product> productsArray = new ArrayList<>();
        //productsArray = productdatafetcher.fetchData();

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 final String input = etSearch.getText().toString();

                new AsyncTask<Void, Void, ArrayList<Product>>() {

                    @Override
                    protected void onPostExecute(ArrayList<Product> productsArray) {
                        super.onPostExecute(productsArray);
                        adapter = new SearchResultsRVAdapter(productsArray, "list");
                        layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
                        recycleView.setLayoutManager(layoutManager);
                        recycleView.setAdapter(adapter);
                    }

                    @Override
                    protected ArrayList<Product> doInBackground(Void... params) {
                        ProductDataFetcher productdatafetcher = new ProductDataFetcher(MainActivity.this);
                        productsArray = new ArrayList<>();
                        productsArray = productdatafetcher.fetchData(input);
                        return productsArray;

                    }


                }.execute();


            }

        });

        Resources res = getResources();
         coloumnNumber = res.getInteger(R.integer.coloumn_number);
        BtnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter = new SearchResultsRVAdapter(productsArray,"grid");
                recycleView.setLayoutManager(new GridLayoutManager(getApplicationContext(),coloumnNumber));
                recycleView.setAdapter(adapter);


            }
        });


        BtnGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter = new SearchResultsRVAdapter(productsArray,"list");
                recycleView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                recycleView.setAdapter(adapter);


            }
        });
    }


}




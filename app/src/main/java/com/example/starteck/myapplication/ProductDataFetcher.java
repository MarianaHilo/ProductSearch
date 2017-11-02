package com.example.starteck.myapplication;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by Starteck on 9/29/2017.
 */

public class ProductDataFetcher implements IDatafetcher<Product> {
    private IDataLoader dataLoader;
    private Context context;
    private IParser parser;

    public ProductDataFetcher(Context context) {

        this.context = context;
       // this.dataLoader = new DataLoaderFromResource(context);
        this.dataLoader = new DataLoaderFromAPI();
        this.parser = new ParserJSON();
    }

    @Override
    public ArrayList<Product> fetchData(String input) {
        String data = dataLoader.loadDatat(input);

       return  parser.ParseData(data);
    }
}

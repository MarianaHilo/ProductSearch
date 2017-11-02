package com.example.starteck.myapplication;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Starteck on 9/29/2017.
 */

class DataLoaderFromResource implements IDataLoader {
    private Context context;

    public DataLoaderFromResource(Context context) {
        this.context = context;
    }


    @Override
    public String loadDatat(String input) {
        return loadJSONFromAsset(input);
    }

    public String loadJSONFromAsset(String input) {

        String json = null;
        try {

            InputStream is = context.getResources().openRawResource(R.raw.search);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

}

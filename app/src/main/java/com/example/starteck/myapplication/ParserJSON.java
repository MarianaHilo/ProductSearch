package com.example.starteck.myapplication;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Starteck on 9/29/2017.
 */

public class ParserJSON implements IParser<Product>{

    public ArrayList<Product> ParseData(String data){

        ArrayList<Product> products= new ArrayList<>() ;
        JSONObject jObject = null;
        try {
            jObject = new JSONObject(data);
            JSONArray jArray = jObject.getJSONArray("products");

            for (int i=0; i < jArray.length(); i++)
            {
                try {
                    JSONObject oneObject = jArray.getJSONObject(i);
                    // Pulling items from the array
                    String objectName = oneObject.getString("name");
                    String objectDesc = oneObject.getString("description");
                    String objectPrice = oneObject.getString("price");
                    String objectImage = oneObject.getString("imageUrl");
                    String objectProductURL = oneObject.getString("productUrl");
                    String objectProductId = oneObject.getString("id");


                    Product product = new Product(objectName,objectDesc, objectImage,objectPrice,objectProductURL,objectProductId);
                    products.add(product);

                } catch (JSONException e) {
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    return products;
    }

}

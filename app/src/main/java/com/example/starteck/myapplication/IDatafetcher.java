package com.example.starteck.myapplication;

import java.util.ArrayList;

/**
 * Created by Starteck on 9/29/2017.
 */

public interface IDatafetcher<T> {

    ArrayList<T> fetchData(String input);

}

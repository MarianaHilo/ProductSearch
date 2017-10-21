package com.example.starteck.myapplication;

import java.util.ArrayList;

/**
 * Created by Starteck on 9/30/2017.
 */

public interface IParser<T> {

    public ArrayList<T> ParseData(String data);
}

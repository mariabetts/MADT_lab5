package com.example.madt_lab5;

import android.os.AsyncTask;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;

public abstract class Async_Data_Loader extends AsyncTask<String, Void, ArrayList<String>> {

    protected ArrayList<String> doInBackground(String... params) {
        try {
            return Data_reader.ApiValues();
        } catch (Exception ex) {
            StringWriter SW = new StringWriter();
            ex.printStackTrace(new PrintWriter(SW));

        }
        return null;
    }

    protected abstract void onPostExecute(ArrayList<String> result);

}

   


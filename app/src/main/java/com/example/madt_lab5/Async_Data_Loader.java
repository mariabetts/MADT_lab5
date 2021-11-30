package com.example.madt_lab5;

import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import java.io.IOException;
import java.util.Arrays;

public class Async_Data_Loader extends AsyncTask<String,Void,List<String>> {

    protected List<String> doInBackground(String... params) {
        try {
            return com.example.madt_lab5.Data_reader.ApiValues(params[0]);
        } catch (IOException exmp) {
            return Arrays.asList(String.format("An error has occured, please try again => %s", exmp.getMessage()));

        }
    }
    @Override
    protected void onPostExecute(List<String> result)
    {
        super.onPostExecute(result);
    }




}

   


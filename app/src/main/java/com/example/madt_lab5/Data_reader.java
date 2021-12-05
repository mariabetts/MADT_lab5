package com.example.madt_lab5;

import static com.example.madt_lab5.FloatRate_Constant.FloatRate_Url;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;;



public class Data_reader {

    public static ArrayList<String> ApiValues() throws IOException {
        ArrayList<String> result = new ArrayList<>();
        InputStream ContentsApi = GetURLContent(FloatRate_Url);
        try {
            result = (ArrayList<String>) Parser.getBaseUSRate(ContentsApi);
        } finally {
            if (ContentsApi != null) {
                ContentsApi.close();
            }
        }
        return result;
    }

    private static InputStream GetURLContent(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setReadTimeout(10000);
        conn.setConnectTimeout(15000);
        conn.setRequestMethod("GET");
        conn.setDoInput(true);
        conn.connect();
        return conn.getInputStream();
    }


}



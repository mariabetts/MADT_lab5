package com.example.madt_lab5;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static com.example.madt_lab5.FloatRate_Constant.FloatRates_Url;

public class Data_reader
{
    private static InputStream GetURLContent (String urlString) throws IOException
    {
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setReadTimeout(10000);
        conn.setConnectTimeout(15000);
        conn.setRequestMethod("GET");
        conn.setDoInput(true);
        conn.connect();
        return conn.getInputStream();
    }

    public static List<String> ApiValues(String apicode) throws IOException {
        InputStream ContentsApi = null;
        List<String> result = new ArrayList<>();
        try {
            switch (apicode) {
                case FloatRates_Url:
                    ContentsApi = GetURLContent(FloatRates_Url);
                    result.addAll(Parser.getBaseUSRate(ContentsApi));
                    break;
                default:
            }

        } finally {
            if (ContentsApi != null) {
                ContentsApi.close();
            }
            return result;
        }





    }
}



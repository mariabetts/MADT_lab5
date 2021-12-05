package com.example.madt_lab5;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView lvdata;
    private TextView datastats;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.lvdata = findViewById(R.id.lvdata);
        this.datastats = findViewById(R.id.datastatus);

    }

    public void setAdapter(ArrayList<String> result) {
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, result);
        lvdata.setAdapter(arrayAdapter);
    }

    public void GetData(View view) {
        this.datastats.setText("Getting Data, Please Wait");
        new Async_Data_Loader() {
            @Override
            public void onPostExecute(ArrayList<String> result) {
                setAdapter(result);
                datastats.setText("Rates");
            }
        }.execute();
    }
}
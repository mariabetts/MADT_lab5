package com.example.madt_lab5;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private ListView lvdata;
    public TextView datastatus;
    public ArrayAdapter listadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.lvdata = findViewById(R.id.lvdata);
        this.datastatus = findViewById(R.id.datastatus);

        this.listadapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, new ArrayList<>());
        // gotta fumble around and set the listview to the adapater for all classes
        this.lvdata.setAdapter(this.listadapter);


    }
    @SuppressLint("The_Static_Field")

    public void GetData (View view)
    {
        this.datastatus.setText("Getting Data, Please Wait");
        new Async_Data_Loader()
        {
            @Override
            public void onPostExecute(List<String> result) {
                datastatus.setText("Rates against USD");
                listadapter.clear();
                listadapter.addAll(result);
                listadapter.notifyDataSetChanged();
            }
        }.execute(FloatRate_Constant.FloatRates_Url);
    }
}
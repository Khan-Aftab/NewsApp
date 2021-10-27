package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.newsapp.Features.CalculatorActivity;
import com.example.newsapp.Features.NotificationActivity;
import com.example.newsapp.Features.ShowLocActivity;
import com.example.newsapp.Features.StorageActivity;

import java.util.ArrayList;
import java.util.List;

public class SettingsActivity extends AppCompatActivity {
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        getSupportActionBar().setTitle(Html.fromHtml("<font color =\"black\">" + "Features" + "</font>"));

        listView = findViewById(R.id.listView);

        List<String> list = new ArrayList<>();

        list.add("Calculator");
        list.add("Notification Alert");
        list.add("Save Data");
        list.add("Where am I?");

        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, list);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0)
                {
                    Intent intent = new Intent(SettingsActivity.this, CalculatorActivity.class);
                    startActivity(intent);
                }
                else if(position == 1)
                {
                    Intent intent = new Intent(SettingsActivity.this, NotificationActivity.class);
                    startActivity(intent);
                }
                else if(position == 2)
                {
                    Intent intent = new Intent(SettingsActivity.this, StorageActivity.class);
                    startActivity(intent);
                }
                else if(position == 3)
                {
                    Intent intent = new Intent(SettingsActivity.this, ShowLocActivity.class);
                    startActivity(intent);
                }
            }
        });


    }

}

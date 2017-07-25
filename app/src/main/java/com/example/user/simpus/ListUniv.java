package com.example.user.simpus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class ListUniv extends AppCompatActivity {

    ListView lv;

    String[] strings= {"1. satu", "2. dua"};

    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_univ);

        lv= (ListView) findViewById(R.id.listunivview);

        adapter= new ArrayAdapter(this, android.R.layout.simple_list_item_1, strings);

        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent InfoUniv = new Intent(ListUniv.this, InfoList.class);
                ListUniv.this.startActivity(InfoUniv);
            }
        });
    }
}

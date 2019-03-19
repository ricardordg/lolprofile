package com.example.ricardo.teste3;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

/**
 *  CLASSE INCOMPLETA - NÃO EXIBE LIST VIEW
 *
 *
 *
 */


public class MasteriesActivity extends AppCompatActivity {
    private AdapterListView adapterListView;

    ListView listView;

    private ArrayList<ItemListView>  itemListViews;

    private SummonerClass summonerC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Champions");

        Intent intent = getIntent();
        summonerC = (SummonerClass) intent.getSerializableExtra("masteriesActivity");

        setContentView(R.layout.list);

        listView = (ListView) findViewById(R.id.listid);

        adapterListView = new AdapterListView(this, itemListViews);

        createListView();

        //adapterListView.notifyDataSetChanged();
    }

    private void createListView(){
        itemListViews = new ArrayList<ItemListView>();

        for(int i = 0; i < summonerC.getMcl().size(); i++){
            ItemListView  item = new ItemListView();
            item.setTexto(summonerC.getMcl().get(i).getName());
            itemListViews.add(item);
        }

        adapterListView = new AdapterListView(this,itemListViews);

        listView.setAdapter(adapterListView);

        listView.setCacheColorHint(Color.TRANSPARENT);

        adapterListView.notifyDataSetChanged();
    }


}

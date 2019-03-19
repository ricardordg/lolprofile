package com.example.ricardo.teste3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.constant.Region;
import net.rithms.riot.dto.Summoner.Summoner;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Home");

    }

    @Override
    protected void onResume(){
        super.onResume();

        final SummonerClass summonerC = new SummonerClass();

        final Intent intent = new Intent(this,ResumeProfileActivity.class);

        final EditText textSummonerName = (EditText) findViewById(R.id.summonerEditText);
        ImageButton button = (ImageButton) findViewById(R.id.searchButton);

        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //startActivity(intent);
                summonerC.setName(textSummonerName.getText().toString());

                chamarSearch(summonerC);
                //intent.putExtra("sclass", summonerC);
                //startActivity(intent);
            }
        });
    }

    private void chamarSearch(SummonerClass summonerC){
        Search search = new Search(MainActivity.this);
        search.execute(summonerC);
    }
}

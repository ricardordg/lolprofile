package com.example.ricardo.teste3;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import net.rithms.riot.dto.Champion.Champion;
import net.rithms.riot.dto.League.League;
import net.rithms.riot.dto.League.LeagueEntry;
import net.rithms.riot.dto.Static.Image;

import org.w3c.dom.Text;

import java.util.List;

public class ResumeProfileActivity extends AppCompatActivity {
    private SummonerClass summonerC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume_profile);

        getSupportActionBar().setTitle("Profile");

        Intent intent = getIntent();
        summonerC = (SummonerClass)intent.getSerializableExtra("resumeProfile");

        String nameLeague = "UNRANKED";

        List<League> l = null;

        TextView leaguePoints = (TextView) findViewById(R.id.leaguePoints);
        TextView leagueText = (TextView) findViewById(R.id.leagueText);

        if(summonerC.isRanked()) {

            for (String k : summonerC.getLeagues().keySet()) {
                l = summonerC.getLeagues().get(k);

            }

            League league = null;

            for (League ls : l) {
                league = ls;
            }

            nameLeague = league.getTier();

            LeagueEntry le = null;

            for (LeagueEntry lle : league.getEntries()) {
                le = lle;
            }

            leaguePoints.setText(le.getLeaguePoints() + " Point(s)");
            leagueText.setText(nameLeague + " " + le.getDivision());
        } else{
            leaguePoints.setText("");
            leagueText.setText("Unranked");
        }

        TextView summonerNameText = (TextView) findViewById(R.id.summonerNameText);
        TextView levelText = (TextView) findViewById(R.id.levelText);

        setLeagueImage(nameLeague);

        if(summonerC.getChampionMasteries() != null && summonerC.getChampionMasteries().size() >= 1)
            setMaestriesImages();


        summonerNameText.setText(""+summonerC.getName());
        levelText.setText("Level " + summonerC.getLevel());
    }

    @Override
    protected void onResume() {
        super.onResume();

        Button button = (Button) findViewById(R.id.mbutton);

        final Intent intent = new Intent(this, MasteriesActivity.class);
        intent.putExtra("masteriesActivity",summonerC);

        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(intent);
            }
        });
    }

    private void setLeagueImage(String nameLeague){
        ImageView leagueImage = (ImageView) findViewById(R.id.imageLeague);

        switch(nameLeague){
            case "BRONZE":
                leagueImage.setImageResource(R.drawable.bronze);
                break;
            case "PLATINUM":
                leagueImage.setImageResource(R.drawable.platinum);
                break;
            case "GOLD":
                leagueImage.setImageResource(R.drawable.gold);
                break;
            case "SILVER":
                leagueImage.setImageResource(R.drawable.silver);
                break;
            case "DIAMOND":
                leagueImage.setImageResource(R.drawable.diamond);
                break;
            case "CHALLENGER":
                leagueImage.setImageResource(R.drawable.challenger);
                break;
            case "MASTER":
                leagueImage.setImageResource(R.drawable.master);
                break;
            default:
                leagueImage.setImageResource(R.drawable.unranked);
                break;
        }
    }

    private void setMaestriesImages(){
        ImageView imageMaestry1 = (ImageView) findViewById(R.id.imageMaestry1);
        ImageView imageMaestry2 = (ImageView) findViewById(R.id.imageMaestry2);
        ImageView imageMaestry3 = (ImageView) findViewById(R.id.imageMaestry3);

        int champion1 = (int) summonerC.getChampionMasteries().get(0).getChampionId();
        int champion2 = -1;
        int champion3 = -1;

        if(summonerC.getChampionMasteries().size() >= 2)
            champion2 = (int) summonerC.getChampionMasteries().get(1).getChampionId();

        if(summonerC.getChampionMasteries().size() >= 3)
            champion3 = (int) summonerC.getChampionMasteries().get(2).getChampionId();

        int c1level = summonerC.getChampionMasteries().get(0).getChampionLevel();
        int c2level = -1;
        int c3level = -1;
        if(summonerC.getChampionMasteries().size() >= 2)
            c2level = summonerC.getChampionMasteries().get(1).getChampionLevel();

        if(summonerC.getChampionMasteries().size() >= 3)
            c3level = summonerC.getChampionMasteries().get(2).getChampionLevel();

        String c1 = null;
        String c2 = null;
        String c3 = null;

        for(String s : summonerC.getMcl().keySet()){
            if(summonerC.getMcl().get(s).getId() == champion1){
                c1 = summonerC.getMcl().get(s).getName();
                c1 = "@drawable/" + c1.toLowerCase();
                c1 = c1.replace(" ","");
            }
            else if (summonerC.getMcl().get(s).getId() == champion2 && summonerC.getChampionMasteries().size() >= 2){
                c2 = summonerC.getMcl().get(s).getName();
                c2 = "@drawable/" + c2.toLowerCase();
                c2 = c2.replace(" ","");
            }
            else if (summonerC.getMcl().get(s).getId() == champion3 && summonerC.getChampionMasteries().size() >= 3){
                c3 = summonerC.getMcl().get(s).getName();
                c3 = "@drawable/" + c3.toLowerCase();
                c3 = c3.replace(" ","");
            }
        }

        int imageResource1 = getResources().getIdentifier(c1,null,getPackageName());
        Drawable res = getResources().getDrawable(imageResource1);
        imageMaestry1.setImageDrawable(res);

        if(summonerC.getChampionMasteries().size() >= 2) {
            int imageResource2 = getResources().getIdentifier(c2, null, getPackageName());
            Drawable res2 = getResources().getDrawable(imageResource2);
            imageMaestry2.setImageDrawable(res2);
        }
        if(summonerC.getChampionMasteries().size() >= 3) {
            int imageResource3 = getResources().getIdentifier(c3, null, getPackageName());
            Drawable res3 = getResources().getDrawable(imageResource3);
            imageMaestry3.setImageDrawable(res3);
        }
        setIconsMasteries(c1level,c2level,c3level);
    }

    private void setIconsMasteries(int c1level, int c2level, int c3level){
        ImageView iconMastery1 = (ImageView) findViewById(R.id.mastery1);
        ImageView iconMastery2 = (ImageView) findViewById(R.id.mastery2);
        ImageView iconMastery3 = (ImageView) findViewById(R.id.mastery3);

        switch(c1level){
            case 1:
                iconMastery1.setImageResource(R.drawable.mastery1);
                break;
            case 2:
                iconMastery1.setImageResource(R.drawable.mastery2);
                break;
            case 3:
                iconMastery1.setImageResource(R.drawable.mastery3);
                break;
            case 4:
                iconMastery1.setImageResource(R.drawable.mastery4);
                break;
            case 5:
                iconMastery1.setImageResource(R.drawable.mastery5);
                break;
            case 6:
                iconMastery1.setImageResource(R.drawable.mastery6);
                break;
            case 7:
                iconMastery1.setImageResource(R.drawable.mastery7);
                break;
        }

        if(c2level != -1) {
            switch (c2level) {
                case 1:
                    iconMastery2.setImageResource(R.drawable.mastery1);
                    break;
                case 2:
                    iconMastery2.setImageResource(R.drawable.mastery2);
                    break;
                case 3:
                    iconMastery2.setImageResource(R.drawable.mastery3);
                    break;
                case 4:
                    iconMastery2.setImageResource(R.drawable.mastery4);
                    break;
                case 5:
                    iconMastery2.setImageResource(R.drawable.mastery5);
                    break;
                case 6:
                    iconMastery2.setImageResource(R.drawable.mastery6);
                    break;
                case 7:
                    iconMastery2.setImageResource(R.drawable.mastery7);
                    break;
            }
        }

        if(c3level != -1) {
            switch (c3level) {
                case 1:
                    iconMastery3.setImageResource(R.drawable.mastery1);
                    break;
                case 2:
                    iconMastery3.setImageResource(R.drawable.mastery2);
                    break;
                case 3:
                    iconMastery3.setImageResource(R.drawable.mastery3);
                    break;
                case 4:
                    iconMastery3.setImageResource(R.drawable.mastery4);
                    break;
                case 5:
                    iconMastery3.setImageResource(R.drawable.mastery5);
                    break;
                case 6:
                    iconMastery3.setImageResource(R.drawable.mastery6);
                    break;
                case 7:
                    iconMastery3.setImageResource(R.drawable.mastery7);
                    break;
            }
        }
    }
}

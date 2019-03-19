package com.example.ricardo.teste3;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.RestrictionEntry;
import android.os.AsyncTask;
import android.util.Log;

import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.constant.PlatformId;
import net.rithms.riot.constant.Region;
import net.rithms.riot.dto.ChampionMastery.ChampionMastery;
import net.rithms.riot.dto.League.League;
import net.rithms.riot.dto.League.LeagueEntry;
import net.rithms.riot.dto.Summoner.Summoner;

import java.util.List;
import java.util.Map;

/**
 * Created by Ricardo on 22/06/2016.
 */
public class Search extends AsyncTask<SummonerClass, Void, Void> {
    private ProgressDialog pd;
    private Activity activity;
    private SummonerClass summoner;


    @Override
    protected void onPreExecute(){
        pd = ProgressDialog.show(activity, "Procurando","Por favor espere...");

    }

    public Search(Activity activity){
        this.activity = activity;
    }

    @Override
    protected Void doInBackground(SummonerClass...params) {
        RiotApi api = new RiotApi("97aba231-c6ab-42a0-ac3c-5d66a8fa2a15");

        summoner = params[0];

        try {
            Map<String, Summoner> summonersAPI = api.getSummonersByName(Region.BR, summoner.getName());

            summoner.setOk(true);

            for(String key : summonersAPI.keySet()){
                Summoner summonerAPI = summonersAPI.get(key);
                summoner.setId((int)summonerAPI.getId());
                summoner.setName(summonerAPI.getName());
                summoner.setLevel((int)summonerAPI.getSummonerLevel());
            }

            try {
                summoner.setChampionMasteries(api.getChampionMasteries(PlatformId.BR, summoner.getId()));
            } catch(RiotApiException e){
                summoner.setChampionMasteries(null);
            }
            Integer i = summoner.getId();

            String idString = i.toString();

            try {
                summoner.setLeagues(api.getLeagueEntryBySummoners(Region.BR, (long) summoner.getId()));
                summoner.setRanked(true);
            } catch(RiotApiException e){
                summoner.setRanked(false);
            }
            summoner.setMcl(api.getDataChampionList(Region.BR).getData());

        } catch (RiotApiException e) {
            e.printStackTrace();
            summoner.setOk(false);
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        pd.dismiss();

        if(summoner.isOk()) {
            Intent intent = new Intent(this.activity, ResumeProfileActivity.class);
            intent.putExtra("resumeProfile", summoner);

            activity.startActivity(intent);
        }
    }
}

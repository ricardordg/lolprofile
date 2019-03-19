package com.example.ricardo.teste3;

import android.widget.EditText;
import android.widget.TextView;

import net.rithms.riot.dto.Champion.Champion;
import net.rithms.riot.dto.ChampionMastery.ChampionMastery;
import net.rithms.riot.dto.League.League;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Ricardo on 23/06/2016.
 */
public class SummonerClass implements Serializable{
    boolean ok;
    boolean isRanked;
    int id;
    int level;
    int leaguePoints;
    List<ChampionMastery> championMasteries;
    String name;
    String league;
    TextView textView;
    Map<String,List<League>> leagues;
    Map<String, net.rithms.riot.dto.Static.Champion> mcl;

    public boolean isRanked() {
        return isRanked;
    }

    public void setRanked(boolean ranked) {
        isRanked = ranked;
    }

    public Map<String, net.rithms.riot.dto.Static.Champion> getMcl() {
        return mcl;
    }

    public void setMcl(Map<String, net.rithms.riot.dto.Static.Champion> mcl) {
        this.mcl = mcl;
    }

    public SummonerClass(){
        ok = false;
    }

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public SummonerClass(int id, String name, String league, int level, TextView textView,
                         int leaguePoints, List<ChampionMastery> championsMasteries) {
        this.id = id;
        this.name = name;
        this.league = league;
        this.level = level;
        this.leaguePoints = leaguePoints;
        this.championMasteries = championsMasteries;
        ok = false;
    }

    public Map<String, List<League>> getLeagues() {
        return leagues;
    }

    public void setLeagues(Map<String, List<League>> leagues) {
        this.leagues = leagues;
    }

    public List<ChampionMastery> getChampionMasteries() {
        return championMasteries;
    }

    public void setChampionMasteries(List<ChampionMastery> championMasteries) {
        this.championMasteries = championMasteries;
    }

    public int getLeaguePoints() {
        return leaguePoints;
    }

    public void setLeaguePoints(int leaguePoints) {
        this.leaguePoints = leaguePoints;
    }

    public TextView getTextView() {
        return textView;
    }

    public void setTextView(TextView textView) {
        this.textView = textView;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLeague() {
        return league;
    }

    public int getLevel() {
        return level;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}

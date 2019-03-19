package com.example.ricardo.teste3;

/**
 * Created by Ricardo on 23/06/2016.
 */
public class MasteryClass {
    String championName;
    int championId;
    int playerId;
    int championPointsUntilNextLevel;
    int championLevel;
    int championPointsSinceLastLevel;

    public MasteryClass() {

    }

    public MasteryClass(String championName, int championId, int playerId, int championPointsUntilNextLevel,
                        int championLevel, int championPointsSinceLastLevel) {
        this.championName = championName;
        this.championId = championId;
        this.playerId = playerId;
        this.championPointsUntilNextLevel = championPointsUntilNextLevel;
        this.championLevel = championLevel;
        this.championPointsSinceLastLevel = championPointsSinceLastLevel;
    }

    public String getChampionName() {
        return championName;
    }

    public void setChampionName(String championName) {
        this.championName = championName;
    }

    public int getChampionId() {
        return championId;
    }

    public void setChampionId(int championId) {
        this.championId = championId;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getChampionPointsUntilNextLevel() {
        return championPointsUntilNextLevel;
    }

    public void setChampionPointsUntilNextLevel(int championPointsUntilNextLevel) {
        this.championPointsUntilNextLevel = championPointsUntilNextLevel;
    }

    public int getChampionLevel() {
        return championLevel;
    }

    public void setChampionLevel(int championLevel) {
        this.championLevel = championLevel;
    }

    public int getChampionPointsSinceLastLevel() {
        return championPointsSinceLastLevel;
    }

    public void setChampionPointsSinceLastLevel(int championPointsSinceLastLevel) {
        this.championPointsSinceLastLevel = championPointsSinceLastLevel;
    }
}

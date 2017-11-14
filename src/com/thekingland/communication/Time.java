package com.thekingland.communication;

public class Time {
    private int startTimeMil; //początkowy czas w milisekundach
    private int currentTimeMil; //aktualny czas  w milisekundach
    private int timeOfGame; //zliczony czas w grze
    private int absolutiveTimeOfGames; //caly zliczony czas w grze

    public Time() {
        this.startTimeMil = 0;
        this.currentTimeMil = 0;
        this.timeOfGame = 0;
        this.absolutiveTimeOfGames = 0;
    }
    public Time(int timeOfGame, int absolutiveTimeOfGames) {
        this.startTimeMil = 0;
        this.currentTimeMil = 0;
        this.timeOfGame = timeOfGame;
        this.absolutiveTimeOfGames = absolutiveTimeOfGames;
    }

//////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////

    public void setStartTimeMil(int startTimeMil) {
        this.startTimeMil = startTimeMil;
    }
    public void setStartTimeMil() {
        this.startTimeMil = getCurrentTimeMil();
    }
    public int getStartTimeMil() {
        return this.startTimeMil;
    }
    public void downloadStartTimeMil() {
        this.startTimeMil = (int) System.currentTimeMillis();
    }

    public void setDownloadedTimeMil(int currentTimeMil) {
        this.currentTimeMil = currentTimeMil;
    }
    public int getCurrentTimeMil() {
        return this.currentTimeMil;
    }
    public void downloadCurrentTimeMil() {
        this.currentTimeMil = (int) System.currentTimeMillis();
    }
}

// Tomasz Topolewski
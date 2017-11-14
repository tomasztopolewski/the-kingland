package com.thekingland;

public class OldTime {
    private int startTimeMil; //czas startu produckji w ms
    private int currentTimeMil; //czas aktualnej produckji w ms
    private int time; //czas produkcji w sek
    private int absolutiveTimeOfGame; //caly czas produkcji w obecnej grze
    private int absolutiveTime;


    public OldTime() {
        this.startTimeMil = 0;
        this.currentTimeMil = 0;
        this.time = 0;
        this.absolutiveTimeOfGame = 0;
        this.absolutiveTime = 0;
    }
    public OldTime(int startTimeMil, int currentTimeMil, int differenceTimeMil, int time, int absolutiveTimeOfGame, int absolutiveTime) {
        this.startTimeMil = startTimeMil;
        this.currentTimeMil = currentTimeMil;
        this.time = time;
        this.absolutiveTimeOfGame = absolutiveTimeOfGame;
        this.absolutiveTime = absolutiveTime;
    }

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

    public void setTime(int time) {
        this.time = time;
    }
    public void addTime(int time) {
        if (time >= 0) {
            this.time += time;
        } else System.out.print("Error time: Nie mozna dodac czasu.");
    }
    public int getTime() {
        return this.time;
    }
    public int getTimeArgs(int time) {
        return time;
    } //zwraca wyznaczona ilosc czasu produkcji
    public void removeTime(int time) {
            this.time = this.time - time;
    }

    public void setAbsolutiveTime(int absolutiveTime) {
        this.absolutiveTime = absolutiveTime;
    }
    public void addAbsolutiveTime(int absolutiveTime) {
        if (absolutiveTime >= 0) this.absolutiveTime += absolutiveTime;
        //przydalby sie blad o zlej wartosci czasu dodawane; nie moze byc ujemny
    }
    public int getAbsolutiveTimeOfGame() {
        return this.absolutiveTimeOfGame;
    }

//////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////


    public void calcTimeSec() {
        int differenceTimeMil = currentTimeMil - startTimeMil;
        int time = differenceTimeMil / 1000;
        this.time = this.time + time;
        addAbsolutiveTime(time);
    }

}

// Tomasz Topolewski
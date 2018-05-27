package pl.tomasztopolewski.thekingland.game.production;

import pl.tomasztopolewski.thekingland.communication.Time;

public class TimeForProduction extends Time {
    private int timeOfProduction;
    private int[] timeOfProductionInTab;
    private int producedTime;

    public TimeForProduction() {
        super();
        timeOfProduction = 0;
        timeOfProductionInTab = new int[2];
        producedTime = 0;
    }


    public int getTimeOfProduction() {
        return timeOfProduction;
    }
    public void setTimeOfProduction(int timeOfProduction) {
        this.timeOfProduction = timeOfProduction >= 0 ? timeOfProduction : 0;
    }
    public void addTimeOfProduction(int timeOfProduction) {
        this.timeOfProduction += timeOfProduction >= 0 ? timeOfProduction : 0;
    }
    /*public void calcTimeOfProduction() {
                int time = getTime();
                calcTimeSec();

    }*/
    public int reutrnTimeOfProduction() {
        downloadCurrentTimeMil();
        calcTimeSec();
        return getTime() - this.timeOfProduction;
    }


}

// Tomasz Topolewski

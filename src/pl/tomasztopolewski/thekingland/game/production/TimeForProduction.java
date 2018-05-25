package pl.tomasztopolewski.thekingland.game.production;

import pl.tomasztopolewski.thekingland.communication.Time;

public class TimeForProduction extends Time {
    private int timeOfProduction;
    private int[] timeOfProductionInTab;


    public TimeForProduction() {
        super();
    }



    /*public void setTimeInTab(int[] timeInTab) {
        this.timeInTab = timeInTab;
    }
    public void setTimeInTab() {
        downloadCurrentTimeMil();
        calcTimeSec();

        int min = 0, time = getTime();
        while (time >= 60) {
            min++;
            time -= 60;
        }

        timeInTab = new int[]{min, time};
    }
    public int[] getTimeInTab() {
        return timeInTab;
    }*/

}

// Tomasz Topolewski

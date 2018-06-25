package pl.tomasztopolewski.thekingland.game.production;

public class Production {
    private TimeForProduction timeOfProduction;
    private double indicatorOfProduction;
    private float powerOfFactory;

    private int producedMaterial;
    private int deliveredMaterial;

    public Production() {
        timeOfProduction = new TimeForProduction();
        setIndicatorOfProduction(0);
        setProducedMaterial(0);
    }


    public int getTimeOfProduction() {
        return timeOfProduction.getTimeOfProduction();
    }

    public double getIndicatorOfProduction() {
        return indicatorOfProduction;
    }
    public void setIndicatorOfProduction(double indicatorOfProduction) {
        this.indicatorOfProduction = indicatorOfProduction >= 0 ? indicatorOfProduction : 0;
    }

    public float getPowerOfFactory() {
        return powerOfFactory;
    }
    public void setPowerOfFactory(float powerOfFactory) {
        this.powerOfFactory = powerOfFactory >= 0 ? powerOfFactory : 0;
    }

    public int getProducedMaterial() {
        return producedMaterial;
    }
    private void setProducedMaterial(int producedMaterial) {
        this.producedMaterial = producedMaterial >= 0 ? producedMaterial : 0;
    }
    private void addProducedMaterial(int producedMaterial) {
        this.producedMaterial += (this.producedMaterial + producedMaterial >= 0) && producedMaterial >= 0 ? producedMaterial : 0;
    }

    public int getDeliveredMaterial() {
        return deliveredMaterial;
    }
    public void setDeliveredMaterial(int deliveredMaterial) {
        this.deliveredMaterial = deliveredMaterial >= 0 ? deliveredMaterial : 0;
    }
    public void addDeliveredMaterial(int deliveredMaterial) {
        this.deliveredMaterial += deliveredMaterial >= 0 ? deliveredMaterial : 0;
    }


    public boolean produce() {
        //System.out.println("produced Material before: " + producedMaterial);
        int timeOfProduction = this.timeOfProduction.reutrnTimeOfProduction();
        //System.out.println("timeOfProduction: " + timeOfProduction);
        if (timeOfProduction >= 10) {
            this.timeOfProduction.addTimeOfProduction(timeOfProduction);
            //System.out.println("production: (double) " + (powerOfFactory * (timeOfProduction * indicatorOfProduction)));
            //System.out.println("production: (int) " + (int) (powerOfFactory * (timeOfProduction * indicatorOfProduction)));
            addProducedMaterial((int) (powerOfFactory * (timeOfProduction * indicatorOfProduction)));
            return true;
        } //else System.out.println("INFO: Produkcja jest w trakcie. Spróbuj za " + (10 - timeOfProduction) + " sec.\n");
        //System.out.println("produced Material after: " + producedMaterial);
        return false;
    }

}

// Tomasz Topolewski

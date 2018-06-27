package pl.tomasztopolewski.thekingland.game.production;

public class Production {
    private TimeForProduction timeOfProduction;
    private double indicatorOfProduction;
    private double powerOfFactory;

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

    public double getPowerOfFactory() {
        return powerOfFactory;
    }
    public void setPowerOfFactory(double powerOfFactory) {
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
        int timeOfProduction = this.timeOfProduction.reutrnTimeOfProduction();
        if (timeOfProduction >= 10) {
            this.timeOfProduction.addTimeOfProduction(timeOfProduction);
            addProducedMaterial((int) (powerOfFactory * (timeOfProduction * indicatorOfProduction)));
            return true;
        }
        return false;
    }

}

// Tomasz Topolewski

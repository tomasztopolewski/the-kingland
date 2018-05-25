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


    public void produce() {
        int timeOfProduction = this.timeOfProduction.reutrnTimeOfProduction();
        addProducedMaterial((int) (powerOfFactory * (timeOfProduction * indicatorOfProduction)));
    }

}

// Tomasz Topolewski

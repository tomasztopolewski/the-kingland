package pl.tomasztopolewski.thekingland;

public abstract class Materials implements Ore {
    private int quantity; //quantity of material  produced in last game
    private int producedQuantity;  //quantity of material producing in actual game
    private float percentProduction; //percent production, resultant
    private float burden; //load on production across i.a weather, random elements (fire, sabotage)
    private int sizeWarehouse; //liczba materialow jaka moze byc zgromadozna w krolestwie
    private double indicatorProduction; //ile materialow zostanie wyprodukowanych przez 1 sekunde

    private boolean successProduction; //przechowuje czy produkcja materilow powiodla sie


    public Materials(int quantity, int producedQuantity, float percentProduction, float burden, int sizeWarehouse) {
        this.quantity = quantity;
        this.producedQuantity = producedQuantity;
        this.percentProduction = percentProduction;
        this.burden = burden;
        this.sizeWarehouse = sizeWarehouse;
        this.indicatorProduction = 0;
        this.successProduction = false;
    }

    public Materials() {
        this.quantity = 0;
        this.producedQuantity = 0;
        this.percentProduction = 0;
        this.burden = 0;
        this.sizeWarehouse = 70000;
        this.indicatorProduction = 0;
    }


    public void setQuantity(int quantity) {
        if (quantity < 0) {
            this.quantity += 0;
            System.out.print("Error: Lack of material to be added.");
        } else this.quantity = quantity;
    }
    public int getQuantity() {
        return this.quantity;
    }

    public void setProducedQuantity(int producedQuantity) {
        if (producedQuantity < 0) {
            this.producedQuantity += 0;
            System.out.print("Error: Lack of material to be added.");
        } else this.producedQuantity = producedQuantity;
    }
    public int getProducedQuantity() {
        return this.producedQuantity;
    }
    public void addProducedQuantity(int producedQuantity) {
        if (producedQuantity < 0) {
            this.producedQuantity += 0;
            System.out.print("Error: Lack of material to be added.");
        } else {
            this.producedQuantity += producedQuantity;
        }
    }

    public int getSumQuantity() {
        return this.quantity + this.producedQuantity;
    }

    public void setPercentProduction(float percentProduction) {
        if (percentProduction < 0 || percentProduction > 100) {
            System.out.print("Error: Percent production is too large.");
        } else if (percentProduction >= 0 && percentProduction <= 100) {
            this.percentProduction = percentProduction;
        }
    }
    public float getPercentProduction() {
        return this.percentProduction;
    }

    public void setBurden(float burden) {
        this.burden = burden;
    }
    public float getBurden() {
        return this.burden;
    }

    public void setSizeWarehouse(int sizeWarehouse) {
        this.sizeWarehouse = sizeWarehouse;
    }
    public int getSizeWarehouse() {
        return this.sizeWarehouse;
    }


    public void setIndicatorProduction(double indicatorProduction) {
        this.indicatorProduction = indicatorProduction;
    }
    public double getIndicatorProduction() {
        return this.indicatorProduction;
    }


    public void setSuccessProduction(boolean successProduction) {
        this.successProduction = successProduction;
    }
    public boolean getSuccessProduction() {
        return this.successProduction;
    }

//////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////


    public void calcIndicatorProduction(Sociaty sociaty1) {
        this.indicatorProduction = 0;
        double calculatedIndicatorProduction = 0;

        calculatedIndicatorProduction = ((sociaty1.calcfForcePeople() * sociaty1.calcFactorOfMood()) / sociaty1.getWillingness());
        calculatedIndicatorProduction = (((calculatedIndicatorProduction * getPercentProduction()) - getBurden()) / 10000) - 0.2;

        this.indicatorProduction = calculatedIndicatorProduction;
    }

    public void productionMaterials(OldTime time, Sociaty sociaty) {
        calcIndicatorProduction(sociaty);

        time.downloadCurrentTimeMil(); time.calcTimeSec(); //pobieranie czasu i przeliczanie
        time.setStartTimeMil(time.getCurrentTimeMil()); //ustalanie wartosci startowej dla nastepnego cyklu produkcyjnego

        double indicatorProduction = getIndicatorProduction();
        int timeProduction = time.getTime();
        int productedMaterials = 0;
        productedMaterials = (int) (timeProduction * indicatorProduction);

        time.setTime(0);
        //time.removeTime(timeProduction);
        addProducedQuantity(productedMaterials);
        successProduction = true;
    }
}

// Tomasz Topolewski
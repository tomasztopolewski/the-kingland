/*
Nazwa: Kamieniołom
Produkacja kamienia.
Przechowuje poziom rozwinięcia kamieniołomu.
 */
package pl.tomasztopolewski.thekingland.building.buildings.factories;

import pl.tomasztopolewski.thekingland.building.Building;
import pl.tomasztopolewski.thekingland.building.BuildingWithStaticSquare;
import pl.tomasztopolewski.thekingland.building.EssentialsBuilding;

public class Quarry extends Building implements EssentialsBuilding, BuildingWithStaticSquare {
    private final int square = 4; // pole powierzchni [m2]

    private final String codeGroupBuilding  = "factories"; // kod grupy do, ktorej należy budynek
    private final String codeBuilding = "quarry"; // kod budynku

    private int levelUpgrade;
    private final int minimumUpgradeLevel = 1;
    private final int maximumUpgradeLevel = 8;

    private final int[] costUpgradeGold =  {0, 5, 15, 60, 180, 720, 2020, 8065, 16100};
    private final int[] costUpgradeWood =  {0, 8, 22, 60, 120, 305, 945, 2270, 9070};
    private final int[] costUpgradeStone = {0, 9, 25, 70, 255, 820, 2050, 6815, 28400};
    private final int[] levelOfAdvancementBuilding = {0, 200, 200, 800, 800, 3600, 3600, 18000, 18000};
    //private final float[] costOfBuyingMoreBuildings = {0, 1, (float) 1.2, (float) 1.9, (float) 2.8, 4};

    private final float[] powerOfFactory = {0, 1, (float)1.2, (float)1.8, 2, (float) 2.1, (float)2.5, (float)2.85, (float)3.2};

/////////////////////////////////////////////////////////////////////////////

    public Quarry(){
        this.levelUpgrade = 0;
    }
    public Quarry(int levelUpgrade) {
        setLevelUpgrade(levelUpgrade);
    }


    public int getSquare() {
        return this.square;
    }

    public String getCodeGroupBuilding() {
        return codeGroupBuilding;
    }
    public String getCodeBuilding() {
        return this.codeBuilding;
    }

    public void setLevelUpgrade(int levelUpgrade) {
        this.levelUpgrade = (levelUpgrade <= maximumUpgradeLevel ? levelUpgrade : 0);
    }
    public int getLevelUpgrade() {
        return this.levelUpgrade;
    }
    public void addLevelUpgrade(int levelUpgrade) {
        this.levelUpgrade = (this.levelUpgrade + levelUpgrade) <= maximumUpgradeLevel && levelUpgrade >= minimumUpgradeLevel ? this.levelUpgrade + levelUpgrade : this.levelUpgrade;
    }

    public int getMinimumUpgradeLevel() {
        return minimumUpgradeLevel;
    }
    public int getMaximumUpgradeLevel() {
        return maximumUpgradeLevel;
    }

    public int getCostUpgradeGoldOneLevel(int numberLevel) {
        return costUpgradeGold[numberLevel];
    } //zwraca koszt ulepszenia dla poziomu w agrumencie
    public int getCostUpgradeWoodOneLevel(int numberLevel) {
        return costUpgradeWood[numberLevel];
    }
    public int getCostUpgradeStoneOneLevel(int numberLevel) {
        return costUpgradeStone[numberLevel];
    }
    public int getLevelOfAdvancementBuilding(int numberLevel) { return levelOfAdvancementBuilding[numberLevel];}

    public float getPowerOfFactory() {
        return powerOfFactory[levelUpgrade];
    }
    public float getPowerOfFactoryForLevel(int numberLevel) {
        return powerOfFactory[numberLevel];
    }
}

// Tomasz Topolewski
/*
Nazwa: Chata Drwala
Produkacja drewna.
Przechowuje poziom rozwinięcia chaty drwala.
 */
package pl.tomasztopolewski.thekingland.game.buildings.factories;

import pl.tomasztopolewski.thekingland.game.EssentialsBuilding;
import pl.tomasztopolewski.thekingland.game.Building;
import pl.tomasztopolewski.thekingland.game.BuildingWithStaticSquare;

public class Lumberjack extends Building implements EssentialsBuilding, BuildingWithStaticSquare {
    private final int square = 4;

    private final String codeGroupBuilding = "factories";
    private final String codeBuilding = "lumberjack";

    private int levelUpgrade;
    private final int minimumUpgradeLevel = 1;
    private final int maximumUpgradeLevel = 8;

    private int[] costUpgradeGold =  {0, 5, 15, 60, 180, 720, 2020, 8065, 16100};
    private int[] costUpgradeWood =  {0, 10, 28, 75, 150, 380, 945, 2840, 11340};
    private int[] costUpgradeStone = {0, 6, 17, 30, 170, 546, 1365, 4550, 19080};
    private final int[] levelOfAdvancementBuilding = {0, 200, 200, 800, 800, 3600, 3600, 18000, 18000};
    //private final float[] costOfBuyingMoreBuildings = {0, 1, (float) 1.2, (float) 1.9, (float) 2.8, 4};

    private final float[] powerOfFactory = {0, 1, (float)1.2, (float)1.8, 2, (float) 2.1, (float)2.5, (float)2.85, (float)3.2};

/////////////////////////////////////////////////////////////////////////////

    public Lumberjack(){
        this.levelUpgrade = 0;
    }
    public Lumberjack(int levelUpgrade){
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
    }
    public int getCostUpgradeWoodOneLevel(int numberLevel) {
        return costUpgradeWood[numberLevel];
    }
    public int getCostUpgradeStoneOneLevel(int numberLevel) {
        return costUpgradeStone[numberLevel];
    }
    public int getLevelOfAdvancementBuilding(int numberLevel) { return levelOfAdvancementBuilding[numberLevel];}

    public float getPowerOfFactoryForLevel(int numberLevel) {
        return powerOfFactory[numberLevel];
    }
    public float getPowerOfFactory() {
        return powerOfFactory[levelUpgrade];
    }

}

// Tomasz Topolewski

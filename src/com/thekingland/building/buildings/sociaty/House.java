/*
Nazwa: Dom
Dodaje ludzi.
Przechowuje poziom rozwinięcia domu.
 */
package com.thekingland.building.buildings.sociaty;

import com.thekingland.building.Building;
import com.thekingland.building.BuildingWithStaticSquare;
import com.thekingland.building.EssentialsBuilding;

public class House extends Building implements EssentialsBuilding, BuildingWithStaticSquare {
    private final int square = 4;

    private final String codeGroupBuilding = "sociaty";
    private final String codeBuilding = "house";

    private int levelUpgrade;
    private final int minimumUpgradeLevel = 1;
    private final int maximumUpgradeLevel = 8;

    private final int[] costUpgradeGold =  {0, 20, 44, 140, 510, 1400, 4100, 13600, 56800};
    private final int[] costUpgradeWood =  {0, 10, 22, 70, 255, 700, 2050, 6815, 28400};
    private final int[] costUpgradeStone = {0, 10, 22, 70, 255, 700, 2050, 6815, 28400};
    private final int[] levelOfAdvancementBuilding = {0, 200, 200, 800, 3600, 3600, 3600, 18000, 18000};
    //private final float[] costOfBuyingMoreBuildings = {0, 1, (float) 1.2, (float) 1.9, (float) 2.8, 4};

    private final int[] numberOfPeople = {0, 50, 80, 120, 200, 250, 400, 500, 750};

/////////////////////////////////////////////////////////////////////////////

    public House(){
        this.levelUpgrade = 0;
    }
    public House(int levelUpgrade) {
        this.levelUpgrade = levelUpgrade;
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

    public int getNumberOfPeopleForLevel(int numberLevel) {
        return numberOfPeople[numberLevel];
    }
    public int getNumberOfPeople() {
        return numberOfPeople[levelUpgrade];
    }
}

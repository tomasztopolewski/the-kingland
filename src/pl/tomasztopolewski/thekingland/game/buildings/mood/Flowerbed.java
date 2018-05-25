/*
Nazwa: Kwietnik
Dodaje punkty upiększenia.
Przechowuje metry kwadratowe powierzchni obiektu.
 */
package pl.tomasztopolewski.thekingland.game.buildings.mood;

import pl.tomasztopolewski.thekingland.game.EssentialsBuilding;
import pl.tomasztopolewski.thekingland.game.Building;
import pl.tomasztopolewski.thekingland.game.BuildingWithChangingSquare;

public class Flowerbed extends Building implements EssentialsBuilding, BuildingWithChangingSquare {
    private int square;
    private final int maximumSquare = 50;

    private final String codeGroupBuilding = "mood";
    private final String codeBuilding = "flower";

    private int levelUpgrade;
    private final int minimumUpgradeLevel = 1;
    private final int maximumUpgradeLevel = 4;

    private final int[] costUpgradeGold =  {0, 30, 150, 320, 700};
    private final int[] costUpgradeWood =  {0, 120, 300, 600, 1000};
    private final int[] costUpgradeStone = {0, 140, 440, 800, 1400};
    private final int[] levelOfAdvancementBuilding = {0, 200, 800, 800, 3600};

    private final float[] embellishmentsPoints = {0, (float)0.5, (float)0.85, (float)1.20, (float)1.6};

/////////////////////////////////////////////////////////////////////////////

    public Flowerbed() {
        this.square = 0;
        this.levelUpgrade = 0;
    }
    public Flowerbed(int square, int levelUpgrade) {
        this.square = (square <= maximumSquare ? square : 0);
        this.levelUpgrade = (levelUpgrade <= maximumUpgradeLevel ? levelUpgrade : 0);
    }


    public void setSquare(int square) {
        this.square = (square <= maximumSquare ? square : 0);
    }
    public int getSquare() {
        return square;
    }
    public void addSquare(int square) {
        this.square += (this.square + square <= maximumSquare ? square : 0);
    }
    public int getMaximumSquare() {
        return maximumSquare;
    }

    public String getCodeGroupBuilding() {
        return codeGroupBuilding;
    }
    public String getCodeBuilding() {
        return codeBuilding;
    }

    public void setLevelUpgrade(int levelUpgrade) {
        this.levelUpgrade = (levelUpgrade <= maximumUpgradeLevel ? levelUpgrade : 0);
    }
    public int getLevelUpgrade() {
        return levelUpgrade;
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

    public float getEmbellishmentsPoints() {
        return embellishmentsPoints[levelUpgrade];
    }
    public float getEmbellishmentsPointsForLevel(int numberLevel) {
        return embellishmentsPoints[numberLevel];
    }
}

// Tomasz Topolewski
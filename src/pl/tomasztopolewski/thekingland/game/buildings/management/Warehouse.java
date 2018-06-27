package pl.tomasztopolewski.thekingland.game.buildings.management;

import pl.tomasztopolewski.thekingland.authentication.preparation.Installation;
import pl.tomasztopolewski.thekingland.game.EssentialsBuilding;
import pl.tomasztopolewski.thekingland.handlingdata.ClassLoadFile;
import pl.tomasztopolewski.thekingland.handlingdata.SettingsObject;
import pl.tomasztopolewski.thekingland.game.Building;
import pl.tomasztopolewski.thekingland.game.BuildingWithStaticSquare;

import java.io.FileNotFoundException;

public class Warehouse extends Building implements EssentialsBuilding, BuildingWithStaticSquare {
    private final int[] square = {0, 4, 6, 9, 12};

    private final String codeGroupBuilding = "management";
    private final String codeBuilding = "warehouse";

    private int levelUpgrade;
    private final int minimumUpgradeLevel = 1;
    private final int maximumUpgradeLevel = 5;

    private final int[] costUpgradeGold =  {0, 100, 15, 60, 180, 720};
    private final int[] costUpgradeWood =  {0, 40, 22, 60, 120, 305};
    private final int[] costUpgradeStone = {0, 35, 25, 70, 255, 820};
    private final int[] levelOfAdvancementBuilding = {0, 200, 200, 800, 3600, 3600};
    //private final float[] costOfBuyingMoreBuildings = {0, 1, (float) 1.9};


    private final int[] space = {0, 3000, 6000, 12000, 35000, 60000};

    public final int numberOfMaterials = 2;
    public final int indexOfMaterialWood = 0;
    public final int indexOfMaterialStone = 1;

    private int[] occupiedSpaceByMaterials; //zajęta przestrzeń przez materiały


    public Warehouse(int levelUpgrade, int[] occupiedSpaceByMaterials) {
        setLevelUpgrade(levelUpgrade);
        this.occupiedSpaceByMaterials = new int[numberOfMaterials];

        loadOccupiedSpaceByMaterial(occupiedSpaceByMaterials);
    }
    public Warehouse() {
        this.levelUpgrade = 0;
        occupiedSpaceByMaterials = new int[numberOfMaterials];
        setOccupiedSpaceByMaterialsOnNothing();
    }

/////////////////////////////////////////////////////////////////////////////

    public int getSquare() {
        return this.square[levelUpgrade];
    }
    public int getSquareForLevel(int numberLevel) {
        return this.square[numberLevel];
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
    }    public int getMinimumUpgradeLevel() {
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


    public int getSpace() {
        return space[levelUpgrade];
    }
    public int getSpace(int numberLevel) {
        return space[numberLevel];
    }

    public int returnFreeSpace() {
        return space[levelUpgrade] - getAllOccupiedSpaceByMaterials();
    }

    public int getNumberOfMaterials() {
        return numberOfMaterials;
    }

    public int getIndexOfMaterialWood() {
        return indexOfMaterialWood;
    }

    public int getIndexOfMaterialStone() {
        return indexOfMaterialStone;
    }

    public void loadOccupiedSpaceByMaterial(int[] occupiedSpaceByMaterials) {
        if (occupiedSpaceByMaterials[indexOfMaterialWood] <= returnFreeSpace()) this.occupiedSpaceByMaterials[indexOfMaterialWood] = occupiedSpaceByMaterials[indexOfMaterialWood];
        if (occupiedSpaceByMaterials[indexOfMaterialStone] <= returnFreeSpace()) this.occupiedSpaceByMaterials[indexOfMaterialStone] = occupiedSpaceByMaterials[indexOfMaterialStone];
    }

    public void setOccupiedSpaceByMaterial(int numberOfMaterial, int quantity) {
        switch (numberOfMaterial) {
            case 0:
                this.occupiedSpaceByMaterials[indexOfMaterialWood] = quantity >= 0 && quantity <= returnFreeSpace() ? quantity : 0;
                break;
            case 1:
                this.occupiedSpaceByMaterials[indexOfMaterialStone] = quantity >= 0 && quantity <= returnFreeSpace() ? quantity : 0;
                break;
            default:
        }
    }
    public void setOccupiedSpaceByMaterialsOnNothing() {
        for (int i = 0; i < numberOfMaterials; i++) occupiedSpaceByMaterials[i] = 0;
    }
    public int getOccupiedSpaceByMaterial(int numberOfMaterial) {
        switch (numberOfMaterial) {
            case 0: return this.occupiedSpaceByMaterials[indexOfMaterialWood];
            case 1: return this.occupiedSpaceByMaterials[indexOfMaterialStone];
            default: return -1;
        }
    }


    public void addWood(int quantity) {
        this.occupiedSpaceByMaterials[indexOfMaterialWood] += quantity <= returnFreeSpace() ? quantity : 0;
    }
    public void addStone(int quantity) {
        this.occupiedSpaceByMaterials[indexOfMaterialStone] += quantity <= returnFreeSpace() ? quantity : 0;
    }


    public void removeWood(int quantity) {
        this.occupiedSpaceByMaterials[indexOfMaterialWood] -= quantity <= this.occupiedSpaceByMaterials[indexOfMaterialWood] ? quantity : 0;
    }
    public void removeStone(int quantity) {
        this.occupiedSpaceByMaterials[indexOfMaterialStone] -= quantity <= this.occupiedSpaceByMaterials[indexOfMaterialStone] ? quantity: 0;
    }

    public int getAllOccupiedSpaceByMaterials() {
        return occupiedSpaceByMaterials[indexOfMaterialWood] + occupiedSpaceByMaterials[indexOfMaterialStone];
    }


    private int convertValueFromSettingObject(String value) {
        return Integer.valueOf(value);
    }

    public boolean enoughWood(int quantity) {
        if (quantity <= getOccupiedSpaceByMaterial(indexOfMaterialWood)) return true;
        else return false;
    }

    public boolean enoughStone(int quantity) {
        if (quantity <= getOccupiedSpaceByMaterial(indexOfMaterialStone)) return true;
        else return false;
    }

}

// Tomasz Topolewski

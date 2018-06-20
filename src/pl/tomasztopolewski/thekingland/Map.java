/**
 * int[] x - przechowuje zmienną x mapy dla odpowiedniego poziomu rozwoju
 * int[] y - przechowuje zmienną y mapy dla odpowiedniego poziomu rozwoju
 * int[] areaSize - przechowuje wielkość mapy dla odpowiedniego poziomu rozwoju
 *
 * costUpgradeGold - cena za 1m, poziomu podstawowego
 * Całkowity koszt ulepszenia:
 *    cost = costUpgradeGold * (++levelUpgrade) * (areaSize[++levelUpgrade] - areaSize[levelUpgrade])
 *
 */
package pl.tomasztopolewski.thekingland;

public class Map {
    private int levelUpgrade;
    private final int minimumUpgradeLevel = 1;
    private final int maximumUpgradeLevel = 5;

    //private int x; // gorna dlugosc pola zamku
    private final int[] x = new int[]{0, 4, 5, 7, 10, 14, 18, 20, 25};
    //private int y; // boczna dlugosc pola zamku
    private final int[] y = new int[]{0, 5, 8, 10, 12, 15, 20, 21, 26};
    //private int areaSize; // maksymalny rozmiar (x * y)
    private final int[] areaSize = new int[]{0, 20, 40, 70, 120, 210, 360, 420, 650};
    //private int occupiedArea; // zajety rozmiar zamku
    private int occupiedArea;

    //boolean failedToAddToTheOccupiedArea;

    private final int costUpgradeGold = 0;


    /*public Map(int x, int y,  int areaSize, int occupiedArea) {
        this.x = x;
        this.y = y;
        this.areaSize = areaSize;
        this.occupiedArea = occupiedArea;
    } //konstrkutkor
    public Map() {
        this.x = 10;
        this.y = 10;
        this.areaSize = 100;
        this.occupiedArea = 0;
    }*/

    public int getLevelUpgrade() {
        return levelUpgrade;
    }
    public void setLevelUpgrade(int levelUpgrade) {
        this.levelUpgrade = levelUpgrade;
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


    public int getX() {
        return this.x[this.levelUpgrade];
    }
    public int getX(int levelUpgrade) {
        return this.x[levelUpgrade];
    }
    public int getY() {
        return this.y[this.levelUpgrade];
    }
    public int getY(int levelUpgrade) {
        return this.y[levelUpgrade];
    }

    public int getAreaSize() {
        return this.areaSize[this.levelUpgrade];
    }
    public int getAreaSize(int levelUpgrade) {
        return this.areaSize[levelUpgrade];
    }

    public int getOccupiedArea() {
        return this.occupiedArea;
    }
    public void setOccupiedArea(int occupiedArea) {
        this.occupiedArea = occupiedArea > 0 && occupiedArea <= getAreaSize() ? occupiedArea : 0;
    }
    public void addOccupiedArea(int occupiedArea) {
        this.occupiedArea += occupiedArea > 0 && (this.occupiedArea + occupiedArea) <= getAreaSize() ? occupiedArea : 0;
    }

    public int getCostUpgradeGold() {
        return costUpgradeGold;
    }
    public int getCostUpgradeGoldNextLevel() {
        if (!(levelUpgrade == maximumUpgradeLevel)) return costUpgradeGold * (levelUpgrade + 1) * (areaSize[levelUpgrade + 1] - areaSize[levelUpgrade]);
        return 0;
    }


/***
    public boolean checkWhetherThereIsFreeSpace(int buildingSize) {
        int expectedOccupiedArea = 0;
        expectedOccupiedArea = buildingSize + occupiedArea;

        if (expectedOccupiedArea > areaSize) {
            return false;
        } else return expectedOccupiedArea <= areaSize;
    }

    public int calcFreeArea() {
        return areaSize - occupiedArea;
    }

    /*public void enlargeAreaSize(int x, int y) {
        this.x += x;
        this.y += y;
        calcAreaSize();
    }
    public void calcAreaSize() {
        areaSize = x + y;
    }

    public void increaseOccupiedArea(int buildingSize) {
        if (checkWhetherThereIsFreeSpace(buildingSize)) {
            this.occupiedArea += buildingSize;
            failedToAddToTheOccupiedArea = true;
        } else {
            System.out.print("Error: Brak miejsca w zamku.\n");
            failedToAddToTheOccupiedArea = false;
        }
    }

*
*/

}

// Tomasz Topolewski
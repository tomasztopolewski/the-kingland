package pl.tomasztopolewski.thekingland.building;

public class Building implements EssentialsBuilding {
    private int square;

    private String codeGroupBuilding;
    private String codeBuilding;

    private int levelUpgrade;
    private int minimumUpgradeLevel;
    private int maximumUpgradeLevel;

    private int[] costUpgradeGold;
    private int[] costUpgradeWood;
    private int[] costUpgradeStone;
    private int[] levelOfAdvancementBuilding;


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
    public void addLevelUpgrade() {
        this.levelUpgrade = (levelUpgrade++ <= maximumUpgradeLevel ? this.levelUpgrade++ : this.levelUpgrade);
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
}

// Tomasz Topolewski
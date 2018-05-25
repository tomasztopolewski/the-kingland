package pl.tomasztopolewski.thekingland.game;

public interface EssentialsBuilding {
    int getSquare();

    String getCodeGroupBuilding();
    String getCodeBuilding();

    void setLevelUpgrade(int levelUpgrade);
    int getLevelUpgrade();
    void addLevelUpgrade();
    int getMaximumUpgradeLevel();

    int getCostUpgradeGoldOneLevel(int numberLevel);
    int getCostUpgradeWoodOneLevel(int numberLevel);
    int getCostUpgradeStoneOneLevel(int numberLevel);
    int getLevelOfAdvancementBuilding(int numberLevel);
}

// Tomasz Topolewski
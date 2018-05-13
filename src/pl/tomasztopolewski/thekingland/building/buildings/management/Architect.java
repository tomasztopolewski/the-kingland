/*
Nazwa: Architekt
Dodaje doświadczenie architekta.
Przechowuje poziom rozwinięcia architekta..
*/
package pl.tomasztopolewski.thekingland.building.buildings.management;


import pl.tomasztopolewski.thekingland.building.Building;
import pl.tomasztopolewski.thekingland.building.BuildingWithStaticSquare;
import pl.tomasztopolewski.thekingland.building.EssentialsBuilding;

public class Architect extends Building implements EssentialsBuilding, BuildingWithStaticSquare {
    private final int square = 1;

    private final String codeGroupBuilding = "management";
    private final String codeBuilding = "architect";

    private int levelUpgrade;
    private final int minimumUpgradeLevel = 1;
    private final int maximumUpgradeLevel = 5;

    private final int[] costUpgradeGold =  {0, 500, 2000, 9000, 45000};
    private final int[] costUpgradeWood =  {0, 250, 800, 2000, 4000};
    private final int[] costUpgradeStone = {0, 250, 900, 2700, 7000};
    private final int[] levelOfAdvancementBuilding = {0, 0, 200, 800, 3600};

    private final int[] architectExperience = {0, 200, 800, 3600, 18000};

/////////////////////////////////////////////////////////////////////////////

    public Architect(){
        this.levelUpgrade = 0;
    }
    public Architect(int levelUpgrade) {
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
        this.levelUpgrade = levelUpgrade <= maximumUpgradeLevel ? levelUpgrade : 0;
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

    public int getArchitectExperienceForLevel(int numberLevel) {
        return architectExperience[numberLevel];
    }
    public int getArchitectExperience() {
        return architectExperience[levelUpgrade];
    }

}

// Tomasz Topolewski

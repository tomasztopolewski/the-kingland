package pl.tomasztopolewski.thekingland.game.buildings.factories;

import pl.tomasztopolewski.thekingland.game.Building;
import pl.tomasztopolewski.thekingland.game.BuildingWithStaticSquare;
import pl.tomasztopolewski.thekingland.game.EssentialsBuilding;

public class Bakery extends Building implements EssentialsBuilding, BuildingWithStaticSquare {
    private final int square = 4;

    private final String codeGroupBuilding = "factories";
    private final String codeBuilding = "bakery";

    private int levelUpgrade;
    private final int minimumUpgradeLevel = 1;
    private final int maximumUpgradeLevel = 8;

    private int[] costUpgradeGold =  {0, 5, 15, 60, 180, 720, 2020, 8065, 16100};
    private int[] costUpgradeWood =  {0, 10, 28, 75, 150, 380, 945, 2840, 11340};
    private int[] costUpgradeStone = {0, 6, 17, 30, 170, 546, 1365, 4550, 19080};
    private final int[] levelOfAdvancementBuilding = {0, 200, 200, 800, 800, 3600, 3600, 18000, 18000};
    //private final float[] costOfBuyingMoreBuildings = {0, 1, (float) 1.2, (float) 1.9, (float) 2.8, 4};

    private final double[] powerOfFactory = {0, 1, 1.2, 1.8, 2, 2.1, 2.5, 2.85, 3.2};

}

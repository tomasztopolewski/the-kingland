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

    private final int numberOfMaterials = 2;
    private final int indexOfMaterialWood = 0;
    private final int indexOfMaterialStone = 1;

    //private ClassLoadFile classLoadFileMaterialOfSpace;
    //private String[] linesOfFileMaterialOfSpace;

    //private SettingsObject[] settingsMaterials;

    private int[] occupiedSpaceByMaterials; //zajęta przestrzeń przez materiały


    public Warehouse(int levelUpgrade, int[] occupiedSpaceByMaterials) {
        setLevelUpgrade(levelUpgrade);
        this.occupiedSpaceByMaterials = new int[numberOfMaterials];

        loadOccupiedSpaceByMaterial(occupiedSpaceByMaterials);
    }
    /*public Warehouse(int levelUpgrade) throws FileNotFoundException {
        setLevelUpgrade(levelUpgrade);
        occupiedSpaceByMaterials = new int[numberOfMaterials];

        classLoadFileMaterialOfSpace  = new ClassLoadFile(Installation.nameOfFile_SpaceOfWarehouse, Installation.pathToFolder);
        linesOfFileMaterialOfSpace = classLoadFileMaterialOfSpace.getDownloadedLines();

        settingsMaterials = new SettingsObject[numberOfMaterials];
        createSettingsMaterials();
        processOfSettingsMaterials();

        setOccupiedSpaceByMaterial(indexOfMaterialWood, convertValueFromSettingObject(settingsMaterials[indexOfMaterialWood].getValue(0)));
        setOccupiedSpaceByMaterial(indexOfMaterialStone, convertValueFromSettingObject(settingsMaterials[indexOfMaterialStone].getValue(0)));
    }*/
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
    public int getSpaceForLevel(int numberLevel) {
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
    /*public void loadOccupiedSpaceByMaterial(int numberOfMaterial, int quantity) {
        switch (numberOfMaterial) {
            case 0:
                this.occupiedSpaceByMaterials[indexOfMaterialWood] = quantity;// >= 0 ? quantity : 0;
                break;
            case 1:
                this.occupiedSpaceByMaterials[indexOfMaterialStone] = quantity;// >= 0 ? quantity : 0;
                break;
            default: break;
        }
    }*/
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
    /*public void addWood(int quantity) {
        if (returnFreeSpace() == 0) System.out.println("INFO: Magazyn jest pełny. Nie dodano materiałów.\n");
        else {
            if (quantity <= returnFreeSpace()) {
                this.occupiedSpaceByMaterials[indexOfMaterialWood] += quantity;
                System.out.println("INFO: Dodano do magazynu " + quantity + " jedn. drewna.\n");
            } else if (quantity > returnFreeSpace()) {
                int freeSpace = returnFreeSpace();
                this.occupiedSpaceByMaterials[indexOfMaterialWood] += freeSpace;
                System.out.println("INFO: Dodano do magazynu " + freeSpace + " jedn. drewna. Magazyn został zapełniony.\n");
            } else System.out.println("INFO: Materiały nie zostały dodane do magazynu.\n");
        }
    }
    public void addStone(int quantity) {
        if (returnFreeSpace() == 0) System.out.println("INFO: Magazyn jest pełny. Nie dodano materiałów.\n");
        else {
            if (quantity <= returnFreeSpace()) {
                this.occupiedSpaceByMaterials[indexOfMaterialStone] += quantity;
                System.out.println("INFO: Dodano do magazynu " + quantity + " jedn. kamienia.\n");
            } else if (quantity > returnFreeSpace()) {
                int freeSpace = returnFreeSpace();
                this.occupiedSpaceByMaterials[indexOfMaterialStone] += freeSpace;
                System.out.println("INFO: Dodano do magazynu " + freeSpace + " jedn. kamienia. Magazyn został zapełniony.\n");
            } else System.out.println("INFO: Materiały nie zostały dodane do magazynu.\n");
        }
    }*/

    /*public void addMaterial(int numberOfMaterial, int quantity) {
        switch (numberOfMaterial) {
            case 0:
                this.occupiedSpaceByMaterials[indexOfMaterialWood] += quantity <= returnFreeSpace() ? quantity : 0;
                break;
            case 1:
                this.occupiedSpaceByMaterials[indexOfMaterialStone] += quantity <= returnFreeSpace() ? quantity : 0;
                break;
            default:
        }
    }*/


    public void removeWood(int quantity) {
        this.occupiedSpaceByMaterials[indexOfMaterialWood] -= quantity <= this.occupiedSpaceByMaterials[indexOfMaterialWood] ? quantity : 0;
    }
    public void removeStone(int quantity) {
        this.occupiedSpaceByMaterials[indexOfMaterialStone] -= quantity <= this.occupiedSpaceByMaterials[indexOfMaterialStone] ? quantity: 0;
    }
    /*public void removeWood(int quantity) {
        if (this.occupiedSpaceByMaterials[indexOfMaterialWood] == 0) System.out.println("INFO: Brak drewna w magazynie.\n");
        else {
            if (quantity <= this.occupiedSpaceByMaterials[indexOfMaterialWood]) {
                this.occupiedSpaceByMaterials[indexOfMaterialWood] -= quantity;
                System.out.println("INFO: Pobrano z magazynu " + quantity + " jedn. drewna.\n");
            } else if (quantity > this.occupiedSpaceByMaterials[indexOfMaterialWood]) {
                System.out.println("INFO: Nie pobrano " + quantity + " jedn. drewna. W magazynie brakuje " + (quantity - this.occupiedSpaceByMaterials[indexOfMaterialWood]) + " jedn. drewna.\n");
            } else System.out.println("INFO: Materiały nie zostały pobrane z magazynu.\n");
        }
    }
    public void removeStone(int quantity) {
        if (this.occupiedSpaceByMaterials[indexOfMaterialStone] == 0) System.out.println("INFO: Brak kamienia w magazynie.\n");
        else {
            if (quantity <= this.occupiedSpaceByMaterials[indexOfMaterialStone]) {
                this.occupiedSpaceByMaterials[indexOfMaterialStone] -= quantity;
                System.out.println("INFO: Pobrano z magazynu " + quantity + " jedn. kamienia.\n");
            } else if (quantity > this.occupiedSpaceByMaterials[indexOfMaterialStone]) {
                System.out.println("INFO: Nie pobrano " + quantity + " jedn. kamienia. W magazynie brakuje " + (quantity - this.occupiedSpaceByMaterials[indexOfMaterialStone]) + " jedn. kamienia.\n");
            } else System.out.println("INFO: Materiały nie zostały pobrane z magazynu.\n");
        }
    }*/
    /*public void removeMaterial(int numberOfMaterial, int quantity) {
        switch (numberOfMaterial) {
            case 0:
                this.occupiedSpaceByMaterials[indexOfMaterialWood] -= quantity <= getOccupiedSpaceByMaterial(indexOfMaterialWood) ? quantity : 0;
                break;
            case 1:
                this.occupiedSpaceByMaterials[indexOfMaterialStone] -= quantity <= getOccupiedSpaceByMaterial(indexOfMaterialStone) ? quantity : 0;
                break;
            default:
        }
    }*/

    public int getAllOccupiedSpaceByMaterials() {
        return occupiedSpaceByMaterials[indexOfMaterialWood] + occupiedSpaceByMaterials[indexOfMaterialStone];
    }


    /*private void createSettingsMaterials(){
        //System.out.print("linesOfFileMaterialOfSpace 0: \"" + linesOfFileMaterialOfSpace[0] + "\"; linesOfFileMaterialOfSpace 1: \"" +  linesOfFileMaterialOfSpace[1] +"\";\n");
        settingsMaterials[0] = new SettingsObject(linesOfFileMaterialOfSpace[0], "material", "wood",  1 ,1);
        settingsMaterials[1] = new SettingsObject(linesOfFileMaterialOfSpace[1], "material", "stone", 1 ,1);
    }
    //private void createSettingsMaterial(int indexOfMaterial){} //tworzenie obiektu dla indeksu
    private void processOfSettingsMaterials() {
        settingsMaterials[0].prepareTabOfValues();
        settingsMaterials[1].prepareTabOfValues();
    }*/
    //private void processOfSettingsMaterials() {} //przetwarzanie obiektu dla indeksu

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


/////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////

    /*public void viewValuesFromSettingMaterial(int index) {
        settingsMaterials[index].viewValues();
    }*/
}

// Tomasz Topolewski

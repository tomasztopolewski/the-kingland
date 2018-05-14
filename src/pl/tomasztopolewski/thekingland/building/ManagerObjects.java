package pl.tomasztopolewski.thekingland.building;

import pl.tomasztopolewski.thekingland.authentication.preparation.Installation;
import pl.tomasztopolewski.thekingland.building.buildings.factories.Lumberjack;
import pl.tomasztopolewski.thekingland.building.buildings.factories.Quarry;
import pl.tomasztopolewski.thekingland.building.buildings.management.Architect;
import pl.tomasztopolewski.thekingland.building.buildings.management.Warehouse;
import pl.tomasztopolewski.thekingland.building.buildings.mood.Flowerbed;
import pl.tomasztopolewski.thekingland.building.buildings.sociaty.House;
import pl.tomasztopolewski.thekingland.handlingdata.ClassLoadFile;
import pl.tomasztopolewski.thekingland.handlingdata.SettingsObject;

import java.io.FileNotFoundException;

public class ManagerObjects {
    private final ClassLoadFile classLoadFileSettingsOfBuildings = new ClassLoadFile(Installation.nameOfFile_ManagerBuilding, Installation.pathToFolder);
    private String[] linesOfFileSettingsOfBuildings;


    private final int numberOfBuilding = 6;

    private final int indexOfArchitect = 0;
    private final int indexOfWarehouse = 1;
    private final int indexOfQuarry = 2;
    private final int indexOfLumberjack = 3;
    private final int indexOfFlowerbed = 4;
    private final int indexOfHouse = 5;


    public SettingsObject[] settingsBuildings;

    private Architect architect = new Architect();
    private Warehouse warehouse = new Warehouse();
    private Quarry quarry = new Quarry();
    private Lumberjack lumberjack = new Lumberjack();
    private Flowerbed flowerbed = new Flowerbed();
    private House house = new House();

    //konstruktor warunkowany dla zmiennej "nameOfConstructor"
    public ManagerObjects(String nameOfConstructor) throws FileNotFoundException {
        if (nameOfConstructor.equals("load values from file")) {
            createEmptyBuildings();

            settingsBuildings = new SettingsObject[numberOfBuilding];
            loadFileWithObjects();
            createSettingObjects();
            processOfSettingObjects();

            resetBuildings();
            createBuildings();
        } else {
            createEmptyBuildings();
        }
    }
    public ManagerObjects() throws FileNotFoundException {
        createEmptyBuildings();
    }


/////////////////////////////////////////////////////////////////////////////
// METODY TWORZĄCE OBIEKTY USTAWIEŃ I ŁADUJĄCE USTAWIENIA Z PLIKU

    public void loadFileWithObjects() throws FileNotFoundException {
        classLoadFileSettingsOfBuildings.loadFile();
        //classLoadFileSettingsOfBuildings.viewDownloadedLoadedLines();
        linesOfFileSettingsOfBuildings = classLoadFileSettingsOfBuildings.getDownloadedLines();
        //viewLinesOfFileSettingsOfBuildings();
    }

    private void createSettingObjects() {
        settingsBuildings[0] = new SettingsObject(linesOfFileSettingsOfBuildings[0], "management", "architect",  1, 1);
        settingsBuildings[1] = new SettingsObject(linesOfFileSettingsOfBuildings[1], "management", "warehouse",  1, 1);
        settingsBuildings[2] = new SettingsObject(linesOfFileSettingsOfBuildings[2], "factories",  "quarry",     1, 1);
        settingsBuildings[3] = new SettingsObject(linesOfFileSettingsOfBuildings[3], "factories",  "lumberjack", 1, 1);
        settingsBuildings[4] = new SettingsObject(linesOfFileSettingsOfBuildings[4], "mood",       "flowerbed",  2, 1);
        settingsBuildings[5] = new SettingsObject(linesOfFileSettingsOfBuildings[5], "sociaty",    "house",      1, 1);
    }
    private void createSettingObject(String building) {
        switch (returnIndexOfBuilding(building)) {
            case 0:
                settingsBuildings[0] = new SettingsObject(linesOfFileSettingsOfBuildings[0], "management", "architect",  1, 1); break;
            case 1:
                settingsBuildings[1] = new SettingsObject(linesOfFileSettingsOfBuildings[1], "management", "warehouse",  1, 1); break;
            case 2:
                settingsBuildings[2] = new SettingsObject(linesOfFileSettingsOfBuildings[2], "factories",  "quarry",     1, 1); break;
            case 3:
                settingsBuildings[3] = new SettingsObject(linesOfFileSettingsOfBuildings[3], "factories",  "lumberjack", 1, 1); break;
            case 4:
                settingsBuildings[4] = new SettingsObject(linesOfFileSettingsOfBuildings[4], "mood",       "flowerbed",  2, 1); break;
            case 5:
                settingsBuildings[5] = new SettingsObject(linesOfFileSettingsOfBuildings[5], "sociaty",    "house",      1, 1); break;
        }
    }

    private void processOfSettingObjects() {
        settingsBuildings[0].prepareTabOfValues();
        settingsBuildings[1].prepareTabOfValues();
        settingsBuildings[2].prepareTabOfValues();
        settingsBuildings[3].prepareTabOfValues();
        settingsBuildings[4].prepareTabOfValues();
        settingsBuildings[5].prepareTabOfValues();
    }
    private void processOfSettingObject(String building) {
        switch (returnIndexOfBuilding(building)) {
            case indexOfArchitect:
                settingsBuildings[indexOfArchitect].prepareTabOfValues();
                break;
            case indexOfWarehouse:
                settingsBuildings[indexOfWarehouse].prepareTabOfValues();
                break;
            case indexOfQuarry:
                settingsBuildings[indexOfQuarry].prepareTabOfValues();
                break;
            case indexOfLumberjack:
                settingsBuildings[indexOfLumberjack].prepareTabOfValues();
                break;
            case indexOfFlowerbed:
                settingsBuildings[indexOfFlowerbed].prepareTabOfValues();
                break;
            case indexOfHouse:
                settingsBuildings[indexOfHouse].prepareTabOfValues();
                break;
        }
    }

/////////////////////////////////////////////////////////////////////////////
// METODY ZARZĄDZAJĄCE BUDYNKAMI

    //////////////////////////////////////////////
    //Tworzenie budynków
    public void createBuildings() throws FileNotFoundException {
        createArchitect();
        createWarehouse();
        createQuarry();
        createLumberjack();
        createFlowerbed();
        createHouse();
    }
    public void createEmptyBuildings() throws FileNotFoundException {
        createEmptyArchitect();
        createEmptyWarehouse();
        createEmptyQuarry();
        createEmptyLumberjack();
        createEmptyFlowerbed();
        createEmptyHouse();
    }

    public void createArchitect() {
        architect = new Architect(settingsBuildings[0].convertValue(settingsBuildings[0].getFirstValue()));
    }
    public void createEmptyArchitect() {
        architect = new Architect();
    }
    public void createWarehouse() throws FileNotFoundException {
        warehouse = new Warehouse(settingsBuildings[1].convertValue(settingsBuildings[1].getFirstValue()));
    }
    public void createEmptyWarehouse() throws FileNotFoundException {
        warehouse = new Warehouse();
    }
    public void createQuarry() {
       quarry = new Quarry(settingsBuildings[2].convertValue(settingsBuildings[2].getValue(0)));
    }
    public void createEmptyQuarry() {
        quarry = new Quarry();
    }
    public void createLumberjack() {
        lumberjack = new Lumberjack(settingsBuildings[3].convertValue(settingsBuildings[3].getValue(0)));
    }
    public void createEmptyLumberjack() {
        lumberjack = new Lumberjack();
    }
    public void createFlowerbed() {
        flowerbed = new Flowerbed(settingsBuildings[4].convertValue(settingsBuildings[4].getValue(0)), settingsBuildings[4].convertValue(settingsBuildings[4].getValue(1)));
    }
    public void createEmptyFlowerbed() {
        flowerbed = new Flowerbed();
    }
    public void createHouse() {
        house = new House(settingsBuildings[5].convertValue(settingsBuildings[5].getValue(0)));
    }
    public void createEmptyHouse() {
        house = new House();
    }


    //////////////////////////////////////////////
    //Kupowanie budynków
    public void buyArchitect() {
        if (architect.getLevelUpgrade() == 0) {
            architect.setLevelUpgrade(1);
            System.out.println("INFO: Kupiono budynek Architect.\n");
        } else {
            System.out.println("INFO: Budynek Architect zostal juz zakupiony. Nie realizowano transakcji.\n");
        }
    }
    public void buyWarehouse() {
        if (warehouse.getLevelUpgrade() == 0) {
            warehouse.setLevelUpgrade(1);
            System.out.println("INFO: Kupiono budynek Warehouse.\n");
        } else {
            System.out.println("INFO: Budynek Warehouse zostal juz zakupiony. Nie realizowano transakcji.\n");
        }
    }
    public void buyQuarry() {
        if (quarry.getLevelUpgrade() == 0) {
            quarry.setLevelUpgrade(1);
            System.out.println("INFO: Kupiono budynek Quarry.\n");
        } else {
            System.out.println("INFO: Budynek Quarry zostal juz zakupiony. Nie realizowano transakcji.\n");
        }
    }
    public void buyLumberjack() {
        if (lumberjack.getLevelUpgrade() == 0) {
            lumberjack.setLevelUpgrade(1);
            System.out.println("INFO: Kupiono budynek Lumberjack.\n");
        } else {
            System.out.println("INFO: Budynek Lumberjack zostal juz zakupiony. Nie realizowano transakcji.\n");
        }
    }
    public void buyFlowerbed() {
        if (flowerbed.getLevelUpgrade() == 0) {
            flowerbed.setLevelUpgrade(1);
            System.out.println("INFO: Kupiono budynek Flowerbed.\n");
        } else {
            System.out.println("INFO: Budynek Architect zostal juz zakupiony. Nie realizowano transakcji.\n");
        }
    }
    public void buyHouse() {
        if (house.getLevelUpgrade() == 0) {
            house.setLevelUpgrade(1);
            System.out.println("INFO: Kupiono budynek House.\n");
        } else {
            System.out.println("INFO: Budynek House zostal juz zakupiony. Nie realizowano transakcji.\n");
        }
    }


    //////////////////////////////////////////////
    // Ustawianie poziomu na dowolny
    public void setLevelBuilding(String building, int level) {
        //sprawdzenie czy można wykonać operację
        //sprawdzenie kosztów
        //operacja odjęcia kosztów
        //faktyczna zmiana

        switch (returnIndexOfBuilding(building)) {
            case indexOfArchitect:
                setLevelArchitect(level);
                break;
            case indexOfWarehouse:
                setLevelWarehouse(level);
                break;
            case indexOfQuarry:
                setLevelQuarry(level);
                break;
            case indexOfLumberjack:
                setLevelLumberjack(level);
                break;
            case indexOfFlowerbed:
                setLevelFlowerbed(level);
                break;
            case indexOfHouse:
                setLevelHouse(level);
                break;
        }
    }

    public void setLevelArchitect(int level) {
        architect.setLevelUpgrade(level);
    }
    public void setLevelWarehouse(int level) {
        warehouse.setLevelUpgrade(level);
    }
    public void setLevelQuarry(int level) {
        quarry.setLevelUpgrade(level);
    }
    public void setLevelLumberjack(int level) {
        lumberjack.setLevelUpgrade(level);
    }
    public void setLevelFlowerbed(int level) {
        flowerbed.setLevelUpgrade(level);
    }
    public void setLevelHouse(int level) {
        house.setLevelUpgrade(level);
    }


    //////////////////////////////////////////////
    // Ulepszenie o jeden poziom budynków
    public void levelUpBuilding(String building) {
        //sprawdzenie czy można wykonać operację
        //sprawdzenie kosztów
        //operacja odjęcia kosztów
        //faktyczna zmiana

        switch (returnIndexOfBuilding(building)) {
            case indexOfArchitect:
                levelUpArchitect();
                break;
            case indexOfWarehouse:
                levelUpWarehouse();
                break;
            case indexOfQuarry:
                levelUpQuarry();
                break;
            case indexOfLumberjack:
                levelUpLumberjack();
                break;
            case indexOfFlowerbed:
                levelUpFlowerbed();
                break;
            case indexOfHouse:
                levelUpHouse();
                break;
        }
    }

    public void levelUpArchitect() {
        if (architect.getLevelUpgrade() == architect.getMaximumUpgradeLevel()) {
            System.out.println("INFO: Budynek Architect osiagnal najwyzszy poziom. Ulepszenie jest niemozliwe.\n");
        } else if ((architect.getLevelUpgrade() < architect.getMaximumUpgradeLevel()) && (architect.getLevelUpgrade() >= architect.getMinimumUpgradeLevel())) {
            architect.addLevelUpgrade(1);
            System.out.println("INFO: Budynek Architect zostal ulepszony o jeden poziom. Jego poziom to " + architect.getLevelUpgrade() + ".\n");
        } else if (architect.getLevelUpgrade() == 0) System.out.println("INFO: Budynek Architect nie zostal wybudowany.\n");
    }
    public void levelUpWarehouse() {
        if (warehouse.getLevelUpgrade() == warehouse.getMaximumUpgradeLevel()) {
            System.out.println("INFO: Budynek Warehouse osiagnal najwyzszy poziom. Ulepszenie jest niemozliwe.\n");
        } else if ((warehouse.getLevelUpgrade() < warehouse.getMaximumUpgradeLevel()) && (warehouse.getLevelUpgrade() >= warehouse.getMinimumUpgradeLevel())) {
            warehouse.addLevelUpgrade(1);
            System.out.println("INFO: Budynek Warehouse zostal ulepszony o jeden poziom. Jego poziom to " + warehouse.getLevelUpgrade() + ".\n");
        } else if (warehouse.getLevelUpgrade() == 0) System.out.println("INFO: Budynek Warehouse nie zostal wybudowany.\n");
    }
    public void levelUpQuarry() {
        if (quarry.getLevelUpgrade() == quarry.getMaximumUpgradeLevel()) {
            System.out.println("INFO: Budynek Quarry osiagnal najwyzszy poziom. Ulepszenie jest niemozliwe.\n");
        } else if ((quarry.getLevelUpgrade() < quarry.getMaximumUpgradeLevel()) && (quarry.getLevelUpgrade() >= quarry.getMinimumUpgradeLevel())) {
            quarry.addLevelUpgrade(1);
            System.out.println("INFO: Budynek Quarry zostal ulepszony o jeden poziom. Jego poziom to " + quarry.getLevelUpgrade() + ".\n");
        } else if (quarry.getLevelUpgrade() == 0) System.out.println("INFO: Budynek Quarry nie zostal wybudowany.\n");
    }
    public void levelUpLumberjack() {
        if (lumberjack.getLevelUpgrade() == lumberjack.getMaximumUpgradeLevel()) {
            System.out.println("INFO: Budynek Lumberjack osiagnal najwyzszy poziom. Ulepszenie jest niemozliwe.\n");
        } else if ((lumberjack.getLevelUpgrade() < lumberjack.getMaximumUpgradeLevel()) && (lumberjack.getLevelUpgrade() >= lumberjack.getMinimumUpgradeLevel())) {
            lumberjack.addLevelUpgrade(1);
            System.out.println("INFO: Budynek Lumberjack zostal ulepszony o jeden poziom. Jego poziom to " + lumberjack.getLevelUpgrade() + ".\n");
        } else if (lumberjack.getLevelUpgrade() == 0) System.out.println("INFO: Budynek Lumberjack nie zostal wybudowany.\n");
    }
    public void levelUpFlowerbed() {
        if (flowerbed.getLevelUpgrade() == flowerbed.getMaximumUpgradeLevel()) {
            System.out.println("INFO: Budynek Flowerbed osiagnal najwyzszy poziom. Ulepszenie jest niemozliwe.\n");
        } else if ((flowerbed.getLevelUpgrade() < flowerbed.getMaximumUpgradeLevel()) && (flowerbed.getLevelUpgrade() >= flowerbed.getMinimumUpgradeLevel())) {
            flowerbed.addLevelUpgrade(1);
            System.out.println("INFO: Budynek Flowerbed zostal ulepszony o jeden poziom. Jego poziom to " + flowerbed.getLevelUpgrade() + ".\n");
        } else if (flowerbed.getLevelUpgrade() == 0) System.out.println("INFO: Budynek Flowerbed nie zostal wybudowany.\n");
    }
    public void levelUpHouse() {
        if (house.getLevelUpgrade() == house.getMaximumUpgradeLevel()) {
            System.out.println("INFO: Budynek House osiagnal najwyzszy poziom. Ulepszenie jest niemozliwe.\n");
        } else if ((house.getLevelUpgrade() < house.getMaximumUpgradeLevel()) && (house.getLevelUpgrade() >= house.getMinimumUpgradeLevel())) {
            house.addLevelUpgrade(1);
            System.out.println("INFO: Budynek House zostal ulepszony o jeden poziom. Jego poziom to " + house.getLevelUpgrade() + ".\n");
        } else if (house.getLevelUpgrade() == 0)
            System.out.println("INFO: Budynek House nie zostal wybudowany.\n");
    }


    //////////////////////////////////////////////
    // Ulepszenie o kilka poziomów budynków
    public void levelsUpBuilding(String building, int levels) {
        //sprawdzenie czy można wykonać operację
        //sprawdzenie kosztów
        //operacja odjęcia kosztów
        //faktyczna zmiana

        switch (returnIndexOfBuilding(building)) {
            case indexOfArchitect:
                levelsUpArchitect(levels);
                break;
            case indexOfWarehouse:
                levelsUpWarehouse(levels);
                break;
            case indexOfQuarry:
                levelsUpQuarry(levels);
                break;
            case indexOfLumberjack:
                levelsUpLumberjack(levels);
                break;
            case indexOfFlowerbed:
                levelsUpFlowerbed(levels);
                break;
            case indexOfHouse:
                levelsUpHouse(levels);
                break;
        }
    }

    public void levelsUpArchitect(int levels) {
        architect.addLevelUpgrade(levels);
    }
    public void levelsUpWarehouse(int levels) {
        warehouse.addLevelUpgrade(levels);
    }
    public void levelsUpQuarry(int levels) {
        quarry.addLevelUpgrade(levels);
    }
    public void levelsUpLumberjack(int levels) {
        lumberjack.addLevelUpgrade(levels);
    }
    public void levelsUpFlowerbed(int levels) {
        flowerbed.addLevelUpgrade(levels);
    }
    public void levelsUpHouse(int levels) {
        house.addLevelUpgrade(levels);
    }


    //////////////////////////////////////////////
    // WYŚWIETLAJĄCE PARAMTERY BUDYNKÓW
    /**/


    /**
    private void destroyedBuilding(String building) {
        // TODO: funkcja ma oddawać 30-40% z materiałów jakie trzeba dać na konkretny budnek o konretnym level
        //if, gdy lvl budynku będzie równy 0 to: wyrzuci println
        //gdy większy od 0 to ustaw budynek na 0
       try {
           if (buildings[returnIndexOfBuilding(building)].getLevelUpgrade() > 0) {

           }
       } catch (ArrayIndexOutOfBoundsException aioobe) {
           System.out.print("Error-ManagerObjects:destroyedBuilding() : Nie mozna wywolac funkcji 'ManagerObjects::destroyedBuilding' z powodu nie wlasciwego adresu refenecji do budynku.\n");
       } finally {}
    }
    */


/////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////
//FUNKCJE DODATKOWE LUB DLA OBSŁUGI PROGRAMISTYCZNEJ PROCESÓW

    public void resetBuildings() {
        resetArchitect();
        resetWarehouse();
        resetQuarry();
        resetLumberjack();
        resetFlowerbed();
        resetHouse();
    }
    public void resetArchitect() {
        architect = null;
    }
    public void resetWarehouse() {
        warehouse = null;
    }
    public void resetQuarry() {
        quarry = null;
    }
    public void resetLumberjack() {
        lumberjack = null;
    }
    public void resetFlowerbed() {
        flowerbed = null;
    }
    public void resetHouse() {
        house = null;
    }


    public int returnIndexOfBuilding(String building) {
        if (building == "architect") return indexOfArchitect;
        if (building == "warehouse") return indexOfWarehouse;
        if (building == "quarry") return indexOfQuarry;
        if (building == "lumberjack") return indexOfLumberjack;
        if (building == "flowerbed") return indexOfFlowerbed;
        if (building == "house") return indexOfHouse;
        System.out.print("Error-ManagerObjects:returnIndexOfBuilding() : Nie istnieje budynek o podanej nazwie \"" + building + "\".\n");
        return -1;
    }

    public void viewLinesOfFileSettingsOfBuildings() {
        for (int i = 0; i < linesOfFileSettingsOfBuildings.length; i++) System.out.print("Line in ManagerObjects no. " + i + ": " + linesOfFileSettingsOfBuildings[i] + "\n");
    }
    public void viewValuesFromSettingBuilding(int index) {
        settingsBuildings[index].viewValues();
    }


    public String returnCodeGroupBuildingOfBuilding(String building) {
        if (building == "architect") return "management";
        if (building == "warehouse") return "management";
        if (building == "quarry") return "factiories";
        if (building == "lumberjack") return "factiories";
        if (building == "flowerbed") return "mood";
        if (building == "house") return "sociaty";
        return null;
    }
    public String returnCodeBuildingOfBuilding(String building) {
        if (building == "architect") return building;
        if (building == "warehouse") return building;
        if (building == "quarry") return building;
        if (building == "lumberjack") return building;
        if (building == "flowerbed") return building;
        if (building == "house") return building;
        return null;
    }

}

// Tomasz Topolewski

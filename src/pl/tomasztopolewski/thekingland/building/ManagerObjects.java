package pl.tomasztopolewski.thekingland.building;

import jdk.internal.cmm.SystemResourcePressureImpl;
import pl.tomasztopolewski.thekingland.authentication.preparation.Installation;
import pl.tomasztopolewski.thekingland.building.buildings.factories.Lumberjack;
import pl.tomasztopolewski.thekingland.building.buildings.factories.Quarry;
import pl.tomasztopolewski.thekingland.building.buildings.management.Architect;
import pl.tomasztopolewski.thekingland.building.buildings.management.Warehouse;
import pl.tomasztopolewski.thekingland.building.buildings.mood.Flowerbed;
import pl.tomasztopolewski.thekingland.building.buildings.sociaty.House;
import pl.tomasztopolewski.thekingland.handlingdata.ClassLoadFile;
import pl.tomasztopolewski.thekingland.handlingdata.ClassSaveFile;
import pl.tomasztopolewski.thekingland.handlingdata.SettingsObject;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ManagerObjects {
    private final ClassLoadFile classLoadFileSettingsOfBuildings = new ClassLoadFile(Installation.nameOfFile_ManagerBuilding, Installation.pathToFolder);
    private String[] linesOfFileSettingsOfBuildings;

    private ClassSaveFile classSaveFileSettingsOfBuildings;
    private String[] saveLinesToFileSettingsOfBuildings;

    private final ClassLoadFile classLoadFileMaterialOfSpace = new ClassLoadFile(Installation.nameOfFile_SpaceOfWarehouse, Installation.pathToFolder);
    private String[] linesOfFileMaterialOfSpace;
    private boolean loadedSpaceOfWarehouse;

    public ClassSaveFile classSaveFileMaterialOfSpace;
    private String[] saveLinesToFileMaterialOfSpace;


    private final int numberOfBuilding = 6;

    private final int indexOfArchitect = 0;
    private final int indexOfWarehouse = 1;
    private final int indexOfQuarry = 2;
    private final int indexOfLumberjack = 3;
    private final int indexOfFlowerbed = 4;
    private final int indexOfHouse = 5;


    private SettingsObject[] settingsBuildings;
    private SettingsObject[] saveSettingsBuildings;

    private Architect architect = new Architect();
    private Warehouse warehouse = new Warehouse();
    private Quarry quarry = new Quarry();
    private Lumberjack lumberjack = new Lumberjack();
    private Flowerbed flowerbed = new Flowerbed();
    private House house = new House();


    private final int numberOfMaterials = new Warehouse().getNumberOfMaterials();
    private final int indexOfMaterialWood = new Warehouse().getIndexOfMaterialWood();
    private final int indexOfMaterialStone = new Warehouse().getIndexOfMaterialStone();

    private SettingsObject[] settingsMaterials;
    private SettingsObject[] saveSettingsMaterials;


    //konstruktor warunkowany dla zmiennej "nameOfConstructor"
    public ManagerObjects(String nameOfConstructor) throws FileNotFoundException {


        if (nameOfConstructor.equals("load values from file")) {
            createEmptyBuildings();

            settingsMaterials = new SettingsObject[numberOfMaterials];
            saveSettingsMaterials = new SettingsObject[numberOfMaterials];
            loadFileWithSpaceOfWarehouse();
            createSettingsMaterials();
            processOfSettingsMaterials();

            settingsBuildings = new SettingsObject[numberOfBuilding];
            saveSettingsBuildings = new SettingsObject[numberOfBuilding];
            loadFileWithObjects();
            createSettingObjects();
            processOfSettingObjects();

            resetBuildings();
            createBuildings();
        } else {
            createEmptyBuildings();
        }
    }
    /**konstruktor warunkowany dla zmiennej "nameOfConstructor"
    /*public ManagerObjects(String nameOfConstructor) throws FileNotFoundException {
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
    }*/
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

    public void loadFileWithSpaceOfWarehouse() throws FileNotFoundException {
        classLoadFileMaterialOfSpace.loadFile();

        linesOfFileMaterialOfSpace = classLoadFileMaterialOfSpace.getDownloadedLines();
        if (linesOfFileMaterialOfSpace[0].length() > 1 && (linesOfFileMaterialOfSpace[1].length() > 1)) loadedSpaceOfWarehouse = true;
        else loadedSpaceOfWarehouse = false;
    };


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

    private void createSettingsMaterials() {
        settingsMaterials[0] = new SettingsObject(linesOfFileMaterialOfSpace[0], "material", "wood",  1 ,1);
        settingsMaterials[1] = new SettingsObject(linesOfFileMaterialOfSpace[1], "material", "stone", 1 ,1);
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

    private void processOfSettingsMaterials() {
        settingsMaterials[0].prepareTabOfValues();
        settingsMaterials[1].prepareTabOfValues();
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
        //warehouse = new Warehouse(settingsBuildings[1].convertValue(settingsBuildings[1].getFirstValue()));
        warehouse = new Warehouse(settingsBuildings[1].convertValue(settingsBuildings[1].getFirstValue()),
                new int[]{Integer.valueOf(settingsMaterials[indexOfMaterialWood].getValue(0)),
                        Integer.valueOf(settingsMaterials[indexOfMaterialStone].getValue(0))});
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
            System.out.println("INFO: Building Architect is bought.\n");
        } else {
            System.out.println("INFO: Building Architect was bought. Transaction isn't realized.\n");
        }
    }
    public void buyWarehouse() {
        if (warehouse.getLevelUpgrade() == 0) {
            warehouse.setLevelUpgrade(1);
            System.out.println("INFO: Building Warehouse is bought.\n");
        } else {
            System.out.println("INFO: Building Warehouse was bought. Transaction isn't realized.\n");
        }
    }
    public void buyQuarry() {
        if (quarry.getLevelUpgrade() == 0) {
            quarry.setLevelUpgrade(1);
            System.out.println("INFO: Building Quarry is bought.\n");
        } else {
            System.out.println("INFO: Building Quarry was bought. Transaction isn't realized.\n");
        }
    }
    public void buyLumberjack() {
        if (lumberjack.getLevelUpgrade() == 0) {
            lumberjack.setLevelUpgrade(1);
            System.out.println("INFO: Building Lumberjack is bought..\n");
        } else {
            System.out.println("INFO: Building Lumberjack was bought. Transaction isn't realized.\n");
        }
    }
    public void buyFlowerbed() {
        if (flowerbed.getLevelUpgrade() == 0) {
            flowerbed.setLevelUpgrade(1);
            System.out.println("INFO: Building Flowerbed is bought..\n");
        } else {
            System.out.println("INFO: Building Architect was bought. Transaction isn't realized.\n");
        }
    }
    public void buyHouse() {
        if (house.getLevelUpgrade() == 0) {
            house.setLevelUpgrade(1);
            System.out.println("INFO: Building House is bought..\n");
        } else {
            System.out.println("INFO: Building House was bought. Transaction isn't realized.\n");
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
            System.out.println("INFO: Building Architect has achieved the highest level.\n");
        } else if ((architect.getLevelUpgrade() < architect.getMaximumUpgradeLevel()) && (architect.getLevelUpgrade() >= architect.getMinimumUpgradeLevel())) {
            architect.addLevelUpgrade(1);
            System.out.println("INFO: Building Architect upgrades about one level. New level amounts " + architect.getLevelUpgrade() + ".\n");
        } else if (architect.getLevelUpgrade() == 0) System.out.println("INFO: Building Architect hasn't existed. At first, you should buy the building.\n");
    }
    public void levelUpWarehouse() {
        if (warehouse.getLevelUpgrade() == warehouse.getMaximumUpgradeLevel()) {
            System.out.println("INFO: Building Warehouse has achieved the highest level.\n");
        } else if ((warehouse.getLevelUpgrade() < warehouse.getMaximumUpgradeLevel()) && (warehouse.getLevelUpgrade() >= warehouse.getMinimumUpgradeLevel())) {
            warehouse.addLevelUpgrade(1);
            System.out.println("INFO: Building Warehouse upgrades about one level. New level amounts " + warehouse.getLevelUpgrade() + ".\n");
        } else if (warehouse.getLevelUpgrade() == 0) System.out.println("INFO: Building Warehouse hasn't existed. At first, you should buy the building.\n");
    }
    public void levelUpQuarry() {
        if (quarry.getLevelUpgrade() == quarry.getMaximumUpgradeLevel()) {
            System.out.println("INFO: Building Quarry has achieved the highest level.\n");
        } else if ((quarry.getLevelUpgrade() < quarry.getMaximumUpgradeLevel()) && (quarry.getLevelUpgrade() >= quarry.getMinimumUpgradeLevel())) {
            quarry.addLevelUpgrade(1);
            System.out.println("INFO: Building Quarry upgrades about one level. New level amounts " + quarry.getLevelUpgrade() + ".\n");
        } else if (quarry.getLevelUpgrade() == 0) System.out.println("INFO: Building Quarry hasn't existed. At first, you should buy the building.\n");
    }
    public void levelUpLumberjack() {
        if (lumberjack.getLevelUpgrade() == lumberjack.getMaximumUpgradeLevel()) {
            System.out.println("INFO: Building Lumberjack has achieved the highest level.\n");
        } else if ((lumberjack.getLevelUpgrade() < lumberjack.getMaximumUpgradeLevel()) && (lumberjack.getLevelUpgrade() >= lumberjack.getMinimumUpgradeLevel())) {
            lumberjack.addLevelUpgrade(1);
            System.out.println("INFO: Building Lumberjack upgrades about one level. New level amounts " + lumberjack.getLevelUpgrade() + ".\n");
        } else if (lumberjack.getLevelUpgrade() == 0) System.out.println("INFO: Building Lumberjack hasn't existed. At first, you should buy the building.\n");
    }
    public void levelUpFlowerbed() {
        if (flowerbed.getLevelUpgrade() == flowerbed.getMaximumUpgradeLevel()) {
            System.out.println("INFO: Building Flowerbed has achieved the highest level.\n");
        } else if ((flowerbed.getLevelUpgrade() < flowerbed.getMaximumUpgradeLevel()) && (flowerbed.getLevelUpgrade() >= flowerbed.getMinimumUpgradeLevel())) {
            flowerbed.addLevelUpgrade(1);
            System.out.println("INFO: Building Flowerbed upgrades about one level. New level amounts " + flowerbed.getLevelUpgrade() + ".\n");
        } else if (flowerbed.getLevelUpgrade() == 0) System.out.println("INFO: Building Flowerbed hasn't existed. At first, you should buy the building.\n");
    }
    public void levelUpHouse() {
        if (house.getLevelUpgrade() == house.getMaximumUpgradeLevel()) {
            System.out.println("INFO: Building House has achieved the highest level.\n");
        } else if ((house.getLevelUpgrade() < house.getMaximumUpgradeLevel()) && (house.getLevelUpgrade() >= house.getMinimumUpgradeLevel())) {
            house.addLevelUpgrade(1);
            System.out.println("INFO: Building House upgrades about one level. New level amounts " + house.getLevelUpgrade() + ".\n");
        } else if (house.getLevelUpgrade() == 0)
            System.out.println("INFO: Building House hasn't existed. At first, you should buy the building.\n");
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
    // Ustawianie minimalnego poziomu (1) budynków
    public void setMinimumUpgradeLevelForBuildings() {
        setMinimumUpgradeLevelForArchitect();
        setMinimumUpgradeLevelForWarehouse();
        setMinimumUpgradeLevelForQuarry();
        setMinimumUpgradeLevelForLumberjack();
        setMinimumUpgradeLevelForFlowerbed();
        setMinimumUpgradeLevelForHouse();
    }

    public void setMinimumUpgradeLevelForArchitect() {
        architect.setLevelUpgrade(architect.getMinimumUpgradeLevel());
    }
    public void setMinimumUpgradeLevelForWarehouse() {
        warehouse.setLevelUpgrade(warehouse.getMinimumUpgradeLevel());
    }
    public void setMinimumUpgradeLevelForQuarry() {
        quarry.setLevelUpgrade(quarry.getMinimumUpgradeLevel());
    }
    public void setMinimumUpgradeLevelForLumberjack() {
        lumberjack.setLevelUpgrade(lumberjack.getMinimumUpgradeLevel());
    }
    public void setMinimumUpgradeLevelForFlowerbed() {
        flowerbed.setLevelUpgrade(flowerbed.getMinimumUpgradeLevel());
    }
    public void setMinimumUpgradeLevelForHouse() {
        house.setLevelUpgrade(house.getMinimumUpgradeLevel());
    }



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
// METODY WYŚWIETLAJĄCE WYNIKI

    //////////////////////////////////////////////
    // WYŚWIETLAJĄCE PARAMTERY BUDYNKÓW

    // LEVEL BUILDING
    public void viewLevelArchitect() {
        System.out.println("Architect level: " + architect.getLevelUpgrade() + "\n");
    }
    public void viewLevelWarehouse() {
        System.out.println("Warehouse level: " + warehouse.getLevelUpgrade() + "\n");
    }
    public void viewLevelQuarry() {
        System.out.println("Quarry level: " + quarry.getLevelUpgrade() + "\n");
    }
    public void viewLevelLumberjack() {
        System.out.println("Lumberjack level: " + lumberjack.getLevelUpgrade() + "\n");
    }
    public void viewLevelFlowerbed() {
        System.out.println("Flowerbed level: " + flowerbed.getLevelUpgrade() + "\n");
    }
    public void viewLevelHouse() {
        System.out.println("House level: " + house.getLevelUpgrade() + "\n");
    }


    // DETAILS BUILDING
    public void viewDetailsArchitect() {
        System.out.println("Architect: lvl. " + architect.getLevelUpgrade() + "  architect experience: " + architect.getArchitectExperience());
    }
    public void viewDetailsWarehouse() {
        System.out.println("Warehouse: lvl. " + warehouse.getLevelUpgrade() + "  space: " + warehouse.getAllOccupiedSpaceByMaterials() + "/" + warehouse.getSpace());
    }
    public void viewDetailsQuarry() {
        System.out.println("Quarry: lvl. " + quarry.getLevelUpgrade() + "  power of factory: " + quarry.getPowerOfFactory());
    }
    public void viewDetailsLumberjack() {
        System.out.println("Lumberjack: lvl. " + lumberjack.getLevelUpgrade() + "  power of factory: " + lumberjack.getPowerOfFactory());
    }
    public void viewDetailsFlowerbed() {
        System.out.println("Flowerbed: lvl. " + flowerbed.getLevelUpgrade() + "  square: " + flowerbed.getSquare() + " m2  embellishments points: " + flowerbed.getEmbellishmentsPoints() + " points");
    }
    public void viewDetailsHouse() {
        System.out.println("House: lvl. " + house.getLevelUpgrade() + "  number of people: " + house.getNumberOfPeople());
    }





/////////////////////////////////////////////////////////////////////////////
// METODY TWORZĄCE OBIEKTY USTAWIEŃ DO ZAPISU I ŁADUJĄCE USTAWIENIA Z GRY

    public void save() {
        prepareSaves();
        loadSaves();
        saveFiles();
        System.out.println("SYSTEM-INFO: Changes are saved.\n");
    }

    private void saveFiles() {
        saveFileManagerBuilding();
        saveFileSpaceOfWarehouse();
    }

    public void loadSaves() {
        createClassSaveFile();
        loadSaveObjects();
        loadSaveMaterials();
        System.out.println("SYSTEM-INFO: Class are loaded.");
    }

    public void prepareSaves() {
        //saveSettingsBuildings[6] = new SettingsObject("test", "topolewski", 5, 2, new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"});
        //saveSettingsBuildings[6] = new SettingsObject("tomasz",    "topolewski",      4, 3, new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"});
        //saveSettingsBuildings[6].generateLine();
        prepareSaveObjects();
        prepareSaveMaterials();

        generateFileSaveLinesToFileSettingsOfBuildings();
        generateFileSaveLinesToFileMaterialOfSpace();
        System.out.println("SYSTEM-INFO: Saves are created.");
    }


    private void createClassSaveFile() {
        classSaveFileSettingsOfBuildings = new ClassSaveFile(Installation.nameOfFile_ManagerBuilding, Installation.pathToFolder);
        classSaveFileMaterialOfSpace = new ClassSaveFile(Installation.nameOfFile_SpaceOfWarehouse, Installation.pathToFolder);
    }


    private void createSaveSettingObjects() {
        saveSettingsBuildings[indexOfArchitect] = new SettingsObject("management", "architect",  1, 1, new String[]{String.valueOf(architect.getLevelUpgrade())});
        saveSettingsBuildings[indexOfWarehouse] = new SettingsObject("management", "warehouse",  1, 1, new String[]{String.valueOf(warehouse.getLevelUpgrade())});
        saveSettingsBuildings[indexOfQuarry] = new SettingsObject("factories",  "quarry",     1, 1, new String[]{String.valueOf(quarry.getLevelUpgrade())});
        saveSettingsBuildings[indexOfLumberjack] = new SettingsObject("factories",  "lumberjack", 1, 1, new String[]{String.valueOf(lumberjack.getLevelUpgrade())});
        saveSettingsBuildings[indexOfFlowerbed] = new SettingsObject("mood",       "flowerbed",  2, 1, new String[]{String.valueOf(flowerbed.getSquare()), String.valueOf(flowerbed.getLevelUpgrade())});
        saveSettingsBuildings[indexOfHouse] = new SettingsObject("sociaty",    "house",      1, 1, new String[]{String.valueOf(house.getLevelUpgrade())});
    }

    private void createSaveSettingsMaterials() {
        saveSettingsMaterials[indexOfMaterialWood] = new SettingsObject("material", "wood",  1 ,1, new String[]{String.valueOf(warehouse.getOccupiedSpaceByMaterial(indexOfMaterialWood))});
        saveSettingsMaterials[indexOfMaterialStone] = new SettingsObject("material", "stone", 1 ,1, new String[]{String.valueOf(warehouse.getOccupiedSpaceByMaterial(indexOfMaterialStone))});
    }


    private void generateLineForSaveSettingObjects() {
        saveSettingsBuildings[indexOfArchitect].generateLine();
        saveSettingsBuildings[indexOfWarehouse].generateLine();
        saveSettingsBuildings[indexOfQuarry].generateLine();
        saveSettingsBuildings[indexOfLumberjack].generateLine();
        saveSettingsBuildings[indexOfFlowerbed].generateLine();
        saveSettingsBuildings[indexOfHouse].generateLine();
    }

    private void generateLineForSaveSettingsMaterials() {
        saveSettingsMaterials[indexOfMaterialWood].generateLine();
        saveSettingsMaterials[indexOfMaterialStone].generateLine();
    }


    private void prepareSaveObjects() {
        createSaveSettingObjects();
        generateLineForSaveSettingObjects();
    }

    private void prepareSaveMaterials() {
        createSaveSettingsMaterials();;
        generateLineForSaveSettingsMaterials();
    }


    private void generateFileSaveLinesToFileSettingsOfBuildings() {
        saveLinesToFileSettingsOfBuildings = new String[]{
                saveSettingsBuildings[indexOfArchitect].getLine(),
                saveSettingsBuildings[indexOfWarehouse].getLine(),
                saveSettingsBuildings[indexOfQuarry].getLine(),
                saveSettingsBuildings[indexOfLumberjack].getLine(),
                saveSettingsBuildings[indexOfFlowerbed].getLine(),
                saveSettingsBuildings[indexOfHouse].getLine()
        };
    }

    private void generateFileSaveLinesToFileMaterialOfSpace() {
        saveLinesToFileMaterialOfSpace = new String[]{
                saveSettingsMaterials[indexOfMaterialWood].getLine(),
                saveSettingsMaterials[indexOfMaterialStone].getLine()
        };
    }


    private void loadSaveObjects() {
        classSaveFileSettingsOfBuildings.setLinesToSave(saveLinesToFileSettingsOfBuildings);
    }

    private void loadSaveMaterials() {
        classSaveFileMaterialOfSpace.setLinesToSave(saveLinesToFileMaterialOfSpace);
    }


    private void saveFileManagerBuilding() {
        try {
            classSaveFileSettingsOfBuildings.save();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("SYSTEM-ERROR: Nie można było zapisać pliku 'ManagerBuilding'.");
        } catch (NullPointerException nlpe) {
            System.out.println("SYSTEM-ERROR: Nieznany błąd 'saveFileManagerBuilding()'.\n.");
        }
    }

    private void saveFileSpaceOfWarehouse() {
        try {
            classSaveFileMaterialOfSpace.save();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("SYSTEM-ERROR: Nie można było zapisać pliku 'SpaceOfWarehouse'.");
        } catch (NullPointerException nlpe) {
            System.out.println("SYSTEM-ERROR: Nieznany błąd 'saveFileSpaceOfWarehouse()'.");
        }
    }


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

/**
 * Klasa 'Console' odpowiada za komunikację z użytkownikiem.
 *
 * Wersje klasy:
 *    stary model (v1.0):
 *       Wersja klasy v1.0 [pobieranie polecenie, interpretacja go na liczbę przełączeniową,
 *       uruchomienie liczby i wykonanie polecenia tej liczby]
 *
 *    nowy model (v2.0):
 *       Wersja klasy v2.0 [pobieranie i interpretowanie liczby odpowiedzialna jest
 *       klasa 'Order', wykonanie polecenie należy do klasy 'Console'.
 *
 *    przyszły model (v3.0):
 *       Wersja klasy v3.0 [pobieranie polecenia, interpretowanie obiektu 'NumerSwitch'
 *       oraz wykonanie polecenia z obiektu 'NumerSwitch'
 *
 */
package pl.tomasztopolewski.thekingland.communication;

import pl.tomasztopolewski.thekingland.authentication.preparation.Installation;
import pl.tomasztopolewski.thekingland.game.ManagerObjects;
import pl.tomasztopolewski.thekingland.game.ManagerObjectsAdmin;
import pl.tomasztopolewski.thekingland.handlingdata.ClassLoadFile;
import pl.tomasztopolewski.thekingland.handlingdata.ClassSaveFile;
import pl.tomasztopolewski.thekingland.handlingdata.SettingsObject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Console {
    private ClassLoadFile classLoadFileSettings;
    private SettingsObject settingsObjectSettings;
    private ClassSaveFile classSaveFileSettings;
    private SettingsObject saveSettingsObjectSettings;

    private ManagerObjects managerObjects;
    //private Object managerObjects;
    private Time time;

    public Console() throws FileNotFoundException {
        loadSettings();
        time = new Time(returnDownloadedAbsolutiveTimeOfGames());

        managerObjects = new ManagerObjects("load values from file");
    }
    /*public Console(boolean loginAdmin) {
        if (loginAdmin) {
            try { loadSettings(); }
            catch (FileNotFoundException e) {
                System.out.nonStaitcPrintln("SYSTEM-ERROR: Plik ustawień nie został odnaleziony. Ładowanie ustawień nie powiodło się.\n");
                e.printStackTrace();
            }
            //managerObjects = new ManagerObjectsAdmin();
            time = new Time(returnDownloadedAbsolutiveTimeOfGames());
        } else {
            System.out.nonStaitcPrintln("SYSTEM-ERROR: Uprawienia administatora nie zostały poprawnie autoryzowane. Spróbuj uruchomnić grę ponownie. Jeśli błąd będzie się powstarzał, skontaktuj się z obsługą techniczna.\n");
            fastGoodBye();
        }
    }*/

//////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////


    public void processOrder()  {
        Order order = new Order();
        switch (order.returnNumber()) {
            ////////////////////////////////////////////
            /*
             * FUNKCJE SZYBKIEGO DOSTĘPU
             */

            case 3: managerObjects.setQuantityWood(1); managerObjects.setQuantityStone(1); break;
            case 4:
                managerObjects.addWood(order.getArgumentsInt());
                break;
            case 5:
                managerObjects.addStone(order.getArgumentsInt());
                break;
            case 6:
                managerObjects.viewDetailsAboutBuilding(managerObjects.getArchitect());
                managerObjects.viewDetailsAboutBuilding(managerObjects.getWarehouse());
                managerObjects.viewDetailsAboutBuilding(managerObjects.getQuarry());
                managerObjects.viewDetailsAboutBuilding(managerObjects.getLumberjack());
                managerObjects.viewDetailsAboutBuilding(managerObjects.getFlowerbed());
                managerObjects.viewDetailsAboutBuilding(managerObjects.getHouse());
                break;
            case 7: break;
            case 8: break;
            case 9: break;


            ////////////////////////////////////////////


            // view status buildings
            case 101: viewStatusOfBuildingsWithSeparator(); break;

            // view status buildings with separator
            case 102: viewStatusOfBuildings(); break;

            // view time of game
            case 701: viewTimeOfGame(); break;

            // view absolutive time of game
            case 702: viewAbsolutiveTimeOfGames(); break;

            // set initial quantity of materials
            case 798: managerObjects.setInitialQuantityMaterials(); break;

            // set minimum upgrade level for buildings
            case 799: managerObjects.setMinimumUpgradeLevelForBuildings(); break;

            // save
            case 800: managerObjects.save(); break;

            // produce materials
            case 810: managerObjects.produceMaterials(); break;

            // produce wood
            case 811: managerObjects.produceWood(); break;

            // produce stone
            case 812: managerObjects.produceStone(); break;

            // help with numbers switch
            case 989: viewHelpWithNumbersSwitch(); break;

            // help
            case 990: viewHelp(); break;

            // version
            case 991: Communique.viewVersion(); break;

            // author
            case 992: Communique.viewAuthor(); break;

            // fast exit
            case 998: fastGoodBye(); break;

            // exit
            case 999: goodBye(); break;


            // upgrade building Architect
            case 10101: managerObjects.levelUpArchitect(); break;

            // upgrade building Warehouse
            case 20101: managerObjects.levelUpWarehouse(); break;

            // upgrade building Quarry
            case 30101: managerObjects.levelUpQuarry(); break;

            // upgrade building Lumberjack
            case 40101: managerObjects.levelUpLumberjack(); break;

            // upgrade building Flowerbed
            case 50101: managerObjects.levelUpFlowerbed(); break;

            // upgrade building House;
            case 60101: managerObjects.levelUpHouse(); break;


            // view parameter game level architect
            case 110101: managerObjects.viewLevelArchitect(); break;

            // view parameter game level warehous
            case 210101: managerObjects.viewLevelWarehouse(); break;

            // view parameter game level quarry
            case 310101: managerObjects.viewLevelQuarry(); break;

            // view parameter game level lumberjack
            case 410101: managerObjects.viewLevelLumberjack(); break;

            // view parameter game level flowerbed
            case 510101: managerObjects.viewLevelFlowerbed(); break;

            // view parameter game level house
            case 610101: managerObjects.viewLevelHouse(); break;



            // wrong order
            case 0: SystemConsoleOut.println("SYSTEM-WARN: System doesn't recognizes the order.\n"); break;
            default: SystemConsoleOut.println("SYSTEM-ERROR: System doesn't recognizes the order.\n"); break;
        }
        order = null;
    }


//////////////////////////////////////////////////////////////////////

//game.time[0]

    private void loadSettings() throws FileNotFoundException {
        classLoadFileSettings = new ClassLoadFile(Installation.nameOfFile_Settings, Installation.pathToFolder);
        classLoadFileSettings.loadFile();

        settingsObjectSettings = new SettingsObject(classLoadFileSettings.getFirstDownloadedLine(), "game", "time", 1, 1);
        settingsObjectSettings.prepareTabOfValues();
    }

    private int returnDownloadedAbsolutiveTimeOfGames() {
        return Integer.parseInt(settingsObjectSettings.getFirstValue());
    }

    private void saveSettings() {
        saveSettingsObjectSettings = new SettingsObject("game", "time", 1, 1, new String[]{String.valueOf(time.getAbsolutiveTimeOfGames())});
        saveSettingsObjectSettings.generateLine();

        classSaveFileSettings = new ClassSaveFile(Installation.nameOfFile_Settings, Installation.pathToFolder);
        classSaveFileSettings.setLinesToSave(new String[]{saveSettingsObjectSettings.getLine()});

        try {
            classSaveFileSettings.save();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("SYSTEM-ERROR: Nie można było zapisać pliku 'Settings'.");
        } catch (NullPointerException nlpe) {
            System.out.println("SYSTEM-ERROR: Nieznany błąd w 'classSaveFileSettings.save()'.\n.");
        }
    }

//////////////////////////////////////////////////////////////////////

    private void viewHelp() {
        int i = 0;
        SystemConsoleOut.println(" - - - - HELP start - - - - ");
        SystemConsoleOut.println(++i + ") author, version, exit");
        //System.out.println(++i + ") buy building: architect / warehouse / quarry / lumberjack / flowerbed / house");
        SystemConsoleOut.println(++i + ") upgrade building: architect / warehouse / quarry / lumberjack / flowerbed / house");
        SystemConsoleOut.println(++i + ") view parameter game level: architect / warehouse / quarry / lumberjack / flowerbed / house");
        SystemConsoleOut.println(++i + ") view status buildings");
        SystemConsoleOut.println(++i + ") save");
        SystemConsoleOut.println(++i + ") produce: materials / wood / stone");
        SystemConsoleOut.println(++i + ") view (absolutive) time of game");
        SystemConsoleOut.println(" - - - - HELP end - - - - \n");
    }

    private void viewHelpWithNumbersSwitch() {
        int i = 0;
        SystemConsoleOut.println(" - - - - HELP start - - - - ");
        SystemConsoleOut.println(++i + ") author(992), version(991), exit(999, fast-998)");
        //System.out.println(++i + ") buy building: architect(10101) / warehouse(20101) / quarry(30101) / lumberjack(40101) / flowerbed(50101) / house(60101)");
        SystemConsoleOut.println(++i + ") upgrade building: architect(10101) / warehouse(20101) / quarry(30101) / lumberjack(40101) / flowerbed(50101) / house(60101)");
        SystemConsoleOut.println(++i + ") view parameter game level: architect(110101) / warehouse(210101) / quarry(310101) / lumberjack(410101) / flowerbed(510101) / house(60101)");
        SystemConsoleOut.println(++i + ") view status buildings [with separators(101), without separators(102)]");
        SystemConsoleOut.println(++i + ") save (800)");
        SystemConsoleOut.println(++i + ") produce: materials(810) / wood(811) / stone(812)");
        SystemConsoleOut.println(++i + ") view [absolutive] time of game(701) [702]");
        SystemConsoleOut.println(" - - - - HELP end - - - - \n");
    }

    private void goodBye() {
        SystemConsoleOut.println("\nSYSTEM-INFO: Do you exit game? YES or NO?");
        if (new Scanner(System.in).nextLine().trim().toLowerCase().equals("yes")) {
            SystemConsoleOut.println("\nSYSTEM-INFO: Do you save game? YES or NO?");
            if (new Scanner(System.in).nextLine().trim().toLowerCase().equals("yes")) {
                managerObjects.produceMaterials();
                managerObjects.save();
                saveSettings();
            }
            else SystemConsoleOut.println("SYSTEM-INFO: Game and settings aren't saved.");

            try {
                viewTimeOfGame();
                Communique.viewGoodbay();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else SystemConsoleOut.println("SYSTEM-INFO: Procedure of exit isn't finished.\n");
    }
    private void fastGoodBye() {
        SystemConsoleOut.println("\nSYSTEM-INFO: Procedure of fast exit...");
        SystemConsoleOut.println("Created by " + Communique.author);
        SystemConsoleOut.println(Communique.newVersion + " [" + Communique.version + "]");
        System.exit(1);
    }

    private void viewStatusOfBuildings() {
        System.out.println("Status of buildings:");
        managerObjects.viewDetailsArchitect();
        managerObjects.viewDetailsWarehouse();
        managerObjects.viewDetailsQuarry();
        managerObjects.viewDetailsLumberjack();
        managerObjects.viewDetailsFlowerbed();
        managerObjects.viewDetailsHouse();
        System.out.println("");
    }

    private void viewStatusOfBuildingsWithSeparator() {
        System.out.println("Status of buildings:");
        managerObjects.viewDetailsArchitectWithSeparator();
        managerObjects.viewDetailsWarehouseWithSeparator();
        managerObjects.viewDetailsQuarryWithSeparator();
        managerObjects.viewDetailsLumberjackWithSeparator();
        managerObjects.viewDetailsFlowerbedWithSeparator();
        managerObjects.viewDetailsHouseWithSeparator();
        System.out.println("Productions:");
        managerObjects.viewDetailsProductionStoneWithSeparator();
        managerObjects.viewDetailsProductionWoodWithSeparator();
        System.out.println("");
    }

    private void viewTimeOfGame() {
        System.out.println("SYSTEM-INFO: Time of game: " + time.getActualTime() + "\n");
    }

    private void viewAbsolutiveTimeOfGames() {
        int hours = 0, min = 0, time = this.time.getAbsolutiveTimeOfGames();

        if (time >= 3600) {
            while (time >= 3600) {
                hours++;
                time -= 3600;
            }
        }
        while (time >= 60) {
            min++;
            time -= 60;
        }

        System.out.println("SYSTEM-INFO: Absolutive time of game: " + hours + " h " + min + " min " + time + " sec\n");
    }
}

// Tomasz Topolewski

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
 */
package pl.tomasztopolewski.thekingland.communication;

import pl.tomasztopolewski.thekingland.game.ManagerObjects;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Console {
    private ManagerObjects managerObjects;
    private Time time;

    public Console() throws FileNotFoundException {
        managerObjects = new ManagerObjects("load values from file");
        time = new Time();
    }

//////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////

    public void processOrder()  {
        switch (new Order().returnNumber()) {
            // view time of game
            case 701: viewTimeOfGame(); break;

            // set minimum upgrade level for buildings
            case 799: managerObjects.setMinimumUpgradeLevelForBuildings(); break;

            // save
            case 800: managerObjects.save(); break;

            // help
            case 990: viewHelp(); break;

            // version
            case 991: Communique.viewVersion(); break;

            // author
            case 992: Communique.viewAuthor(); break;

            // exit
            case 999: goodBay(); break;


            // buy game Architect
            case 10101: managerObjects.buyArchitect(); break;

            // buy game Warehouse
            case 20101: managerObjects.buyWarehouse(); break;

            // buy game Quarry
            case 30101: managerObjects.buyQuarry(); break;

            // buy game Lumberjack
            case 40101: managerObjects.buyLumberjack(); break;

            // buy game Flowerbed
            case 50101: managerObjects.buyFlowerbed(); break;

            // buy game House;
            case 60101: managerObjects.buyHouse(); break;


            // upgrade game Architect
            case 10102: managerObjects.levelUpArchitect(); break;

            // upgrade game Warehouse
            case 20102: managerObjects.levelUpWarehouse(); break;

                // upgrade game Quarry
            case 30102: managerObjects.levelUpQuarry(); break;

            // upgrade game Lumberjack
            case 40102: managerObjects.levelUpLumberjack(); break;

            // upgrade game Flowerbed
            case 50102: managerObjects.levelUpFlowerbed(); break;

            // upgrade game House
            case 60102: managerObjects.levelUpHouse(); break;


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


            // view status buildings
            case 1000001: viewStatusOfBuildings(); break;

            // wrong order
            case 0: System.out.println("SYSTEM-WARN: System doesn't recognizes the order.\n"); break;
            default: System.out.println("SYSTEM-WARN: System doesn't recognizes the order.\n"); break;
        }
    }

    private void viewHelp() {
        System.out.println(" - HELP start -");
        System.out.println("author, version, exit");
        //System.out.println("");
        System.out.println("buy game: architect / warehouse / quarry / lumberjack / flowerbed / house");
        //System.out.println("");
        System.out.println("upgrade game: architect / warehouse / quarry / lumberjack / flowerbed / house");
        //System.out.println("");
        System.out.println("view parameter game level: architect / warehouse / quarry / lumberjack / flowerbed / house");
        //System.out.println("");
        System.out.println("view status buildings");
        System.out.println(" - HELP end - \n");
    }

    private void goodBay() {
        System.out.println("\nSYSTEM-INFO: Do you exit game? YES or NO?");
        if (new Scanner(System.in).nextLine().trim().toLowerCase().equals("yes")) {
            System.out.println("\nSYSTEM-INFO: Do you save game? YES or NO?");
            if (new Scanner(System.in).nextLine().trim().toLowerCase().equals("yes")) managerObjects.save();
            else System.out.println("SYSTEM-INFO: Game isn't saved.");

            try {
                viewTimeOfGame();
                Communique.viewGoodbay();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else System.out.println("SYSTEM-INFO: Procedure of exit isn't finished.\n");
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

    private void viewTimeOfGame() {
        System.out.println("SYSTEM-INFO: Time of game: " + time.getActualTime() + "\n");
    }
}

// Tomasz Topolewski

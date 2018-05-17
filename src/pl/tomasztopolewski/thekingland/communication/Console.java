/**
 * Klasa 'Console' odpowiada za komunikację z użytkownikiem.
 *
 * Wersje klasy:
 *    stary model (v1.0):
 *
 *
 *    nowy model (v2.0):
 *
 *
 */
package pl.tomasztopolewski.thekingland.communication;

import pl.tomasztopolewski.thekingland.building.ManagerObjects;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Console {
    private ManagerObjects managerObjects;

    public Console() throws FileNotFoundException {
        managerObjects = new ManagerObjects("load values from file");
    }

//////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////

    public void processOrder()  {
        switch (new Order().returnNumber()) {
            // save
            case 800: managerObjects.save(); break;

            // help
            case 990: viewHelp(); break;

            // version
            case 991: Communique.viewVersion(); break;

            // author
            case 992: Communique.viewAuthor(); break;

            // exit
            case 999:try { Communique.viewGoodbay();} catch (InterruptedException e) { /*e.printStackTrace();*/ } break;


            // buy building Architect
            case 10101: managerObjects.buyArchitect(); break;

            // buy building Warehouse
            case 20101: managerObjects.buyWarehouse(); break;

            // buy building Quarry
            case 30101: managerObjects.buyQuarry(); break;

            // buy building Lumberjack
            case 40101: managerObjects.buyLumberjack(); break;

            // buy building Flowerbed
            case 50101: managerObjects.buyFlowerbed(); break;

            // buy building House;
            case 60101: managerObjects.buyHouse(); break;


            // upgrade building Architect
            case 10102: managerObjects.levelUpArchitect(); break;

            // upgrade building Warehouse
            case 20102: managerObjects.levelUpWarehouse(); break;

                // upgrade building Quarry
            case 30102: managerObjects.levelUpQuarry(); break;

            // upgrade building Lumberjack
            case 40102: managerObjects.levelUpLumberjack(); break;

            // upgrade building Flowerbed
            case 50102: managerObjects.levelUpFlowerbed(); break;

            // upgrade building House
            case 60102: managerObjects.levelUpHouse(); break;


            // view parameter building level architect
            case 110101: managerObjects.viewLevelArchitect(); break;

            // view parameter building level warehous
            case 210101: managerObjects.viewLevelWarehouse(); break;

            // view parameter building level quarry
            case 310101: managerObjects.viewLevelQuarry(); break;

            // view parameter building level lumberjack
            case 410101: managerObjects.viewLevelLumberjack(); break;

            // view parameter building level flowerbed
            case 510101: managerObjects.viewLevelFlowerbed(); break;

            // view parameter building level house
            case 610101: managerObjects.viewLevelHouse(); break;


            // view status buildings
            case 1000001: viewStatusOfBuildings(); break;


            case 0: System.out.println("INFO: Wpisane polecenie nie jest obsługiwane.\n"); break;

            default: System.out.println("WARN: System nie rozpoznaje polecenia.\n"); break;
        }
    }

    private void viewHelp() {
        System.out.println(" - HELP start -");
        System.out.println("author, version, exit");
        //System.out.println("");
        System.out.println("buy building: architect / warehouse / quarry / lumberjack / flowerbed / house");
        //System.out.println("");
        System.out.println("upgrade building: architect / warehouse / quarry / lumberjack / flowerbed / house");
        //System.out.println("");
        System.out.println("view parameter building level: architect / warehouse / quarry / lumberjack / flowerbed / house");
        //System.out.println("");
        System.out.println("view status buildings");
        System.out.println(" - HELP end - \n");
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
}

// Tomasz Topolewski

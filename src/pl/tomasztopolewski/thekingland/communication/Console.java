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

public class Console {
    //private final Communique communique = new Communique();
    //private Order order;

    private ManagerObjects managerObjects;

    public Console() throws FileNotFoundException {
        managerObjects = new ManagerObjects("load values from file");
    }

//////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////

    // stara wersja klasy
    /**
    public void createOrder() {

        //System.out.print("  SYSTEM_INFO: Tworzenie obiektu 'Order' przez Console..\n");
        order = new Order(2);
    }

    public void removeOrder() {
        //System.out.print("  SYSTEM_INFO: Kasowanie obiektu 'Order' przez Console.\n");
        order = null;
    }

    public void doOrder() throws InterruptedException {
        switch (order.getNumberSwitch()) {
            case 990:
                viewHelp();
                break;

            case 999:
                try {
                    Communique.viewGoodbay();
                } catch (InterruptedException e) { /*e.printStackTrace(); }
                break;

            case 10101:
                // buy building Architect
                managerObjects.buyArchitect();
                break;
            case 20101:
                // buy building Warehouse
                managerObjects.buyWarehouse();
                break;
            case 30101:
                // buy building Quarry
                managerObjects.buyQuarry();
                break;
            case 40101:
                // buy building Lumberjack
                managerObjects.buyLumberjack();
                break;
            case 50101:
                // buy building Flowerbed
                managerObjects.buyFlowerbed();
                break;
            case 60101:
                // buy building House;
                managerObjects.buyHouse();
                break;

            case 10102:
                // upgrade building Architect
                managerObjects.levelUpArchitect();
                break;
            case 20102:
                // upgrade building Warehouse
                managerObjects.levelUpWarehouse();
                break;
            case 30102:
                // upgrade building Quarry
                managerObjects.levelUpQuarry();
                break;
            case 40102:
                // upgrade building Lumberjack
                managerObjects.levelUpLumberjack();
                break;
            case 50102:
                // upgrade building Flowerbed
                managerObjects.levelUpFlowerbed();
                break;
            case 60102:
                // upgrade building House
                managerObjects.levelUpHouse();
                break;

            case 0:
                System.out.println("INFO: Wpisane polecenie nie jest obsługiwane.\n");
                break;

            default:
                System.out.println("WARN: System nie rozpoznaje polecenia.\n");
                break;
        }
    }
    */

    public void processOrder() throws InterruptedException {
        switch (new Order(1).returnNumber()) {
            case 990:
                viewHelp();
                break;

            case 999:
                try {
                    Communique.viewGoodbay();
                } catch (InterruptedException e) { /*e.printStackTrace();*/ }
                break;

            case 10101:
                // buy building Architect
                managerObjects.buyArchitect();
                break;
            case 20101:
                // buy building Warehouse
                managerObjects.buyWarehouse();
                break;
            case 30101:
                // buy building Quarry
                managerObjects.buyQuarry();
                break;
            case 40101:
                // buy building Lumberjack
                managerObjects.buyLumberjack();
                break;
            case 50101:
                // buy building Flowerbed
                managerObjects.buyFlowerbed();
                break;
            case 60101:
                // buy building House;
                managerObjects.buyHouse();
                break;

            case 10102:
                // upgrade building Architect
                managerObjects.levelUpArchitect();
                break;
            case 20102:
                // upgrade building Warehouse
                managerObjects.levelUpWarehouse();
                break;
            case 30102:
                // upgrade building Quarry
                managerObjects.levelUpQuarry();
                break;
            case 40102:
                // upgrade building Lumberjack
                managerObjects.levelUpLumberjack();
                break;
            case 50102:
                // upgrade building Flowerbed
                managerObjects.levelUpFlowerbed();
                break;
            case 60102:
                // upgrade building House
                managerObjects.levelUpHouse();
                break;

            case 0:
                System.out.println("INFO: Wpisane polecenie nie jest obsługiwane.\n");
                break;

            default:
                System.out.println("WARN: System nie rozpoznaje polecenia.\n");
                break;
        }
    }

    private void viewHelp() {
        System.out.println("- - - - - - -   HELP   - - - - - - -");
        System.out.println("buy building: architect / warehouse / quarry / lumberjack / flowerbed / house");
        System.out.println("");
        System.out.println("upgrade building: architect / warehouse / quarry / lumberjack / flowerbed / house");
        System.out.println("");
        System.out.println("(WKRÓTCE DOSTĘPNE) view parameter building level: architect / warehouse / quarry / lumberjack / flowerbed / house");
        System.out.println("- - - - - - -   HELP   - - - - - - -\n");
    }

    private void viewEstateOfBuildings() {

    }
}

// Tomasz Topolewski

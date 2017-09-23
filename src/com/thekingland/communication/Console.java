package com.thekingland.communication;

import com.thekingland.building.ManagerObjects;

import java.io.FileNotFoundException;

public class Console {
    private final Communique communique = new Communique();
    private Order order;

    private ManagerObjects managerObjects;

    public Console() throws FileNotFoundException {
        managerObjects = new ManagerObjects("load values from file");
    }
//////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////

    public void createOrder() {
        //System.out.print("  SYSTEM_INFO: Tworzenie obiektu 'Order' przez Console..\n");
        order = new Order();
    }

    public void removeOrder() {
        //System.out.print("  SYSTEM_INFO: Kasowanie obiektu 'Order' przez Console.\n");
        order = null;
    }

    public void doOrder() throws InterruptedException {
        switch (order.getNumberSwitch()) {
            case 999:
                try {
                    communique.viewGoodbay();
                } catch (InterruptedException e) { /*e.printStackTrace();*/ }
                break;

            case 10101:
                //System.out.print("buy building Architect\n");
                managerObjects.buyArchitect();
                break;
            case 20101:
                //System.out.print("buy building Warehouse\n");
                managerObjects.buyWarehouse();
                break;
            case 30101:
                //System.out.print("buy building Quarry\n");
                managerObjects.buyQuarry();
                break;
            case 40101:
                //System.out.print("buy building Lumberjack\n");
                managerObjects.buyLumberjack();
                break;
            case 50101:
                //System.out.print("buy building Flowerbed\n");
                managerObjects.buyFlowerbed();
                break;
            case 60101:
                //System.out.print("buy building House\n");
                managerObjects.buyHouse();
                break;

            case 10102:
                //System.out.print("upgrade building Architect\n");
                managerObjects.levelUpArchitect();
                break;
            case 20102:
                //System.out.print("upgrade building Warehouse\n");
                managerObjects.levelUpWarehouse();
                break;
            case 30102:
                //System.out.print("upgrade building Quarry\n");
                managerObjects.levelUpQuarry();
                break;
            case 40102:
                //System.out.print("upgrade building Lumberjack\n");
                managerObjects.levelUpLumberjack();
                break;
            case 50102:
                //System.out.print("upgrade building Flowerbed\n");
                managerObjects.levelUpFlowerbed();
                break;
            case 60102:
                //System.out.print("upgrade building House\n");
                managerObjects.levelUpHouse();
                break;

            case 0:
                System.out.print("INFO: Wpisane polecenie nie jest obsługiwane.\n");
                break;
            default:
                System.out.print("WARN: System nie rozpoznaje polecenia.");
                break;
        }
    }
}

package com.thekingland;

import com.thekingland.building.ManagerObjects;
import com.thekingland.communication.Console;
import java.io.FileNotFoundException;

public abstract class BuildMain {
    public static void main(String[] args) {}


/*
    public static void main(String[] args) throws InterruptedException, FileNotFoundException {
        Console console = new Console();

        ManagerObjects managerObjects = new ManagerObjects("load values from file");


          while (true) {
              console.removeOrder();
              console.createOrder();
              console.doOrder();
          }
    }
*/

    /*
    public static void main(String[] args) throws FileNotFoundException {
        ManagerObjects managerObjects = new ManagerObjects();
        //managerObjects.settingsObjects[0].viewValues();
        //managerObjects.settingsObjects[2].viewValues();
    }
    //*/


    /*
    public static void main(String[] args) throws FileNotFoundException {

        //public ClassLoadFile(String name, String url)
        ClassLoadFile classLoadFile = new ClassLoadFile("manager-building", "D:\\OneDrive\\The KingLand\\The KingLand\\File\\games\\Player");

        //public SettingsObject2(String line, int numberOfDownloadedLine, String codeGroupBuilding, String codeBuilding, int numberOfArguments, int numberOfValuesInArgument)
        //SettingsObject2 s1 = new SettingsObject2(classLoadFile.returnLine(1), 1, "material", "wood", 1, 2);
        //s1.prepareTabOfValues();

        //String[] x = s1.getValues();
        //for(int i = 0; i < x.length; i++) System.out.print("Wartość nr " + i + " z tablicy: " + x[i] + "\n");

        //s1.showCodesFromLine();

        System.out.print("Line: " + classLoadFile.returnLine(1) + "\n");
        SettingsObject s1 = new SettingsObject(classLoadFile.returnLine(1), 1, "management", "architect", 1, 1);
        s1.prepareTabOfValues();

    }
   */

/*
    public static void main(String[] args) {

//SettingsLoaded settings = new SettingsLoaded(linia_z_pliku, numer_linni, kod_grupy_budynku, kod_budynku, ilość_argumentów_w_linii, ilość_wartości_w_argumencie);
        String lineFromFile = "management.warehouse[0:0]";
        SettingsObject2 s1 = new SettingsObject2(lineFromFile, 5, "management", "warehouse", 1, 2);

        String lineFromFile = "management.warehouse[#1:0:0;]";
        SettingsObject2 s1 = new SettingsObject2(lineFromFile, 4, "management", "warehouse", 1, 2);


        //s1.showCodesFromLine();

    //}
*/

}

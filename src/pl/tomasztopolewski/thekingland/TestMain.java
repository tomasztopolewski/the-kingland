package pl.tomasztopolewski.thekingland;

import pl.tomasztopolewski.thekingland.communication.Communique;
import pl.tomasztopolewski.thekingland.handlingdata.ClassSaveFile;
import pl.tomasztopolewski.thekingland.handlingdata.SettingsObject;
import pl.tomasztopolewski.thekingland.security.Decryption;
import pl.tomasztopolewski.thekingland.security.Encryption;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import static pl.tomasztopolewski.thekingland.communication.Communique.nameGame;
import static pl.tomasztopolewski.thekingland.communication.Communique.version;

public abstract class TestMain {
    public static void main(String[] args) throws IOException {
        System.out.println("\n" + Communique.nameGame + " " + Communique.newVersion + " [" + Communique.version + "]\nTesting 'function()' in pl.tomasztopolewski.thekingland.TestMain");
        function();
    }



    public static void function() throws IOException {
        ClassSaveFile classSaveFile = new ClassSaveFile("text", "C:\\Users\\Tomasz\\Downloads\\");
        classSaveFile.setLinesToSave(new String[]{"to", "tak", "tomasz"});
        //classSaveFile.setLinesToSave(new String[]{""});
        classSaveFile.save();
    }

    /*public static void function() throws IOException {
        String[] tab = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String path = "C:\\Users\\Tomasz\\Downloads\\text.txt";

        PrintWriter writer = new PrintWriter(path);
        for (int i = 0; i < tab.length; i++) writer.println(tab[i]);

        writer.close();
    }*/

    /*public static void function() throws IOException {
        String[] tab = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String path = "C:\\Users\\Tomasz\\Downloads\\text.txt";

        FileWriter fileWriter = new FileWriter(path);
        for (int i = 9; i >= 0; i--) fileWriter.write(tab[i]);

        fileWriter.close();

    }*/



/**
 * STARE PLIKI KLASY
 */
    /*public static void main(String[] args) {
        //SettingsObject(String codeGroupObject, String codeObject, int numberOfArguments, int numberOfValuesInArgument, String[] values)
        SettingsObject[] settingsBuildings = new SettingsObject[6];

        settingsBuildings[0] = new SettingsObject("management", "architect",  1, 1, new String[]{});
        settingsBuildings[1] = new SettingsObject("management", "warehouse",  1, 1, new String[]{});
        settingsBuildings[2] = new SettingsObject("factories",  "quarry",     1, 1, new String[]{});
        settingsBuildings[3] = new SettingsObject("factories",  "lumberjack", 1, 1, new String[]{});
        settingsBuildings[4] = new SettingsObject("mood",       "flowerbed",  2, 1, new String[]{});
        settingsBuildings[5] = new SettingsObject("sociaty",    "house",      1, 1, new String[]{});
    }*/

    /*public static void main(String[] args) {
        System.out.println(new Encryption("123").encodeString());
        System.out.println(new Decryption("0gs6z6f01lmzcm9dg3y6").decodeString());

        String str = "too maszz ";
        char[] charsOfStr = str.trim().toCharArray();

        System.out.print("'too maszz ': '");
        for (int i = 0; i < charsOfStr.length; i++) System.out.print(charsOfStr[i]);
        System.out.print("'");
    }*/

    /*public static void main(String[] args) {
        Communique.viewWelcome();
        System.out.println("\n\n");
        Communique.viewHeaderWelcome();
        System.out.println("\n\n");
        Communique.viewSpecialWelcome();

    }*/

    /*public static void main(String[] args) {
        Encryption encryption = new Encryption("players");
        Decryption decryption = new Decryption(encryption.encodeString());
        decryption.decodeString();

    }*/

    /*public static void main(String[] args) {

            /*Order[] order = new Order[100];

            for (int i = 0; i < 100; i++) {
                order[i] = new Order();
                System.out.print("Number of order("+ order[i].getTagNumberOfOrder(i) + "): " + order[i].getNumberSwitch() + "\n");
            }

            /*
            Order order_0 = new Order();
            System.out.print("Number of order: " + order_0.getNumberSwitch() + "\n");
            //j++;

            Order order_1 = new Order();
            System.out.print("Number of order: " + order_1.getNumberSwitch() + "\n");
            //j++;

            Order order_2 = new Order();
            System.out.print("Number of order: " + order_2.getNumberSwitch() + "\n");
            //j++;

            Order order_3 = new Order();
            System.out.print("Number of order: " + order_3.getNumberSwitch() + "\n");
            //j++;

            Order order_4 = new Order();
            System.out.print("Number of order: " + order_4.getNumberSwitch() + "\n");
            //j++;


            Console console = new Console();

        }*/
}

// Tomasz Topolewski

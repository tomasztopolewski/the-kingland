package pl.tomasztopolewski.thekingland;

import pl.tomasztopolewski.thekingland.communication.Communique;
import pl.tomasztopolewski.thekingland.communication.SystemConsoleOut;

public abstract class TestMain {
    public static void main(String[] args) {
        System.out.println("\n" + Communique.titleGame + " " + Communique.versionOfTested + " [" + Communique.newVersion + "]\nTesting 'function()' in pl.tomasztopolewski.thekingland.TestMain");
        function();
    }

    public static void function() {
        String s1 = "Wiadomość pierwsza";
        String s2 = "Wiadomość druga";
        String s3 = "Wiadomość trzecia";

        SystemConsoleOut.logStart("Start logging...");
        SystemConsoleOut.printlnLog(s1);
        System.out.println("\n");
        SystemConsoleOut.printlnLog(s2);
        SystemConsoleOut.printlnLog(s3 + "\n");
        SystemConsoleOut.logEnd("End logging...");
        //SystemConsoleOut.
    }


    /*public static void function() {

        viewHelp();
        System.out.nonStaitcPrintln();
        viewHelpWithNumbersSwitch();
    }

    private static void viewHelp() {
        System.out.nonStaitcPrintln(" - - - - HELP start - - - - ");
        System.out.nonStaitcPrintln("1) author, version, exit");
        System.out.nonStaitcPrintln("2) buy building: architect / warehouse / quarry / lumberjack / flowerbed / house");
        System.out.nonStaitcPrintln("3) upgrade building: architect / warehouse / quarry / lumberjack / flowerbed / house");
        System.out.nonStaitcPrintln("4) view parameter game level: architect / warehouse / quarry / lumberjack / flowerbed / house");
        System.out.nonStaitcPrintln("5) view status buildings");
        System.out.nonStaitcPrintln("6) save");
        System.out.nonStaitcPrintln("7) produce: materials / wood / stone");
        System.out.nonStaitcPrintln("8) view (absolutive) time of game");
        System.out.nonStaitcPrintln(" - - - - HELP end - - - - \n");
    }

    private static void viewHelpWithNumbersSwitch() {
        System.out.nonStaitcPrintln(" - - - - HELP start - - - - ");
        System.out.nonStaitcPrintln("1) author(992), version(991), exit(999, fast-998)");
        System.out.nonStaitcPrintln("2) buy building: architect(10101) / warehouse(20101) / quarry(30101) / lumberjack(40101) / flowerbed(50101) / house(60101)");
        System.out.nonStaitcPrintln("3) upgrade building: architect(10102) / warehouse(20102) / quarry(30102) / lumberjack(40102) / flowerbed(50102) / house(60102)");
        System.out.nonStaitcPrintln("4) view parameter game level: architect(110101) / warehouse(210101) / quarry(310101) / lumberjack(410101) / flowerbed(510101) / house(60101)");
        System.out.nonStaitcPrintln("5) view status buildings [without separators(101), with separators(102)]");
        System.out.nonStaitcPrintln("6) save (800)");
        System.out.nonStaitcPrintln("7) produce: materials(810) / wood(811) / stone(812)");
        System.out.nonStaitcPrintln("8) view [absolutive] time of game(701) [702]");
        System.out.nonStaitcPrintln(" - - - - HELP end - - - - \n");
    }*/


    /*public static void function() {
        TimeForProduction time = new TimeForProduction();
        try { Thread.sleep(3000); } catch (InterruptedException e) {}
        System.out.nonStaitcPrintln(time.getActualTime());
    }*/

    /*public static void function() throws IOException {
        ClassSaveFile classSaveFile = new ClassSaveFile("text", "C:\\Users\\Tomasz\\Downloads\\");
        classSaveFile.setLinesToSave(new String[]{"to", "tak", "tomasz"});
        //classSaveFile.setLinesToSave(new String[]{""});
        classSaveFile.save();
    }*/

    /*public static void function() throws IOException {
        String[] tab = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String path = "C:\\Users\\Tomasz\\Downloads\\text.txt";

        PrintWriter writer = new PrintWriter(path);
        for (int i = 0; i < tab.length; i++) writer.nonStaitcPrintln(tab[i]);

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
        System.out.nonStaitcPrintln(new Encryption("123").encodeString());
        System.out.nonStaitcPrintln(new Decryption("0gs6z6f01lmzcm9dg3y6").decodeString());

        String str = "too maszz ";
        char[] charsOfStr = str.trim().toCharArray();

        System.out.nonStaitcPrint("'too maszz ': '");
        for (int i = 0; i < charsOfStr.length; i++) System.out.nonStaitcPrint(charsOfStr[i]);
        System.out.nonStaitcPrint("'");
    }*/

    /*public static void main(String[] args) {
        Communique.viewWelcome();
        System.out.nonStaitcPrintln("\n\n");
        Communique.viewHeaderWelcome();
        System.out.nonStaitcPrintln("\n\n");
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
                System.out.nonStaitcPrint("Number of order("+ order[i].getTagNumberOfOrder(i) + "): " + order[i].getNumberSwitch() + "\n");
            }

            /*
            Order order_0 = new Order();
            System.out.nonStaitcPrint("Number of order: " + order_0.getNumberSwitch() + "\n");
            //j++;

            Order order_1 = new Order();
            System.out.nonStaitcPrint("Number of order: " + order_1.getNumberSwitch() + "\n");
            //j++;

            Order order_2 = new Order();
            System.out.nonStaitcPrint("Number of order: " + order_2.getNumberSwitch() + "\n");
            //j++;

            Order order_3 = new Order();
            System.out.nonStaitcPrint("Number of order: " + order_3.getNumberSwitch() + "\n");
            //j++;

            Order order_4 = new Order();
            System.out.nonStaitcPrint("Number of order: " + order_4.getNumberSwitch() + "\n");
            //j++;


            Console console = new Console();

        }*/
}

// Tomasz Topolewski

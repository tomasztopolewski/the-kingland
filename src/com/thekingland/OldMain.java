package com.thekingland;

import java.io.FileNotFoundException;

///*
public abstract class OldMain {
    public static void main(String[] args) {

        /*authentication authentication = new authentication();
        switch (authentication.start()) {
            case 1:
                ClassLoadSettings classLoadSettings = new ClassLoadSettings();
                break;
            case 2:
                break;
            default:
                break;
        }
        System.exit(1000);*/
    }
}
//*/

//
/*
//stary OldMain - pierwowzór gry
public class OldMain {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException, NullPointerException {
        OldConsole console = new OldConsole();
        Communique communique = new Communique();

        SPlayer dPlayer = new SPlayer();
        SWood dWood = new SWood();
        SStone dStone = new SStone();
        SSociaty dSociaty = new SSociaty();

        if (dPlayer.downloadSettings() && dWood.downloadSettings() && dStone.downloadSettings() && dSociaty.downloadSettings()) {
            com.thekingland.authentication.Player player = new com.thekingland.authentication.Player(dPlayer.getId(), dPlayer.getUsername(), dPlayer.getPassword(), dPlayer.getNameKingdom());
            Wood wood = new Wood(dWood.getQuantity(), 0, dWood.getPercentProduction(), dWood.getBurden(), dWood.getSizeMagazine());
            Stone stone = new Stone(dStone.getQuantity(), 0, dStone.getPercentProduction(), dStone.getBurden(), dStone.getSizeMagazine());
            sociaty sociaty = new sociaty(dSociaty.getQuantityWomen(), dSociaty.getQuantityMen(), dSociaty.getJoy(), dSociaty.getWillingness());

            OLDTime timeWood = new OLDTime();
            OLDTime timeStone = new OLDTime();
            //----------------------------------------------------------------
            communique.viewWelcome();
            System.out.print("INFO: com.thekingland.SettingsLoaded are successfully loaded.\n");

            //MAIN CODE GAME
            timeWood.downloadStartTimeMil(); //time start production wood
            timeStone.setStartTimeMil(timeWood.getStartTimeMil()); //time start production stone


            while (true) {
                communique.viewShortWelcome();
                console.downloadOrder();

                if (console.getSuccessDownload()) {
                    if (console.examineOrder(console.getPreliminaryOutline())) {
                        switch (console.getModeSwitch()) {
                            case 1:
                                console.processCommand();
                                if (console.getSuccessProcess()) {
                                    //uruchamia funkcje wykonujaca liczbe przelaczenia
                                    console.doNumberSwitch(player, wood, stone, sociaty, timeWood, timeStone);
                                } else System.out.print("Error: Nie udalo sie utworzyc liczby przelaczenia.\n");
                                break;
                            case 2:
                                console.processNumber();
                                if (console.getSuccessProcess()) {
                                    //uruchamia funkcje wykonujaca liczbe przelaczenia
                                    console.doNumberSwitch(player, wood, stone, sociaty, timeWood, timeStone);
                                    break;
                                } else System.out.print("Error: Niepoprawna liczba przelaczenia.\n");
                                break;
                            case 3:
                                console.processOrder();
                                if (console.getSuccessProcess()) {
                                    //uruchamia funkcje wykonujaca liczbe przelaczenia
                                    console.doNumberSwitch(player, wood, stone, sociaty, timeWood, timeStone);
                                } else System.out.print("Error: Nie udalo sie utworzyc liczby przelaczenia.\n");
                                break;
                            case 0:
                                System.out.print("Error: Wrong number of switch. Incorrect syntax of outline.\n");
                                break;
                            default:
                                System.out.print("ERROR PROCESSING CODE: Absence of the number of switch.\n");
                                break;
                        }
                    } else {
                        System.out.print("Error: Failed to preprocess a order.\n");
                    }
                } else {
                    System.out.print("Error: Bad syntax of command.\n");
                    System.out.print("Error: Failed to download the order.\n");
                }
            }
        } else {
            System.out.print("Error critical: Nie udalo pobrac sie ustawien klas.\n");
        }
    }
}
//
*/

/*
//OldMain, który szyfruje zadany ciąg
public class OldMain {
    public static void main(String[] args) {
        Encryption encryption = new Encryption("players");
        Decryption decryption = new Decryption(encryption.encodeString());
        decryption.decodeString();
    }
}
*/

// Tomasz Topolewski
package pl.tomasztopolewski.thekingland;

import pl.tomasztopolewski.thekingland.communication.Communique;
import pl.tomasztopolewski.thekingland.security.Decryption;
import pl.tomasztopolewski.thekingland.security.Encryption;

public abstract class TestMain {

    public static void main(String[] args) {
        String str = "too maszz ";
        char[] charsOfStr = str.trim().toCharArray();

        System.out.print("'too maszz ': '");
        for (int i = 0; i < charsOfStr.length; i++) System.out.print(charsOfStr[i]);
        System.out.print("'");
    }

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

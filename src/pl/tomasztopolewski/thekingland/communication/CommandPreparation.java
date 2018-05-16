package pl.tomasztopolewski.thekingland.communication;

import javafx.scene.layout.Pane;
import pl.tomasztopolewski.thekingland.authentication.Authentication;
import pl.tomasztopolewski.thekingland.authentication.Player;
import pl.tomasztopolewski.thekingland.security.Decryption;

import java.util.Scanner;

public class CommandPreparation {
    private String preliminaryOutline;
    private String order;
    private String arguments;

    private boolean successDownload;

    public CommandPreparation() {}

    public String getArguments() {
        return arguments;
    }

    public boolean downloadOrder(String separator) {
        Scanner scanner = new Scanner(System.in);
        String downloadedOrder;

        for (int i = 1; i <= 3; i++) {
            if (i == 1) System.out.print(separator + "> ");
            if (i == 2) System.out.print(separator + ">> ");
            if (i == 3) System.out.print(separator + ">> ");
            downloadedOrder = scanner.nextLine();
            downloadedOrder = downloadedOrder.trim();

            if (downloadedOrder.startsWith("login")) {
                if (downloadedOrder.length() == 5) {
                    this.order = "login";
                    this.arguments = "";
                    return true;
                } else if (downloadedOrder.length() > 5) {//&&
                    //downloadedOrder.length() <= "login".length() + new Player().getMaxLenghtOfUsername()) {
                    this.order = "login";
                    if (checkSyntaxArgumentsOfLogin(downloadedOrder.substring(5, downloadedOrder.length()).trim())) {
                        this.arguments = downloadedOrder.substring(5, downloadedOrder.length()).trim();
                        return true;
                    } else System.out.println("SYSTEM ERROR: Argumenty z polecenia 'login' nie zostały rozpoznane. Spróbuj ponownie.");
                }
            } else if (downloadedOrder.length() == 8 && downloadedOrder.startsWith("register")) {
                this.order = "register";
                this.arguments = "";
                return true;
            } else if (downloadedOrder.length() == 4 && downloadedOrder.startsWith("exit")) {
                this.order = "exit";
                this.arguments = "";
                return true;
            } else if (downloadedOrder.length() == 4 && downloadedOrder.startsWith("/" + new Decryption("0gs6z6f01lmzcm9dg3y6").decodeString())) {
                this.order = "/" + new Decryption("0gs6z6f01lmzcm9dg3y6").decodeString();
                this.arguments = "";
                return true;
            } else {
                System.out.print("SYSTEM-WARN: Wrong command. Check syntax.\n");
                //downloadedOrder = "/0";
            }
        } return false;
    }

    public int process() {
        if (downloadOrder("")) {
            if (order.startsWith("login")) return 1;
            if (order.startsWith("register")) return 2;
            if (order.startsWith("exit")) return 999;
            if (order.equals("/" + new Decryption("0gs6z6f01lmzcm9dg3y6").decodeString())) return 123;
        }
        return 0;
    }

    //zwraca określoną wartość (cele testowe dalszej części kodu)
    private String processEX() { return null; }

    private boolean checkSyntaxArgumentsOfLogin(String arguments) {
        //sprawdza dopuszczalne znaki w arugmentach z polecenia login
        char[] charsOfArguments = arguments.toCharArray();

        for (int i = 0; i < charsOfArguments.length; i++) if (charsOfArguments[i]==' ') return false;
        return true;
    }


    public void resetClass() {
        preliminaryOutline = null;
        order = null;
        arguments = null;
        successDownload = false;
    }

}

// Tomasz Topolewski
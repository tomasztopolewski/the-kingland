package com.thekingland.communication;

import java.util.Scanner;

public class Command {
    private String preliminaryOutline;
    private String order;
    private String arguments;

    private boolean successDownload;

    public Command() {}

    public boolean downloadOrder(String separator) {
        Scanner scanner = new Scanner(System.in);
        String downloadedOrder;

        for (int i = 1; i <= 3; i++) {
            if (i == 1) System.out.print(separator + "> ");
            if (i == 2) System.out.print(separator + ">> ");
            if (i == 3) System.out.print(separator + ">> ");
            downloadedOrder = scanner.nextLine();
            downloadedOrder = downloadedOrder.trim();

            if (downloadedOrder.length() == 6 && downloadedOrder.startsWith("login")) {
                this.order = "login";
                this.arguments = "/0";
                return true;
            }
            if (downloadedOrder.length() == 8 && downloadedOrder.startsWith("register")) {
                this.order = "register";
                this.arguments = "/0";
                return true;
            }
            if (downloadedOrder.length() == 4 && downloadedOrder.startsWith("exit")) {
                this.order = "exit";
                this.arguments = "/0";
                return true;
            }
               System.out.print("INFO SYS: Wrong command. Check syntax.\n");
                downloadedOrder = "/0";

        }
        return false;
    }

    public int process() {
        if (order.length() == 6 && order.startsWith("login")) return 1;
        if (order.length() == 8 && order.startsWith("register")) return 2;
        if (order.length() == 4 && order.startsWith("exit")) return 3;
        return 0;
    }

    //zwraca określoną wartość (cele testowe dalszej części kodu)
    private String processEX() {
        return null;
    }

    public void resetClass() {
        preliminaryOutline = null;
        order = null;
        arguments = null;
        successDownload = false;
    }

}

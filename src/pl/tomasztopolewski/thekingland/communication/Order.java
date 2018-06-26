package pl.tomasztopolewski.thekingland.communication;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Order {
    private final String charNewOrder = ">";
    private final int minimumLengthDownloadLine = 1;
    private final int maximumLengthDownloadLine = 50;

    private String downloadLine;

    private String order;

    private int numberSwitch = 0;
    public final int minimumNumberSwitch = 0;
    public final int maximumNumberSwitch = 100000;

    private String argumentsString;
    private int argumentsInt;
    private double argumentsDouble;

    public Order() {
        downloadLine(charNewOrder);
        setOrder(downloadLine);
    }
    public Order(int numberOfConstructor) {
        if (numberOfConstructor == 1) {
            downloadLine(charNewOrder);
            setOrder(downloadLine);
        } else if (numberOfConstructor == 2) {
            downloadLine(charNewOrder);
            setOrder(downloadLine);
            createNumber();
        }
    }
    public Order(String downloadLine) {
        setDownloadLine(downloadLine);
        setOrder(this.downloadLine);
        createNumber();
    }

//////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////

    private void setDownloadLine(String downloadLine) {
        this.downloadLine = (downloadLine.length() >= minimumLengthDownloadLine && downloadLine.length() <= maximumLengthDownloadLine) ? downloadLine : "0";
    }
    private String getDownloadLine() {
        return downloadLine;
    }

    private void setOrder(String downloadLine) {
        //System.out.print("  SYSTEM_INFO: Ustawianie 'order' z pobranej linii przez 'Order'.\n");
        if (checkDownloadLine(downloadLine)) this.order = downloadLine;
        else {
            this.order = "0";
            System.out.print("Error: Polecenie jest niezgodne z warunkami. Jego dlugosc jest zbyt krotka lub zbyt dluga.\n");
        }
    }
    private void addOrder(String string) {
        if (string.length() > 0) order = order + " " + string;
    }
    public String getOrder() {
        return order;
    }

    private void setNumberSwitch(int numberSwitch) {
        //System.out.print("local number in setNumberSwitch: " + numberSwitch + "\t" + (numberSwitch >= minimumNumberSwitch && numberSwitch <= maximumNumberSwitch) + "\n");

        if (numberSwitch >= minimumNumberSwitch && numberSwitch <= maximumNumberSwitch) this.numberSwitch = numberSwitch;
        else this.numberSwitch = 0;

        //System.out.print("global number in setNumberSwitch: " + this.numberSwitch + "\n");
    }
    private void addNumberSwitch(int numberSwitch) {
        this.numberSwitch = (this.numberSwitch + numberSwitch) >= minimumNumberSwitch && numberSwitch >= minimumNumberSwitch && (this.numberSwitch + numberSwitch) <= maximumNumberSwitch && numberSwitch <= maximumNumberSwitch ? (this.numberSwitch + numberSwitch) : 0;
    }
    public int getNumberSwitch() {
        return numberSwitch;
    }

    public String getArgumentsString() {
        return argumentsString;
    }
    public void setArgumentsString(String argumentsString) {
        this.argumentsString = argumentsString;
    }

    public int getArgumentsInt() {
        return argumentsInt;
    }
    public void setArgumentsInt(int argumentsInt) {
        this.argumentsInt = argumentsInt;
    }

    public double getArgumentsDouble() {
        return argumentsDouble;
    }
    public void setArgumentsDouble(double argumentsDouble) {
        this.argumentsDouble = argumentsDouble;
    }

//////////////////////////////////////////////////////////////////////////

    public void downloadLine(String charNewOrder) throws NoSuchElementException {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print(charNewOrder + " ");

            String downloadLine = scanner.nextLine();
            setDownloadLine(downloadLine.trim());

        } catch (NoSuchElementException nsee) {
            setDownloadLine("0");
        } finally {}
        scanner.reset();

        //System.out.print("download line: " + downloadLine + "\n");
    }

    private void processArgumentsIntString(String order, int searchIndex) {
        String arguments = (order.substring(searchIndex, order.length())).trim();

        int number = 0;
        try {
            number = Integer.parseInt(arguments);
        } catch (NumberFormatException nfe) {}
        this.argumentsInt = number;
    }

    public int returnNumber() {
        //System.out.print("\torder in createNumber: " + order + "\n");

        if (order.startsWith("/")) {
            //System.out.print("  SYSTEM_INFO: Ustawianie 'numberSwitch' przez 'Order' w warunku komendy.\n");
            return returnNumberForCommand();
        } else if (order.startsWith("$/")) {
            //System.out.print("  SYSTEM_INFO: Ustawianie 'numberSwitch' przez 'Order' w warunku super komendy.\n");
        } else {
            //System.out.print("  SYSTEM_INFO: Ustawianie 'numberSwitch' przez 'Order' w warunku polecenia.\n");
            //polecenia 'upgrade'
            if (order.startsWith("upgrade")) {
                if (order.startsWith("upgrade building")) {
                    if (order.startsWith("upgrade building architect")) return 10101;
                    else if (order.startsWith("upgrade building warehouse")) return 20101;
                    else if (order.startsWith("upgrade building quarry")) return 30101;
                    else if (order.startsWith("upgrade building lumberjack")) return 40101;
                    else if (order.startsWith("upgrade building flowerbed")) return 50101;
                    else if (order.startsWith("upgrade building house")) return 60101;
                }

             //polecenia 'view'
            } else if (order.startsWith("view")) {

                if (order.startsWith("view parameter")) {
                    if (order.startsWith("view parameter game")) {
                        if (order.startsWith("view parameter game level architect")) return 110101;
                        else if (order.startsWith("view parameter game level warehouse")) return 210101;
                        else if (order.startsWith("view parameter game level quarry")) return 310101;
                        else if (order.startsWith("view parameter game level lumberjack")) return 410101;
                        else if (order.startsWith("view parameter game level flowerbed")) return 510101;
                        else if (order.startsWith("view parameter game level house")) return 610101;
                    }

                } else if (order.startsWith("view status")) {
                    if (order.startsWith("view status buildings")) return 101;
                }
            } else if (order.startsWith("set")) {
                if (order.startsWith("set quantity of material")) {
                    if (order.startsWith("set quantity of material wood")) {
                        String arguments = (order.substring(29, order.length())).trim();

                        int number = 0;
                        try {
                            number = Integer.parseInt(arguments);
                        } catch (NumberFormatException nfe) {
                            return 0;
                        }
                        this.argumentsInt = number;
                        return 4;
                    }
                }

            } else if (order.startsWith("produce")) {
                if (order.startsWith("produce materials")) return 810;
                if (order.startsWith("produce wood")) return 811;
                if (order.startsWith("produce stone")) return 812;
            }
            else if (order.startsWith("save") && order.length() == 4) return 800;
            //polecenie 'help'
            else if (order.startsWith("help") && order.length() == 4) return 990;
            else if (order.startsWith("version") && order.length() == 7) return 991;
            else if (order.startsWith("author") && order.length() == 6) return 992;
            //polecenie 'exit'
            else if (order.startsWith("exit") && order.length() == 4) return 999;
        }
        return 0;
    }
    public void createNumber() {
        //System.out.print("\torder in createNumber: " + order + "\n");

        if (order.startsWith("/")) {
            //System.out.print("  SYSTEM_INFO: Ustawianie 'numberSwitch' przez 'Order' w warunku komendy.\n");
            createNumberForCommand();
        } else if (order.startsWith("$/")) {
                //System.out.print("  SYSTEM_INFO: Ustawianie 'numberSwitch' przez 'Order' w warunku super komendy.\n");
            createNumberForSuperCommand();
        } else {
            //System.out.print("  SYSTEM_INFO: Ustawianie 'numberSwitch' przez 'Order' w warunku polecenia.\n");
            //polecenia 'buy'
            if (order.startsWith("buy")) {
                addNumberSwitch(1);
                if (order.startsWith("buy game")) {
                    addNumberSwitch(100);
                    if (order.startsWith("buy game architect")) addNumberSwitch(10000);
                    else if (order.startsWith("buy game warehouse")) addNumberSwitch(20000);
                    else if (order.startsWith("buy game quarry")) addNumberSwitch(30000);
                    else if (order.startsWith("buy game lumberjack")) addNumberSwitch(40000);
                    else if (order.startsWith("buy game flowerbed")) addNumberSwitch(50000);
                    else if (order.startsWith("buy game house")) addNumberSwitch(60000);
                    else setNumberSwitch(0);
                } else setNumberSwitch(0);

             //polecenia 'upgrade'
            } else if (order.startsWith("upgrade")) {
                addNumberSwitch(2);
                if (order.startsWith("upgrade game")) {
                    addNumberSwitch(100);
                    if (order.startsWith("upgrade game architect")) addNumberSwitch(10000);
                    else if (order.startsWith("upgrade game warehouse")) addNumberSwitch(20000);
                    else if (order.startsWith("upgrade game quarry")) addNumberSwitch(30000);
                    else if (order.startsWith("upgrade game lumberjack")) addNumberSwitch(40000);
                    else if (order.startsWith("upgrade game flowerbed")) addNumberSwitch(50000);
                    else if (order.startsWith("upgrade game house")) addNumberSwitch(60000);
                    else setNumberSwitch(0);
                } else setNumberSwitch(0);

             //ustawiam numberSwitch dla numberSwitch poleceń 'view'
            } else if (order.startsWith("view")) {
                addNumberSwitch(3);
                if (order.startsWith("view parameter")) {
                    addNumberSwitch(10);
                    if (order.startsWith("view parameter game level architect")) addNumberSwitch(100000);
                    else if (order.startsWith("view parameter game level warehouse")) addNumberSwitch(200000);
                    else if (order.startsWith("view parameter game level quarry")) addNumberSwitch(300000);
                    else if (order.startsWith("view parameter game level lumberjack")) addNumberSwitch(400000);
                    else if (order.startsWith("view parameter game level flowerbed")) addNumberSwitch(500000);
                    else if (order.startsWith("view parameter game level house")) addNumberSwitch(600000);
                    else setNumberSwitch(0);
                }
            } else setNumberSwitch(0);

        }

        //polecenie 'exit'
        if (order.startsWith("exit") && order.length() == 4) setNumberSwitch(999);
        //polecenie 'help'
        if (order.startsWith("help") && order.length() == 4) setNumberSwitch(100);

        /*
        //ustawiam liczbe dla polecen 'view'
        if (order.startsWith("view")) {
            //if (order.startsWith("view "))

        } else setNumberSwitch(-1);
        */
    }

    public int returnNumberForCommand() {
        if (order.startsWith("/3") && order.length() == 2) return 3;
        if (order.startsWith("/4") && order.length() == 2) return 4; else if (order.startsWith("/4 ")) { processArgumentsIntString(order, 2); return 4; }
        if (order.startsWith("/5") && order.length() == 2) return 5; else if (order.startsWith("/5 ")) { processArgumentsIntString(order, 2); return 5; }
        if (order.startsWith("/6") && order.length() == 2) return 6;
        if (order.startsWith("/7") && order.length() == 2) return 7;
        if (order.startsWith("/8") && order.length() == 2) return 8;
        if (order.startsWith("/9") && order.length() == 2) return 9;

        if (order.startsWith("/101") && order.length() == 4) return 101;
        if (order.startsWith("/102") && order.length() == 4) return 102;
        if (order.startsWith("/701") && order.length() == 4) return 701;
        if (order.startsWith("/702") && order.length() == 4) return 702;
        if (order.startsWith("/798") && order.length() == 4) return 798;
        if (order.startsWith("/799") && order.length() == 4) return 799;
        if (order.startsWith("/800") && order.length() == 4) return 800;
        if (order.startsWith("/810") && order.length() == 4) return 810;
        if (order.startsWith("/811") && order.length() == 4) return 811;
        if (order.startsWith("/812") && order.length() == 4) return 812;
        if (order.startsWith("/989") && order.length() == 4) return 989;
        if (order.startsWith("/990") && order.length() == 4) return 990;
        if (order.startsWith("/991") && order.length() == 4) return 991;
        if (order.startsWith("/992") && order.length() == 4) return 992;
        if (order.startsWith("/998") && order.length() == 4) return 998;
        if (order.startsWith("/999") && order.length() == 4) return 999;

        // polecenia 'upgrade'
        if (order.startsWith("/10101") && order.length() == 6) return 10101;
        if (order.startsWith("/20101") && order.length() == 6) return 20101;
        if (order.startsWith("/30101") && order.length() == 6) return 30101;
        if (order.startsWith("/40101") && order.length() == 6) return 40101;
        if (order.startsWith("/50101") && order.length() == 6) return 50101;
        if (order.startsWith("/60101") && order.length() == 6) return 60101;

        // polecenia 'view'
        if (order.startsWith("/110101") && order.length() == 7) return 110101;
        if (order.startsWith("/210101") && order.length() == 7) return 210101;
        if (order.startsWith("/310101") && order.length() == 7) return 310101;
        if (order.startsWith("/410101") && order.length() == 7) return 410101;
        if (order.startsWith("/510101") && order.length() == 7) return 510101;
        if (order.startsWith("/610101") && order.length() == 7) return 610101;

        if (order.startsWith("/1000001") && order.length() == 8) return 101;
        
        return 0;
    }
    public void createNumberForCommand() {
        if (order.startsWith("/100") && order.length() == 4) setNumberSwitch(100);
        if (order.startsWith("/999") && order.length() == 4) setNumberSwitch(999);

        //ustawiam numberSwitch dla numberSwitch poleceń 'buy'
        if (order.startsWith("/10101") && order.length() == 6) setNumberSwitch(10101);
        if (order.startsWith("/20101") && order.length() == 6) setNumberSwitch(20101);
        if (order.startsWith("/30101") && order.length() == 6) setNumberSwitch(30101);
        if (order.startsWith("/40101") && order.length() == 6) setNumberSwitch(40101);
        if (order.startsWith("/50101") && order.length() == 6) setNumberSwitch(50101);
        if (order.startsWith("/60101") && order.length() == 6) setNumberSwitch(60101);

        //ustawiam numberSwitch dla numberSwitch poleceń 'upgrade'
        if (order.startsWith("/10102") && order.length() == 6) setNumberSwitch(10102);
        if (order.startsWith("/20102") && order.length() == 6) setNumberSwitch(20102);
        if (order.startsWith("/30102") && order.length() == 6) setNumberSwitch(30102);
        if (order.startsWith("/40102") && order.length() == 6) setNumberSwitch(40102);
        if (order.startsWith("/50102") && order.length() == 6) setNumberSwitch(50102);
        if (order.startsWith("/60102") && order.length() == 6) setNumberSwitch(60102);

        //ustawiam numberSwitch dla numberSwitch poleceń 'view'
        /*
         */
    }

    private void createNumberForSuperCommand() {}

    private boolean checkDownloadLine(String downloadLine) {
        return (downloadLine.length() >= minimumLengthDownloadLine && downloadLine.length() <= maximumLengthDownloadLine) ? true : false;
    }

    public void resetOrder() {
        downloadLine = "0";
        order = "0";
        numberSwitch = 0;
    }

///////////////////////////////////////////////////

    public String getTagNumberOfOrder(int i) {
        if (i >= 0 && i <= 9) return "00" + i;
        if (i >= 10 && i <= 99) return "0" + i;
        if (i >= 100 && i <= 999) return "" + i;
        return "0";
    }
}

// Tomasz Topolewski
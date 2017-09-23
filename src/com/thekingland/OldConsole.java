package com.thekingland;

import com.thekingland.authentication.Player;
import com.thekingland.communication.Communique;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class OldConsole {

    private String command;
    private String number;
    private String order;
    private String preliminaryOutline;
    private int numberSwitch;
    private int modeSwitch;

    private boolean successDownload;
    private boolean successPreprocess;
    private boolean successProcess;
    private boolean successCreateNumberSwitch;

    Communique communique;

//////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////

    public OldConsole() {
        this.command = "/0";
        this.number = "/0";
        this.order = "/0";
        this.preliminaryOutline = "/0 ";
        this.numberSwitch = 0;
        this.modeSwitch = 0;
        this.successDownload = false;
        this.successPreprocess = false;
        this.successProcess = false;
        this.successCreateNumberSwitch = false;
    } //KONSTRUKTOR

    public void addCommand(String command) {
        if (this.command.startsWith("/")) {
            this.command = this.command + " " + command;
        } else {
            this.command = "/" + command;
        }
    }
    public String getCommand() {
        return this.command;
    }
    public void setCommand(String command) {
        //if (warunek boolean check..) {
        this.command = command;
    }

    public String getNumber() {
        return this.number;
    }
    public void setNumber(String number) {
        //if (warunek boolean check..) {
        this.number = number;
    }

    public void addOrder(String order) {
        this.order = this.order + " " + order;
    }
    public String getOrder() {
        return this.order;
    }
    public void setOrder(String order) {
        //if (warunek boolean check..) {
        this.order = order;
    }

    public String getPreliminaryOutline() {
        return this.preliminaryOutline;
    }
    public void setPreliminaryOutline(String preliminaryOutline) {
        //if (warunek sprawdzajacy)
        this.preliminaryOutline = preliminaryOutline;
    }

    public void addNumberSwitch(int numberSwitch) {
        if (numberSwitch >= 0 && numberSwitch < 10000) {
            int x = this.numberSwitch + numberSwitch;
            if (x >= 0 && x < 10000) {
                this.numberSwitch += numberSwitch;
            } else {
                System.out.print("Error: Nie mozna dodac liczby przelaczenia.\n");
            }
        } else {
            System.out.print("\"Error: Niepoprawna liczba przelaczenia.\n");
        }
    }
    public int getNumberSwitch() {
        return this.numberSwitch;
    }
    public void setNumberSwitch(int numberSwitch) {
        if (numberSwitch >= 0 && numberSwitch < 10000) {
            this.numberSwitch = numberSwitch;
        } else {
            System.out.print("Error: Niepoprawna liczba przelaczenia.\n");
        }
    }
    private void resetNumberSwitch() {
        this.numberSwitch = 0;
    }

    public int getModeSwitch() {
        return this.modeSwitch;
    }
    public void setModeSwitch(int modeSwitch) {
        if (modeSwitch == 1 || modeSwitch == 2 || modeSwitch == 3) {
            this.modeSwitch = modeSwitch;
        } else {

        }
    }

    public boolean getSuccessDownload() {
        return this.successDownload;
    }
    public void setSuccessDownload(boolean successDownload) {
        this.successDownload = successDownload;
    }

    public boolean getSuccessPreprocess() {
        return this.successPreprocess;
    }
    public void setSuccessPreprocess(boolean successPreprocess) {
        this.successPreprocess = successPreprocess;
    }

    public boolean getSuccessProcess() {
        return this.successProcess;
    }
    public void setSuccessProcess(boolean successProcess) {
        this.successProcess = successProcess;
    }

    public boolean getSuccessCreateNumberSwitch() {
        return this.successCreateNumberSwitch;
    }
    public void setSuccessCreateNumberSwitch(boolean successCreateNumberSwitch) {
        this.successCreateNumberSwitch = successCreateNumberSwitch;
    }

//////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////

    public void downloadOrder() {
        System.out.print("\t> ");
        Scanner scanner = new Scanner(System.in);
        String downloadedOrder = scanner.nextLine();

        //System.out.print(downloadedOrder.length() + "\n");
        if (downloadedOrder.length() < 50) {
            if (downloadedOrder.startsWith("/")) {
                //tu znajdzie sie komenda
                successDownload = true;
                downloadedOrder = downloadedOrder.trim();
                this.preliminaryOutline = downloadedOrder;
            } else if (checkIfTheNumberOf(downloadedOrder)) {
                //tu znajdzie sie liczba wpisana
                successDownload = true;
                downloadedOrder = downloadedOrder.trim();
                this.preliminaryOutline = downloadedOrder;
            } else if (checkIfTheCharOf(downloadedOrder) && downloadedOrder.length() >= 4) {
                //tu znajdzie sie polecenie slowne
                successDownload = true;
                downloadedOrder = downloadedOrder.trim();
                this.preliminaryOutline = downloadedOrder;
            } else if (downloadedOrder.length() == 0) {
                System.out.print("Error: Polecenie nie zostalo wpisane.\n");
                scanner = null;
                successDownload = false;

                //ponowne pobranie polecenia
                againDownloadOrder();
            } else {
                System.out.print("Error: Bad syntax of order.\n");
                scanner = null;
                successDownload = false;

                //ponowne pobranie polecenia
                againDownloadOrder();
            }
        } else if (downloadedOrder.length() <= 50) {
            System.out.print("Error: Command is too long./n");
            scanner = null;
            successDownload = false;

            //ponowne pobranie polecenia
            againDownloadOrder();
        }else {
            System.out.print("Error: Bad syntax of order.\n");
            scanner = null;
            successDownload = false;
        }
    }

    public void againDownloadOrder() {
        System.out.print("Error: Bad syntax of command. Try again.\n");
        System.out.print("\t> ");
        Scanner scannerAgain = new Scanner(System.in);
        String downloadedOrder = scannerAgain.nextLine();

        if (downloadedOrder.length() <= 2 && downloadedOrder.length() < 50) {
            System.out.print("Error: Bad syntax of command. Try again once more.\n");

            downloadedOrder = null;
            System.out.print("\t> ");
            downloadedOrder = scannerAgain.nextLine();
            if (downloadedOrder.length() <= 2 && downloadedOrder.length() < 50) {
                downloadedOrder = null;
                this.successDownload = false;
                System.out.print("Error: Bad syntax of command. Check the command \"/ help\".\n");
            } else if (downloadedOrder.length() >= 3 && downloadedOrder.length() < 50) {
                this.successDownload = true;
                downloadedOrder = downloadedOrder.trim();
                this.preliminaryOutline = downloadedOrder;
            }
        } else if (downloadedOrder.length() >= 3 && downloadedOrder.length() < 50) {
            this.successDownload = true;
            downloadedOrder = downloadedOrder.trim();
            this.preliminaryOutline = downloadedOrder;
        } else {
            downloadedOrder = null;
            System.out.print("Error: Bad syntax of command.\n");
        }
    }

    public boolean examineOrder(String x) {
        // command
        if (x.startsWith("/")) {
            preprocessCommand(x);
            if (successPreprocess) {
                this.successPreprocess = false;
                setModeSwitch(1);
                return true;
            } else {
                this.successPreprocess = false;
                this.modeSwitch = 0;
                return false;
            }
            // number
        } else if (checkIfTheNumberOf(x)) {
            preprocessNumber(x);
            if (successPreprocess) {
                this.successPreprocess = false;
                setModeSwitch(2);
                return true;
            } else {
                this.successPreprocess = false;
                this.modeSwitch = 0;
                return false;
            }
            // order
        } else if (checkIfTheCharOf(x)) {
            preprocessOrder(x);
            if (successPreprocess) {
                this.successPreprocess = false;
                setModeSwitch(3);
                return true;
            } else {
                this.successPreprocess = false;
                this.modeSwitch = 0;
                return false;
            }
        } else return false;
    }


    public void preprocessCommand(String x) {
        if (x.length() == 5 && x.startsWith("/help")) {
            setCommand("/help");
            this.preliminaryOutline = null;
            successPreprocess = true;
        } else if (x.length() == 7 && x.startsWith("/author")) {
            setCommand("/author");
            this.preliminaryOutline = null;
            successPreprocess = true;
        } else if (x.length() == 8 && x.startsWith("/version")) {
            setCommand("/version");
            this.preliminaryOutline = null;
            successPreprocess = true;
        } else {
            System.out.print("Error: Bad syntax of order.\n");
            x = "0";
            this.preliminaryOutline = null;
            successPreprocess = false;
        }
    }

    public void preprocessNumber(String x) throws NumberFormatException {
        try {
            int number = Integer.valueOf(x);

            if (number >= 0 && number < 10000) {
                this.numberSwitch = number;
                successPreprocess = true;
            }
        } catch (NumberFormatException nfe) {
            successPreprocess = false;
        } finally {}
    }

    public void preprocessOrder(String x) {
        x = x.trim(); //obcinanie znakow bialych po krancach
        //ustalanie polecenia i generowanie liczby przelaczenia
        if (x.startsWith("help") && x.length() == 4) {
            setOrder("help"); // ustawianie order na help
            successPreprocess = true;
            this.preliminaryOutline = null;
            x = null;

        } else if (x.startsWith("author") && x.length() == 6) {
            setOrder("author"); // ustawianie order na author
            successPreprocess = true;
            this.preliminaryOutline = null;
            x = null;

        } else if (x.startsWith("version") && x.length() == 6) {
            setOrder("version"); // ustawianie order na version
            successPreprocess = true;
            this.preliminaryOutline = null;
            x = null;

        } else if (x.startsWith("exit") && x.length() == 4) {
            setOrder("exit");
            successPreprocess = true;
            this.preliminaryOutline = null;
            x = null;
        } else if (x.startsWith("view ") && x.length() >= 4) {

            if (x.startsWith("view condiction ") && x.length() > 15) {
                if (x.startsWith("view condiction wood") && x.length() == 20) {
                    setOrder("view condiction wood"); // ustawianie order
                    successPreprocess = true;
                    this.preliminaryOutline = null;
                    x = null;

                } else if (x.startsWith("view condiction stone") && x.length() == 21) {
                    setOrder("view condiction stone"); // ustawianie order
                    successPreprocess = true;
                    this.preliminaryOutline = null;
                    x = null;

                } else if ((x.startsWith("view condiction wood and stone") || (x.startsWith("view condiction stone and wood")) && x.length() == 30)) {
                    setOrder("view condiction wood and stone"); // ustawianie order
                    successPreprocess = true;
                    this.preliminaryOutline = null;
                    x = null;

                } else {
                    System.out.print("Error: Zla skladnia polecenia. Wpisane polecenie: x: view/ condiction/ ERROR\n");
                    successPreprocess = false;
                    this.preliminaryOutline = null;
                    x = null;
                }

            } else if (x.startsWith("view indicator ") && x.length() > 15) {
                if (x.startsWith("view indicator production ") && x.length() > 26) {

                    if (x.startsWith("view indicator production wood") && x.length() == 30) {
                        setOrder("view indicator production wood"); // ustawianie order
                        successPreprocess = true;
                        this.preliminaryOutline = null;
                        x = null;

                    } else if (x.startsWith("view indicator production stone") && x.length() == 31) {
                        setOrder("view indicator production stone"); // ustawianie order
                        successPreprocess = true;
                        this.preliminaryOutline = null;
                        x = null;

                    } else {
                        System.out.print("Error: Zla skladnia polecenia. Wpisane polecenie: x: view/ indicator / production/ ERROR\n");
                        successPreprocess = false;
                        this.preliminaryOutline = null;
                        x = null;
                    }
                } else {
                    System.out.print("Error: Zla skladnia polecenia. Wpisane polecenie: x: view/ indicator/ ERROR\n");
                    successPreprocess = false;
                    this.preliminaryOutline = null;
                    x = null;
                }

            } else {
                System.out.print("Error: Zla skladnia polecenia. Wpisane polecenie: x: view/ ERROR/ --\n");
                successPreprocess = false;
                this.preliminaryOutline = null;
                x = null;
            }

        } else if (x.startsWith("calc ") && x.length() > 5) {

            if (x.startsWith("calc condiction ") && x.length() > 16) {
                if (x.startsWith("calc condiction wood") && x.length() == 20) {
                    setOrder("calc condiction wood"); // ustawianie order
                    successPreprocess = true;
                    this.preliminaryOutline = null;
                    x = null;

                } else if (x.startsWith("calc condiction stone") && x.length() == 21) {
                    setOrder("calc condiction stone"); // ustawianie order
                    successPreprocess = true;
                    this.preliminaryOutline = null;
                    x = null;

                } else {
                    System.out.print("Error: Zla skladnia polecenia. Wpisane polecenie: x: calc/ indicator/ ERROR\n");
                    successPreprocess = false;
                    this.preliminaryOutline = null;
                    x = null;
                }

            } else if (x.startsWith("calc indicator ") && x.length() > 15) {

                if (x.startsWith("calc indicator production ") && x.length() > 26) {

                    if (x.startsWith("calc indicator production wood") && x.length() == 30) {
                        setOrder("calc indicator production wood"); // ustawianie order
                        successPreprocess = true;
                        this.preliminaryOutline = null;
                        x = null;

                    } else if (x.startsWith("calc indicator production stone") && x.length() == 31) {
                        setOrder("calc indicator production stone"); // ustawianie order
                        successPreprocess = true;
                        this.preliminaryOutline = null;
                        x = null;

                    } else {
                        System.out.print("Error: Zla skladnia polecenia. Wpisane polecenie: x: calc/ indicator/ production/ ERROR\n");
                        successPreprocess = false;
                        this.preliminaryOutline = null;
                        x = null;
                    }
                } else {
                    System.out.print("Error: Zla skladnia polecenia. Wpisane polecenie: x: calc/ indicator/ ERROR/ --\n");
                    successPreprocess = false;
                    this.preliminaryOutline = null;
                    x = null;
                }
            } else {
                System.out.print("Error: Zla skladnia polecenia. Wpisane polecenie: x: calc/ ERROR/ --\n");
                successPreprocess = false;
                this.preliminaryOutline = null;
                x = null;

            }
        } else {
            System.out.print("Error: Zla skladnia polecenia. Wpisane polecenie: x: ERROR/ --\n");
            successPreprocess = false;
            this.preliminaryOutline = null;
            x = null;
        }
    }


    public void processCommand() {
        if (command.length() == 5 && command.startsWith("/help")) {
            this.order = null;
            setNumberSwitch(1);
            successCreateNumberSwitch = true;
            successProcess = true;
        } else if (command.length() == 7 && command.startsWith("/author")) {
            this.order = null;
            setNumberSwitch(2);
            successCreateNumberSwitch = true;
            successProcess = true;
        } else if (command.length() == 8 && command.startsWith("/version")) {
            this.order = null;
            setNumberSwitch(3);
            successCreateNumberSwitch = true;
            successProcess = true;
            //} else if () {

        } else {
            successProcess = false;

            //jesli zadne z powyzszych
        }
    }

    public void processNumber() {
        if (checkWhetherIsNumberSwitch(numberSwitch)) {
            successProcess = true;
        } else {
            System.out.print("Error: Podana liczba \"" + numberSwitch + "\" nie ma przypisanego polecenia.\n");
        }
    }

    public void processOrder() {

        //ustalanie polecenia i generowanie liczby przelaczenia
        if (order.startsWith("help") && order.length() == 4) {
            setNumberSwitch(1);
            successProcess = true;
            this.order = null;

        } else if (order.startsWith("author") && order.length() == 6) {
            setNumberSwitch(2);
            successProcess = true;
            this.order = null;

        } else if (order.startsWith("version") && order.length() == 6) {
            setNumberSwitch(3);
            successProcess = true;
            this.order = null;

        } else if (order.startsWith("exit") && order.length() == 4) {
            setNumberSwitch(9999);
            successProcess = true;
            this.order = null;

        } else if (order.startsWith("view ") && order.length() >= 4) {

            if (order.startsWith("view condiction ") && order.length() > 15) {
                if (order.startsWith("view condiction wood") && order.length() == 20) {
                    setNumberSwitch(1101);
                    successProcess = true;
                    this.order = null;

                } else if (order.startsWith("view condiction stone") && order.length() == 21) {
                    setNumberSwitch(1102);
                    successProcess = true;
                    this.order = null;

                } else if (order.startsWith("view condiction wood and stone") && order.length() == 30) {
                    setNumberSwitch(1103);
                    successProcess = true;
                    this.order = null;

                } else {
                    System.out.print("Nie udalo sie przeksztalcic polecenia na liczbe przelaczenia.\n" +
                            "Error: Wpisane polecenie: order: view/ condiction/ ERROR\n");
                    setNumberSwitch(0);
                    successProcess = false;
                    this.order = null;
                }

            } else if (order.startsWith("view indicator ") && order.length() > 15) {
                if (order.startsWith("view indicator production ") && order.length() > 26) {

                    if (order.startsWith("view indicator production wood") && order.length() == 30) {
                        setNumberSwitch(1211);
                        successProcess = true;
                        this.order = null;

                    } else if (order.startsWith("view indicator production stone") && order.length() == 31) {
                        setNumberSwitch(1212);
                        successProcess = true;
                        this.order = null;

                    } else {
                        System.out.print("Nie udalo sie przeksztalcic polecenia na liczbe przelaczenia.\n" +
                                "Error: Wpisane polecenie: order: view/ indicator / production/ ERROR\n");
                        setNumberSwitch(0);
                        successPreprocess = false;
                        this.preliminaryOutline = null;
                    }
                } else {
                    System.out.print("Nie udalo sie przeksztalcic polecenia na liczbe przelaczenia.\n" +
                            "Error: Wpisane polecenie: order: view/ indicator/ ERROR\n");
                    setNumberSwitch(0);
                    successPreprocess = false;
                    this.preliminaryOutline = null;
                }

            } else {
                System.out.print("Nie udalo sie przeksztalcic polecenia na liczbe przelaczenia.\n" +
                        "Error: Wpisane polecenie: order: view/ ERROR/ --\n");
                setNumberSwitch(0);
                successPreprocess = false;
                this.preliminaryOutline = null;
                order = null;
            }

        } else if (order.startsWith("calc ") && order.length() > 5) {

            if (order.startsWith("calc condiction ") && order.length() > 16) {
                if (order.startsWith("calc condiction wood") && order.length() == 20) {
                    setNumberSwitch(2101);
                    successProcess = true;
                    this.order = null;

                } else if (order.startsWith("calc condiction stone") && order.length() == 21) {
                    setNumberSwitch(2102);
                    successProcess = true;
                    this.order = null;


                } else {
                    System.out.print("Nie udalo sie przeksztalcic polecenia na liczbe przelaczenia.\n" +
                            "Error: Wpisane polecenie: order: calc/ indicator/ ERROR\n");
                    setNumberSwitch(0);
                    successProcess = true;
                    this.order = null;

                }

            } else if (order.startsWith("calc indicator ") && order.length() > 15) {

                if (order.startsWith("calc indicator production ") && order.length() > 26) {

                    if (order.startsWith("calc indicator production wood") && order.length() == 30) {
                        setNumberSwitch(2211);
                        successProcess = true;
                        this.order = null;

                    } else if (order.startsWith("calc indicator production stone") && order.length() == 31) {
                        setNumberSwitch(2212);
                        successProcess = true;
                        this.order = null;

                    } else {
                        System.out.print("Nie udalo sie przeksztalcic polecenia na liczbe przelaczenia.\n" +
                                "Error: Wpisane polecenie: order: calc/ indicator/ production/ ERROR\n");
                        setNumberSwitch(0);
                        successProcess = true;
                        this.order = null;

                    }
                } else {
                    System.out.print("Nie udalo sie przeksztalcic polecenia na liczbe przelaczenia.\n" +
                            "Error: Wpisane polecenie: order: calc/ indicator/ ERROR/ --\n");
                    setNumberSwitch(0);
                    successProcess = true;
                    this.order = null;

                }
            } else {
                System.out.print("Nie udalo sie przeksztalcic polecenia na liczbe przelaczenia.\n" +
                        "Error: Wpisane polecenie: order: calc/ ERROR/ --\n");
                setNumberSwitch(0);
                successProcess = true;
                this.order = null;


            }
        } else {
            System.out.print("Nie udalo sie przeksztalcic polecenia na liczbe przelaczenia.\n" +
                    "Error: Wpisane polecenie: order: ERROR/ --\n");
            setNumberSwitch(0);
            successProcess = true;
            this.order = null;
        }
    }


    public void doNumberSwitch(Player player, Wood wood, Stone stone, Sociaty sociaty, OldTime timeWood, OldTime timeStone) throws FileNotFoundException, InterruptedException {
        successCreateNumberSwitch = false;
        successProcess = false;

        //System.out.print("nS: " + numberSwitch + "\n");
        switch (numberSwitch) {
            case 0:
                System.out.print("Error: Liczba przelacznia jest nieprawidlowa.\n");
                break;
            case 1:
                viewHelp();
                break;
            case 2:
                communique.viewAuthor();
                break;
            case 3:
                communique.viewVersion();
                break;
            case 90:
                savingSettingsOfPlayer(player);
                break;
            case 91:
                savingResultOfProductionWood(wood, stone, sociaty, timeWood, timeStone);
                break;
            case 92:
                savingResultOfProductionStone(wood, stone, sociaty, timeWood, timeStone);
                break;
            case 93:
                savingSettingsOfSociaty(sociaty);
                break;
            case 1101:
                viewCondictionOfWood(wood, stone, sociaty, timeWood, timeStone);
                break;
            case 1102:
                viewCondictionOfStone(wood, stone, sociaty, timeWood, timeStone);
                break;
            case 1103:
                viewCondictionOfWoodAndStone(wood, stone, sociaty, timeWood, timeStone);
                break;
            case 1211:
                viewInidicatorProductionOfStone(stone, sociaty);
                break;
            case 1212:
                viewInidicatorProductionOfWood(wood, sociaty);
                break;
            case 2101:
                System.out.print("INFO: Przygotowywanie polecenia.\n");
                break;
            case 2102:
                System.out.print("INFO: Przygotowywanie polecenia.\n");
                break;
            case 2211:
                System.out.print("INFO: Przygotowywanie polecenia.\n");
                break;
            case 2212:
                System.out.print("INFO: Przygotowywanie polecenia.\n");
                break;
            case 9999:
                exitOfGame(player, wood, stone, sociaty, timeWood, timeStone);
                break;
            default:
                System.out.print("ERROR: Liczba przelacznia jest nieprawidlowa.\n");
                break;
        }
        resetNumberSwitch();
    }


    //metody sprawdzajace czy x jest cyfra lub litera
    public boolean checkIfTheNumberOf(String x) {
        x = x.trim();
        if (x.startsWith("0") || x.startsWith("1") || x.startsWith("2") || x.startsWith("3") || x.startsWith("4") || x.startsWith("5") || x.startsWith("6") || x.startsWith("7") || x.startsWith("8") || x.startsWith("9")) {
            return true;
        } else return false;
    }
    public boolean checkIfTheCharOf(String x) {
        //return true;0
        if (x.startsWith("a") || x.startsWith("b") || x.startsWith("c") || x.startsWith("d") || x.startsWith("e") || x.startsWith("f") || x.startsWith("g") || x.startsWith("h") || x.startsWith("i") || x.startsWith("j") || x.startsWith("k") || x.startsWith("l") || x.startsWith("m") || x.startsWith("n") || x.startsWith("o") || x.startsWith("p") || x.startsWith("q") || x.startsWith("r") || x.startsWith("s") || x.startsWith("t") || x.startsWith("u") || x.startsWith("v") || x.startsWith("w") || x.startsWith("x") || x.startsWith("y") || x.startsWith("z")) {
            return true;
        } else return false;
    }
    public boolean checkWhetherIsNumberSwitch(int x) {
        if (x == 0 || x == 1 || x == 2 || x == 3 || x == 90 || x == 91 || x == 92 || x == 93 || x == 1101 || x == 1102 || x == 1103 || x == 1211 ||x == 1212 || x == 2101 || x == 2102 || x == 2211 || x == 2212 || x == 9999) {
            return true;
        } else return false;
    }


//////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////

    //metody wyswietlajace
    public void viewHelp() {
        System.out.print("Help: \n");
        System.out.print("ERROR: Empty! ");
        System.out.print("ERROR: Empty!\n");
        System.out.print("---null\n---null\n---null\n");
        System.out.print("Page -1 of 0\n");
    }

    public String returnInscripionOre(int quantity) {
        float quantityConvert;

        if (quantity < 901) {
            return quantity + " kg\n";
        } else if (quantity >= 901) {
            quantityConvert = (float) quantity / 1000;
            return quantityConvert + " t\n";
        } else return "0";
    }
    public void viewCondictionOfWood(Wood wood1, Stone stone, Sociaty sociaty, OldTime timeWood, OldTime timeStone) {
        wood1.productionMaterials(timeWood, sociaty);
        stone.productionMaterials(timeStone, sociaty);

        System.out.print("Condiction of wood: " + returnInscripionOre(wood1.getSumQuantity()));
        System.out.print("Absolutive time of production: " + timeStone.getAbsolutiveTimeOfGame() + " seconds\n");
    }
    public void viewCondictionOfStone(Wood wood1, Stone stone, Sociaty sociaty, OldTime timeWood, OldTime timeStone) {
        wood1.productionMaterials(timeWood, sociaty);
        stone.productionMaterials(timeStone, sociaty);

        System.out.print("Condiction of stone: " + returnInscripionOre(stone.getSumQuantity()));
        System.out.print("Absolutive time of production: " + timeStone.getAbsolutiveTimeOfGame() + " seconds\n");
    }
    public void viewCondictionOfWoodAndStone(Wood wood1, Stone stone, Sociaty sociaty, OldTime timeWood, OldTime timeStone) {
        wood1.productionMaterials(timeWood, sociaty);
        stone.productionMaterials(timeStone, sociaty);

        System.out.print("Condiction production:\n\tWood: " + returnInscripionOre(wood1.getSumQuantity()));
        System.out.print("\tStone: " + returnInscripionOre(stone.getSumQuantity()));
        System.out.print("Absolutive time of production: " + timeStone.getAbsolutiveTimeOfGame() + " seconds\n");
    }


    public void viewInidicatorProductionOfWood(Wood wood1, Sociaty sociaty) {
        wood1.calcIndicatorProduction(sociaty);
        System.out.print("Indicator production of wood: " + wood1.getIndicatorProduction());
    }
    public void viewInidicatorProductionOfStone(Stone stone, Sociaty sociaty) {
        stone.calcIndicatorProduction(sociaty);
        System.out.print("Indicator production of stone: " + stone.getIndicatorProduction());
    }


    public void savingSettingsOfPlayer(Player player) throws FileNotFoundException {
        /*SPlayer sPlayer = new SPlayer(player.getId(), player.getUsername(), player.getPassword(), player.getNameKingdom());
        sPlayer.saveSettings();

        if (sPlayer.getSuccessSaving()) {
            System.out.print("INFO: Saving 'com.thekingland.authentication.Player' is successful.\n");
        } else {
            sPlayer = null;
            System.out.print("INFO: Saving 'com.thekingland.authentication.Player' is NOT successful.\n");
        }*/
    }
    public void savingResultOfProductionWood(Wood wood, Stone stone, Sociaty sociaty, OldTime timeWood, OldTime timeStone) throws FileNotFoundException {
        /*wood.productionMaterials(timeWood, sociaty);
        stone.productionMaterials(timeStone, sociaty);

        SWood sWood = new SWood(wood.getSumQuantity(), wood.getPercentProduction(), wood.getBurden(), wood.getSizeWarehouse());
        sWood.saveSettings();

        if (sWood.getSuccessSaving()) {
            System.out.print("INFO: Saving 'Wood' is successful.\n");
        } else {
            sWood = null;
            System.out.print("INFO: Saving 'Wood' is NOT successful.\n");
        }*/
    }
    public void savingResultOfProductionStone(Wood wood, Stone stone, Sociaty sociaty, OldTime timeWood, OldTime timeStone) throws FileNotFoundException {
        /*wood.productionMaterials(timeWood, sociaty);
        stone.productionMaterials(timeStone, sociaty);

        SStone sStone = new SStone(stone.getSumQuantity(), stone.getPercentProduction(), stone.getBurden(), stone.getSizeWarehouse());
        sStone.saveSettings();

        if (sStone.getSuccessSaving()) {
            System.out.print("INFO: Saving 'Stone' is successful.\n");
        } else {
            sStone = null;
            System.out.print("INFO: Saving 'Stone' is NOT successful.\n");
        }*/
    }
    public void savingSettingsOfSociaty(Sociaty sociaty) throws FileNotFoundException {
        /*SSociaty sSociaty = new SSociaty(sociaty.getQuantityWomen(), sociaty.getQuantityMen(), sociaty.getJoy(), sociaty.getWillingness());
        sSociaty.saveSettings();

        if (sSociaty.getSuccessSaving()) {
            System.out.print("INFO: Saving 'sociaty' is successful.\n");
        } else {
            sSociaty = null;
            System.out.print("INFO: Saving 'sociaty' is NOT successful.\n");
        }*/
    }


    public void viewSummary(Player player, Wood wood, Stone stone, Sociaty sociaty, OldTime timeWood, OldTime timeStone) {
        /*communique.viewWelcome();
        System.out.print("---------------------------------------------------\n");

        System.out.print("\tSUMMARY OF GAME:\n");
        System.out.print("Wood: produced " + wood.getProducedQuantity() + " kg. Together " + returnInscripionOre(wood.getSumQuantity()));
        //System.out.print("Percent production of wood: " + wood.getBurden() + "  ||  Burden production of wood: " + wood.getBurden() + "\n");
        System.out.print("Stone: produced " + wood.getProducedQuantity() + " kg. Together " + returnInscripionOre(wood.getSumQuantity()));
        //System.out.print("Percent production of stone: " + stone.getBurden() + "  ||  Burden production of stone: " + stone.getBurden() + "\n");

        System.out.print("sociaty:  " + "Population: " + sociaty.getQuantityWomen() + " women and " + sociaty.getQuantityMen() + " men");
        System.out.print(" || Satisfaction of sociaty: " + sociaty.getJoy() + "\n");
        System.out.print("OldTime of production: " + timeWood.getAbsolutiveTimeOfGame() + " sec\n");*/
    }
    public void exitOfGame(Player player, Wood wood, Stone stone, Sociaty sociaty, OldTime timeWood, OldTime timeStone) throws FileNotFoundException, InterruptedException {
        /*String consent; // przechowuje tak lub nie
        System.out.print("\n\n\n\n\tDo you want exit of game?\nIf you exit of program enter \"yes\" or if you not exit of program enter \"no\".\n\n");
        Scanner scanner = new Scanner(System.in);
        consent = scanner.nextLine();

        if (Objects.equals(consent, "yes") || Objects.equals(consent, "y")) {
            //instrukcje jesli chce wyjsc
            //zapisanie osiagniec
            savingSettingsOfPlayer(player);
            savingResultOfProductionWood(wood, stone, sociaty, timeWood, timeStone);
            savingResultOfProductionStone(wood, stone, sociaty, timeWood, timeStone);
            savingSettingsOfSociaty(sociaty);

            //wywolanie funkcji podsumuwjacej osiagniecia
            viewSummary(player, wood, stone, sociaty, timeWood, timeStone);
            Thread.sleep(5000); //uspienie na 5sek

            System.out.print("Exit.\n\n");

            System.out.print("\t\t  GOOD BAY!\n"); Thread.sleep(1000);
            System.out.print("\t\t  GOOD BAY!\n"); Thread.sleep(1000);
            communique.viewWelcome();
            System.out.print("\t\t  GOOD BAY!\n\n\n"); Thread.sleep(1000);

            communique.viewAuthor();
            Thread.sleep(10000);
            System.exit(9999);
        } else if (Objects.equals(consent, "no") || Objects.equals(consent, "n")) {
            //instrukcje jesli chcial wyjsc, ale zrezygonwal
            //komunikat: mozesz grac dalej.
            System.out.print("INFO: Przerwano proces 'exit()' na zadanie. Mozesz grac dalej.\n\n");
        } else {
            //instrukcje jak cos sie nie powiedzie
            System.out.print("INFO: Nie udalo sie zamknac programu. Spróbuj ponownie.\n\n");
        }*/
    }
}

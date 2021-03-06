package pl.tomasztopolewski.thekingland.authentication;

import pl.tomasztopolewski.thekingland.authentication.preparation.Installation;
import pl.tomasztopolewski.thekingland.communication.CommandPreparation;
import pl.tomasztopolewski.thekingland.communication.Communique;
import pl.tomasztopolewski.thekingland.communication.SystemConsoleOut;
import pl.tomasztopolewski.thekingland.security.Decryption;

import java.util.Scanner;

public class Authentication {
    private CommandPreparation commandPreparation;

    public int start() throws InterruptedException {
        commandPreparation = new CommandPreparation();
        System.out.println("\n" + Communique.nameGame + "_" + Communique.newVersion + ": Uruchamianie aplikacji...");
        SystemConsoleOut.log(Communique.nameGame + "_" + Communique.newVersion + ": Uruchamianie aplikacji...");

        if (Installation.installation()) {
            SystemConsoleOut.println(Communique.nameGame + "_" + Communique.newVersion + ": Stan instalacji aplikacji jest poprawny.\n");
            SystemConsoleOut.log(Communique.nameGame + "_" + Communique.newVersion + ": Stan instalacji aplikacji jest poprawny.");
            // instalacja gry jest poprawna

            Communique.viewHeaderWelcome();
            //przełącznie w zależności od polecenia pobranego od użytkownika
            switch (commandPreparation.process()) {
                case 0:
                    //gdy użytkownik wprowadzi nie poprawne polecenie
                    System.out.println("ERROR: Pobrane polecenie nie jest prawidlowe.\n");
                    System.exit(-1);
                    break;

                case 1:
                    //gdy użytkownik wprowadzi polecenie logowania
                    if (!commandPreparation.getArguments().equals("")) {
                        if (checkIsItInBasadatePlayers(commandPreparation.getArguments())) {
                            SystemConsoleOut.println("SYSTEM-INFO: Logowanie '" + commandPreparation.getArguments() + "'...");
                            SystemConsoleOut.println("INFO: Zalogowano pomyślnie '" + commandPreparation.getArguments() + "'.\n");
                        } else {
                            System.out.println("SYSTEM-WARN: Gracz '" + commandPreparation.getArguments() + "' nie istnieje w bazie danych.");
                            System.out.println("SYSTEM-WARN: Nie zalogowano poprawnie gracza '" + commandPreparation.getArguments() + "'. Spróbuj zalogować się za pomocą innego konta.");
                        }
                    } else {
                        SystemConsoleOut.println("SYSTEM-INFO: Logowanie...");
                        SystemConsoleOut.println("INFO: Zalogowano pomyślnie.\n");
                    }
                    return 1;

                case 2:
                    //gdy użytkownik wprowadzi polecenie rejestracji
                    System.out.println("SYSTEM-WARN: Polecenie rejestacji nie jest obsługiwane. Spróbuj się zalogować przez 'login'.");
                    System.exit(0);
                    break;

                case 999:
                    //gdy użytkownik wprowadzi polecenie wyjścia z gry
                    Communique.viewGoodbay();
                    System.exit(1);
                    break;

                case 1000:
                    // gdy użytkownik wprowadzi polecenie logowania administratora
                    SystemConsoleOut.println("SYSTEM-INFO: Logowanie administratora...");
                    Thread.sleep(1000);
                    SystemConsoleOut.println("INFO: Zalogowano konto administratora.");
                    //Thread.sleep(1000);
                    SystemConsoleOut.println("INFO: Uuprawnienie nie zostały sprawdzone oraz aktywowane.");
                    //Thread.sleep(1000);
                    SystemConsoleOut.println("WARN: Proszę potwierdzić uprawnienia w panelu administratora.");
                    //Thread.sleep(2000);
                    if (passAdmin()) {
                        return 1000;
                    } else {
                        SystemConsoleOut.println("SYSTEM-ERROR: Niepoprawne dane dostępowe. Aplikacja zostaje zatrzymana.\n");
                        Thread.sleep(2000);
                        Communique.viewGoodbay();
                        return 0;
                    }

                default:
                    //gdy użytkownik wprowadzi nie poprawne polecenie
                    SystemConsoleOut.println("WARN: Pobrane polecenie nie istnieje.");
                    SystemConsoleOut.logEnd("Ending app " + Communique.nameGame + "_" + Communique.numberOfVersion + "_" + Communique.typeOfVersion);
                    System.exit(0);
                    break;
            }
            commandPreparation.resetClass();
        } else {
            // instalacja gry jest niepoprawna
            System.out.println("\nSYSTEM-ERROR: Aplikacja została niepoprawnie zainstalowana.");
            System.out.println("SYSTEM-ERROR: Nie można załadować podstawowych plików aplikacji.");
            System.out.println("SYSTEM-INFO: Jeśli problem będzie się powtarzał, skontaktuj się z pomocą techniczną.");
            System.out.println("SYSTEM-WARN: Aplikacja zostaje zatrzymana.\n");
            Thread.sleep(2000);
            Communique.viewGoodbay();
            System.exit(-1);
        }
        return 0;
    }

    private boolean passAdmin() throws InterruptedException {
        /*
        SystemConsoleOut.print("SYSTEM-INFO: Wprowadź hasło administatora: ");
        SystemConsoleOut.log("SYSTEM-INFO: Wprowadź hasło administatora: *****");
        if (new Scanner(System.in).nextLine().trim().equals("$/" + new Decryption("0gs6z6f01lmzcm9dg3y6").decodeString())) {
            SystemConsoleOut.println("SYSTEM-INFO: Uprawienia administratora zostały pomyślenie autoryzowane.\n");
            return true;
        } else return false;
        */
        ///*

        SystemConsoleOut.println("\n* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        SystemConsoleOut.println("*  SYSTEM-ERROR: WYŁĄCZONO OPCJĘ AUTORYZOWANIA ADMINISTATORA.                                 *");
        //Thread.sleep(1000);
        SystemConsoleOut.println("*  SYSTEM-ERROR: LOGOWANIE ADMINISTATORA BEZ AUTORYZACJI.                                     *");
        SystemConsoleOut.println("*  SYSTEM-ERROR: TRYB ADMINISTATORA AKTYWOWANY W MODULE NIEAUTORYZOWANYM.                     *");
        SystemConsoleOut.println("*  SYSTEM-ERROR: UPRAWIENIA ADMINISTRATORA NIE ZOSTAŁY POMYŚLENIE AUTORYZOWANE.               *");
        //Thread.sleep(2000);
        SystemConsoleOut.println("*                                                                                             *");
        SystemConsoleOut.println("*  SYSTEM-WARN: Narzędzia administatora wymagają autoryzacji.                                 *");
        //Thread.sleep(1000);
        SystemConsoleOut.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
        return true;
        //*/
    }


    //zbiór funkcji sprawdzających
    public boolean checkIsItInBasadatePlayers(String username) {
        return username.toLowerCase().equals("player1");
    }
}

// Tomasz Topolewski

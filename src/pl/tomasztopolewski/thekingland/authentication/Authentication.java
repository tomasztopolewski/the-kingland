package pl.tomasztopolewski.thekingland.authentication;

import pl.tomasztopolewski.thekingland.authentication.preparation.Installation;
import pl.tomasztopolewski.thekingland.communication.CommandPreparation;
import pl.tomasztopolewski.thekingland.communication.Communique;
import pl.tomasztopolewski.thekingland.security.Decryption;

import java.util.Scanner;

public class Authentication {
    private CommandPreparation commandPreparation;

    public int start() throws InterruptedException {
        commandPreparation = new CommandPreparation();
        System.out.println("\nthekingland_" + Communique.newVersion + ": Uruchamianie aplikacji...");

        if (Installation.installation()) {
            System.out.println("thekingland_" + Communique.newVersion + ": Stan instalacji aplikacji jest poprawny.\n");
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
                            System.out.println("SYSTEM-INFO: Logowanie '" + commandPreparation.getArguments() + "'...");
                            System.out.println("INFO: Zalogowano pomyślnie '" + commandPreparation.getArguments() + "'.\n");
                        } else {
                            System.out.println("SYSTEM-WARN: Gracz '" + commandPreparation.getArguments() + "' nie istnieje w bazie danych.");
                            System.out.println("SYSTEM-WARN: Nie zalogowano poprawnie gracza '" + commandPreparation.getArguments() + "'. Spróbuj zalogować się za pomocą innego konta.");
                        }
                    } else {
                        System.out.println("SYSTEM-INFO: Logowanie...");
                        System.out.println("INFO: Zalogowano pomyślnie.\n");
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
                    System.out.println("SYSTEM-INFO: Logowanie administratora...");
                    System.out.println("INFO: Zalogowano konto administratora.");
                    System.out.println("INFO: Twoje uprawnienie nie zostały sprawdzone oraz aktywowane.");
                    System.out.println("WARN: Potwierdzić swoje uprawnienia, stosując komendę specjalną.");
                    if (passAdmin()) {
                        return 1000;
                    } else {
                        System.out.println("SYSTEM-ERROR: Niepoprawne dane dostępowe. Aplikacja zostaje zatrzymana.\n");
                        Thread.sleep(2000);
                        Communique.viewGoodbay();
                        return 0;
                    }

                default:
                    //gdy użytkownik wprowadzi nie poprawne polecenie
                    System.out.println("WARN: Pobrane polecenie nie istnieje.");
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

    private boolean passAdmin() {
        /*System.out.print("SYSTEM-INFO: Wprowadź hasło administatora: ");
        if (new Scanner(System.in).nextLine().trim().equals("$/" + new Decryption("0gs6z6f01lmzcm9dg3y6").decodeString())) {
            System.out.println("SYSTEM-INFO: Uprawienia administratora zostały pomyślenie autoryzowane.\n");
            return true;
        } else return false;*/
        System.out.println("\nSYSTEM-ERROR: WYŁĄCZONO OPCJĘ AUTORYZOWANIA ADMINISTATORA.");
        System.out.println("SYSTEM-ERROR: LOGOWANIE ADMINISTATORA BEZ AUTORYZACJI.");
        System.out.println("SYSTEM-ERROR: TRYB ADMINISTATORA AKTYWOWANY W MODULE NIEAUTORYZOWANYM.");
        System.out.println("SYSTEM-ERROR: UPRAWIENIA ADMINISTRATORA NIE ZOSTAŁY POMYŚLENIE AUTORYZOWANE.\n");
        System.out.println("SYSTEM-WARN: Narzędzia administatora wymagają autoryzacji. Tryb awaryjny został włączony.\n");
        return true;
    }


    //zbiór funkcji sprawdzających
    public boolean checkIsItInBasadatePlayers(String username) {
        return username.toLowerCase().equals("player1");
    }
}

// Tomasz Topolewski

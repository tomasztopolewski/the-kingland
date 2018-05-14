package pl.tomasztopolewski.thekingland.authentication;

import pl.tomasztopolewski.thekingland.communication.Command;
import pl.tomasztopolewski.thekingland.communication.Communique;

public class Authentication {
    private Command command = new Command();
    //public final Communique communique = new Communique();

    public int start() throws InterruptedException {
        boolean continuation = false; //okresla 'true' jesli pobieranie sie udalo
        System.out.println("thekingland_" + Communique.newVersion + ": Uruchamianie aplikacji...\n");
        Communique.viewHeaderWelcome();

        //int returnValue = command.process();
        //command.resetClass(); //czyszczenie klasy

        //przełącznie w zależności od polecenia pobranego od użytkownika
        //switch (returnValue) {
        switch (command.process()) {
            case 0:
            //gdy użytkownik wprowadzi nie poprawne polecenie
                System.out.println("ERROR: Pobrane polecenie nie jest prawidlowe.\n");
                System.exit(-1);
                break;

            case 123:
                System.out.println("SYSTEM-INFO: Logowanie administratora...");
                System.out.println("INFO: Zalogowano konto administatora.");
                System.out.println("INFO: Twoje uprawnienie nie zostały sprawdzone oraz aktywowane.");
                System.out.println("WARN: Potwierdzić swoje uprawnienia, stosując komendę specjalną.\n");
                return 1;
            case 1:
            //gdy użytkownik wprowadzi polecenie logowania
                if (!command.getArguments().equals("")) {
                    System.out.println("SYSTEM-INFO: Logowanie '" + command.getArguments() + "'...");
                    System.out.println("INFO: Zalogowano pomyślnie '" + command.getArguments() + "'.\n");
                } else {
                    System.out.println("SYSTEM-INFO: Logowanie...");
                    System.out.println("INFO: Zalogowano pomyślnie.\n");
                }
                return 1;

            case 2:
            //gdy użytkownik wprowadzi polecenie rejestracji
                System.out.println("");
                System.exit(0);
                break;

            case 999:
                //gdy użytkownik wprowadzi polecenie wyjścia z gry
                Communique.viewGoodbay();
                System.exit(1);
                break;

            default:
            //gdy użytkownik wprowadzi nie poprawne polecenie
                System.out.println("WARN: Pobrane polecenie nie istnieje.");
                System.exit(0);
                break;
        }
        command.resetClass();
        return 0;
    }


    //zbiór funkcji sprawdzających
    public boolean checkIsItInBasadatePlayers(String username) {
        return true;
    }
}

// Tomasz Topolewski

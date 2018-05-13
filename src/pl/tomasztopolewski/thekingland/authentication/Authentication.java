package pl.tomasztopolewski.thekingland.authentication;

import pl.tomasztopolewski.thekingland.communication.Command;
import pl.tomasztopolewski.thekingland.communication.Communique;

public class Authentication {
    private Command command = new Command();
    public final Communique communique = new Communique();

    public int start() {
        boolean continuation = false; //okresla 'true' jesli pobieranie sie udalo
        communique.viewWelcome();

        int returnValue = command.process();
        command.resetClass(); //czyszczenie klasy

        //przełącznie w zależności od polecenia pobranego od użytkownika
        switch (returnValue) {
            case 0:
            //gdy użytkownik wprowadzi nie poprawne polecenie
                System.out.print("Error 00x001: Pobrane polecenie nie jest prawidlowe.\n");
                System.exit(0);
                break;

            case 3:
            //gdy użytkownik wprowadzi polecenie wyjścia z gry
                System.out.print("\n\n\tDo widzenia!\n\n");
                System.exit(0);
                break;

            case 1:
            //gdy użytkownik wprowadzi polecenie logowania
                return 1;
            case 2:
            //gdy użytkownik wprowadzi polecenie rejestracji
                System.out.print("\n\tJeszcze chwilka. Pracujemy nad tym rozwiązaniem!\n");
                System.exit(0);
                break;

            default:
            //gdy użytkownik wprowadzi nie poprawne polecenie
                System.out.print("Error 00x001: Pobrane polecenie nie jest prawidlowe.\n");
                System.exit(0);
                break;
        }
        return 0;
    }


    //zbiór funkcji sprawdzających
    public boolean checkIsItInBasadatePlayers(String username) {
        return true;
    }
}

// Tomasz Topolewski

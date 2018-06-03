package pl.tomasztopolewski.thekingland;

import pl.tomasztopolewski.thekingland.authentication.Authentication;
import pl.tomasztopolewski.thekingland.communication.Communique;
import pl.tomasztopolewski.thekingland.communication.Console;

import java.io.FileNotFoundException;

public abstract class Main {
    public static void main(String[] args) throws InterruptedException, FileNotFoundException, NumberFormatException {
        Console console;
        switch(new Authentication().start()) {
            case 0:
                //nieprawidłowe polecenie
                break;

            case 1:
                Communique.viewWelcome();

                Communique.animationStartLoadingSettings();
                console = new Console();
                Communique.animationEndLoadingSettings();
                while (true) console.processOrder();

            case 1000:
                Communique.viewWelcome();
                console = new Console();
                //console = new ConsoleAdmin();
                System.out.println("SYSTEM-INFO: Settings and saves are loaded. Administators tools are activated.\n");
                while (true) console.processOrder();

            default:
                // nieprawidłowa instalacja --> dalsze działania
                break;
        }
    }
}
// Tomasz Topolewski
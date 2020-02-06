package pl.tomasztopolewski.thekingland;

import pl.tomasztopolewski.thekingland.authentication.Authentication;
import pl.tomasztopolewski.thekingland.communication.Communique;
import pl.tomasztopolewski.thekingland.communication.Console;
import pl.tomasztopolewski.thekingland.communication.SystemConsoleOut;

import java.io.FileNotFoundException;

public abstract class Main {
    public static void main(String[] args) throws InterruptedException, FileNotFoundException, NumberFormatException {
        SystemConsoleOut.logStart("Starting app " + Communique.nameGame + "_" + Communique.numberOfVersion + "_" + Communique.typeOfVersion);

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
                Thread.sleep(1000);
                SystemConsoleOut.println("SYSTEM-INFO: Settings and saves are loaded. Administators tools are activated.\n");
                Thread.sleep(1000);
                SystemConsoleOut.log("SYSTEM-INFO: Settings and saves are loaded. Administators tools are activated.");
                while (true) console.processOrder();

            default:
                // nieprawidłowa instalacja --> dalsze działania
                break;
        }
    }
}
// Tomasz Topolewski
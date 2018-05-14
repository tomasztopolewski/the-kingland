package pl.tomasztopolewski.thekingland;

import pl.tomasztopolewski.thekingland.authentication.Authentication;
import pl.tomasztopolewski.thekingland.communication.Communique;
import pl.tomasztopolewski.thekingland.communication.Console;

import java.io.FileNotFoundException;

public abstract class Main {
    public static void main(String[] args) throws InterruptedException, FileNotFoundException, NumberFormatException {
        //Communique communique = new Communique();
        //Communique.viewWelcome();

        Authentication authentication = new Authentication();
        if (authentication.start() == 1) {
            Communique.viewWelcome();

            Communique.animationStartLoadingSettings();
            Console console = new Console();
            Communique.animationEndLoadingSettings();

            while (true) {
                console.removeOrder();
                console.createOrder();
                console.doOrder();
            }

        } else {
            // nieprawidłówa instalacja --> dalsze działania
        }
    }
}
// Tomasz Topolewski
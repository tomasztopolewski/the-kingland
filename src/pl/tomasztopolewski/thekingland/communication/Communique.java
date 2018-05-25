/**
 * Klasa 'Communique' odpowiedzialna jest za generowanie podstawowych informacji o grze.
 *
 * System zapisywania wersji:
 *     - branchowy: zapisywana jest wersja główna programu np. (v45.75.820) oznaczająca
 *                  poszczególne zmiany w grze i wprowadzone rozwiązania, usprawnienia,
 *                  poprawki kodu etc. Następnie po myślniku dawana jest gałąź rozwoju
 *                  aplikacji.
 *                  Główna to 'branch' (dla GIT jest to master). W użyciu nie
 *                  funkcjonuje inna poza główną. W domyśle projektowania powstała
 *                  gałąź główna 'main' [dawniej: branch] - w celu rozwoju głównego
 *                  aplikacji - oraz testowa gałąź 'tested' służąca rozwoju testowych
 *                  rozwiązań w aplkiacji oraz możliwych kolokacji łączeniowych
 *                  (np. z interfejsem). Ostatnią gąłęzią jest 'undermain' służąca
 *                  rozwoju odmiennej wizji aplikacji.
 *                  Po nazwie gałęzi rozwoju aplikacji, w nawiasach, dodawana jest
 *                  skrócona data (miesiąc i rok) rozpoczęcia prac nad główną wersją
 *                  aplikacji. Po osiągnięciu wersji następujące zmiana celu i zmiana
 *                  daty rozpoczęcia. Na koniec dodawany jest opisowy kształt aplikacji.
 *                  Opisy rozwoju aplikacji:
 *                      - preDEV: przygotowanie podstawowych mechanizów aplikacji,
 *                                niezbędnych klas
 *                      - DEV_alpha: rozwijanie aplikacji do wersji DEV, tworzenie
 *                                   mechaniki gry, elementów podstawowych w grze,
 *                                   rozwój aplikacji i funkcji konsolowej
 *                      - DEV_beta: wersja aplikacji, w której użytkownik będzie mógł
 *                                  zagrać w pierwszą rozgrywkę i poznać doznać
 *                                  mechaniki gry
 *                      - DEV: poprawna wersja aplikacji, poprawianie i usprawnianie
 *                             poszczególnych elementów, mechaniki gry
 *                      - BETA: rozwojowa wersja aplikacji, wprowadzająca funkcjonalności
 *                              w prognozowanym kształcie, usprawnianie aplikacji i gry
 *                      - releaseBETA: wersja testowa aplikacji pozwalająca korzystać
 *                                     z aplikacji z mniejszymi lub większymi błędami
 *                      - RTM: stabilna wersja aplikacji z drobymi błędami
 *
 *     - nowy: zapisywana jest numer wersji oraz opis rozwoju aplikacji
 *
 */
package pl.tomasztopolewski.thekingland.communication;

public abstract class Communique {
    public static final String nameGame = "The KingLand";
    public static final String author = "Tomasz Topolewski";

    public static final String numberOfVersion = "v60.01.100";

    public static final String typeOfVersion = "DEV_alpha";
    public static final String version = numberOfVersion + "-main(May 2018) " + typeOfVersion;
    public static final String versionOfTested = numberOfVersion + "-tested(May 2018) " + typeOfVersion;
    public static final String newVersion = numberOfVersion + " " + typeOfVersion;

    public static final String longStartDateWork = "October 11th 2015";
    public static final String medianStartDateWork = "October 2015";
    public static final String shortStartDateWork = "Oct 2015";
    public static final String longDate = "May 18th 2018";
    public static final String medianDate = "May 2018";
    public static final String shortDate = "May 2018";


    public String getNameGame() {
        return nameGame;
    }
    public String getAuthor() {
        return author;
    }
    public String getVersion() {
        return version;
    }
    public String getStartDateWork() {
        return longStartDateWork;
    }
    public String getShortStartDateWork() {
        return shortStartDateWork;
    }
    public String getShortDate() {
        return shortDate;
    }


    public static void viewWelcome() {
        System.out.print("\t" + nameGame + " " + version + "\n");
        System.out.print("\t\t\t" + medianStartDateWork + " - " + medianDate + "\n\n");
    }

    public static void viewHeaderWelcome() {
        System.out.println("\t" + nameGame + " " + newVersion + " by " + author);
    }
    public static void viewSpecialWelcome() {
        System.out.println("****************************************************************");
        System.out.println("*    The KingLand v45.75.820 DEV_alpha by Tomasz Topolewski    *");
        System.out.println("****************************************************************");
    }

    public void viewNameGame() {
        System.out.print("Name game: " + nameGame);
    }
    public static void viewAuthor() {
        System.out.print("Author of game: " + author + "\n");
    }
    public static void viewVersion() {
        System.out.print("Version of game: " + newVersion + "\n");
    }

    public void animationWait(int sec) throws InterruptedException {
        System.out.print("\n\tWaiting");
        Thread.sleep(1000);
        for (int i = 1; i <= sec; i++) {
            System.out.print(".");
            Thread.sleep(2000);
        }
        System.out.print("\n");
    }

    public static void animationStartLoadingSettings() throws InterruptedException {
        Thread.sleep(500);
        System.out.print("Loading settings ");
        Thread.sleep(200);
        System.out.print("0% ");
        for (int k = 0; k < 3; k++) {
            Thread.sleep(500);
            System.out.print(".");
        }
        System.out.println("");
    }
    public static void animationEndLoadingSettings() throws InterruptedException {
        Thread.sleep(1500);
        System.out.print("Loading settings 100%\n\n");
        //Thread.sleep(500);
    }

    public static void viewGoodbay() throws InterruptedException {
        System.out.println("Good bay!\n");
        System.out.println("\nCreated by " + author + "\n\n");
        Thread.sleep(2000);
        System.out.print(newVersion + " / " + version);
        System.exit(1);
    }
}

// Tomasz Topolewski

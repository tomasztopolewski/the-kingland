package pl.tomasztopolewski.thekingland.handlingdata;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ClassLoadDatabase {
    private final String name = "players";
    private final String enlargement = ".kingdatabase";
    private String url;

    private String[] downloadedLines;
    private final int maxNumberOfLines = 51;
    private final int maxNumberOfArguments = 50;

    private final String separator = ":";
    private final String endLine = ";";

    private int numberOfLines;
    private int numberOfArguments;
    private boolean loaded;

    //konstruktor dla bazy danych
    public ClassLoadDatabase(String url) {
        if (url.length() > 5 && url.endsWith("\\")) this.url = url;
        this.downloadedLines = new String[this.maxNumberOfLines];
        this.loaded = false;
    }
    //konstruktor zerujący (nulluje i zeruje wszystkie wartości)
    public ClassLoadDatabase() {
        this.url = null;
        this.downloadedLines = null;
        this.loaded = false;
    }


//////////////////////////////////////////////////////////////////////////


    public void load() throws FileNotFoundException, NoSuchElementException {
        try {
            //wyswietlanie linku do bazy danych
            //System.out.print("URL: " + urlDatabase + nameDatabase + enlargementFileDatabase + "\n");

            File fileDownload = new File(url + name + enlargement);
            Scanner reader = new Scanner(fileDownload);

            int i = -1;
            try {
                do {
                    i++;
                    downloadedLines[i] = reader.nextLine();
                } while (!(downloadedLines[i] == ""));
                setValueBooleanLoadedDatabase(1);
            } catch (NoSuchElementException nsee) {
                setValueBooleanLoadedDatabase(0);
            } finally {
                numberOfLines = i--;
            }
        } catch (FileNotFoundException fnfe) {
            setValueBooleanLoadedDatabase(0);
            System.out.print("Error 11x000: Baza danych \"" + name +"\" nie istnieje. Sproboj zaladowac ponownie gre. Jesli blad sie poworzy zresetuje ustawienia.\n");
            for (int i = 0; i <= 99; i++)downloadedLines[i] = "null";
        } finally {}
    }

    private void setValueBooleanLoadedDatabase(int x) {
        if (x == 1) loaded = true; else loaded = false;
    }

    public boolean returnBooleanLoadedDatabase() {
        return this.loaded;
    }

    public void printLines() {
        int numberOfLine = 1;
        for (int i = 0; i <= numberOfLines; i++) {
            System.out.print("Line " + numberOfLine + ": " +downloadedLines[i--] + "\n"); i++; numberOfLine++;
        }
        System.out.print("Number ofdownloadedLines: " + numberOfLines + "\n\n");
    }


    public String[] sendDatabase() {
        return downloadedLines;
    }

    protected int getLengthOfLines() {
        return this.numberOfLines;
    }

    private void decodedLinesPlayers() {
        //tworzymy plętle która wykona sie tyle razy ile mamy linii w bazie - zmienna 'numberOfLines'
        //petla ktora bedzie wykonywala sie dwa razy; raz dla każdego argumentu zwracanego przez 'returnLineOfArguments'
        //inicjalizujemy obiekt 'decryption' przez konstruktor uzupełniony jednym z elementów jednej linii bazy danych
        //zwracamy napis rozszyfrowany
        //zapisujemy go do tablicy pod tym samym indeksem
        //resetujemy obiekt 'decryption' i inne wspomagające zmienne
        //przestawiamy inne zmienne o następną iterację

    }

}

// Tomasz Topolewski

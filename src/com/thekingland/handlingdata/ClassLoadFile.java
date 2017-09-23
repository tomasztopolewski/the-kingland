/*
Klasa ClassLoadFile ma jedno podstawowe zadanie: załadować plik i zwrócić go w postaci linii uporządkowanych w tablicy String.
Powinna być tworzona jednorazowo dla każdego z plików.

TO DO:
1. Sprawdzenie poprawności pliku np. z znakiem kończącym linię
2. Czyszczenie klasy do ponownego załadowania pliku.
 */
package com.thekingland.handlingdata;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ClassLoadFile {
    private String name;
    private final String enlargement = ".kingfile";
    private String url;

    private String[] loadedLines;
    private final int maxNumberOfLines = 100;

    private int numberOfLines;
    private String[] downloadedLines;

    private boolean loaded;


    //konstruktor tworzący klasę
    public ClassLoadFile(String name, String url) throws FileNotFoundException {
        this.name = name;
        this.url = url;
        this.loadedLines = new String[100];
        this.numberOfLines = 0;
        this.loaded = false;

        loadFile();
        downloadedLines = new String[numberOfLines];
        downloadedLines = cutEmptyLines();
    }

    //konstktor resetujący klasę
    public ClassLoadFile() {
        this.name = null;
        this.url = null;
        this.loadedLines = null;
        this.numberOfLines = -1;
        this.loaded = false;
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////

    public String getPathUrl() {
        return url + "\\" + name + enlargement;
    }
    public String getName() {
        return name;
    }
    public String getEnlargement() {
        return enlargement;
    }
    public String getUrl() {
        return url;
    }

    public String[] getLoadedLines() {
        return loadedLines;
    }
    public int getMaxNumberOfLines() {
        return maxNumberOfLines;
    }

    public int getNumberOfLines() {
        return numberOfLines;
    }

    public boolean isLoaded() {
        return loaded;
    }

    public String[] getDownloadedLines() {
        return downloadedLines;
    }

    public void loadFile() throws FileNotFoundException, NoSuchElementException {
        try {
           // System.out.print("URL: " + url + "\\" + name + enlargement + "\n");

            File fileDownload = new File(url + "\\" + name + enlargement);
            Scanner reader = new Scanner(fileDownload);

            int i = -1;
            try {
                do {
                    i++;
                    loadedLines[i] = reader.nextLine();
                } while (loadedLines[i] != ""); //wykonuj dopóki pobrana linia jest pełna, gdy jest pusta (== "") przerwij i złap wyjątek
                loaded = true;
            } catch (NoSuchElementException nsee) {
                loaded = false;
            }
            numberOfLines = i--;

        } catch (FileNotFoundException fnfe) {
            loaded = false;
            System.out.print("Error-ClassLoadFile::loadFile: Plik \"" + name + "\" nie istnieje w takiej sciezce dostepu: \"" + url + "\\" + name + enlargement + "\"\n");
            for (int i = 0; i <= 99; i++) loadedLines = null;
        }
    }

    private String[] cutEmptyLines() {
        String[] lines = new String[numberOfLines];
        for (int i = 0; i < numberOfLines; i++) lines[i] = loadedLines[i];

        return lines;
    }

    public void viewDownloadedLoadedLines() {
        int numberOfLine = 1;
        for (int i = 0; i < numberOfLines; i++) {
            System.out.print("Line " + numberOfLine + ": " + loadedLines[i--] + "\n");
            i++;
            numberOfLine++;
        }
        System.out.print("Number of lines(downloadedLoadedLines): " + numberOfLines + "\n\n");


    }

}


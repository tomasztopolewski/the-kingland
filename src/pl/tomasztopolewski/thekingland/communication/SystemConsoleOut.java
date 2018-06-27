/**
 * nonStaitcPrint(String string): metoda wyświetla w strumieniu System.out 'string' przy pomocy
 *                       System.out.nonStaitcPrint()
 * nonStaitcPrintLog(String string): metoda wyświetla w strumieniu System.out 'string' przy pomocy
 *                          System.out.nonStaitcPrint() oraz zapisuje 'string' do logów
 * printl(String string): metoda wyświetla w strumieniu System.out 'string' przy pomocy
 *                        System.out.printl()
 * printlLog(String string): metoda wyświetla w strumieniu System.out 'string' przy pomocy
 *                           System.out.printl() oraz zapisuje 'string' do logów
 */
package pl.tomasztopolewski.thekingland.communication;

import pl.tomasztopolewski.thekingland.Logs;

import java.io.IOException;

public abstract class SystemConsoleOut {

    public void nonStaitcPrint(String string) {
        System.out.print(string);
    }
    public static void print(String string) {
        System.out.print(string);
    }
    public void nonStaitcPrintLog(String string) {
        nonStaitcPrint(string);

        try {
            new Logs().appendWithReason(string);
        } catch (IOException e) {
            System.out.println("\nSYSTEM-ERROR: Zapis logu nie został przeprowadzony poprawnie. Bufor zapisu mógł zostać uszkodzony lub bufor zapisu nie mógł zapisać zmian w pliku.\n");
            e.printStackTrace();
        }
    }
    public static void printLog(String string) {
        print(string);

        try {
            new Logs().appendWithReason(string);
        } catch (IOException e) {
            System.out.println("\nSYSTEM-ERROR: Zapis logu nie został przeprowadzony poprawnie. Bufor zapisu mógł zostać uszkodzony lub bufor zapisu nie mógł zapisać zmian w pliku.\n");
            e.printStackTrace();
        }
    }

    public void nonStaitcPrintln(String string) {
        System.out.println(string);
    }
    public static void println(String string) {
        System.out.println(string);
    }
    public void nonStaitcPrintlnLog(String string) {
        nonStaitcPrintln(string);

        try {
            new Logs().appendWithReason(string);
        } catch (IOException e) {
            System.out.println("\nSYSTEM-ERROR: Zapis logu nie został przeprowadzony poprawnie. Bufor zapisu mógł zostać uszkodzony lub bufor zapisu nie mógł zapisać zmian w pliku.\n");
            e.printStackTrace();
        }
    }
    public static void printlnLog(String string) {
        println(string);

        try {
            new Logs().appendWithReason(string);
        } catch (IOException e) {
            System.out.println("\nSYSTEM-ERROR: Zapis logu nie został przeprowadzony poprawnie. Bufor zapisu mógł zostać uszkodzony lub bufor zapisu nie mógł zapisać zmian w pliku.\n");
            e.printStackTrace();
        }
    }


    public void nonStaitcLogStart(String string) {
        try {
            new Logs().appendWithReason(string);
        } catch (IOException e) {
            System.out.println("\nSYSTEM-ERROR: Zapis logu nie został przeprowadzony poprawnie. Bufor zapisu mógł zostać uszkodzony lub bufor zapisu nie mógł zapisać zmian w pliku.\n");
            e.printStackTrace();
        }
    }
    public static void logStart(String string) {
        try {
            new Logs().appendStart(string);
        } catch (IOException e) {
            System.out.println("\nSYSTEM-ERROR: Zapis logu nie został przeprowadzony poprawnie. Bufor zapisu mógł zostać uszkodzony lub bufor zapisu nie mógł zapisać zmian w pliku.\n");
            e.printStackTrace();
        }
    }

    public void nonStaitcLog(String string) {
        try {
            new Logs().appendWithReason(string);
        } catch (IOException e) {
            System.out.println("\nSYSTEM-ERROR: Zapis logu nie został przeprowadzony poprawnie. Bufor zapisu mógł zostać uszkodzony lub bufor zapisu nie mógł zapisać zmian w pliku.\n");
            e.printStackTrace();
        }
    }
    public static void log(String string) {
        try {
            new Logs().appendWithReason(string);
        } catch (IOException e) {
            System.out.println("\nSYSTEM-ERROR: Zapis logu nie został przeprowadzony poprawnie. Bufor zapisu mógł zostać uszkodzony lub bufor zapisu nie mógł zapisać zmian w pliku.\n");
            e.printStackTrace();
        }
    }

    public void nonStaitcLogEnd(String string) {
        try {
            new Logs().appendWithReason(string);
        } catch (IOException e) {
            System.out.println("\nSYSTEM-ERROR: Zapis logu nie został przeprowadzony poprawnie. Bufor zapisu mógł zostać uszkodzony lub bufor zapisu nie mógł zapisać zmian w pliku.\n");
            e.printStackTrace();
        }
    }
    public static void logEnd(String string) {
        try {
            new Logs().appendEnd(string);
        } catch (IOException e) {
            System.out.println("\nSYSTEM-ERROR: Zapis logu nie został przeprowadzony poprawnie. Bufor zapisu mógł zostać uszkodzony lub bufor zapisu nie mógł zapisać zmian w pliku.\n");
            e.printStackTrace();
        }
    }
}

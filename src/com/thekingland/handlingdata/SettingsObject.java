/*
Klasa ma zadanie zwrócić wartości argumentów linii w postaci uporządkowanej tablicy. Lacznie z
 */
package com.thekingland.handlingdata;

import java.util.regex.Pattern;

public class  SettingsObject {
    private String codeGroupObject; //kod grupy obiektów
    private String codeObject; //kod obiektu

    private String line; //pobrana linia
    private int numberOfDownloadedLine; //numer pobranej linii

    private final int minimumNumberOfArguments = 1; //mimalna liczba argumentów w linii
    private final int maximumNumberOfArguments = 10; //maksymalna liczba argumentów w linii
    private int numberOfArguments; //liczba argumentów w linii

    private String[] arguments; //tablica z podzielonymi argumentami

    private final int minimumNumberOfValuesInArgument = 1; //minimalna liczba wartości w jednym argumencie
    private final int maximumNumberOfValuesInArgument = 10; //maksymalna liczba wartości w jednym argumencie
    private int numberOfValuesInArgument; //liczba wartości w jednym argumencie

    private int numberOfAnythingValues;
    private String[] values; //wartości z argumentów

    //konstruktor ten przygotowuje obiekt do utworzenia tablicy z wartościami z linii
    //public SettingsObject(String line, int numberOfDownloadedLine, String codeGroupObject, String codeObject, int numberOfArguments, int numberOfValuesInArgument) {
    public SettingsObject(String line, String codeGroupObject, String codeObject, int numberOfArguments, int numberOfValuesInArgument) {
        setCodeGroupObject(codeGroupObject);
        setCodeObject(codeObject);

        setNumberOfArguments(numberOfArguments);
        setNumberOfValuesInArgument(numberOfValuesInArgument);

        setNumberOfAnythingValues(getNumberOfArguments(), getNumberOfValuesInArgument());
        this.values = new String[getNumberOfAnythingValues()];

        setLine(line);
       //setNumberOfDownloadedLine(numberOfDownloadedLine);
    }

    //konstruktor tego typu przygotowuje obiekt do stworzenia linii kodu, aby przekazać ją do zapisu
    public SettingsObject(String codeGroupObject, String codeObject, int numberOfArguments, int numberOfValuesInArgument, String[] values) {
        setCodeGroupObject(codeGroupObject);
        setCodeObject(codeObject);

        setNumberOfArguments(numberOfArguments);
        setNumberOfValuesInArgument(numberOfValuesInArgument);

        setNumberOfAnythingValues(getNumberOfArguments(), getNumberOfValuesInArgument());
        this.values = new String[getNumberOfAnythingValues()];
        setValues(values);
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void setCodeGroupObject(String codeGroupObject) {
        this.codeGroupObject = codeGroupObject;
    }
    public String getCodeGroupObject() {
        return codeGroupObject;
    }

    private void setCodeObject(String codeObject) {
        this.codeObject = codeObject;
    }
    public String getCodeObject() {
        return codeObject;
    }

    private void setLine(String line) {
        //System.out.print("if (checkCodeGroupObject(line) && checkCodeObject(line)): " + (checkCodeGroupObject(line) && checkCodeObject(line)) + "\n");
        if (checkCodeGroupObject(line) && checkCodeObject(line)) this.line = line;
        //this.line = checkCodeGroupObject(line) && checkCodeObject(line) ? line : null;
    }
    public String getLine() {
        return line;
    }
    private void setNumberOfDownloadedLine(int numberOfDownloadedLine) {
        this.numberOfDownloadedLine = numberOfDownloadedLine > 0 ? numberOfDownloadedLine : 0;
    }
    public int getNumberOfDownloadedLine() {
        return numberOfDownloadedLine;
    }

    public int getMinimumNumberOfArguments() {
        return minimumNumberOfArguments;
    }
    public int getMaximumNumberOfArguments() {
        return maximumNumberOfArguments;
    }
    private void setNumberOfArguments(int numberOfArguments) {
        this.numberOfArguments = numberOfArguments >= minimumNumberOfArguments && numberOfArguments <= maximumNumberOfArguments ? numberOfArguments : 0;
    }
    public int getNumberOfArguments() {
        return numberOfArguments;
    }

    //brak jakiegokolwiek zabezpieczenia prawidłowośc zapisu argumentów
    private void setArguments(String[] arguments) {
        try {
            if (arguments.length == getNumberOfArguments()) {
                int condition = 0;
                for (int i = 0; i < numberOfArguments; i++) {
                    condition = condition + (checkSyntaxArgument(arguments[i]) ? 1 : 0);
                }
                this.arguments = condition == numberOfArguments ? arguments : null;
            }
        } catch (NullPointerException npe) {
            this.arguments = null;
            System.out.print("Error-setArguments: Nie mozna zainicjalozowac zmiennej 'arguments', poniewaz argument z zmiennej do przepisania jest pusty.\n");
        }
    }
    public String[] getArguments() {
        return arguments;
    }

    public int getMinimumNumberOfValuesInArgument() {
        return minimumNumberOfValuesInArgument;
    }
    public int getMaximumNumberOfValuesInArgument() {
        return maximumNumberOfValuesInArgument;
    }
    private void setNumberOfValuesInArgument(int numberOfValuesInArgument) {
        this.numberOfValuesInArgument = numberOfValuesInArgument >= minimumNumberOfValuesInArgument && numberOfValuesInArgument <= maximumNumberOfValuesInArgument ? numberOfValuesInArgument : 0;
    }
    public int getNumberOfValuesInArgument() {
        return numberOfValuesInArgument;
    }

    private void setNumberOfAnythingValues(int numberOfArguments, int numberOfValuesInArgument) {
        this.numberOfAnythingValues = numberOfArguments * numberOfValuesInArgument;
    }
    public int getNumberOfAnythingValues() {
        return numberOfAnythingValues;
    }

    //brak jakiegokolwiek zabezpieczenia prawidłowośc zapisu wartości
    private void setValues(String[] values) {
        if (values.length == numberOfAnythingValues) this.values = values;
    }
    public String[] getValues() {
        return values;
    }
    public String getValue(int indexValue) {
        try {
            return values[indexValue];
        } catch (NullPointerException npe) {
            System.out.print("Error-(SettingsObject.getValue()): Wartosc nr " + indexValue + " nie istnieje w tablicy 'values'.\n");
        } finally {}
        return null;
    }
    public String getFirstValue() {
        return values[0];
    }
    public String getSecond() {
        return values[1];
    }
    private void addValues(String[] values, int beginSavingIndex) {
        //values.length == numberOfValuesInArgument
        beginSavingIndex *= numberOfValuesInArgument;
        for (int i = 0; i < numberOfValuesInArgument; i++) addValue(values[i], beginSavingIndex + i);
    }
    private void addValue(String value, int beginSavingIndex) {
        //System.out.print("addValue: Numer indeksu poczatkowego: " + beginSavingIndex + "\n");
        this.values[beginSavingIndex] = value;
    }
    public int convertValue(String value) {
        //System.out.print("convertValue: "  + value + "\n");
        return Integer.parseInt(value);
    }


    public void prepareTabOfValues(){
        //inicjalizacja tablicy "arguments" wyciętymi argumentami z linii
        setArguments(cutArgumentsFromLine(line));
        //viewArguments("prepareTabOfValues");

        //tworzenie tablicy z wartościami z argumentów
        try {
            for (int i = 0; i < numberOfArguments; i++) addValues(getValuesFromArgument(arguments[i]), i);
        } catch (NullPointerException npe) {
            System.out.print("Error-prepareTabOfValues: Zmienna 'arguments' nie jest zainicjalizowana lub zostala blednie zformatowana.\n");
        }
       // viewValues("prepareTabOfValues");
    }


    private String[] getValuesFromArgument(String argument) {
        return argument != "" || argument != null ? argument.split(Pattern.quote(":")) : null;
    }

    private String[] cutArgumentsFromLine(String line) {
        String lineOfArgument = null;
        try {
           //wycinanie argumentów z linii
           //System.out.print("cutArgumentsFromLine:// Line: " + line + "\n");
           String[] x = line.split(Pattern.quote("["));
           String y = x[1];
           x = y.split(Pattern.quote("]"));
           lineOfArgument = x[0];
       } catch (NullPointerException npe) {
           System.out.print("Error-cutArgumentsFromLine: Linia z argumentami jest pusta. Nie mozna bylo przeprowadzic operacji.\n");
       } finally {}

        //System.out.print("cutArgumentsFromLine :// Linia argumentów: " + lineOfArgument + "\n");
        //zwraca tablice z argumentami argumentami z linii
        return lineOfArgument != null ? lineOfArgument.split(Pattern.quote(";")) : null;
    }

    private String cutCodeGroupObject(String line) {
        //System.out.print("cutcodeGroupObject:// Line: " + line + "\n");
        if (!(line == null)) {
            String[] x = line.split(Pattern.quote("."));
            return x[0];
        } else return null;
    }
    private String cutCodeObject(String line) {
        if (!(line == null)) {
            String x[] = line.split(Pattern.quote("."));
            String y = x[1];

            x = y.split(Pattern.quote("["));
            return x[0];
        } else return null;
    }

///////////////////////////////////////////////////////////////////////
// metody sprawdzające

    private boolean checkSyntaxArgument(String argument) {
        String[] valuesFromArgument = argument.split(Pattern.quote(":"));

        return valuesFromArgument.length == this.numberOfValuesInArgument;
    }

    private boolean checkCodeGroupObject(String line) {
        String codeGroupObjectFromLine = cutCodeGroupObject(line);
        //System.out.print("codeGroupObjectFromLine: " + codeGroupObjectFromLine + " " + codeGroupObjectFromLine.equals(codeGroupObject) + "\n");
        return codeGroupObjectFromLine.equals(codeGroupObject);
    }
    private boolean checkCodeObject(String line) {
        String codeObjectFromLine = cutCodeObject(line);
        //System.out.print("codeObjectFromLine: " + codeObjectFromLine + " " + codeObjectFromLine.equals(codeObject) + "\n");
        return codeObjectFromLine.equals(codeObject);
    }
    private boolean checkSyntaxOfLineOfArguments(String line) {
        return false;
    }

///////////////////////////////////////////////////////////////////////
// metody sprawdzające zmiany w obiekcie; bardziej z punktu programistyczne

    public void viewArguments(String nameOfMethod) {
        System.out.print("\nviewArguments in '" + nameOfMethod + "':// Wyswietlanie argumentow z linii: ");
        int i = 1;
        try {
            for (String x : this.arguments) {
                System.out.print("Argument " + i + ": \"" + x + "\" "); i++;
            }
            System.out.print("\n");
        } catch (NullPointerException npe) {
            System.out.print("\nERROR: (viewArguments :: " + nameOfMethod + "): Tablica \"arguments\" jest pusta.");
        } finally {}
    }
    public void viewArguments() {
        System.out.print("\nviewArguments :// Wyswietlanie argumentow z linii: ");
        int i = 1;
        try {
            for (String x : this.arguments) {
                System.out.print("Argument " + i + ": \"" + x + "\" ");
                i++;
            }
            System.out.print("\n");
        } catch (NullPointerException npe) {
            System.out.print("\nError (viewArguments): Tablica \"arguments\" jest pusta.");
        } finally {}
    }

    public void viewValues(String nameOfMethod) {
        System.out.print("\nviewValues :// Wyświetlanie wartości z tablicy("+ this.codeGroupObject + "." + this.codeObject +") ");
        int i = 1;
        try {
            for (String x : this.values) {
                System.out.print("Wartość " + i + ": \"" + x + "\" ");
                i++;
            }
            System.out.print("\n");
        } catch (NullPointerException npe) {
            System.out.print("\nError (viewValues :: " + nameOfMethod + "): Tablica \"values\" jest pusta.");
        } finally {}
    }
    public void viewValues() {
        System.out.print("\nviewValues :// Wyświetlanie wartości z tablicy("+ this.codeGroupObject + "." + this.codeObject +") ");
        int i = 1;
        try {
            for (String x : this.values) {
                System.out.print("Wartość " + i + ": \"" + x + "\" ");
                i++;
            }
            System.out.print("\n");
        } catch (NullPointerException npe) {
            System.out.print("\nError (viewValues): Tablica \"values\" jest pusta.");
        } finally {}
    }

}

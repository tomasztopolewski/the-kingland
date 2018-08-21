/**
 *    new Logs().appendStart("starting " + NAME + " v" + VERSION + TYPE_VERSION + " from Main");
 *    new Logs().appendReason();
 *    new Logs().appendEnd("end of testing.");
 */
package pl.tomasztopolewski.thekingland;

import pl.tomasztopolewski.thekingland.authentication.preparation.Installation;
import pl.tomasztopolewski.thekingland.communication.SystemConsoleOut;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Logs {
    public final static String pathToTheFolder = Installation.pathToFolder;
    public final static String nameFile = "logs.logs";

    public int numerator;

    Writer logsput;

    private SimpleDateFormat dateFormating = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    /*public Logs() throws IOException {
        String line, lastLine = "";

        BufferedReader reader = new BufferedReader(new FileReader(pathToTheFolder + nameFile));
        while ((line = reader.readLine()) != null) lastLine = line;

        if (lastLine != "" && lastLine != null) {
            String[] s = lastLine.split(Pattern.quote(")"));

            if (s.length > 0) {
                try {
                    this.numerator = Integer.parseInt(s[0]);
                } catch (NumberFormatException nfe) {
                    this.numerator = 0;
                }
            } else this.numerator = 0;
        } else {
            this.numerator = 0;
        }
    }*/
    public Logs() throws IOException {
        String[] lines = new String[10];
        String line, lastLine = "";

        BufferedReader reader = new BufferedReader(new FileReader(pathToTheFolder + nameFile));

        int numberOfLines = 0;
        while (reader.readLine() != null) numberOfLines++;

        SystemConsoleOut.println("number of lines: " + numberOfLines);

        int i = 0, j = 0;
        while (i < numberOfLines) {
            line = reader.readLine();
            i++;
            if (j < 10) {
                lines[j] = line;
                j++;
            }
            if (j == 10 && i < (numberOfLines-11)) {
                lines = new String[10];
                j = 0;
            }
        }

        for (i = 0; i < lines.length; i++) SystemConsoleOut.println("LINES-" + i + ": \"" + lines[i] + "\"");

        if (lastLine != "" && lastLine != null) {
            String[] s = lastLine.split(Pattern.quote(")"));

            if (s.length > 0) {
                try {
                    this.numerator = Integer.parseInt(s[0]);
                } catch (NumberFormatException nfe) {
                    this.numerator = 0;
                }
            } else this.numerator = 0;
        } else {
            this.numerator = 0;
        }
    }

    private int getIteratorFromLines() {
        return 0;
    }


    public void appendStart(String s) throws IOException {
        logsput = new BufferedWriter(new FileWriter(pathToTheFolder + nameFile, true));
        logsput.append("\n" + ++numerator + ") [" + dateFormating.format(new Date()) + "] " + s + "\n");
        logsput.close();
    }

    /*public void appendReason() throws IOException {
        logsput = new BufferedWriter(new FileWriter(pathToTheFolder + nameFile, true));

        Scanner scanner = new Scanner(System.in);
        System.out.println("[System-Console-Out] Reason of starting app: ");
        String s = scanner.nextLine();

        logsput.append("\n" + ++numerator + ") [" + dateFormating.format(new Date()) + "] " + s);
        logsput.close();
    }*/

    public void appendWithReason(String s) throws IOException {
        logsput = new BufferedWriter(new FileWriter(pathToTheFolder + nameFile, true));
        logsput.append(++numerator + ") [" + dateFormating.format(new Date()) + "] " + s + "\n");
        logsput.close();
    }

    public void appendEnd(String s) throws IOException {
        logsput = new BufferedWriter(new FileWriter(pathToTheFolder + nameFile, true));
        logsput.append(++numerator + ") [" + dateFormating.format(new Date()) + "] " + s + "\n");
        logsput.close();
    }
}
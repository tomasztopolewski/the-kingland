/**
 *    new Logs().appendStart("starting " + NAME + " v" + VERSION + TYPE_VERSION + " from Main");
 *    new Logs().appendReason();
 *    new Logs().appendEnd("end of testing.");
 */
package pl.tomasztopolewski.thekingland;

import pl.tomasztopolewski.thekingland.authentication.preparation.Installation;

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

    public Logs() throws IOException {
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
    }


    private SimpleDateFormat dateFormating = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss zzz");


    public void appendStart(String s) throws IOException {
        logsput = new BufferedWriter(new FileWriter(pathToTheFolder + nameFile, true));
        logsput.append("\n\n" + ++numerator + ") [" + dateFormating.format(new Date()) + "] " + s);
        logsput.close();
    }

    public void appendReason() throws IOException {
        logsput = new BufferedWriter(new FileWriter(pathToTheFolder + nameFile, true));

        Scanner scanner = new Scanner(System.in);
        System.out.println("[System-Console-Out] Reason of starting app: ");
        String s = scanner.nextLine();

        logsput.append("\n" + ++numerator + ") [" + dateFormating.format(new Date()) + "] " + s);
        logsput.close();
    }

    public void appendWithReason(String s) throws IOException {
        logsput = new BufferedWriter(new FileWriter(pathToTheFolder + nameFile, true));
        logsput.append("\n" + ++numerator + ") [" + dateFormating.format(new Date()) + "] " + s);
        logsput.close();
    }

    public void appendEnd(String s) throws IOException {
        logsput = new BufferedWriter(new FileWriter(pathToTheFolder + nameFile, true));
        logsput.append("\n" + ++numerator + ") [" + dateFormating.format(new Date()) + "] " + s);
        logsput.close();
    }
}
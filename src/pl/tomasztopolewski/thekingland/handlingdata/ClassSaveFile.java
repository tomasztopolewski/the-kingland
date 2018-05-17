package pl.tomasztopolewski.thekingland.handlingdata;

import java.io.*;

public class ClassSaveFile {
    private String name;
    private final String enlargement = ".kingfile";
    private String path;

    private FileWriter writer;
    private File file;

    private String[] linesToSave;
    private int numberOfLines;
    private final int maxNumberOfLines = 100;

    private boolean saved;

    public ClassSaveFile(String name, String path) {
        this.name = name;
        this.path = path;
        this.file = new File(this.path + this.name + this.enlargement);
        try {
            writer = new FileWriter(file);
        } catch (IOException ioe) {
            System.out.println("SYSTEM-ERROR: ClassSave isn't existed: " + this.path + this.name + this.enlargement);
            writer = null;
        }
    }
    public ClassSaveFile(String name, String path, String[] linesToSave) throws IOException {
        this.name = name;
        this.path = path;
        try {
            writer = new FileWriter(this.path + this.name + this.enlargement);
        } catch (IOException ioe) {
            System.out.println("\nPrintWriter isn't existed.");
            writer = null;
        }
        this.linesToSave = linesToSave;
    }

    public void setLinesToSave(String[] linesToSave) {
        this.linesToSave = linesToSave;
    }

    public void save() throws IOException {
        if (linesToSave != null && linesToSave[0] != "") {
            for (int i = 0; i < linesToSave.length; i++) {
                writer.write(linesToSave[i] + "\n");
            }
        }
        else System.out.println("SYSTEM-ERROR: Nieprawidłowa konfiguracja zapisu.");
        //System.out.println("SYSTEM-ERROR: Nie można było poprawnie przekazać linii do bufora.");

        writer.close();
        //System.out.println("SYSTEM-ERROR: Nie można było poprawnie zamknąć bufora. Plik nie został zapisany.");
    }
}

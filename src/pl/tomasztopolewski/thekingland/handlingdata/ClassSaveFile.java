package pl.tomasztopolewski.thekingland.handlingdata;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class ClassSaveFile {
    private String name;
    private final String enlargement = ".kingfile";
    private String url;

    private File fileDownload;
    private Writer writer;
    private FileWriter fileWriter;

    private String[] loadedLines;
    private final int maxNumberOfLines = 100;

    private int numberOfLines;
    private String[] downloadedLines;

    private boolean loaded;

    public ClassSaveFile() throws IOException {
        fileWriter = new FileWriter(url, true);
    }
}

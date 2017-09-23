package com.thekingland.security;

public class Encryption {
    public final String[] signs = { //po: 20, 6, 20, 6, 10 kodów w linijkach
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
            "U", "V", "W", "X", "Y", "Z",
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
            "u", "v", "w", "x", "y", "z",
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    private final int numberOfSigns = 62;
    private final String[] cypher = { //po: 20, 6, 20, 6, 10 kodów w linijkach
            "5t7", "gqe", "377", "k6u", "lyv", "2t3", "da8", "9xo", "nw2", "rph", "2ua", "aa0", "oe8", "wyf", "rkd", "nm7", "qzi", "y9f", "nwc", "po1",
            "6rw", "h16", "iql", "qnj", "6e3", "k1q",
            "t5y", "6bw", "16x", "8ov", "cp6", "ygw", "fbd", "lnm", "p4k", "kpy", "3lp", "rsd", "jir", "xf1", "07z", "v0m", "hts", "mpf", "g4j", "q6z",
            "0ve", "18c", "iyg", "ozv", "2wz", "dag",
            "9gh", "f01", "lmz", "cm9", "dv4", "c3c", "cgl", "klw", "i3q", "qp3"};
    private String[] cypherFromFile = new String[numberOfSigns];

    private final String codeStarting = "0gs6z6";
    private String codeStartingFromFile;
    private final int numberOfStringCodeStarting = 6;
    private int numberOfStringCodeStartingFromFile;

    private final String codeEnding = "dg3y6";
    private String codeEndingFromFile;
    private final int numberOfStringCodeEnding = 5;
    private int numberOfStringCodeEndingFromFile;


    private String stringToEncode; //ciąg znaków do zakodowania
    private String code; //kod po kodowaniu

    private boolean correctStringToEncode; //true jeśli zmiena 'stringToEncode' jest poprawna, zgodna z wytycznymi
    private boolean savingCode; //true jeśli kod został zapisany

    public Encryption(String stringToEncode) {
        assignString(stringToEncode);
        code = "/0";
        savingCode = false;
    } // podstawowy konstruktor
    public Encryption(String stringToEncode, String codeStartingFromFile, String codeEndingFromFile, String[] cypherFromFile) {
        assignString(stringToEncode);
        this.code = "/0";
        savingCode = false;
    } // rozszerzony konstruktor z możliwością wgrania tablicy szyfrowania

//////////////////////////////////////////////////////////////////////////

    public void assignString(String string) {
        if (checkString(string)) {
            this.stringToEncode = string;
            correctStringToEncode = true;
        } else {
            this.stringToEncode = "/0";
            correctStringToEncode = false;
        }
    }

    public boolean checkString(String string) {
        string = string.trim();
        return (string.length() > 0 && string.length() < 101) && checkThatTheCorrectSyntax(string);
    }

    public String encodeString() {
        final int lengthOfString = stringToEncode.length();
        final int lengthOfStringAfterEncode = numberOfStringCodeStarting + (lengthOfString * 3) + numberOfStringCodeEnding;
        char[] signsToEncode = stringToEncode.toCharArray();

        String code = codeStarting;
        for (int i = 0; i < lengthOfString; i++) code = code + cypher[whichCharacter(signsToEncode[i])];
        code = code + codeEnding;

        if (code.length() == lengthOfStringAfterEncode) {
            savingCode = true;
            this.code = code;
            return this.code;
        } else return null;
    }

    private int whichCharacter(char x) { //zwrca liczbę index'u pod którą znak 'x' istnieje w tablicy 'signs'
        String sign = Character.toString(x);
        int numberOfIndex = 0;
        for (int i = 0; i < numberOfSigns; i++) {
            if (!(sign.indexOf(signs[numberOfIndex]) >= 0)) numberOfIndex++; else return numberOfIndex;
        }
        return -1;
    }


    private boolean checkThatTheCorrectSyntax(String string) {
        final int lengthOfString = string.length();
        char[] x = string.toCharArray();
        int i = 0;
        int condition = 0;
        while (i < lengthOfString) {
            condition += checkIfCharIsCorrectSyntax(x[i]);
            i++;
        }
        return condition == lengthOfString;
    }
    private int checkIfCharIsCorrectSyntax(char sign) {
        String x = Character.toString(sign);
        int conditiionPrimary = 0;
        for (int j = 0; j <= numberOfSigns; j++) {
            if (x.indexOf(signs[j]) >= 0) {
                conditiionPrimary++;
                if (conditiionPrimary > 0) return 1;
            }
        }
        return 0;
    }


    public void resetSettingsStrings() {
        stringToEncode = "/0";
        code = "/0";
        correctStringToEncode = false;
        savingCode = false;
    }
}


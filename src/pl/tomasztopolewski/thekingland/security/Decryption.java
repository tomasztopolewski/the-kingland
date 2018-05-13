package pl.tomasztopolewski.thekingland.security;

public class Decryption {
    private final String[] signs = { //po: 20, 6, 20, 6, 10 kodów w linijkach
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

    private String code; //kod do rozkodowania
    private String stringDecoded; //ciąg znaków rozkodowany

    private boolean correctCode; //true jeśli zmiena 'code' jest poprawna, zgodna z wytycznymi
    private boolean savingString; //true jeśli string został zapisany

    public Decryption(String code) {
        assignCode(code);
        this.stringDecoded = "/0";
        savingString = false;
    }
    public Decryption(String code, String codeStartingFromFile, String codeEndingFromFile, String[] cypherFromFile) {
        assignCode(code);
        this.stringDecoded = "/0";
        savingString = false;
    }

//////////////////////////////////////////////////////////////////////////

    public void assignCode(String code) {
        if (checkCode(code)) {
            this.code = code;
            correctCode = true;
        } else {
            this.code = "/0";
            correctCode = false;
        }
    }

    public boolean checkCode(String code) {
        if (code.startsWith(codeStarting) && code.endsWith(codeEnding) && code.length() > (numberOfStringCodeStarting + numberOfStringCodeEnding)) return true; else return false;
    }

    public String decodeString() {
        final int lengthOfCode = code.length();
        final int lengthCodeToDecode = lengthOfCode - (numberOfStringCodeStarting + numberOfStringCodeEnding);
        final int lengthOfStringBeforeEncoding = lengthCodeToDecode / 3;

        //System.out.print("Code witch prefix: " + code + "\n");

        String codeToDecode;
        if (checkCode(code)) {
            //wycinanie pierwszego kodu zabezpieczającego
            codeToDecode = code.substring(numberOfStringCodeStarting);
            //wycinanie drugiego kodu zabezpieczającego
            codeToDecode = codeToDecode.substring(0, codeToDecode.length() - numberOfStringCodeEnding);

            //System.out.print("Code:       " + codeToDecode + "\n");
            //wyświetli true jeśli kod sie zgadza /sprawdza czy kod po podzieleniu da liczbę długości stringu
            //System.out.print(((codeToDecode.length() / 3) == lengthOfStringBeforeEncoding) + "\n");
        } else return null;

        char[] signsToDecode = codeToDecode.toCharArray(); //zamiana stringu do deszyfracji w tablice char

        String stringAfterDecoding = null;
        String signEncoded = "";
        int condiction = 0;
        while (codeToDecode.length() > condiction) {
            //tworzenie kodu pojedyńczego znaku
            signEncoded = signEncoded + String.valueOf(signsToDecode[condiction]);
            signEncoded = signEncoded + String.valueOf(signsToDecode[condiction + 1]);
            signEncoded = signEncoded + String.valueOf(signsToDecode[condiction + 2]);

            //tworzenie rozkodowanego stringu z tego stringu i nowego znaku pobranego z tablicy spod indeksu pojedynczego kodu kodującego ten znak
            stringAfterDecoding = stringAfterDecoding + signs[whichSign(signEncoded)];
            condiction += 3;
            //System.out.print("String decoding: " + stringAfterDecoding + "\n");
            signEncoded = "";
        }
        //zwracanie rozkodowanego ciągu
        return stringAfterDecoding;
    }

    private int whichSign(String sign) { //zwrca liczbę index'u pod którą znak 'x' istnieje w tablicy 'signs'
        //System.out.print("Sign to decode: " + sign + "\n");
        int numberOfIndex = 0;
        for (int i = 0; i < numberOfSigns; i++) {
            if (!(sign.startsWith(cypher[numberOfIndex]))) numberOfIndex++; else return numberOfIndex;
        }
        return -1;
    }

    public void resetSettingsStrings() {
        this.code = "/0";
        this.stringDecoded = "/0";
        correctCode = false;
        savingString = false;
    }
}

// Tomasz Topolewski
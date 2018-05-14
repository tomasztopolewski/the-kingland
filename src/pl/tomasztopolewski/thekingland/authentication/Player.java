package pl.tomasztopolewski.thekingland.authentication;

public class Player {
    private String ID;
    private static final int lenghtID = 3;

    private String username;
    private static final int minLenghtOfUsername = 4;
    private static final int maxLenghtOfUsername = 16;

    private String password;
    private static final int minLenghtOfPassword = 5;
    private static final int maxLenghtOfPassword = 32;

    private String nameKingdom;
    private static final int minLenghtOfNameKingdom = 4;
    private static final int maxLenghtOfNameKingdom = 32;


    public Player() {
        this.ID = "000";
        this.username = "Player1";
        this.password = "pass123";
        this.nameKingdom = "Castle1";
    }

    public Player(String ID, String username, String password, String nameKingdom) {
        this.ID = ID;
        this.username = username;
        this.password = password;
        this.nameKingdom = nameKingdom;
    }

    public void setId(String id) {
        this.ID = id;
    }
    public String getId() {
        return this.ID;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername() {
        return this.username;
    }

    public static int getMinLenghtOfUsername() {
        return minLenghtOfUsername;
    }
    public static int getMaxLenghtOfUsername() {
        return maxLenghtOfUsername;
    }

    public void setPassword(String password) {
        if (password.length()>=8) {
           this.password = password;
        } else {
            System.out.print("Error unclassified: Password is too short. It must have min. 8 chars.");
        }
    }

    public String getPassword() {
        return this.password;
    }

    public void setNameKingdom(String nameKingdom) {
        this.nameKingdom = nameKingdom;
    }

    public String getNameKingdom() {
        return this.nameKingdom;
    }
}

// Tomasz Topolewski


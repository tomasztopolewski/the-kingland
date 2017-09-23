package com.thekingland.authentication;

public class Player {
    private String id;
    private String username;
    private String password;
    private String nameKingdom;

    public Player() {
        this.id = "000";
        this.username = "Player1";
        this.password = "pass123";
        this.nameKingdom = "Castle1";
    }

    public Player(String id, String username, String password, String nameKingdom) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nameKingdom = nameKingdom;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
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


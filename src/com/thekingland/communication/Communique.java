package com.thekingland.communication;

public class Communique {
    public final String nameGame = "The KingLand";
    public final String author = "Tomasz Topolewski";
    public final String version = " v45.75.820-branch(Jun 2017) DEV_alpha";
    public final String longStartDateWork = "October 11th 2015";
    public final String medianStartDateWork = "October 2015";
    public final String shortStartDateWork = "Oct 2015";
    public final String longDate = "4th July 2017";
    public final String medianDate = "July 2017";
    public final String shortDate = "Jul 2017";

    public final String welcome =  "\t" + nameGame + version + "\n";
    public final String startWelcome = "\t" + nameGame + version + "\n\t" + shortStartDateWork + " - " + shortDate + "\n\n";
    public final String shortWelcome = "\n---------------------------------------------------\n\t" + nameGame + version + " - Oct2015\n\n";


    public Communique() {}

    public String getNameGame() {
        return nameGame;
    }
    public String getAuthor() {
        return author;
    }
    public String getVersion() {
        return version;
    }
    public String getStartDateWork() {
        return longStartDateWork;
    }
    public String getShortStartDateWork() {
        return shortStartDateWork;
    }
    public String getShortDate() {
        return shortDate;
    }

    /*public void viewWelcome() {
        System.out.print(welcome);
    }
    public void viewShortWelcome() {
        System.out.print(shortWelcome);
    }
    public void viewStartWelcome() {
        System.out.print(startWelcome);
    }*/
    public void viewWelcome() {
        System.out.print("\t" + nameGame + version + "\n");
        System.out.print("\t" + medianStartDateWork + " - " + medianDate + "\n\n");
    }


    public void viewNameGame() {
        System.out.print("Name game: " + nameGame);
    }
    public void viewAuthor() {
        System.out.print("Author of game: " + author + "\n");
    }
    public void viewVersion() {
        System.out.print("Version of game: " + version + "\n");
    }

    public void animationWait(int sec) throws InterruptedException {
        System.out.print("\n\tWaiting");
        Thread.sleep(1000);
        for (int i = 1; i <= sec; i++) {
            System.out.print(".");
            Thread.sleep(2000);
        }
        System.out.print("\n");
    }
    public void animationSimpleWaitLoadSettings(int sec) throws InterruptedException {
        Thread.sleep(2000);
        System.out.print("\n\tLoading settings");
        Thread.sleep(1000);
        for (int i = 1; i <= sec; i++) {
            System.out.print(".");
            Thread.sleep(2000);
        }
        System.out.print("\n");
    }
    public void animationStartLoadingSettings() throws InterruptedException {
        Thread.sleep(500);
        System.out.print("Loading settings ");
        Thread.sleep(200);
        System.out.print("0% ");
        for (int k = 0; k < 3; k++) {
            Thread.sleep(500);
            System.out.print(".");
        }
    }
    public void animationEndLoadingSettings() throws InterruptedException {
        Thread.sleep(1000);
        System.out.print(" 100%\n\n");
        Thread.sleep(1000);
    }

    public void viewGoodbay() throws InterruptedException {
        System.out.print("Good bay!\n");
        Thread.sleep(5000);
        System.out.print("\n\nCreated by " + author + "\n");
        Thread.sleep(2500);
        System.exit(1);
    }
}

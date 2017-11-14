package com.thekingland;

public class Sociaty {
    private int quantityWomen;  //quantity of women in all society
    private int quantityMen;  //quantity of men in all society
    private float joy;  //degree satisfaction of society
    private float willingness;  //willingness to work

    public Sociaty() {
        this.quantityWomen = 50;
        this.quantityMen = 70;
        this.joy = 10;
        this.willingness = (float) 0.5;
    }
    public Sociaty(int quantityWomen, int quantityMen, float joy, float willingness) {
        this.quantityWomen = quantityWomen;
        this.quantityMen = quantityMen;
        this.joy = joy;
        this.willingness = willingness;
    }

    public void setQuantityWomen(int quantityWomen){
        this.quantityWomen = quantityWomen;
    }
    public int getQuantityWomen(){
        return this.quantityWomen;
    }

    public void setQuantityMen(int quantityMen){
        this.quantityMen = quantityMen;
    }
    public int getQuantityMen(){
        return this.quantityMen;
    }

    public void setJoy(float joy){
        this.joy = joy;
    }
    public float getJoy(){
        return this.joy;
    }

    public void setWillingness(float willingness){
        this.willingness = willingness;
    }
    public float getWillingness(){
        return this.willingness;
    }


    public double calcfForcePeople() {
        return ((this.quantityMen * 1.5) + (this.quantityWomen * 1.1));
    }

    public double calcFactorOfMood() {
        return (((this.quantityWomen + this.quantityMen) / 100) * this.joy);
    }
}

// Tomasz Topolewski
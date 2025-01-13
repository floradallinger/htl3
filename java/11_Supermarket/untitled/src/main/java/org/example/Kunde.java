package org.example;

import java.util.Random;

public class Kunde {
    private int id;
    private double einkaufswert;
    private Random rand = new Random();

    private static int nextId = 1;

    private Kunde(){
        this.id = nextId++;
        this.einkaufswert = rand.nextDouble(1, 101);
    }

    public static Kunde einkaufen(){
        Kunde k = new Kunde();
        System.out.println("Kunde " + k.id + " starts buying");
        return k;
    }

    @Override
    public String toString() {
        return ("Kunde " + id + " Eur:" + einkaufswert);
    }

    public int getId() {
        return id;
    }
    public double getEinkaufswert() {
        return einkaufswert;
    }
}
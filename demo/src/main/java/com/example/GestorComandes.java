package com.example;

import java.util.ArrayList;

public class GestorComandes {
    private ArrayList<Comanda> pendents; // [cite: 83]

    public GestorComandes() {
        this.pendents = new ArrayList<>(); // [cite: 85]
    }

    public void afegirComanda(Comanda c) {
        this.pendents.add(c); // [cite: 86, 87]
    }

    public Comanda extreurePrimera() {
        if (estaBuit())
            return null; // [cite: 90]
        return this.pendents.remove(0); // [cite: 88, 89]
    }

    public boolean estaBuit() {
        return this.pendents.isEmpty(); // [cite: 91, 92]
    }

    public int totalComandes() {
        return this.pendents.size(); // [cite: 98]
    }

    public void mostrarComandes() {
        System.out.println("== COMANDES PENDENTS: " + totalComandes() + " =="); // [cite: 101]
        for (Comanda c : pendents) {
            System.out.print(c.toString() + " ");
        }
        System.out.println(); // [cite: 102]
    }
}
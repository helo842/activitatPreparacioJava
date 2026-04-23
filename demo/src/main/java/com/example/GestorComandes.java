package com.example;

import java.util.ArrayList;

public class GestorComandes {
    private ArrayList<Comanda> pendents;

    public GestorComandes() {
        this.pendents = new ArrayList<>();
    }

    public void afegirComanda(Comanda c) {
        this.pendents.add(c);
    }

    public Comanda extreurePrimera() {
        if (estaBuit())
            return null;
        return this.pendents.remove(0);
    }

    public boolean estaBuit() {
        return this.pendents.isEmpty();
    }

    public int totalComandes() {
        return this.pendents.size();
    }

    public void mostrarComandes() {
        System.out.println("== COMANDES PENDENTS: " + totalComandes() + " ==");
        for (Comanda c : pendents) {
            System.out.print(c.toString() + " ");
        }
        System.out.println();
    }
}
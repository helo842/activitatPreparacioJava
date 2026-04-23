package com.example;

public class ComandaNormal extends Comanda {
    private int numArticles;

    public ComandaNormal(String codi, String nomClient, int numArticles) {
        super(codi, nomClient);
        if (numArticles < 1) {
            throw new IllegalArgumentException("El número d'articles ha de ser >= 1");
        }
        this.numArticles = numArticles;
    }

    @Override
    public double calcularPes() {
        return numArticles * 0.5;
    }

    @Override
    public String toString() {
        return "[Normal - " + codi + "]";
    }
}
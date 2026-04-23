package com.example;

public abstract class Comanda {
    protected String codi;
    protected String nomClient;

    public Comanda(String codi, String nomClient) {
        if (codi == null || codi.length() != 6) {
            throw new IllegalArgumentException("El codi ha de tenir exactament 6 caràcters"); // [cite: 17, 19]
        }
        if (nomClient == null || nomClient.length() < 3) {
            throw new IllegalArgumentException("El nom del client ha de tenir almenys 3 caràcters"); // [cite: 18, 19]
        }
        this.codi = codi;
        this.nomClient = nomClient;
    }

    public String getCodi() {
        return codi; // [cite: 20]
    }

    public String getNomClient() {
        return nomClient; // [cite: 21]
    }

    public abstract double calcularPes(); // [cite: 22, 23]
}
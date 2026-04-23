package com.example;

public abstract class Comanda {
    protected String codi;
    protected String nomClient;

    public Comanda(String codi, String nomClient) {
        if (codi == null || codi.length() != 6) {
            throw new IllegalArgumentException("El codi ha de tenir exactament 6 caràcters");
        }
        if (nomClient == null || nomClient.length() < 3) {
            throw new IllegalArgumentException("El nom del client ha de tenir almenys 3 caràcters");
        }
        this.codi = codi;
        this.nomClient = nomClient;
    }

    public String getCodi() {
        return codi;
    }

    public String getNomClient() {
        return nomClient;
    }

    public abstract double calcularPes();
}
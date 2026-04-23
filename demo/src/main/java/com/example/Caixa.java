package com.example;

public class Caixa {
    private String referencia;
    private double pesKg;
    private boolean prioritaria;

    public Caixa(String referencia, double pesKg, boolean prioritaria) {
        if (referencia == null || referencia.length() < 4) {
            throw new IllegalArgumentException("La referència ha de tenir almenys 4 caràcters"); // [cite: 67, 69]
        }
        if (pesKg <= 0) {
            throw new IllegalArgumentException("El pes ha de ser més gran que 0"); // [cite: 68, 69]
        }
        this.referencia = referencia;
        this.pesKg = pesKg;
        this.prioritaria = prioritaria;
    }

    public String getReferencia() {
        return referencia;
    } // [cite: 70]

    public double getPesKg() {
        return pesKg;
    } // [cite: 71]

    public boolean isPrioritaria() {
        return prioritaria;
    } // [cite: 72]

    public double costEnviament() {
        double cost = 0;
        if (pesKg <= 2) {
            cost = 4.0; // [cite: 75]
        } else {
            cost = 4.0 + (pesKg * 1.5); // [cite: 76]
        }
        if (prioritaria) {
            cost += 5.0; // [cite: 77]
        }
        return cost;
    }

    @Override
    public String toString() {
        return "[" + referencia + ": " + pesKg + "kg]"; // [cite: 78]
    }
}
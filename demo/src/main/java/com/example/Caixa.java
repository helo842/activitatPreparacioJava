package com.example;

public class Caixa {
    private String referencia;
    private double pesKg;
    private boolean prioritaria;

    public Caixa(String referencia, double pesKg, boolean prioritaria) {
        if (referencia == null || referencia.length() < 4) {
            throw new IllegalArgumentException("La referència ha de tenir almenys 4 caràcters");
        }
        if (pesKg <= 0) {
            throw new IllegalArgumentException("El pes ha de ser més gran que 0");
        }
        this.referencia = referencia;
        this.pesKg = pesKg;
        this.prioritaria = prioritaria;
    }

    public String getReferencia() {
        return referencia;
    }

    public double getPesKg() {
        return pesKg;
    }

    public boolean isPrioritaria() {
        return prioritaria;
    }

    public double costEnviament() {
        double cost = 0;
        if (pesKg <= 2) {
            cost = 4.0;
        } else {
            cost = 4.0 + (pesKg * 1.5);
        }
        if (prioritaria) {
            cost += 5.0;
        }
        return cost;
    }

    @Override
    public String toString() {
        return "[" + referencia + ": " + pesKg + "kg]";
    }
}
package com.example;

public class ComandaUrgent extends Comanda {
    private boolean embalatgeEspecial;

    public ComandaUrgent(String codi, String nomClient, boolean embalatgeEspecial) {
        super(codi, nomClient);
        this.embalatgeEspecial = embalatgeEspecial;
    }

    @Override
    public double calcularPes() {
        double pesBase = 2.0; // [cite: 53]
        if (embalatgeEspecial) {
            pesBase += 1.5; // [cite: 54]
        }
        return pesBase; // [cite: 55]
    }

    @Override
    public String toString() {
        return "[Urgent - " + codi + "]"; // [cite: 56]
    }
}
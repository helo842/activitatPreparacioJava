package com.example;

public class ComandaUrgent extends Comanda {
    private boolean embalatgeEspecial;

    public ComandaUrgent(String codi, String nomClient, boolean embalatgeEspecial) {
        super(codi, nomClient);
        this.embalatgeEspecial = embalatgeEspecial;
    }

    @Override
    public double calcularPes() {
        double pesBase = 2.0;
        if (embalatgeEspecial) {
            pesBase += 1.5;
        }
        return pesBase;
    }

    @Override
    public String toString() {
        return "[Urgent - " + codi + "]";
    }
}
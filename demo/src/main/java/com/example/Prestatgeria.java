package com.example;

public class Prestatgeria {
    private Caixa[] espais; // [cite: 106]

    public Prestatgeria(int numEspais) {
        if (numEspais < 1) {
            throw new IllegalArgumentException("El número d'espais ha de ser >= 1"); // [cite: 110, 111]
        }
        this.espais = new Caixa[numEspais]; // [cite: 109]
    }

    public boolean guardarCaixa(Caixa c, int posicio) {
        if (posicio >= 0 && posicio < espais.length && espais[posicio] == null) {
            espais[posicio] = c; // [cite: 113, 114]
            return true;
        }
        return false;
    }

    public Caixa retirarCaixa(int posicio) {
        if (posicio >= 0 && posicio < espais.length && espais[posicio] != null) {
            Caixa c = espais[posicio]; // [cite: 116]
            espais[posicio] = null;
            return c;
        }
        return null; // [cite: 117]
    }

    public int primerEspaiLliure() {
        for (int i = 0; i < espais.length; i++) {
            if (espais[i] == null)
                return i; // [cite: 119]
        }
        return -1; // [cite: 120]
    }

    public boolean hiHaEspai() {
        return primerEspaiLliure() != -1; // [cite: 122]
    }

    public boolean estaBuida() {
        for (Caixa c : espais) {
            if (c != null)
                return false;
        }
        return true; // [cite: 124]
    }

    public void mostrarPrestatgeria() {
        for (Caixa c : espais) {
            if (c == null) {
                System.out.print("[--]");
            } else {
                System.out.print(c.toString());
            }
        }
        System.out.println(); // [cite: 126]
    }
}
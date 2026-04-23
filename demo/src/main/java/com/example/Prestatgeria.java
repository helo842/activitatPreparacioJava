package com.example;

public class Prestatgeria {
    private Caixa[] espais;

    public Prestatgeria(int numEspais) {
        if (numEspais < 1) {
            throw new IllegalArgumentException("El número d'espais ha de ser >= 1");
        }
        this.espais = new Caixa[numEspais];
    }

    public boolean guardarCaixa(Caixa c, int posicio) {
        if (posicio >= 0 && posicio < espais.length && espais[posicio] == null) {
            espais[posicio] = c;
            return true;
        }
        return false;
    }

    public Caixa retirarCaixa(int posicio) {
        if (posicio >= 0 && posicio < espais.length && espais[posicio] != null) {
            Caixa c = espais[posicio];
            espais[posicio] = null;
            return c;
        }
        return null;
    }

    public int primerEspaiLliure() {
        for (int i = 0; i < espais.length; i++) {
            if (espais[i] == null)
                return i;
        }
        return -1;
    }

    public boolean hiHaEspai() {
        return primerEspaiLliure() != -1;
    }

    public boolean estaBuida() {
        for (Caixa c : espais) {
            if (c != null)
                return false;
        }
        return true;
    }

    public void mostrarPrestatgeria() {
        for (Caixa c : espais) {
            if (c == null) {
                System.out.print("[--]");
            } else {
                System.out.print(c.toString());
            }
        }
        System.out.println();
    }
}
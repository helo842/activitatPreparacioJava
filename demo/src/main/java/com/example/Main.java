package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        GestorComandes gestor = new GestorComandes();
        Prestatgeria prestatgeria = new Prestatgeria(5);

        gestor.afegirComanda(new ComandaNormal("CMD001", "Client A", 3)); // [cite: 135]
        gestor.afegirComanda(new ComandaUrgent("CMD002", "Client B", true));
        gestor.afegirComanda(new ComandaNormal("CMD003", "Client C", 5));
        gestor.afegirComanda(new ComandaUrgent("CMD004", "Client D", false));

        while (!gestor.estaBuit() || !prestatgeria.estaBuida()) {
            System.out.println("\n--- ESTAT ACTUAL ---");
            gestor.mostrarComandes();
            prestatgeria.mostrarPrestatgeria();

            System.out.println("\nMenú:");
            System.out.println("1) Preparar següent comanda i guardar caixa");
            System.out.println("2) Retirar caixa d'una posició");
            System.out.print("Tria opció: ");
            int opcio = scanner.nextInt();

            if (opcio == 1) {
                if (gestor.estaBuit()) {
                    System.out.println("No hi ha comandes per processar.");
                    continue;
                }

                Comanda comanda = gestor.extreurePrimera();
                double pes = comanda.calcularPes();
                boolean prioritaria = comanda instanceof ComandaUrgent;

                Caixa novaCaixa = new Caixa("CX" + comanda.getCodi(), pes, prioritaria);

                int posLliure = prestatgeria.primerEspaiLliure();
                if (posLliure != -1) {
                    prestatgeria.guardarCaixa(novaCaixa, posLliure);
                    System.out.println("Caixa guardada a la posició: " + posLliure);
                } else {
                    System.out
                            .println("Error: No hi ha espai. La comanda " + comanda.getCodi() + " no s'ha processat.");
                }
            } else if (opcio == 2) {
                System.out.print("Introdueix la posició a retirar: ");
                int pos = scanner.nextInt();
                Caixa retirada = prestatgeria.retirarCaixa(pos);

                if (retirada != null) {
                    System.out.println("Caixa retirada. Cost d'enviament: " + retirada.costEnviament() + "€");
                } else {
                    System.out.println("No hi havia cap caixa en aquesta posició o posició invàlida.");
                }
            } else {
                System.out.println("Opció no vàlida.");
            }
        }

        System.out.println("Jornada finalitzada");
        scanner.close();
    }
}
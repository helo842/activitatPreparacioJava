package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        GestorComandes gestor = new GestorComandes(); // [cite: 130]
        Prestatgeria prestatgeria = new Prestatgeria(5); // [cite: 131]

        // Crear 2 normals i 2 urgents [cite: 132, 133, 134]
        gestor.afegirComanda(new ComandaNormal("CMD001", "Client A", 3)); // [cite: 135]
        gestor.afegirComanda(new ComandaUrgent("CMD002", "Client B", true));
        gestor.afegirComanda(new ComandaNormal("CMD003", "Client C", 5));
        gestor.afegirComanda(new ComandaUrgent("CMD004", "Client D", false));

        // Bucle principal [cite: 136, 137]
        while (!gestor.estaBuit() || !prestatgeria.estaBuida()) {
            System.out.println("\n--- ESTAT ACTUAL ---");
            gestor.mostrarComandes(); // [cite: 138]
            prestatgeria.mostrarPrestatgeria(); // [cite: 139]

            System.out.println("\nMenú:");
            System.out.println("1) Preparar següent comanda i guardar caixa"); // [cite: 141]
            System.out.println("2) Retirar caixa d'una posició"); // [cite: 142]
            System.out.print("Tria opció: ");
            int opcio = scanner.nextInt();

            if (opcio == 1) {
                if (gestor.estaBuit()) {
                    System.out.println("No hi ha comandes per processar.");
                    continue;
                }

                Comanda comanda = gestor.extreurePrimera(); // [cite: 148]
                double pes = comanda.calcularPes(); // [cite: 149, 152]
                boolean prioritaria = comanda instanceof ComandaUrgent; // [cite: 153, 154, 155]

                Caixa novaCaixa = new Caixa("CX" + comanda.getCodi(), pes, prioritaria); // [cite: 150, 151]

                int posLliure = prestatgeria.primerEspaiLliure(); // [cite: 156]
                if (posLliure != -1) {
                    prestatgeria.guardarCaixa(novaCaixa, posLliure); // [cite: 157]
                    System.out.println("Caixa guardada a la posició: " + posLliure);
                } else {
                    System.out
                            .println("Error: No hi ha espai. La comanda " + comanda.getCodi() + " no s'ha processat."); // [cite:
                                                                                                                        // 158]
                }
            } else if (opcio == 2) {
                System.out.print("Introdueix la posició a retirar: "); // [cite: 160]
                int pos = scanner.nextInt();
                Caixa retirada = prestatgeria.retirarCaixa(pos); // [cite: 161]

                if (retirada != null) {
                    System.out.println("Caixa retirada. Cost d'enviament: " + retirada.costEnviament() + "€"); // [cite:
                                                                                                               // 162]
                } else {
                    System.out.println("No hi havia cap caixa en aquesta posició o posició invàlida."); // [cite: 163]
                }
            } else {
                System.out.println("Opció no vàlida.");
            }
        }

        System.out.println("Jornada finalitzada"); // [cite: 165]
        scanner.close();
    }
}
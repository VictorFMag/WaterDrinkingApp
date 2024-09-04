package com.victorfmag.waterdrinkingapp;

import java.util.ArrayList;
import java.util.List;

public class AguaDiaria {
    private List<Copo> copos;
    private int volumeCopoMl;

    public AguaDiaria(int peso, int volumeCopoMl) {
        this.volumeCopoMl = volumeCopoMl;
        calcularMeta(peso);
    }

    private void calcularMeta(int peso) {
        int totalMl = peso * 35; // Total de mililitros recomendados
        int numCoposCheios = totalMl / volumeCopoMl; // Número de copos completos de 200ml
        int restanteMl = totalMl % volumeCopoMl; // O volume restante que não preenche um copo completo

        copos = new ArrayList<>();

        // Adicionar os copos cheios
        for (int i = 0; i < numCoposCheios; i++) {
            copos.add(new Copo(volumeCopoMl));
        }

        // Se houver algum volume restante, adicionar um copo adicional com esse volume
        if (restanteMl > 0) {
            copos.add(new Copo(restanteMl)); // Copo com a quantidade restante
        }
    }

    public List<Copo> getCopos() {
        return copos;
    }

    public float litrosBebidosAteAgora() {
        int coposBebidos = 0;
        for (Copo copo : copos) {
            if (!copo.isCheio()) {
                System.out.println("1 copo");
                coposBebidos++;
            }
        }
        return (float) (coposBebidos * volumeCopoMl);
    }
}
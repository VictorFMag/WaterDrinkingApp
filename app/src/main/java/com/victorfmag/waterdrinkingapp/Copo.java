package com.victorfmag.waterdrinkingapp;

public class Copo {
    private int volumeMl;
    private boolean cheio;

    public Copo(int volumeMl) {
        this.volumeMl = volumeMl;
        this.cheio = true;
    }

    public boolean isCheio() {
        return cheio;
    }

    public int getVolumeMl() {
        return volumeMl;
    }
}
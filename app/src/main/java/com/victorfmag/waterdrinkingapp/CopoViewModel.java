package com.victorfmag.waterdrinkingapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CopoViewModel extends ViewModel {
    private MutableLiveData<Integer> imagemCopo;

    private AguaDiariaViewModel aguadiaria;
    private Copo copoObjeto;

    private boolean bebido;

    public CopoViewModel(Copo copoobje) {
        this.bebido = false;
        this.copoObjeto = copoobje;
        imagemCopo = new MutableLiveData<>(R.drawable.baseline_water_drop_24_blue);
    }

    public LiveData<Integer> getImagemCopo() {
        return imagemCopo;
    }

    public String getVolume() {
        return copoObjeto.getVolumeMl() + " ml";
    }

    public boolean isBebido() {
        return bebido;
    }

    public void beber() {
        this.bebido = true;
        copoObjeto.setCheio(false);
        imagemCopo.setValue(R.drawable.baseline_water_drop_24);
    }

    public void desfazer() {
        this.bebido = false;
        copoObjeto.setCheio(true);
        imagemCopo.setValue(R.drawable.baseline_water_drop_24_blue);
    }
}
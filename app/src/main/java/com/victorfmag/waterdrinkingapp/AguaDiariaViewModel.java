package com.victorfmag.waterdrinkingapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class AguaDiariaViewModel extends ViewModel {
    private MutableLiveData<String> peso;
    private MutableLiveData<String> volume;
    private MutableLiveData<String> bebidoAgora;
    private MutableLiveData<String> faltando;
    private AguaDiaria aguaDiaria;
    private List<CopoViewModel> coposViewModel;
    private AguaDiariaAdapter adapter;

    public AguaDiariaViewModel() {
        peso = new MutableLiveData<>("70");
        volume = new MutableLiveData<>();
        bebidoAgora = new MutableLiveData<>();
        faltando = new MutableLiveData<>();
        calcular(); // Calcula a meta inicial
        criarAdapter();
    }

    public void calcular() {
        try {
            int pesoInt = Integer.parseInt(peso.getValue());
            aguaDiaria = new AguaDiaria(pesoInt, 200);
            atualizarDados();
            criarCoposViewModel();
        } catch (NumberFormatException e) {
            // Lidar com o caso de peso inválido (opcional)
            volume.setValue("Peso inválido");
        }
    }

    private void atualizarDados() {
        float metaLitros = aguaDiaria.getCopos().size() * (200f / 1000f);
        float litrosBebidos = aguaDiaria.litrosBebidosAteAgora();
        float litrosFaltando = metaLitros - litrosBebidos;

        volume.setValue(String.format("%.1f", metaLitros));
        bebidoAgora.setValue(String.format("%.1f", litrosBebidos));
        faltando.setValue(String.format("%.1f", litrosFaltando));
    }

    private void criarCoposViewModel() {
        coposViewModel = new ArrayList<>();
        for (Copo copo : aguaDiaria.getCopos()) {
            coposViewModel.add(new CopoViewModel(copo));
        }
        if (adapter != null) {
            adapter.setCopos(coposViewModel);
        }
    }

    private void criarAdapter() {
        adapter = new AguaDiariaAdapter(this);
    }

    // ... getters para LiveData

    public MutableLiveData<String> getPeso() {
        return peso;
    }

    public LiveData<String> getVolume() {
        return volume;
    }

    public LiveData<String> getBebidoAgora() {
        return bebidoAgora;
    }

    public LiveData<String> getFaltando() {
        return faltando;
    }

    public AguaDiariaAdapter getAdapter() {
        return adapter;
    }

    public void beberCopo(int position) {
        coposViewModel.get(position).beber();
        atualizarDados();
    }

    public void desfazerCopo(int position) {
        coposViewModel.get(position).desfazer();
        atualizarDados();
    }
}
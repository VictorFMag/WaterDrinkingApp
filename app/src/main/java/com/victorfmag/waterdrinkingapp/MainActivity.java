package com.victorfmag.waterdrinkingapp;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.widget.EditText;

import com.victorfmag.waterdrinkingapp.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private AguaDiariaViewModel aguaDiariaViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        aguaDiariaViewModel = new ViewModelProvider(this).get(AguaDiariaViewModel.class);
        binding.setViewModel(aguaDiariaViewModel);
        binding.setLifecycleOwner(this);

        // Configuração do RecyclerView com o GridLayoutManager
        int numberOfColumns = 3; // Ajuste o número de colunas conforme necessário
        GridLayoutManager layoutManager = new GridLayoutManager(this, numberOfColumns, GridLayoutManager.HORIZONTAL, false);
        binding.recyclerViewCopos.setLayoutManager(layoutManager);
    }
}
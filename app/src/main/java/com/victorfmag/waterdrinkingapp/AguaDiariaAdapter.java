package com.victorfmag.waterdrinkingapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class AguaDiariaAdapter extends RecyclerView.Adapter<CopoViewHolder> {

    private List<CopoViewModel> copos;
    private AguaDiariaViewModel aguaDiariaViewModel;

    public AguaDiariaAdapter(AguaDiariaViewModel viewModel) {
        this.aguaDiariaViewModel = viewModel;
    }

    @NonNull
    @Override
    public CopoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_copo, parent, false);
        return new CopoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CopoViewHolder holder, int position) {
        if (copos != null && position >= 0 && position < copos.size()) {
            CopoViewModel copoViewModel = copos.get(position);
            holder.imageViewCopo.setImageResource(copoViewModel.getImagemCopo().getValue());
            holder.textViewVolumeCopo.setText(copoViewModel.getVolume());

            holder.itemView.setOnClickListener(v -> {
                if (!copoViewModel.isBebido()) {
                    aguaDiariaViewModel.beberCopo(position);
                    notifyDataSetChanged();
                } else {
                    aguaDiariaViewModel.desfazerCopo(position);
                    notifyDataSetChanged();
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return copos != null ? copos.size() : 0;
    }

    public void setCopos(List<CopoViewModel> copos) {
        this.copos = copos;
        notifyDataSetChanged();
    }
}

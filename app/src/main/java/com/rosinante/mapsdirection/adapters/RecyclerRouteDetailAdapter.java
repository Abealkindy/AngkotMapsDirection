package com.rosinante.mapsdirection.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rosinante.mapsdirection.R;
import com.rosinante.mapsdirection.models.jurusanangkot.AngkotModel;

import java.util.List;

public class RecyclerRouteDetailAdapter extends RecyclerView.Adapter<RecyclerRouteDetailAdapter.ViewHolder> {
    private Context context;
    private List<AngkotModel.Result.TempatTujuan> results;

    public RecyclerRouteDetailAdapter(Context context, List<AngkotModel.Result.TempatTujuan> results) {
        this.context = context;
        this.results = results;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.route_detail_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
        viewHolder.textViewAngkot.setText(results.get(position).getMNamaTujuan());
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardViewAngkot;
        TextView textViewAngkot;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardViewAngkot = itemView.findViewById(R.id.card_angkot_detail);
            textViewAngkot = itemView.findViewById(R.id.text_view_nama_angkot_detail);
        }
    }
}

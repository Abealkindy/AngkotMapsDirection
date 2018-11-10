package com.rosinante.mapsdirection.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rosinante.mapsdirection.R;
import com.rosinante.mapsdirection.activities.DetailLocationActivity;
import com.rosinante.mapsdirection.models.jurusanangkot.AngkotModel;

import java.io.Serializable;
import java.util.List;

public class RecyclerRouteAdapter extends RecyclerView.Adapter<RecyclerRouteAdapter.ViewHolder> {
    private Context context;
    private List<AngkotModel.Result> results;

    public RecyclerRouteAdapter(Context context, List<AngkotModel.Result> results) {
        this.context = context;
        this.results = results;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.route_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
        viewHolder.textViewAngkot.setText(results.get(position).getMAngkotName());
        viewHolder.cardViewAngkot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context.getApplicationContext(), DetailLocationActivity.class);
                intent.putExtra("angkotName", results.get(position).getMAngkotName());
                intent.putExtra("latOrigin", results.get(position).getMLatOrigin());
                intent.putExtra("lngOrigin", results.get(position).getMLngOrigin());
                intent.putExtra("lngDes", results.get(position).getMLatDestination());
                intent.putExtra("lngDes", results.get(position).getMLngDestination());

                for (int pos = 0; pos < results.get(position).getMTempatTujuan().size(); pos++) {
                    List<AngkotModel.Result.TempatTujuan> tempatTujuan = results.get(position).getMTempatTujuan();
                    intent.putExtra("tujuanNama", (Serializable) tempatTujuan);
                }

                context.startActivity(intent);
            }
        });
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
            cardViewAngkot = itemView.findViewById(R.id.card_angkot);
            textViewAngkot = itemView.findViewById(R.id.text_view_nama_angkot);
        }
    }
}

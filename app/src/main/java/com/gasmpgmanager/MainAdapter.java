package com.gasmpgmanager;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    private List<Gas> gasList;
    private Activity context;
    private AppDatabase database;

    public MainAdapter(Activity context, List<Gas> gasList) {
        this.context = context;
        this.gasList = gasList;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gas_cardview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Gas current = gasList.get(position);
        holder.tvStationName.setText(current.getStationName());
        holder.tvDate.setText(current.getDate());
        holder.tvPricePerGallon.setText("$" + current.getPricePerGallon());
        holder.tvTotalPrice.setText("$" + current.getTotalPrice());
        holder.tvTotalGallons.setText(current.getTotalGallons());
        holder.tvMPG.setText(current.getMpg());

        holder.ivTrash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Gas g = gasList.get(holder.getAdapterPosition());
                database = AppDatabase.getDBInstance(context);
                database.getGasDao().delete(g);

                int position = holder.getAdapterPosition();
                gasList.remove(position);
                notifyItemChanged(position);
                notifyItemRangeChanged(position, gasList.size());
            }
        });

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvStationName, tvDate, tvPricePerGallon, tvTotalPrice, tvTotalGallons, tvMPG;
        ImageView ivTrash;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvStationName = itemView.findViewById(R.id.tvStationName);
            tvDate = itemView.findViewById(R.id.tvDate);
            tvPricePerGallon = itemView.findViewById(R.id.tvPricePerGallon);
            tvTotalPrice = itemView.findViewById(R.id.tvTotalPrice);
            tvTotalGallons = itemView.findViewById(R.id.tvTotalGallons);
            tvMPG = itemView.findViewById(R.id.tvMPG);
            ivTrash = itemView.findViewById(R.id.ivTrash);
        }
    }

    @Override
    public int getItemCount() {
        return gasList.size();
    }
}

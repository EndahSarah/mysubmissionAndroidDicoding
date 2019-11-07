package com.endah.mysubmissiondicoding;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListHistoryAdapter extends RecyclerView.Adapter<ListHistoryAdapter.ListViewHolder> {
    private ArrayList<History> listHistory;

    public ListHistoryAdapter(ArrayList<History> list) {
        this.listHistory = list;
    }


    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view    = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_history, viewGroup, false);
        return new ListViewHolder(view);
    }

    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        History history = listHistory.get(position);
        Glide.with(holder.itemView.getContext())
                .load(history.getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgPhoto);

        holder.tvName.setText(history.getName());
        holder.tvRelease.setText(history.getRelease());
        holder.tvDetail.setText(history.getDetail());

        final Context context = holder.itemView.getContext();
        Glide.with(holder.itemView.getContext())
                .load(history.getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgPhoto);

        holder.tvName.setText(history.getName());
        holder.tvRelease.setText(history.getRelease());
        holder.tvDetail.setText(history.getDetail());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listHistory.get(holder.getAdapterPosition()));

                Intent moveIntent = new Intent(context, DetailActivity.class);

                moveIntent.putExtra("name", listHistory.get(holder.getAdapterPosition()).getName());
                moveIntent.putExtra("release", listHistory.get(holder.getAdapterPosition()).getRelease());
                moveIntent.putExtra("detail", listHistory.get(holder.getAdapterPosition()).getDetail());
                moveIntent.putExtra("photo", listHistory.get(holder.getAdapterPosition()).getPhoto());
                context.startActivities(new Intent[]{moveIntent});

            }
        });

    }
    public interface onClick {
        void onItemClicked(History data);

        void onItemClicked(View view, int position);
    }

    public interface OnItemClickCallback {
        void onItemClicked(History data);

        void onItemClicked(View view, int position);
    }

    @Override
    public int getItemCount() {
        return listHistory.size();
    }

    public ArrayList<History> getListHistory() {
        return listHistory;
    }

    public void setListHistory(ArrayList<History> listHistory) {
        this.listHistory = listHistory;
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName;
        TextView tvDetail;
        TextView tvRelease;

        ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvRelease = itemView.findViewById(R.id.tv_item_release);
            tvDetail = itemView.findViewById(R.id.tv_item_detail);
        }
    }

    public ListViewHolder onItemClickListener(@NonNull ViewGroup viewGroup, int viewtype ) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_detail, viewGroup, false);
        return new ListViewHolder(view);

    }
}

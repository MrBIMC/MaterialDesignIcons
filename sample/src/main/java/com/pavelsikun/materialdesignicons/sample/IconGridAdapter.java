package com.pavelsikun.materialdesignicons.sample;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Pavel Sikun on 07.06.16.
 */

public class IconGridAdapter extends RecyclerView.Adapter<IconGridAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout root;
        ImageView imageView;
        TextView name;

        public ViewHolder(View itemView) {
            super(itemView);
            root = (RelativeLayout) itemView.findViewById(R.id.root);
            imageView = (ImageView) itemView.findViewById(R.id.icon);
            name = (TextView) itemView.findViewById(R.id.name);
        }
    }

    private List<Pair<Integer, String>> data;

    public IconGridAdapter(List<Pair<Integer, String>> data) {
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_icon, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Pair<Integer, String> item = data.get(position);
        holder.name.setText(item.getSecond());

        holder.imageView.setImageResource(item.getFirst());
        holder.imageView.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP); //tinting drawable
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void add(Pair<Integer, String> item) {
        data.add(item);
    }

}

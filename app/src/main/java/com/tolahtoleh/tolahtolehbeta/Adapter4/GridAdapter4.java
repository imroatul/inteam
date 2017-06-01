package com.tolahtoleh.tolahtolehbeta.Adapter4;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tolahtoleh.tolahtolehbeta.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KING on 31/05/2017.
 */

public class GridAdapter4 extends RecyclerView.Adapter<GridAdapter4.ViewHolder> {

    List<EndangeredItem4> mItems;

    public GridAdapter4() {
        super();
        mItems = new ArrayList<EndangeredItem4>();
        EndangeredItem4 nama = new EndangeredItem4();
        nama.setName("gelang batu");
        nama.setHarga("Rp.25.000");
        nama.setWa("085775654126");
        nama.setThumbnail(R.drawable.gelang);
        mItems.add(nama);

        nama = new EndangeredItem4();
        nama.setName("pipa rokok kayu");
        nama.setHarga("Rp.10.000");
        nama.setWa("085775654126");
        nama.setThumbnail(R.drawable.pipa);
        mItems.add(nama);

        nama = new EndangeredItem4();
        nama.setName("gelang kayu");
        nama.setHarga("Rp.7.500");
        nama.setWa("085775654126");
        nama.setThumbnail(R.drawable.kayu);
        mItems.add(nama);

        nama = new EndangeredItem4();
        nama.setName("lampion tidur kelapa");
        nama.setHarga("Rp.70.000");
        nama.setWa("085775654126");
        nama.setThumbnail(R.drawable.lampu);
        mItems.add(nama);



    }










    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.grid_view, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        EndangeredItem4 nature = mItems.get(i);
        viewHolder.tvspecies.setText(nature.getName());
        viewHolder.tvspekta.setText(nature.getHarga());
        viewHolder.tvspek.setText(nature.getWa());

        viewHolder.imgThumbnail.setImageResource(nature.getThumbnail());
    }

    @Override
    public int getItemCount() {

        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder  {


        public ImageView imgThumbnail;
        public TextView tvspecies;
        public TextView tvspekta;
        public TextView tvspek;


        public ViewHolder(View itemView) {
            super(itemView);
            imgThumbnail = (ImageView)itemView.findViewById(R.id.img_thumbnail);
            tvspecies = (TextView)itemView.findViewById(R.id.status);
            tvspekta = (TextView)itemView.findViewById(R.id.nama);
            tvspek = (TextView)itemView.findViewById(R.id.wa);



        }
    }
}
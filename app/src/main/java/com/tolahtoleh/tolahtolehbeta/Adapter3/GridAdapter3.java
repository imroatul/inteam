package com.tolahtoleh.tolahtolehbeta.Adapter3;

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

public class GridAdapter3 extends RecyclerView.Adapter<GridAdapter3.ViewHolder> {

    List<EndangeredItem3> mItems;

    public GridAdapter3() {
        super();
        mItems = new ArrayList<EndangeredItem3>();
        EndangeredItem3 nama = new EndangeredItem3();
        nama.setName("batik hadiningrat");
        nama.setHarga("Rp.90.000");
        nama.setWa("085675123099");
        nama.setThumbnail(R.drawable.hadining);
        mItems.add(nama);

        nama = new EndangeredItem3();
        nama.setName("kaos jember");
        nama.setHarga("Rp.70.000");
        nama.setWa("085675123099");
        nama.setThumbnail(R.drawable.kaos);
        mItems.add(nama);

        nama = new EndangeredItem3();
        nama.setName("batik orange girls");
        nama.setHarga("Rp.120.000");
        nama.setWa("085675123099");
        nama.setThumbnail(R.drawable.orange);
        mItems.add(nama);

        nama = new EndangeredItem3();
        nama.setName("hem batik pria");
        nama.setHarga("Rp.86.000");
        nama.setWa("085675123099");
        nama.setThumbnail(R.drawable.hem);
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
        EndangeredItem3 nature = mItems.get(i);
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
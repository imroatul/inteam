package com.tolahtoleh.tolahtolehbeta.Adapter2;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tolahtoleh.tolahtolehbeta.Adapter2.EndangeredItem2;
import com.tolahtoleh.tolahtolehbeta.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KING on 31/05/2017.
 */

public class GridAdapter2 extends RecyclerView.Adapter<GridAdapter2.ViewHolder> {

    List<com.tolahtoleh.tolahtolehbeta.Adapter2.EndangeredItem2> mItems;

    public GridAdapter2() {
        super();
        mItems = new ArrayList<com.tolahtoleh.tolahtolehbeta.Adapter2.EndangeredItem2>();
        com.tolahtoleh.tolahtolehbeta.Adapter2.EndangeredItem2 nama = new com.tolahtoleh.tolahtolehbeta.Adapter2.EndangeredItem2();
        nama.setName("getuk");
        nama.setHarga("Rp.5000");
        nama.setWa("081337564234");
        nama.setThumbnail(R.drawable.getuk);
        mItems.add(nama);

        nama = new com.tolahtoleh.tolahtolehbeta.Adapter2.EndangeredItem2();
        nama.setName("chocholate jember");
        nama.setHarga("Rp.20.000");
        nama.setWa("081337564234");
        nama.setThumbnail(R.drawable.chocho);
        mItems.add(nama);

        nama = new com.tolahtoleh.tolahtolehbeta.Adapter2.EndangeredItem2();
        nama.setName("suwar-suwir");
        nama.setHarga("Rp.20.000");
        nama.setWa("081337564234");
        nama.setThumbnail(R.drawable.suwar);
        mItems.add(nama);

        nama = new com.tolahtoleh.tolahtolehbeta.Adapter2.EndangeredItem2();
        nama.setName("proll tape");
        nama.setHarga("Rp.16.000");
        nama.setWa("081337564234");
        nama.setThumbnail(R.drawable.proll);
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
        EndangeredItem2 nature = mItems.get(i);
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
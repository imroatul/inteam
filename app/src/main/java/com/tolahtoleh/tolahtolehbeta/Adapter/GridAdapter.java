package com.tolahtoleh.tolahtolehbeta.Adapter;

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

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.ViewHolder> {

    List<EndangeredItem> mItems;

    public GridAdapter() {
        super();
        mItems = new ArrayList<EndangeredItem>();
        EndangeredItem nama = new EndangeredItem();
        nama.setName("bandrek");
        nama.setHarga("Rp.3000");
        nama.setWa("081330373296");
        nama.setThumbnail(R.drawable.mibandrek);
        mItems.add(nama);

        nama = new EndangeredItem();
        nama.setName("es teler");
        nama.setHarga("Rp.5000");
        nama.setWa("081330373296");
        nama.setThumbnail(R.drawable.miesler);
        mItems.add(nama);

        nama = new EndangeredItem();
        nama.setName("saraba");
        nama.setHarga("Rp.4000");
        nama.setWa("081330373296");
        nama.setThumbnail(R.drawable.misaraba);
        mItems.add(nama);

        nama = new EndangeredItem();
        nama.setName("soto dahlok");
        nama.setHarga("Rp.6000");
        nama.setWa("081330373296");
        nama.setThumbnail(R.drawable.misotodahlok);
        mItems.add(nama);

        nama = new EndangeredItem();
        nama.setName("teh kocok");
        nama.setHarga("Rp.2000");
        nama.setWa("081330373296");
        nama.setThumbnail(R.drawable.mitehkocok);
        mItems.add(nama);

        nama = new EndangeredItem();
        nama.setName("teh talula");
        nama.setHarga("Rp.5000");
        nama.setWa("081330373296");
        nama.setThumbnail(R.drawable.mitehtalula);
        mItems.add(nama);

        nama = new EndangeredItem();
        nama.setName("wedang cor");
        nama.setHarga("Rp.3500");
        nama.setWa("081330373296");
        nama.setThumbnail(R.drawable.miwedcor);
        mItems.add(nama);

        nama = new EndangeredItem();
        nama.setName("angsle ronde");
        nama.setHarga("Rp.4000");
        nama.setWa("081330373296");
        nama.setThumbnail(R.drawable.miangsle);
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
        EndangeredItem nature = mItems.get(i);
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
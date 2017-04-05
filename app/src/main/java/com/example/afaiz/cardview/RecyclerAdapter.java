package com.example.afaiz.cardview;



        import android.content.Context;
        import android.support.v7.widget.RecyclerView;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Toast;

/**
 * Created by Junior on 16/07/2016.
 */
class RecyclerAdapter extends  RecyclerView.Adapter<RecyclerViewHolder> {

    //deklarasi variable context

    private final Context context;

    String [] name={"Apple","Facebook"};

    String [] keterangan={"Apple","Facebook"};

    int [] image={R.drawable.index,R.drawable.index};

    // menampilkan list item dalam bentuk text dengan tipe data string dengan variable name

    LayoutInflater inflater;
    public RecyclerAdapter(Context context) {
        this.context=context;
        inflater=LayoutInflater.from(context);
    }
    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=inflater.inflate(R.layout.item_list, parent, false);

        RecyclerViewHolder viewHolder=new RecyclerViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {

        holder.tv1.setText(name[position]);
        holder.tv2.setText(keterangan[position]);
        holder.imageView.setImageResource(image[position]);

        holder.tv1.setOnClickListener(clickListener);
        holder.tv2.setOnClickListener(clickListener);

        holder.tv1.setTag(holder);
        holder.tv2.setTag(holder);
    }

    View.OnClickListener clickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //member aksi saat cardview diklik berdasarkan posisi tertentu
            RecyclerViewHolder vholder = (RecyclerViewHolder) v.getTag();
            int position = vholder.getPosition();
            Toast.makeText(context, "Menu ini berada di posisi " + position, Toast.LENGTH_LONG).show();
        }
    };

    @Override
    public int getItemCount() {
        return name.length;
    }
}
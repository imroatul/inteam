package com.tolahtoleh.tolahtolehbeta.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tolahtoleh.tolahtolehbeta.Adapter.GridAdapter;
import com.tolahtoleh.tolahtolehbeta.Adapter3.GridAdapter3;
import com.tolahtoleh.tolahtolehbeta.R;

/**
 * Created by Ratan on 7/29/2015.
 */
public class PakaianFragment extends Fragment {
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;
    public PakaianFragment() {

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.pakaian_layout, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager  = new GridLayoutManager(getActivity(),2);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new GridAdapter3();
        mRecyclerView.setAdapter(mAdapter);

        return view ;
    }
}

package com.tolahtoleh.tolahtolehnew.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tolahtoleh.tolahtolehnew.R;

/**
 * Created by KING on 05/04/2017.
 */

public class PakaianFragment extends android.support.v4.app.Fragment {
    public PakaianFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pakaian, container, false);
    }
}

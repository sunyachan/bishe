package com.example.apple.jqjz.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.apple.jqjz.R;

/**
 * Created by apple on 16/12/31.
 */

public class LGPLFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.pager_hd,null);
        TextView tv= (TextView) view.findViewById(R.id.tv_hd);
        tv.setText("分馏炉炉管破裂");
        return view;
    }
}

package com.example.apple.jqjz.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.apple.jqjz.R;
import com.example.apple.jqjz.util.Util;

/**
 * Created by apple on 16/12/31.
 */

public class HDFragment extends Fragment {

//    String html="<p>装置</p><p>晃电</p>";
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.pager_hd,null);
        TextView textView= (TextView) view.findViewById(R.id.tv_hd);
        textView.setText(Util.COM_0);
        return view;

    }
}

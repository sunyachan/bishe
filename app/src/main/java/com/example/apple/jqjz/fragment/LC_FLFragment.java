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
 * Created by apple on 17/1/1.
 */

public class LC_FLFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.pager_hd,null);
        TextView textView= (TextView) view.findViewById(R.id.tv_hd);
        textView.setText("分馏岗位工艺流程");
        return view;
    }
}

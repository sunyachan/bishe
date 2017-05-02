package com.example.apple.jqjz.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.apple.jqjz.R;
import com.example.apple.jqjz.activity.LCActivity;

/**
 * Created by apple on 17/1/1.
 */

public class LCLeftFragment extends Fragment implements View.OnClickListener {


    TextView tv_fy;
    TextView tv_fl;
    View view;
    Fragment showFragment=null;
    String title;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.lc_left_menu, null);
        init();
        return view;
    }

    private void init() {
        tv_fy= (TextView) view.findViewById(R.id.tv_lc_fy);
        tv_fl= (TextView) view.findViewById(R.id.tv_lc_fl);
        tv_fy.setOnClickListener(this);
        tv_fl.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_lc_fy:
//                反应岗位工艺流程
                showFragment=new LC_FYFragment();
                title="反应岗位工艺流程";
                break;
            case R.id.tv_lc_fl:
//                分馏岗位工艺流程
                showFragment=new LC_FLFragment();
                title="分馏岗位工艺流程";
                break;

        }
        if (showFragment!=null){
            changeFragment(showFragment,title);
        }
    }

    private void changeFragment(Fragment showFragment, String title) {
        if (getActivity()==null){
            return;
        }
        if (getActivity() instanceof LCActivity){
            LCActivity lc= (LCActivity) getActivity();
            lc.setFragment(showFragment,title);
        }

    }
}

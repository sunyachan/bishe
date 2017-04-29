package com.example.apple.jqjz.activity;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.example.apple.jqjz.R;

import java.util.ArrayList;
import java.util.List;

public class JCActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView iv_1;
    View view1;
    View view2;
    List<View> viewList;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jc_vp);
        init();
        PagerAdapter pagerAdapter = new PagerAdapter() {

            @Override
            public int getCount() {
                return viewList.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view==object;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(viewList.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(viewList.get(position));
                return viewList.get(position);
            }
        };
        viewPager.setAdapter(pagerAdapter);
        iv_1.setOnClickListener(this);

    }

    private void init() {
        viewPager= (ViewPager) findViewById(R.id.jc_vp);
        LayoutInflater inflater = getLayoutInflater();
        view1=inflater.inflate(R.layout.activity_jc,null);
        view2=inflater.inflate(R.layout.activity_jc_2,null);
        viewList=new ArrayList<View>();
        viewList.add(view1);
        viewList.add(view2);
        iv_1= (ImageView) view1.findViewById(R.id.jc_1_1);
    }


//控制点点击事件
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.jc_1_1:
                showPop();
                break;
        }
    }


//显示popwindow
    private void showPop() {
        LayoutInflater inflate=(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflate.inflate(R.layout.pop_1, null);
        PopupWindow popupWindow = new PopupWindow(view, ViewPager.LayoutParams.WRAP_CONTENT,
                ViewPager.LayoutParams.WRAP_CONTENT);
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
        popupWindow.showAsDropDown(iv_1);
    }
}

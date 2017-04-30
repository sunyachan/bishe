package com.example.apple.jqjz.activity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apple.jqjz.R;
import com.example.apple.jqjz.bean.GVItem;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener ,AdapterView.OnItemClickListener{

    ImageView im_ys;
    ImageButton ib_set;
    GridView gv_menu;
    ArrayList<GVItem> mDatas;
    private final static String[] TITLES = new String[]{"监测画面", "实时数据", "工艺流程", "常见事故"};
    private final static int[] ICONS = new int[]{R.drawable.rjgj, R.drawable.lltj, R.drawable.jcgl, R.drawable.szzx};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        //初始化
        init();
        //设置动画
        ysAnimator();
        //设置GridView数据
        initGV();
        ib_set.setOnClickListener(this);
        gv_menu.setOnItemClickListener(this);
    }

    private void initGV() {
        mDatas = new ArrayList<GVItem>();
        for (int i = 0; i < TITLES.length; i++) {
            GVItem gvItem = new GVItem(ICONS[i], TITLES[i]);
            mDatas.add(gvItem);
        }
        gv_menu.setAdapter(new GVAdapter());
    }

// 设置按钮点击事件

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.ib_set:
                Intent intent = new Intent(getApplicationContext(), SetActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"点击设置按钮",Toast.LENGTH_LONG).show();
                break;
            default:
                break;

        }

    }

//gridview点击事件

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        switch (i){
            case 0:
                Intent intent2 = new Intent(getApplication(), JCActivity.class);
                startActivity(intent2);
               // Toast.makeText(getApplicationContext(),"监测画面",Toast.LENGTH_LONG).show();
                break;
            case 1:
                Intent intent3 = new Intent(getApplication(), DBActivity.class);
                startActivity(intent3);
//                Toast.makeText(getApplicationContext(),"数据查询",Toast.LENGTH_LONG).show();
                break;
            case 2:
                Intent intent1 = new Intent(MenuActivity.this, LCActivity.class);
                startActivity(intent1);
//              Toast.makeText(getApplicationContext(),"工艺流程",Toast.LENGTH_LONG).show();
                break;
            case 3:

                Intent intent = new Intent(MenuActivity.this, ComActivity.class);
                startActivity(intent);
                // Toast.makeText(getApplicationContext(),"常见事故",Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }

    }


    class GVAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return mDatas.size();
        }

        @Override
        public Object getItem(int i) {
            return mDatas.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View convertView, ViewGroup parent) {
//            =====================
            View view = View.inflate(getApplicationContext(), R.layout.gv_item, null);
            ImageView iv_gv_icon = (ImageView) view.findViewById(R.id.iv_gv_icon);
            TextView tv_gv_title = (TextView) view.findViewById(R.id.tv_gv_title);
            GVItem gvItem=mDatas.get(i);
            iv_gv_icon.setImageResource(gvItem.icon);
            tv_gv_title.setText(gvItem.name);
            return view;
        }
    }

    private void ysAnimator() {
        ObjectAnimator oa = ObjectAnimator.ofFloat(im_ys, "rotationY", 0, 360);
        oa.setDuration(2000);
        oa.setRepeatCount(ValueAnimator.INFINITE);
        oa.setRepeatMode(ValueAnimator.REVERSE);
        oa.start();
    }

    private void init() {
        im_ys = (ImageView) findViewById(R.id.im_ys);
        ib_set = (ImageButton) findViewById(R.id.ib_set);
        gv_menu = (GridView) findViewById(R.id.gv_menu);
    }
}

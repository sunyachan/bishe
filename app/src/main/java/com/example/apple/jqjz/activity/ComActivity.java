package com.example.apple.jqjz.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.apple.jqjz.R;
import com.example.apple.jqjz.fragment.ComLeftFragment;
import com.example.apple.jqjz.fragment.HDFragment;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingActivity;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

public class ComActivity extends SlidingFragmentActivity implements View.OnClickListener{

    private ImageView iv_topbtn;
    private TextView tv_toptitle;
    Fragment mCon;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initFragment(savedInstanceState);
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_com,new HDFragment()).commit();
        setContentView(R.layout.activity_com);
        setBehindContentView(R.layout.com_left);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_com_left,new ComLeftFragment()).commit();
        SlidingMenu sm = getSlidingMenu();
        // 设置可以左右滑动的菜单
        sm.setMode(SlidingMenu.LEFT);
        // 设置滑动阴影的宽度
        sm.setShadowWidthRes(R.dimen.shadow_width);
        // 设置滑动菜单阴影的图像资源
        sm.setShadowDrawable(null);
        // 设置滑动菜单视图的宽度
        sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        // 设置渐入渐出效果的值
        sm.setFadeDegree(0.35f);
        // 设置触摸屏幕的模式,这里设置为全屏
        sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        // 设置下方视图的在滚动时的缩放比例
        sm.setBehindScrollScale(0.0f);


//        初始化
        init();
        iv_topbtn.setOnClickListener(this);


    }
//初始化Fragment
    private void initFragment(Bundle savedInstanceState) {
        if (savedInstanceState!=null){
            mCon=getSupportFragmentManager().getFragment(savedInstanceState,"mCon");
        }
        if (mCon==null){
            //首Fragment
            mCon=new HDFragment();
        }

    }

    public void changeFragment(Fragment mCon, String title) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_com,mCon).commit();
        getSlidingMenu().showContent();
        tv_toptitle.setText(title);

    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //保存fragment状态
        getSupportFragmentManager().putFragment(outState,"mCon",mCon);
    }


    private void init() {
        iv_topbtn= (ImageView) findViewById(R.id.iv_topbtn);
        tv_toptitle= (TextView) findViewById(R.id.tv_toptitle);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_topbtn:
                toggle();
                break;
        }

    }
}

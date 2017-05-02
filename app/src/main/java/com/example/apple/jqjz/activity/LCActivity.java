package com.example.apple.jqjz.activity;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.apple.jqjz.R;
import com.example.apple.jqjz.fragment.HDFragment;
import com.example.apple.jqjz.fragment.LCLeftFragment;
import com.example.apple.jqjz.fragment.LC_FYFragment;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

public class LCActivity extends SlidingFragmentActivity implements View.OnClickListener{

    private ImageView tp_btn;
    private TextView tp_title;
    Fragment mSave=null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initFragment(savedInstanceState);
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_lc,new LC_FYFragment()).commit();
        setContentView(R.layout.activity_lc);
        initSliding();
        init();
    }
/*初始化Fragment*/
    private void initFragment(Bundle savedInstanceState) {

        if (savedInstanceState!=null){
            mSave=getSupportFragmentManager().getFragment(savedInstanceState,"mSave");
        }
        if (mSave==null){
            mSave=new LC_FYFragment();
        }

    }
/*初始化侧边栏*/
    private void initSliding() {
        setBehindContentView(R.layout.com_left);
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
        getSupportFragmentManager().beginTransaction().
                replace(R.id.fl_com_left,new LCLeftFragment()).commit();
    }
/*初始化*/
    private void init() {
        tp_btn= (ImageView) findViewById(R.id.iv_topbtn);
        tp_title= (TextView) findViewById(R.id.tv_toptitle);
        tp_title.setText("反应岗位工艺流程");
        tp_btn.setOnClickListener(this);
    }
/*点击事件*/
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_topbtn:
                toggle();
                break;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
//        保存Fragment
        getSupportFragmentManager().putFragment(outState,"mSave",mSave);

    }

    /*切换Fragment*/
    public void setFragment(Fragment mSave,String title){
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_lc,mSave).commit();
        getSlidingMenu().showContent();
        tp_title.setText(title);
    }
}

package com.example.apple.jqjz.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.apple.jqjz.R;

/**
 * Created by apple on 17/5/1.
 */

public class SetItemView extends RelativeLayout {
    TextView tvTitle;
    ImageView ivToggle;
    boolean isToggleOn;
    
    public SetItemView(Context context) {
        this(context,null);
    }

    public SetItemView(Context context, AttributeSet attrs) {
        this(context,attrs,-1);
    }

    public SetItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
//        初始化View
        initView(context);
        // 获取自定义的属性的值
        // 参1 要搜索的属性集 参2 要获取那些属性
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.SettingItemView);
        // 获取属性的值
        String title=typedArray.getString(R.styleable.SettingItemView_siTitle);
        int bgId=typedArray.getInt(R.styleable.SettingItemView_siBackground,0);
        boolean toggleshow=typedArray.getBoolean(R.styleable.SettingItemView_siToggle,true);
        typedArray.recycle();
        // 设置内容
        tvTitle.setText(title);
        // 设置背景
        switch (bgId){
            case 0:
                setBackgroundResource(R.drawable.first_selector);
                break;
            case 1:
                setBackgroundResource(R.drawable.middle_selector);
                break;
            case 2:
                setBackgroundResource(R.drawable.last_selector);
                break;
            default:
                break;
        }
//        右侧的开关是否显示
        ivToggle.setVisibility(toggleshow?View.VISIBLE:View.INVISIBLE);
    }

    public boolean isToggleOn(){
        return isToggleOn;
    }

    public  void setToggleOn(boolean isToggleOn){
        this.isToggleOn=isToggleOn;
//        根据开关属性值设置不同的开关图片
        ivToggle.setImageResource(isToggleOn?R.drawable.on:R.drawable.off);
    }

    /*开关切换*/
    public void toggle(){
        setToggleOn(!isToggleOn);
    }


/**初始化View*/
    private void initView(Context context) {
        View.inflate(context, R.layout.view_setting_item,this);
        tvTitle= (TextView) findViewById(R.id.tv_siv_title);
        ivToggle= (ImageView) findViewById(R.id.iv_siv_toggle);

    }
}

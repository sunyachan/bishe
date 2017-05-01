package com.example.apple.jqjz.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.apple.jqjz.R;
import com.example.apple.jqjz.service.MyService;
import com.example.apple.jqjz.util.Constants;
import com.example.apple.jqjz.util.PreferenceUtils;
import com.example.apple.jqjz.view.SetItemView;

public class SetActivity extends AppCompatActivity implements View.OnClickListener{


    public static Context content;
//    Boolean flag;
    SetItemView sivBackRun;
    SetItemView sivReceive;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);
        init();

    }

    private void init() {
        content=getApplicationContext();
        sivBackRun= (SetItemView) findViewById(R.id.siv_set_br);
        sivReceive= (SetItemView) findViewById(R.id.siv_set_receive);
        sivBackRun.setOnClickListener(this);
        sivReceive.setOnClickListener(this);

//        回显开关数据
        boolean isBackRun= PreferenceUtils.getBoolean(getApplicationContext(),
                Constants.BACK_RUNNING,true);
        sivBackRun.setToggleOn(isBackRun);
        boolean isReceive=PreferenceUtils.getBoolean(getApplicationContext(),
                Constants.RECEIVE_MSG,true);
        sivReceive.setToggleOn(isReceive);

//        flag=false;

    }

    @Override
    public void onClick(View view) {
//        Intent intent = new Intent(getApplicationContext(), MyService.class);
        switch (view.getId()){
            case R.id.siv_set_br:
                //开关切换
                sivBackRun.toggle();
                PreferenceUtils.putBoolean(getApplicationContext(),
                        Constants.BACK_RUNNING,sivBackRun.isToggleOn());
                //sivBackRun关闭时sivReceive的状态也需是关闭的
                if (!sivBackRun.isToggleOn()){
                    if (sivReceive.isToggleOn()){
                        sivReceive.toggle();
                        PreferenceUtils.putBoolean(getApplicationContext(),
                                Constants.RECEIVE_MSG, sivReceive.isToggleOn());
                    }
                }
                break;
            case R.id.siv_set_receive:
                if (sivBackRun.isToggleOn()) {
                    sivReceive.toggle();
                    PreferenceUtils.putBoolean(getApplicationContext(),
                            Constants.RECEIVE_MSG, sivReceive.isToggleOn());
                }else {
                    Toast.makeText(getApplicationContext(),"该功能需要先开启后台运行",
                            Toast.LENGTH_LONG).show();
                }
                break;
            default:
                break;
//            case R.id.bt_start:
//                flag=true;
//                //startService(intent);
////                Toast.makeText(getApplicationContext(),"开启",Toast.LENGTH_LONG).show();
////                Log.i("sun","开启");
//                break;
//            case R.id.bt_stop:
//                flag=false;
//                stopService(intent);
////                Toast.makeText(getApplicationContext(),"关闭",Toast.LENGTH_LONG).show();
////                Log.i("sun","关闭");
//                break;
//            default:
//                break;
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (false){
            Intent intent = new Intent(getApplicationContext(), MyService.class);
            startService(intent);
        }
    }
}

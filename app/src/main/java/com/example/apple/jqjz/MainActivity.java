package com.example.apple.jqjz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.apple.jqjz.activity.LoginActivity;
import com.example.apple.jqjz.activity.RegisterActivity;

public class MainActivity extends AppCompatActivity {

    Button bt_1;
    Button bt_2;
//    Toast ts;
    myclick mclick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mclick = new myclick();
        init();
        click();
    }

    private void click() {
        bt_1.setOnClickListener(mclick);
        bt_2.setOnClickListener(mclick);
    }

    //初始化
    private void init() {
        bt_1 = (Button) findViewById(R.id.bt_dl);
        bt_2 = (Button) findViewById(R.id.bt_zc);
        mclick = new myclick();
    }

    class myclick implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.bt_dl:
//                    ts = Toast.makeText(MainActivity.this, "点击登录", Toast.LENGTH_SHORT);
//                    ts.show();
//                    打开登录页面
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                    break;
                case R.id.bt_zc:
//                    ts = Toast.makeText(MainActivity.this, "点击注册", Toast.LENGTH_SHORT);
//                    ts.show();
//                    打开注册页面
                    Intent intent2 = new Intent(MainActivity.this, RegisterActivity.class);
                    startActivity(intent2);
                    break;
                default:
                    break;
            }
        }
    }


}

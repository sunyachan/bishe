package com.example.apple.jqjz.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apple.jqjz.R;
import com.example.apple.jqjz.web.WebService;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    Button bt_log;
    EditText et_name;
    EditText et_psw;

//    返回的数据
    String info;

    //返回主线程更新数据
    Handler handler=new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        bt_log.setOnClickListener(this);
    }

    private void init() {
        bt_log= (Button) findViewById(R.id.bt_lg);
        et_name= (EditText) findViewById(R.id.et_lg_user);
        et_psw= (EditText) findViewById(R.id.et_lg_ps);
    }

    @Override
    public void onClick(View view) {
        
        switch (view.getId()){
            case R.id.bt_lg:
                //联网获取数据
                String name=et_name.getText().toString();
                String password = et_psw.getText().toString();
                logxUtils(name,password);
               // conLogData();
                break;
        }
        
    }

    private void logxUtils(String name, String password) {
        String path = "http://10.3.231.139:8080" + "/helloweb/LogLet";
        path=path+"?name="+name+"&password="+password;
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.send(HttpRequest.HttpMethod.GET, path, new RequestCallBack<String>() {
                    @Override
                    public void onSuccess(ResponseInfo<String> responseInfo) {
                        Log.d("sun",responseInfo.result);
                        //根据返回结果刷新UI界面
                        showUI(responseInfo.result);
                    }

                    @Override
                    public void onFailure(HttpException e, String s) {
                        Log.d("sun","请求失败");
                    }
                }
        );
    }
    //根据返回结果刷新UI界面
    private void showUI(String result) {
        if (result.isEmpty()){
            //如果返回结果为空登录失败
            Toast.makeText(LoginActivity.this,"用户名或密码错误请重新登录",Toast.LENGTH_SHORT).show();
        }else {
            //登录成功跳转页面
            Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
            startActivity(intent);
        }
    }

    //联网获取数据
    private void conLogData() {
        Toast.makeText(LoginActivity.this,"正在登录请稍后",Toast.LENGTH_SHORT).show();
//          创建子线程进行GET请求
        new Thread(new MyThread()).start();

    }

    class MyThread implements Runnable{

        @Override
        public void run() {
            try {
                Log.v("sun","===========");
                info= WebService.executeHttpGet(et_name.getText().toString(),et_psw.getText().toString());

                Log.d("sun",info);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

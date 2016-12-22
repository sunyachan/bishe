package com.example.apple.jqjz.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.apple.jqjz.R;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{


    EditText rg_name;
    EditText rg_password;
    Button bt_reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
        bt_reg.setOnClickListener(this);
    }
//初始化
    private void init() {
        rg_name= (EditText) findViewById(R.id.et_re_user);
        rg_password= (EditText) findViewById(R.id.et_re_ps);
        bt_reg= (Button) findViewById(R.id.bt_reg);
    }

    @Override
    public void onClick(View view) {
        String name=rg_name.getText().toString();
        String password=rg_password.getText().toString();
        String url="http://10.3.231.139:8080/helloweb/RegLet";
        HttpUtils httpUtils = new HttpUtils();
        RequestParams params = new RequestParams();
        params.addBodyParameter("name",name);
        params.addBodyParameter("password",password);
        httpUtils.send(HttpRequest.HttpMethod.POST, url, params,
                new RequestCallBack<String>() {
                    @Override
                    public void onSuccess(ResponseInfo<String> responseInfo) {
//                          网络请求成功
                        //根据返回结果刷新UI界面
                        updateUI(responseInfo.result);


                    }

                    @Override
                    public void onFailure(HttpException e, String s) {
//                        网络请求失败
                        Toast.makeText(RegisterActivity.this,"注册失败请检查网络连接",
                                Toast.LENGTH_SHORT).show();
                    }
                });


    }

    private void updateUI(String result) {
        if (result.isEmpty()){
            Toast.makeText(RegisterActivity.this,"改用户名已存在，请重新注册...",
                    Toast.LENGTH_SHORT).show();

        }else {
            Intent intent = new Intent(RegisterActivity.this, MenuActivity.class);
            startActivity(intent);

        }

    }
}

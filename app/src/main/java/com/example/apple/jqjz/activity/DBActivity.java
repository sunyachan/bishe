package com.example.apple.jqjz.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apple.jqjz.R;
import com.example.apple.jqjz.bean.JQdb;
import com.example.apple.jqjz.util.Util;
import com.google.gson.Gson;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import java.util.ArrayList;
import java.util.List;

public class DBActivity extends AppCompatActivity {
    TextView text;
    ListView lv;
    JQdb jqdb;
    List<String> list1;
    List<String> list2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);
//        初始化
        init();
        QueryDb();
    }

    private void init() {
        text= (TextView) findViewById(R.id.db_cs);
        lv= (ListView) findViewById(R.id.db_lv);
        list1=new ArrayList<String>(){

        };
        list2=new ArrayList<String>(){

        };
    }
//网络连接。查询数据
    public void QueryDb() {
        String path="http://"+ Util.IP+":8080/jqweb/QueryLet";
        HttpUtils httpUtils = new HttpUtils();
        RequestParams params = new RequestParams();
        params.addBodyParameter("sql","select*from jqdb");
        httpUtils.send(HttpRequest.HttpMethod.POST, path, params, new RequestCallBack<String>() {

            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String json=responseInfo.result;
                parseJson(json);
                //刷新UI界面
                text.setText(jqdb.toString());
            }

            @Override
            public void onFailure(HttpException e, String s) {
                Toast.makeText(getApplicationContext(),"请求失败，请检查网络设置",Toast.LENGTH_LONG).show();
            }
        });

    }
//解析Json数据
    private void parseJson(String json) {
        jqdb=new JQdb();
        Gson gson = new Gson();
        jqdb=gson.fromJson(json, JQdb.class);

    }
}

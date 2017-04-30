package com.example.apple.jqjz.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
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

public class DBActivity extends AppCompatActivity {
//    TextView text;
    ListView lv;
    JQdb jqdb;
    String[] str1;
    String[] str2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);
//        初始化
        init();
        QueryDb();
    }

    private void init() {
//        text= (TextView) findViewById(R.id.db_cs);
        lv= (ListView) findViewById(R.id.db_lv);
        str1=new String[]{"PI201","TI201","TIC202","PI211","TI208","PI207","PI208",
                "TIC203","PI202","LIC202","PI206","TIC201","PI212","PIC101","PI106"};
        str2=new String[]{"Pa","℃","℃","MPa","℃","Mpa","Mpa","℃","Mpa",
                "%","MPa","℃","MPa","MPa","MPa"};
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
                showUI();
            }

            @Override
            public void onFailure(HttpException e, String s) {
                Toast.makeText(getApplicationContext(),"请求失败，请检查网络设置",Toast.LENGTH_LONG).show();
            }
        });

    }
//    ListView填充
    private void showUI() {
        lv.setAdapter(new MyAdapter(getApplicationContext()));
    }

    //解析Json数据
    private void parseJson(String json) {
        jqdb=new JQdb();
        Gson gson = new Gson();
        jqdb=gson.fromJson(json, JQdb.class);

    }
    class  MyAdapter extends BaseAdapter{
        private Context context;

        public MyAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return str1.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder holder;
            if (view==null){
                holder=new ViewHolder();
                view=getLayoutInflater().inflate(R.layout.db_lv_item,null);
                holder.tv1= (TextView) view.findViewById(R.id.db_item_name);
                holder.tv2= (TextView) view.findViewById(R.id.db_item_value);
                holder.tv3= (TextView) view.findViewById(R.id.db_item_nuit);
                view.setTag(holder);
            }else {
                holder= (ViewHolder) view.getTag();
            }
            holder.tv1.setText(str1[i]);
            holder.tv2.setText(jqdb.get(i));
            holder.tv3.setText(str2[i]);
            return view;
        }
    }
    static class  ViewHolder{
        public TextView tv1;
        public TextView tv2;
        public TextView tv3;
    }
}

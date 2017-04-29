package com.example.apple.jqjz.web;

import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by apple on 16/12/4.
 */
public class WebService {
    private  static  String IP="192.168.1.102:8080";
    //通过Get方式获取Http服务器数据
    public static  String executeHttpGet(String name,String password) throws Exception {
        Log.d("sun","开始网络连接-------");
        HttpURLConnection con=null;
        InputStream is=null;
        try{
            Log.d("sun","－－－－－－");
            //用户名 密码 URL 地址
            String path = "http://" + IP + "/helloweb/LogLet";
            path=path+"?name="+name+"&password="+password;
            Log.d("sun",path);
            con=(HttpURLConnection)new URL(path).openConnection();
            con.setConnectTimeout(3000);//设置超时时间
            con.setReadTimeout(3000);
            con.setDoInput(true);
            con.setRequestMethod("GET");//设置请求方式
            con.setRequestProperty("Charset","UTF-8");//设置接受数据编码格式
            if (con.getResponseCode()==200){
                Log.d("sun","网络连接成功");
                is=con.getInputStream();
                return parseInfo(is);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

            if (con!=null){
                con.disconnect();
            }
            if (is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        Log.d("sun","网络失败");

        return null;


    }
//将输入流转化为String型
    private static String parseInfo(InputStream is) throws Exception {
        byte[] data=read(is);
        //转化为字符串
        return  new String(data,"UTF-8");

    }
//将输入流转化为Byte型
    private static byte[] read(InputStream is) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len=0;
        while ((len=is.read(buffer))!=-1){
            outputStream.write(buffer,0,len);
        }
        is.close();
        return outputStream.toByteArray();
    }
}

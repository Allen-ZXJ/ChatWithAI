package com.zxj.chatwithai;

import android.app.Application;
import android.util.Log;

import com.zxj.chatwithai.bean.ChatMessage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author zxj
 * @ 2023/8/6
 */
public class ChatApplication extends Application {

    private static String authorization; //请求的authorization
    private static String organization; //请求的organization
    @Override
    public void onCreate() {
        super.onCreate();
        //获取请求API需要的Header
        new Thread(()->{
            try {
                InputStream stream = getAssets().open("header.properties");
                BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
                String data;
                String[] header = new String[2];
                int cnt = 0;
                while((data = reader.readLine())!=null){
                    header[cnt++] = data.split("=")[1];
                }
                authorization = header[0];
                organization = header[1];
                Log.d("ChatApplication", "authorization = " + header[0]);
                Log.d("ChatApplication", "organization = " + header[1]);
            } catch (IOException e) {
                Log.d("ChatApplication", "异常：" + e.getMessage());
            }

        }).start();
    }

    public static String getAuthorization() {
        return authorization;
    }

    public static String getOrganization() {
        return organization;
    }
}

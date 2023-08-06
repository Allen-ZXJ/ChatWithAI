package com.zxj.chatwithai.utils;

import androidx.annotation.NonNull;

import com.zxj.chatwithai.RespCallBack;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * 网络请求的简单工具类
 *
 * @author zxj
 * @ 2023/8/6
 */
public class NetworkUtils {

    private static OkHttpClient mHttpClient;
    static {
        mHttpClient =new OkHttpClient.Builder()
                .callTimeout(10000, TimeUnit.SECONDS)
                .connectTimeout(10000,TimeUnit.SECONDS)
                .readTimeout(10000, TimeUnit.SECONDS)
                .writeTimeout(10000,TimeUnit.SECONDS)
                .build();
    }

    public static Response execute(Request request){
        try {
            return mHttpClient.newCall(request).execute();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static void enqueue(Request request, RespCallBack mCallBack){

         mHttpClient.newCall(request).enqueue(new Callback() {
             @Override
             public void onFailure(@NonNull Call call, @NonNull IOException e) {
                 mCallBack.failed(e.getMessage());
             }

             @Override
             public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                 if(response.code() == 200){
                     mCallBack.succeed(response.body().string());
                 }else{
                     mCallBack.failed(response.body().string() + "\n" + response.code());
                 }
             }
         });
    }



}

package com.srz.utiltools.net;

import android.util.Log;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * //                    .::::.
 * //                  .::::::::.
 * //                 :::::::::::  FUCK YOU
 * //             ..:::::::::::'
 * //           '::::::::::::'
 * //             .::::::::::
 * //        '::::::::::::::..
 * //             ..::::::::::::.
 * //           ``::::::::::::::::
 * //            ::::``:::::::::'        .:::.
 * //           ::::'   ':::::'       .::::::::.
 * //         .::::'      ::::     .:::::::'::::.
 * //        .:::'       :::::  .:::::::::' ':::::.
 * //       .::'        :::::.:::::::::'      ':::::.
 * //      .::'         ::::::::::::::'         ``::::.
 * //  ...:::           ::::::::::::'              ``::.
 * // ```` ':.          ':::::::::'                  ::::..
 * //                    '.:::::'                    ':'````..
 * ===========================================================
 * You may think you know what the following code does.
 * But you dont. Trust me.
 * Fiddle with it, and youll spend many a sleepless
 * night cursing the moment you thought youd be clever
 * enough to "optimize" the code below.
 * Now close this file and go play with something else.
 * <p>
 * 2019/12/18 12:45 星期三
 **/
public class HttpInterceptor implements Interceptor {


    private Map<String,String> headerMap;
    private static final String TAG = "HttpInterceptor";


    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request originalRequest = chain.request();
        HttpUrl originalHttpUrl = originalRequest.url();

        HttpUrl.Builder builder = originalHttpUrl.newBuilder();

        if (headerMap!=null&&headerMap.size()>0){
            for (String key:headerMap.keySet()) {
                builder.addQueryParameter(key,headerMap.get(key));
            }
            Log.v(TAG,"-");
        }
        HttpUrl url = builder.build();
        Request request = originalRequest.newBuilder()
                .url(url)
                .method(originalRequest.method(), originalRequest.body())
                .build();

        return chain.proceed(request);
    }

    public void setHeader(Map<String,String> headerMap){
        this.headerMap=headerMap;
    }

    public Map<String,String> getMap(){
        Map<String,String> map =new HashMap<>();
        map.put("Content-Type","application/json;charset=utf-8");
        map.put("mac","A89CED82308C");
        map.put("token","eyJhbGciOiJIUzI1NiJ9.eyJhdXRob3JpdGllcyI6IuinkuiJsuWIl-ihqCIsInN1YiI6IjE4MjEwNDcwMjcxIiwiZXhwIjoxNTc3MDYzODEwfQ.sPp1OR4Mirg1zN_Wf3vZU6SX1JowWtozqN5Pjgt2n04");
        map.put("filmId","123456");
        map.put("userId","18210470271");
        return map;
    }
}

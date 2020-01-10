package com.srz.utiltools.net;

import com.google.gson.Gson;
import com.srz.utiltools.BaseApplication;
import com.srz.utiltools.R;
import com.srz.utiltools.net.impl.IHttp;
import com.srz.utiltools.net.ssl.SSLContextMannage;

import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import javax.net.ssl.X509TrustManager;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

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
 * 2020/01/10 16:14 星期五
 **/
public class OkHttpUtils implements IHttp {


    private static OkHttpUtils okHttpUtils;
    private static OkHttpClient.Builder okHttpClientBuilder;
    private OkHttpClient okHttpClient;
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private HttpLoggingInterceptor httpLoggingInterceptor;
    private long readTimOut = 10;
    private long writeTimeOut = 10;
    private long connectTimeout = 10;

    public static OkHttpUtils getInstance() {

        if (okHttpUtils == null) {
            synchronized (OkHttpUtils.class) {
                if (okHttpUtils == null) {
                    okHttpUtils = new OkHttpUtils();
                }

            }
        }
        return okHttpUtils;
    }

    private OkHttpUtils() {
        getOkHttpClient();
    }

    public OkHttpClient getOkHttpClient() {
        httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLogInterceptor());
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        okHttpClientBuilder = new OkHttpClient.Builder();
        okHttpClientBuilder
                .sslSocketFactory(SSLContextMannage.getInstance(), (X509TrustManager) SSLContextMannage.getTrustManagers())
                .hostnameVerifier(hostnameVerifier)
                .addInterceptor(new HttpInterceptor())
                .addInterceptor(httpLoggingInterceptor)
                .connectTimeout(connectTimeout, TimeUnit.SECONDS)
                .readTimeout(readTimOut, TimeUnit.SECONDS)
                .writeTimeout(writeTimeOut, TimeUnit.SECONDS);
        okHttpClient = okHttpClientBuilder.build();
        return okHttpClient;
    }


    private HostnameVerifier hostnameVerifier = new HostnameVerifier() {
        @Override
        public boolean verify(String s, SSLSession sslSession) {
            return true;
        }
    };

    @Override
    public <T> void postRequest(String url, Map<String, String> params, NetworkCallback<T> callback) {


    }

    @Override
    public <T> void postHeaderRequest(String url, Map<String, String> params, NetworkCallback<T> callback) {

    }

    @Override
    public <T> void postBodyRequest(String url, Map<String, String> params, final NetworkCallback<T> callback) {
        RequestBody body = RequestBody.create("{}", JSON);
        Request.Builder builder = new Request.Builder();
        if (params != null && params.size() > 0) {
            for (String key : params.keySet()) {
                builder.addHeader(key, params.get(key));
            }
        }
        Request build = builder.url(url)
                .post(body)
                .build();
        okHttpClient.newCall(build).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull final Call call, @NotNull final IOException e) {

                BaseApplication.getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.fail(e.getMessage());
                    }
                });
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull final Response response) {

                final String jsonData = response.body().toString();


                BaseApplication.getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        callback.success(getGeneric(jsonData, callback));
                    }
                });
            }
        });

    }

    @Override
    public <T> void getRequest(String url, Map<String, String> params, NetworkCallback<T> callback) {

    }

    @Override
    public <T> void getHeaderRequest(String url, Map<String, String> params, NetworkCallback<T> callback) {

    }

    private <T> T getGeneric(String jsonData, NetworkCallback<T> callBack) {
        Gson gson = new Gson();
        //通过反射获取泛型的实例
        Type[] types = callBack.getClass().getGenericInterfaces();
        Type[] actualTypeArguments = ((ParameterizedType) types[0]).getActualTypeArguments();
        Type type = actualTypeArguments[0];
        T t = gson.fromJson(jsonData, type);
        return t;
    }
}

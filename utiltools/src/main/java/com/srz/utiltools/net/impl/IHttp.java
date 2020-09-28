package com.srz.utiltools.net.impl;

import java.util.Map;

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
 * 2020/01/10 16:04 星期五
 **/
public interface IHttp {


    <T> void postRequest(String url, Map<String,String> params, NetworkCallback<T> callback);

    <T> void postHeaderRequest(String url, Map<String,String> params, NetworkCallback<T> callback);

    <T> void postBodyRequest(String url, Map<String,String> params, NetworkCallback<T> callback);


    <T> void getRequest(String url, Map<String,String> params, NetworkCallback<T> callback);

    <T> void getHeaderRequest(String url, Map<String,String> params, NetworkCallback<T> callback);




}

package com.srz.utiltools;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.srz.utiltools.base.BaseActivity;
import com.srz.utiltools.util.SLog;

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
 * 2020/01/10 15:24 星期五
 **/
public class BaseApplication extends Application {

    private static Context context=null;
    public static BaseActivity baseActivity=null;

    @Override
    public void onCreate() {
        super.onCreate();
        context =getApplicationContext();
        SLog.isDebug(true);

    }

    public static Context getContext(){
        return context;
    }

    public static Activity getActivity(){
        return baseActivity;
    }
}

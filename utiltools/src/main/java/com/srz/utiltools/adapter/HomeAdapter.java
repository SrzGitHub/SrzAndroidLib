package com.srz.utiltools.adapter;

import android.content.Context;
import android.view.View;

import com.srz.utiltools.R;

import java.util.List;

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
 * 2020/01/15 16:59 星期三
 **/
public class HomeAdapter extends BaseRecyclerViewAdapter<String> {


    public HomeAdapter(List<String> listData, Context context) {
        super(listData, context);
    }

    @Override
    public int getLayoutId() {
        return 0;
    }

    @Override
    public void converView(BaseRecyclerViewHolder holder, String data, int posision) {

        View view = holder.getView(R.id.mViewId);
    }
}

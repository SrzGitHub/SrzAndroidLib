package com.srz.utiltools.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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
 * 2020/01/15 16:33 星期三
 **/
public abstract class BaseRecyclerViewAdapter<D> extends RecyclerView.Adapter<BaseRecyclerViewHolder> {

    private List<D> listData;
    private Context context;
    private final LayoutInflater layoutInflater;
    private BaseRecyclerViewHolder.OnItemClickListener itemClickListener;
    private BaseRecyclerViewHolder baseRecyclerViewHolder;

    public BaseRecyclerViewAdapter(List<D> listData, Context context) {
        super();
        this.listData = listData;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    public abstract int getLayoutId();

    public abstract void converView(BaseRecyclerViewHolder holder, D data, int posision);


    @NonNull
    @Override
    public BaseRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        baseRecyclerViewHolder = new BaseRecyclerViewHolder(layoutInflater.inflate(getLayoutId(), parent, false));
        baseRecyclerViewHolder.setItemClickListener(itemClickListener);
        return baseRecyclerViewHolder;
    }



    public void setData(List<D> listData) {
        this.listData = listData;
        notifyDataSetChanged();
    }

    public void setItemClickListener(BaseRecyclerViewHolder.OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseRecyclerViewHolder holder, int position) {

        converView(holder, listData.get(position), position);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }
}

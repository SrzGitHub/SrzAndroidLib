package com.srz.utiltools.adapter;

import android.util.SparseArray;
import android.view.View;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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
public class BaseRecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


    private SparseArray<View> viewSparseArray = new SparseArray<>();
    private OnItemClickListener itemClickListener;
    private int mPosition = -1;


    public BaseRecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);

    }

    public <T extends View> T getView(int id) {

        View subview = viewSparseArray.get(id);
        if (subview == null) {
            subview = itemView.findViewById(id);
            viewSparseArray.put(id, subview);
        }
        return (T) subview;
    }


    public void setItemClickListener(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public void setPosition(int position) {
        mPosition = position;
    }

    @Override
    public void onClick(View view) {

        if (itemClickListener != null) {
            int position = getAdapterPosition();
            if (position >= 0) {
                itemClickListener.onItemClick(position, getItemId());
            } else if (mPosition > -1) {
                itemClickListener.onItemClick(mPosition, getItemId());
            }
        }

    }

    public interface OnItemClickListener {
        void onItemClick(int position, long itemViewId);
    }


}

package com.srz.widget;

import android.content.Context;

import com.srz.utiltools.adapter.BaseRecyclerViewAdapter;
import com.srz.utiltools.adapter.BaseRecyclerViewHolder;

import java.util.List;

public class BasAdapter extends BaseRecyclerViewAdapter<Bean> {


    public BasAdapter(List<Bean> listData, Context context) {
        super(listData, context);
    }

    @Override
    public int getLayoutId() {
        return 0;
    }

    @Override
    public void converView(BaseRecyclerViewHolder holder, Bean data, int posision) {

    }
}

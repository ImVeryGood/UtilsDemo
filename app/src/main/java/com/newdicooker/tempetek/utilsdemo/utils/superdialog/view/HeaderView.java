package com.newdicooker.tempetek.utilsdemo.utils.superdialog.view;


import android.content.Context;

import com.newdicooker.tempetek.utilsdemo.utils.superdialog.callback.ProviderHeader;
import com.newdicooker.tempetek.utilsdemo.utils.superdialog.res.drawable.BgHeader;


/**
 * Created by hupei on 2016/3/8 19:29.
 */
class HeaderView extends SuperTextView {

    public HeaderView(Context context, Controller.Params params) {
        super(context);
        initData(params);
    }

    private void initData(Controller.Params params) {
        ProviderHeader providerHeader = params.mProviderHeader;
        setText(providerHeader.getTitle());
        setTextSize(providerHeader.getTextSize());
        setHeight(providerHeader.getHeight());
        setTextColor(providerHeader.getTextColor());
        //背景
        setBackgroundDrawable(new BgHeader(params));
    }
}

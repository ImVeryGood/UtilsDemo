package com.newdicooker.tempetek.utilsdemo.utils.superdialog.callback;


import com.newdicooker.tempetek.utilsdemo.utils.superdialog.res.values.DimenRes;

/**
 * Created by hupei on 2016/3/10 15:04.
 */
public abstract class ProviderFooter extends Provider {

    public abstract void dismiss();

    public abstract int getTextColor();

    public int getTextSize() {
        return DimenRes.footerTextSize;
    }


    public int getHeight() {
        return DimenRes.footerHeight;
    }
}

package com.newdicooker.tempetek.utilsdemo.utils.superdialog.callback;


import com.newdicooker.tempetek.utilsdemo.utils.superdialog.SuperDialog;

/**
 * Created by hupei on 2017/3/21
 */
public abstract class ProviderFooterPositiveInput extends ProviderFooterPositive {
    @Override
    public final SuperDialog.OnClickPositiveListener getOnPositiveListener() {
        return null;
    }

    public abstract SuperDialog.OnClickPositiveInputListener getOnPositiveInputListener();
}

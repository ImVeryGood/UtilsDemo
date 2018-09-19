package com.newdicooker.tempetek.utilsdemo.utils.superdialog.callback;


/**
 * Created by hupei on 2017/3/21
 */
public abstract class ProviderContentSingle extends ProviderContent {

    public abstract int[] getPadding();

    @Override
    public String getItems() {
        return null;
    }

    @Override
    public Mode getMode() {
        return Mode.SINGLE;
    }
}

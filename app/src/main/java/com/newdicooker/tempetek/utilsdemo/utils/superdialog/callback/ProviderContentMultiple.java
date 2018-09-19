package com.newdicooker.tempetek.utilsdemo.utils.superdialog.callback;


import com.newdicooker.tempetek.utilsdemo.utils.superdialog.SuperDialog;

/**
 * Created by hupei on 2017/3/21
 */
public abstract class ProviderContentMultiple extends ProviderContent {
    public abstract SuperDialog.OnItemClickListener getItemClickListener();

    public abstract void dismiss();

    public abstract int getItemHeight();

    @Override
    public Object getItems() {
        return null;
    }

    @Override
    public Mode getMode() {
        return Mode.MULTIPLE;
    }
}

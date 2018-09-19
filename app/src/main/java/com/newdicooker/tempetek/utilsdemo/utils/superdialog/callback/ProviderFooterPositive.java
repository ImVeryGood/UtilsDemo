package com.newdicooker.tempetek.utilsdemo.utils.superdialog.callback;


import com.newdicooker.tempetek.utilsdemo.utils.superdialog.SuperDialog;
import com.newdicooker.tempetek.utilsdemo.utils.superdialog.res.values.ColorRes;

/**
 * Created by hupei on 2016/3/10 15:05.
 */
public abstract class ProviderFooterPositive extends ProviderFooter {
    public abstract SuperDialog.OnClickPositiveListener getOnPositiveListener();

    public int getTextColor() {
        return ColorRes.positiveButton;
    }
}

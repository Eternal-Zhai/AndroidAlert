package com.eternal.alert.conventional;

import android.content.Context;

import com.eternal.alert.abs.AbstractAlert;
import com.eternal.alert.base.AlertWrapper;
import com.eternal.alert.base.BaseAlert;
import com.eternal.alert.wrapper.ThirdPartyPackageAlertWrapper;

import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Created by Eternal on 05/15/2017.
 */

public class Alert extends AbstractAlert<SweetAlertDialog, Alert> {


    private Alert() {
        super();
        mAlert = this;
    }

    public static Alert create(Context context) {
        return create(context, NORMAL_TYPE);
    }

    public static Alert create(Context context, int alertType) {
        return create(context, null, null, alertType);
    }

    public static Alert createByTitle(Context context, CharSequence title) {
        return createByTitle(context, title, NORMAL_TYPE);
    }

    public static Alert createByTitle(Context context, CharSequence title, int alertType) {
        return create(context, title, null, alertType);
    }

    public static Alert createByMsg(Context context, CharSequence msg) {
        return createByMsg(context, msg, NORMAL_TYPE);
    }

    public static Alert createByMsg(Context context, CharSequence msg, int alertType) {
        return create(context, null, msg, alertType);
    }

    public static Alert create(Context context, CharSequence title, CharSequence msg) {
        return create(context, title, msg, NORMAL_TYPE);
    }

    public static Alert create(Context context, CharSequence title, CharSequence msg, int alertType) {

        Alert alert = new Alert();
        alert.createAlert(context, title, msg, alertType);

        return alert;
    }


    //----------Override----------

    @Override
    public Alert createAlert(Context context, CharSequence title, CharSequence msg, int alertType) {

        mAlertWrapper = new ThirdPartyPackageAlertWrapper(this);
        mAlertWrapper.create(context, title, msg, alertType);

        return this;
    }

    @Override
    public SweetAlertDialog getOriginalAlert() {
        return super.getOriginalAlert();
    }

    @Override
    public AlertWrapper<SweetAlertDialog, Alert> getWrapper() {
        if (isAlertWrapperNull())
            return null;
        return mAlertWrapper;
    }

    //----------Override----------


}

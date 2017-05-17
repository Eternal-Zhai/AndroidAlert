package com.eternal.alert.abs;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;

import com.eternal.alert.R;
import com.eternal.alert.base.AlertWrapper;
import com.eternal.alert.base.BaseAlert;

/**
 * Created by Eternal on 05/15/2017.
 */

public abstract class AbstractAlertWrapper<T extends Dialog, A extends BaseAlert> implements AlertWrapper<T, A> {


    public static final int DEFAULT_LEFT_BTN_TEXT_RES = R.string.alert_left_btn_text;
    public static final int DEFAULT_MIDDLE_BTN_TEXT_RES = R.string.alert_middle_btn_text;
    public static final int DEFAULT_RIGHT_BTN_TEXT_RES = R.string.alert_right_btn_text;

    public static final int BTN_LEFT = 0;
    public static final int BTN_MIDDLE = 1;
    public static final int BTN_RIGHT = 2;

    public static final int NORMAL_TYPE = 0;
    public static final int ERROR_TYPE = 1;
    public static final int SUCCESS_TYPE = 2;
    public static final int WARNING_TYPE = 3;
    public static final int CUSTOM_IMAGE_TYPE = 4;
    public static final int PROGRESS_TYPE = 5;


    protected CharSequence mTitleText = null, mMsgText = null, mLeftBtnText = null, mMiddleBtnText = null, mRightBtnText = null;

    protected Context mContext;

    protected T mOriginalAlert;

    protected A mBaseAlert;


    private AbstractAlertWrapper() {
    }

    public AbstractAlertWrapper(A baseAlert) {
        this.mBaseAlert = baseAlert;
    }

    public boolean isOriginalAlertNull() {
        return null == mOriginalAlert;
    }


    //----------Override----------

    @Override
    public T getOriginalAlert() {
        return mOriginalAlert;
    }

    @Override
    public A show() {
        if (isOriginalAlertNull())
            return mBaseAlert;
        mOriginalAlert.show();
        return mBaseAlert;
    }

    @Override
    public void dismiss() {
        if (isOriginalAlertNull())
            return;
        mOriginalAlert.dismiss();
    }

    @Override
    public void cancel() {
        if (isOriginalAlertNull())
            return;
        mOriginalAlert.cancel();
    }

    @Override
    public A cancelable(boolean cancelable) {
        if (isOriginalAlertNull())
            return mBaseAlert;
        mOriginalAlert.setCancelable(cancelable);
        return mBaseAlert;
    }

    @Override
    public A canceledOnTouchOutside(boolean canceledOnTouchOutside) {
        if (isOriginalAlertNull())
            return mBaseAlert;
        mOriginalAlert.setCanceledOnTouchOutside(canceledOnTouchOutside);
        return mBaseAlert;
    }

    @Override
    public Boolean isShowing() {
        return isOriginalAlertNull() ? false : mOriginalAlert.isShowing();
    }

    @Override
    public A onShow(final BaseAlert.OnShow onShow) {
        if (isOriginalAlertNull() || null == onShow)
            return mBaseAlert;
        mOriginalAlert.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                onShow.onShow(mBaseAlert);
            }
        });
        return mBaseAlert;
    }

    @Override
    public A onDismiss(final BaseAlert.OnDismiss onDismiss) {
        if (isOriginalAlertNull() || null == onDismiss)
            return mBaseAlert;
        mOriginalAlert.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                onDismiss.onDismiss(mBaseAlert);
            }
        });
        return mBaseAlert;
    }

    @Override
    public A onCancel(final BaseAlert.OnCancel onCancel) {
        if (isOriginalAlertNull() || null == onCancel)
            return mBaseAlert;
        mOriginalAlert.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                onCancel.onCancel(mBaseAlert);
            }
        });
        return mBaseAlert;
    }

    //----------Override----------


}

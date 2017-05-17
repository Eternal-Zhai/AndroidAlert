package com.eternal.alert.wrapper;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.TextUtils;

import com.eternal.alert.R;
import com.eternal.alert.abs.AbstractAlertWrapper;
import com.eternal.alert.base.AlertWrapper;
import com.eternal.alert.base.BaseAlert;
import com.eternal.alert.conventional.Alert;

import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Created by Eternal on 05/15/2017.
 */

public class ThirdPartyPackageAlertWrapper extends AbstractAlertWrapper<SweetAlertDialog, Alert> {


    public ThirdPartyPackageAlertWrapper(Alert baseAlert) {
        super(baseAlert);
    }

    @Override
    public Alert create(Context context, CharSequence title, CharSequence msg, int alertType) {

        this.mContext = context;

        int sweetAlertType = SweetAlertDialog.NORMAL_TYPE, titleRes = R.string.alert_default_normal_text, msgRes = R.string.alert_default_normal_text;
        switch (alertType) {
            case NORMAL_TYPE:
                sweetAlertType = SweetAlertDialog.NORMAL_TYPE;
                break;
            case ERROR_TYPE:
                sweetAlertType = SweetAlertDialog.ERROR_TYPE;
                titleRes = msgRes = R.string.alert_default_error_text;
                break;
            case SUCCESS_TYPE:
                sweetAlertType = SweetAlertDialog.SUCCESS_TYPE;
                titleRes = msgRes = R.string.alert_default_success_text;
                break;
            case WARNING_TYPE:
                sweetAlertType = SweetAlertDialog.WARNING_TYPE;
                titleRes = msgRes = R.string.alert_default_warning_text;
                break;
            case CUSTOM_IMAGE_TYPE:
                sweetAlertType = SweetAlertDialog.CUSTOM_IMAGE_TYPE;
                break;
            case PROGRESS_TYPE:
                sweetAlertType = SweetAlertDialog.PROGRESS_TYPE;
                titleRes = msgRes = R.string.alert_default_loading_text;
                break;
            default:
                sweetAlertType = SweetAlertDialog.NORMAL_TYPE;
                break;
        }


        mOriginalAlert = new SweetAlertDialog(context, sweetAlertType);

        mTitleText = TextUtils.isEmpty(title) ? mContext.getResources().getString(titleRes) : title;
        mOriginalAlert.setTitleText((String) mTitleText);

        if (!TextUtils.isEmpty(msg)) {
            mMsgText = msg;
            mOriginalAlert.setContentText((String) mMsgText);
        }

        mLeftBtnText = mContext.getResources().getString(DEFAULT_LEFT_BTN_TEXT_RES);
        mMiddleBtnText = mContext.getResources().getString(DEFAULT_MIDDLE_BTN_TEXT_RES);
        mRightBtnText = mContext.getResources().getString(DEFAULT_RIGHT_BTN_TEXT_RES);

        TypedArray typedArray = mContext.getTheme().obtainStyledAttributes(new int[]{android.R.attr.colorPrimary});
        int colorPrimary = typedArray.getColor(0, Color.parseColor("#FF0000"));
        typedArray.recycle();
        mOriginalAlert.getProgressHelper().setBarColor(colorPrimary);

        return mBaseAlert;
    }

    @Override
    public Alert title(CharSequence title) {
        if (!TextUtils.isEmpty(title)) {
            mTitleText = title;
            mOriginalAlert.setTitleText((String) title);
        }
        return mBaseAlert;
    }

    @Override
    public Alert msg(CharSequence msg) {
        if (!TextUtils.isEmpty(msg)) {
            mMsgText = msg;
            mOriginalAlert.setContentText((String) msg);
        }
        return mBaseAlert;
    }

    @Override
    public Alert leftBtn(CharSequence leftBtnText, final BaseAlert.OnClick leftBtnClick) {
        if (TextUtils.isEmpty(leftBtnText) && null == leftBtnClick)
            return mBaseAlert;

        mLeftBtnText = TextUtils.isEmpty(leftBtnText) ?
                (TextUtils.isEmpty(mLeftBtnText) ? mContext.getResources().getString(DEFAULT_LEFT_BTN_TEXT_RES) : mLeftBtnText)
                : leftBtnText;

        mOriginalAlert.setCancelText((String) mLeftBtnText);
        mOriginalAlert.setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
            @Override
            public void onClick(SweetAlertDialog sweetAlertDialog) {
                if (null != leftBtnClick)
                    leftBtnClick.onClick(mBaseAlert, BTN_LEFT);
                else
                    dismiss();
            }
        });

        return mBaseAlert;
    }

    @Override
    public Alert middleBtn(CharSequence middleBtnText, BaseAlert.OnClick middleBtnClick) {
        if (TextUtils.isEmpty(middleBtnText) && null == middleBtnClick)
            return mBaseAlert;

        mMiddleBtnText = TextUtils.isDigitsOnly(middleBtnText) ?
                (TextUtils.isEmpty(mMiddleBtnText) ? mContext.getResources().getString(DEFAULT_MIDDLE_BTN_TEXT_RES) : mMiddleBtnText)
                : middleBtnText;

        return mBaseAlert;
    }

    @Override
    public Alert rightBtn(CharSequence rightBtnText, final BaseAlert.OnClick rightBtnClick) {
        if (TextUtils.isEmpty(rightBtnText) && null == rightBtnClick)
            return mBaseAlert;

        mRightBtnText = TextUtils.isEmpty(rightBtnText) ?
                (TextUtils.isEmpty(mRightBtnText) ? mContext.getResources().getString(DEFAULT_RIGHT_BTN_TEXT_RES) : mRightBtnText)
                : rightBtnText;

        mOriginalAlert.setConfirmText((String) mRightBtnText);
        mOriginalAlert.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
            @Override
            public void onClick(SweetAlertDialog sweetAlertDialog) {
                if (null == rightBtnClick)
                    rightBtnClick.onClick(mBaseAlert, BTN_RIGHT);
                else
                    dismiss();
            }
        });

        return mBaseAlert;
    }

    @Override
    public void dismiss() {
        mOriginalAlert.dismissWithAnimation();
    }


}

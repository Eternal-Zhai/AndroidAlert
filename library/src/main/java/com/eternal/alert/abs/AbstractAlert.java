package com.eternal.alert.abs;

import android.app.Dialog;
import android.content.Context;

import com.eternal.alert.base.AlertWrapper;
import com.eternal.alert.base.BaseAlert;

import java.lang.ref.Reference;

/**
 * Created by Eternal on 05/15/2017.
 */

public abstract class AbstractAlert<T extends Dialog, A extends BaseAlert> implements BaseAlert<T, A> {


    public static final int DEFAULT_LEFT_BTN_TEXT_RES = AbstractAlertWrapper.DEFAULT_LEFT_BTN_TEXT_RES;
    public static final int DEFAULT_MIDDLE_BTN_TEXT_RES = AbstractAlertWrapper.DEFAULT_MIDDLE_BTN_TEXT_RES;
    public static final int DEFAULT_RIGHT_BTN_TEXT_RES = AbstractAlertWrapper.DEFAULT_RIGHT_BTN_TEXT_RES;

    public static final int BTN_LEFT = AbstractAlertWrapper.BTN_LEFT;
    public static final int BTN_MIDDLE = AbstractAlertWrapper.BTN_MIDDLE;
    public static final int BTN_RIGHT = AbstractAlertWrapper.BTN_RIGHT;

    public static final int NORMAL_TYPE = AbstractAlertWrapper.NORMAL_TYPE;
    public static final int ERROR_TYPE = AbstractAlertWrapper.ERROR_TYPE;
    public static final int SUCCESS_TYPE = AbstractAlertWrapper.SUCCESS_TYPE;
    public static final int WARNING_TYPE = AbstractAlertWrapper.WARNING_TYPE;
    public static final int CUSTOM_IMAGE_TYPE = AbstractAlertWrapper.CUSTOM_IMAGE_TYPE;
    public static final int PROGRESS_TYPE = AbstractAlertWrapper.PROGRESS_TYPE;


    protected A mAlert;
    protected AlertWrapper<T, A> mAlertWrapper;


    public abstract A createAlert(Context context, CharSequence title, CharSequence msg, int alertType);

    public abstract AlertWrapper<T, A> getWrapper();


    protected boolean isAlertWrapperNull() {
        return null == mAlertWrapper;
    }


    //----------Override----------

    @Override
    public T getOriginalAlert() {
        return (T) getWrapper().getOriginalAlert();
    }

    @Override
    public A title(CharSequence title) {
        if (isAlertWrapperNull())
            return mAlert;
        mAlertWrapper.title(title);
        return mAlert;
    }

    @Override
    public A msg(CharSequence msg) {
        if (isAlertWrapperNull())
            return mAlert;
        mAlertWrapper.msg(msg);
        return mAlert;
    }

    @Override
    public A leftBtnText(CharSequence leftBtnText) {
        if (isAlertWrapperNull())
            return mAlert;
        mAlertWrapper.leftBtn(leftBtnText, null);
        return mAlert;
    }

    @Override
    public A leftBtnClick(OnClick<A> leftBtnClick) {
        if (isAlertWrapperNull())
            return mAlert;
        mAlertWrapper.leftBtn(null, leftBtnClick);
        return mAlert;
    }

    @Override
    public A leftBtn(CharSequence leftBtnText, OnClick<A> leftBtnClick) {
        if (isAlertWrapperNull())
            return mAlert;
        mAlertWrapper.leftBtn(leftBtnText, leftBtnClick);
        return mAlert;
    }

    @Override
    public A middleBtnText(CharSequence middleBtnText) {
        if (isAlertWrapperNull())
            return mAlert;
        mAlertWrapper.middleBtn(middleBtnText, null);
        return mAlert;
    }

    @Override
    public A middleBtnClick(OnClick<A> middleBtnClick) {
        if (isAlertWrapperNull())
            return mAlert;
        mAlertWrapper.middleBtn(null, middleBtnClick);
        return mAlert;
    }

    @Override
    public A middleBtn(CharSequence middleBtnText, OnClick<A> middleBtnClick) {
        if (isAlertWrapperNull())
            return mAlert;
        mAlertWrapper.middleBtn(middleBtnText, middleBtnClick);
        return mAlert;
    }

    @Override
    public A rightBtnText(CharSequence rightBtnText) {
        if (isAlertWrapperNull())
            return mAlert;
        mAlertWrapper.rightBtn(rightBtnText, null);
        return mAlert;
    }

    @Override
    public A rightBtnClick(OnClick<A> rightBtnClick) {
        if (isAlertWrapperNull())
            return mAlert;
        mAlertWrapper.rightBtn(null, rightBtnClick);
        return mAlert;
    }

    @Override
    public A rightBtn(CharSequence rightBtnText, OnClick<A> rightBtnClick) {
        if (isAlertWrapperNull())
            return mAlert;
        mAlertWrapper.rightBtn(rightBtnText, rightBtnClick);
        return mAlert;
    }

    @Override
    public A show() {
        if (isAlertWrapperNull())
            return mAlert;
        mAlertWrapper.show();
        return mAlert;
    }

    @Override
    public A dismiss() {
        if (isAlertWrapperNull())
            return mAlert;
        mAlertWrapper.dismiss();
        return mAlert;
    }

    @Override
    public A cancel() {
        if (isAlertWrapperNull())
            return mAlert;
        mAlertWrapper.cancel();
        return mAlert;
    }

    @Override
    public A cancelable(boolean cancelable) {
        if (isAlertWrapperNull())
            return mAlert;
        mAlertWrapper.cancelable(cancelable);
        return mAlert;
    }

    @Override
    public A canceledOnTouchOutside(boolean canceledOnTouchOutside) {
        if (isAlertWrapperNull())
            return mAlert;
        mAlertWrapper.canceledOnTouchOutside(canceledOnTouchOutside);
        return mAlert;
    }

    @Override
    public boolean isShowing() {
        return isAlertWrapperNull() ? false : mAlertWrapper.isShowing();
    }

    @Override
    public A onShow(OnShow<A> onShow) {
        if (isAlertWrapperNull())
            return mAlert;
        mAlertWrapper.onShow(onShow);
        return mAlert;
    }

    @Override
    public A onDismiss(OnDismiss<A> onDismiss) {
        if (isAlertWrapperNull())
            return mAlert;
        mAlertWrapper.onDismiss(onDismiss);
        return mAlert;
    }

    @Override
    public A onCancel(OnCancel<A> onCancel) {
        if (isAlertWrapperNull())
            return mAlert;
        mAlertWrapper.onCancel(onCancel);
        return mAlert;
    }

    //----------Override----------


}

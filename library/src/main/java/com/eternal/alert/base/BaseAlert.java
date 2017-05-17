package com.eternal.alert.base;

import android.app.Dialog;


/**
 * Created by Eternal on 05/15/2017.
 */

public interface BaseAlert<T extends Dialog, A extends BaseAlert> {


    interface OnClick<A extends BaseAlert> {
        void onClick(A alert, int which);
    }

    interface OnCancel<A extends BaseAlert> {
        void onCancel(A alert);
    }


    interface OnDismiss<A extends BaseAlert> {
        void onDismiss(A alert);
    }


    interface OnShow<A extends BaseAlert> {
        void onShow(A alert);
    }


    T getOriginalAlert();


    //----------Message----------

    A title(CharSequence title);

    A msg(CharSequence msg);

    //----------Message----------


    //----------Button----------

    A leftBtnText(CharSequence leftBtnText);

    A leftBtnClick(OnClick<A> leftBtnClick);

    A leftBtn(CharSequence leftBtnText, OnClick<A> leftBtnClick);

    A middleBtnText(CharSequence middleBtnText);

    A middleBtnClick(OnClick<A> middleBtnClick);

    A middleBtn(CharSequence middleBtnText, OnClick<A> middleBtnClick);

    A rightBtnText(CharSequence rightBtnText);

    A rightBtnClick(OnClick<A> rightBtnClick);

    A rightBtn(CharSequence rightBtnText, OnClick<A> rightBtnClick);

    //----------Button----------


    //----------Active----------

    A show();

    A dismiss();

    A cancel();

    //----------Active----------


    A cancelable(boolean cancelable);

    A canceledOnTouchOutside(boolean canceledOnTouchOutside);

    boolean isShowing();

    A onShow(final OnShow<A> onShow);

    A onDismiss(final OnDismiss<A> onDismiss);

    A onCancel(final OnCancel<A> onCancel);


}

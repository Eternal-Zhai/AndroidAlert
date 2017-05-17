package com.eternal.alert.base;

import android.app.Dialog;
import android.content.Context;


/**
 * Created by Eternal on 05/12/2017.
 */

public interface AlertWrapper<T extends Dialog, A extends BaseAlert> {


    T getOriginalAlert();


    A create(Context context, CharSequence title, CharSequence msg, int alertType);

    A title(CharSequence title);

    A msg(CharSequence msg);


    A leftBtn(CharSequence leftBtnText, BaseAlert.OnClick<A> leftBtnClick);

    A middleBtn(CharSequence middleBtnText, BaseAlert.OnClick<A> middleBtnClick);

    A rightBtn(CharSequence rightBtnText, BaseAlert.OnClick<A> rightBtnClick);


    A show();

    void dismiss();

    void cancel();


    A cancelable(boolean cancelable);

    A canceledOnTouchOutside(boolean canceledOnTouchOutside);

    Boolean isShowing();


    A onShow(BaseAlert.OnShow<A> onShow);

    A onDismiss(BaseAlert.OnDismiss<A> onDismiss);

    A onCancel(BaseAlert.OnCancel<A> onCancel);


}

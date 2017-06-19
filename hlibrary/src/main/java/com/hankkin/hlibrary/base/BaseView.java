package com.hankkin.hlibrary.base;

import android.view.View;

/**
 * Created by hankkin on 2017/3/29.
 */

public interface BaseView {

    /**
     * 显示loading框
     */
    void showProgress();

    /**
     * 隐藏loading框
     */
    void hideProgress();

    void toast(CharSequence s);

    void toast(int id);

    void toastLong(CharSequence s);

    void toastLong(int id);


    /**
     * 显示空数据布局
     */
    void showNullLayout();

    /**
     * 隐藏空数据布局
     */
    void hideNullLayout();

    /**
     * 显示异常布局
     * @param listener
     */
    void showErrorLayout(View.OnClickListener listener);

    void hideErrorLayout();

}

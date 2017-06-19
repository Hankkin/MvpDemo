package com.hankkin.mvpdemo.home;

import com.hankkin.hlibrary.BaseView;

/**
 * Created by hankkin on 2017/6/19.
 */

public interface HomeView extends BaseView{

    void getDataHttp(String data);

    void getDataHttpFail(String msg);

}

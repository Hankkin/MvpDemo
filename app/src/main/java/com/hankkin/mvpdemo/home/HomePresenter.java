package com.hankkin.mvpdemo.home;

import com.hankkin.hlibrary.base.BasePresent;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

/**
 * Created by hankkin on 2017/6/19.
 */

public class HomePresenter extends BasePresent<HomeView> {


    public void getGankData(){
        OkGo.<String>get("http://gank.io/api/data/Android/10/1")
                .tag(this)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        view.getDataHttp(response.body());
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        view.getDataHttpFail(response.message());
                    }
                });
    }

}

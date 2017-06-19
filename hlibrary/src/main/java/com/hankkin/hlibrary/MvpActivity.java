package com.hankkin.hlibrary;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by hankkin on 2017/3/29.
 */

public abstract class MvpActivity<V,P extends BasePresent<V>> extends AppCompatActivity implements BaseView{

    protected P presenter;

    private ProgressDialog dialog;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = initPresenter();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.attach((V) this);
    }

    @Override
    protected void onDestroy() {
        presenter.detach();

        super.onDestroy();
    }

    public abstract P initPresenter();

    public void showProgress(){
        if (dialog == null){
            dialog = new ProgressDialog(this);
            dialog.setTitle("请稍后...");
        }
        dialog.show();
    }

    public void hideProgress(){
        if (dialog != null){
            dialog.dismiss();
        }
    }

    @Override
    public void toast(CharSequence s) {

    }

    @Override
    public void toast(int id) {

    }

    @Override
    public void toastLong(CharSequence s) {

    }

    @Override
    public void toastLong(int id) {

    }

    @Override
    public void showNullLayout() {

    }

    @Override
    public void hideNullLayout() {

    }

    @Override
    public void showErrorLayout(View.OnClickListener listener) {

    }

    @Override
    public void hideErrorLayout() {

    }
}

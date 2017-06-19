package com.hankkin.mvpdemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hankkin.hlibrary.base.MvpActivity;
import com.hankkin.mvpdemo.home.HomePresenter;
import com.hankkin.mvpdemo.home.HomeView;

import static com.hankkin.mvpdemo.R.id.btn_get;

public class MainActivity extends MvpActivity<HomeView,HomePresenter> implements HomeView{

    private TextView mTextMessage;
    private Button btnGet;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.control);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.notification);
                    return true;
            }
            return false;
        }
    };


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        mTextMessage = (TextView) findViewById(R.id.message);
        btnGet = (Button) findViewById(btn_get);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showProgress();
                presenter.getGankData();
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    public HomePresenter initPresenter() {
        return new HomePresenter();
    }


    @Override
    public void getDataHttp(String data) {
        mTextMessage.setText(data);
        hideProgress();
    }

    @Override
    public void getDataHttpFail(String msg) {
        toast(msg);
    }


    @Override
    public void toast(CharSequence s) {
        toast("获取成功");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}

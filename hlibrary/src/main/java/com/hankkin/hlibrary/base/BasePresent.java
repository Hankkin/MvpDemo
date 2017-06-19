package com.hankkin.hlibrary.base;

/**
 * Created by hankkin on 2017/3/29.
 */

public abstract class BasePresent<T>{
    public T view;

    public void attach(T view){
        this.view = view;
    }

    public void detach(){
        this.view = null;
    }
}

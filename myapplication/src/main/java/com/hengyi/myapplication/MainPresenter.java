package com.hengyi.myapplication;

import android.support.annotation.NonNull;

import com.hengyi.myapplication.model.ExpressInfo;
import com.hengyi.myapplication.net.DataManager;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DefaultObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/1/13.
 */

public class MainPresenter  {

    private MainContract.MainView mView;
    private DataManager dataManager;

    @Inject
    MainPresenter(MainContract.MainView mView) {
        this.mView = mView;
        dataManager = DataManager.getInstance();
    }

    public void load(String type, String postid){
        mView.showDialog();
        dataManager.getExpressInfo(type, postid)
                .subscribeOn(Schedulers.io()) // 在子线程中进行Http访问
                .observeOn(AndroidSchedulers.mainThread()) // UI线程处理返回接口
                .compose(mView.<ExpressInfo>bindToLife()) // onDestroy取消订阅
                .subscribe(new DefaultObserver<ExpressInfo>() {  // 订阅
                    @Override
                    public void onNext(@NonNull ExpressInfo expressInfo) {
                        mView.upDateView(expressInfo);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        mView.showError(e.getMessage());
                        mView.hideDialog();
                    }

                    @Override
                    public void onComplete() {
                        mView.hideDialog();
                    }
                });
    }
}

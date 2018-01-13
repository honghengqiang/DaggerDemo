package com.hengyi.myapplication.module;

import com.hengyi.myapplication.MainContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2018/1/13.
 */

@Module
public class MainModule {
    public final MainContract.MainView mView;

    public MainModule(MainContract.MainView view) {
        mView = view;
    }

    @Provides
    MainContract.MainView provideMainView(){
        return mView;
    }
}

package com.hengyi.daggerdemo.module;

import com.hengyi.daggerdemo.MainContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2018/1/12.
 */

@Module
public class MainModule {
    private final MainContract.View mView;

    public MainModule(MainContract.View view) {
        mView = view;
    }

    @Provides
    MainContract.View provideMainView() {
        return mView;
    }
}

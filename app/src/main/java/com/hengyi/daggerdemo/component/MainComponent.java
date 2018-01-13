package com.hengyi.daggerdemo.component;

import com.hengyi.daggerdemo.MainActivity;
import com.hengyi.daggerdemo.module.MainModule;

import dagger.Component;

/**
 * Created by Administrator on 2018/1/12.
 */
@Component(modules = MainModule.class)
public interface MainComponent {
    void inject(MainActivity activity);
}

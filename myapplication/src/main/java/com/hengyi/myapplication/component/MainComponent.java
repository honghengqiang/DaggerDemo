package com.hengyi.myapplication.component;

import com.hengyi.myapplication.MainActivity;
import com.hengyi.myapplication.module.MainModule;

import dagger.Component;

/**
 * Created by Administrator on 2018/1/13.
 */

@Component(modules = MainModule.class)
public interface MainComponent {
    void inject(MainActivity activity);
}

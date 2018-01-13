package com.hengyi.myapplication.base;

import com.trello.rxlifecycle2.LifecycleTransformer;

/**
 * Created by Administrator on 2018/1/13.
 */

public interface BaseContract {

    interface BasePresenter {
    }

    interface BaseView {

        void showDialog();

        void hideDialog();

        void showError(String error);

        /**
         * 绑定生命周期
         *
         * @param <T>
         * @return
         */
        <T> LifecycleTransformer<T> bindToLife();
    }
}

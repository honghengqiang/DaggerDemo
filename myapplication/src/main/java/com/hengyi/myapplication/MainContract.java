package com.hengyi.myapplication;

import com.hengyi.myapplication.base.BaseContract;
import com.hengyi.myapplication.model.ExpressInfo;

/**
 * Created by Administrator on 2018/1/13.
 */

public interface MainContract extends BaseContract {

    interface MainView extends BaseContract.BaseView{

        void upDateView(ExpressInfo expressInfo);

    }

}

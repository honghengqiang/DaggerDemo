package com.hengyi.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.hengyi.myapplication.component.DaggerMainComponent;
import com.hengyi.myapplication.model.ExpressInfo;
import com.hengyi.myapplication.module.MainModule;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import javax.inject.Inject;


public class MainActivity extends RxAppCompatActivity implements MainContract.MainView{

    @Inject MainPresenter mainPresenter;

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaggerMainComponent.builder()
                .mainModule(new MainModule(this))
                .build()
                .inject(this);


        tv= (TextView) findViewById(R.id.tv);

        findViewById(R.id.bt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainPresenter.load("yuantong", "11111111111");
            }
        });

    }

    @Override
    public void showDialog() {
        Log.d("TAG", "showDialog: ");
    }

    @Override
    public void hideDialog() {
        Log.d("TAG", "hideDialog: ");
    }

    @Override
    public void showError(String error) {
        Log.d("TAG", "showError: ");
    }

    @Override
    public <T> LifecycleTransformer<T> bindToLife() {
        return this.<T>bindToLifecycle();
    }

    @Override
    public void upDateView(ExpressInfo expressInfo) {
            tv.setText(expressInfo.toString());
    }
}

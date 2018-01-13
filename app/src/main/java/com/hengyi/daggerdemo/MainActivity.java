package com.hengyi.daggerdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.hengyi.daggerdemo.component.DaggerMainComponent;
import com.hengyi.daggerdemo.module.MainModule;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainContract.View{

    @Inject
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaggerMainComponent.builder()
                .mainModule(new MainModule(this))
                .build()
                .inject(this);

        findViewById(R.id.bt_refresh).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainPresenter.loadData();
            }
        });

    }

    @Override
    public void updateUI() {
        Toast.makeText(MainActivity.this, "更新UI", Toast.LENGTH_SHORT).show();
    }
}

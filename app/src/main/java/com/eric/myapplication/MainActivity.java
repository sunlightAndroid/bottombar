package com.eric.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.eric.bottombarlibrary.view.tab.BottomTab;
import com.eric.bottombarlibrary.view.tab.TabModel;

public class MainActivity extends AppCompatActivity {

    private BottomTab mBottomtab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }


    private void initView() {
        mBottomtab = findViewById(R.id.bottomTab);
        mBottomtab.initTab(R.color.bottom_tab_normal_text_bg, R.color.bottom_tab_select_text_bg);

        mBottomtab
                .addTab(new TabModel.Builder()
                        .addTabText("首页")
                        .addTabNormalIcon(R.mipmap.ic_top_normal)
                        .addTabSelectedIcon(R.mipmap.ic_top_pressed)
                        .build())
                .addTab(new TabModel.Builder()
                        .addTabText("我的任务")
                        .addTabNormalIcon(R.mipmap.ic_mission_normal)
                        .addTabSelectedIcon(R.mipmap.ic_mission_pressed)
                        .build())

                .addTab(new TabModel.Builder()
                        .addTabText("个人中心")
                        .addTabNormalIcon(R.mipmap.ic_mine_normal)
                        .addTabSelectedIcon(R.mipmap.ic_mine_pressed)
                        .build())
                .setOnTabItemClickListener(new BottomTab.onTabItemClickListener() {
                    @Override
                    public void onTabItemClick(int position) {
                        switch (position) {
                            case 0:
                                Toast.makeText(MainActivity.this, "首页", Toast.LENGTH_SHORT).show();
                                break;

                            case 1:
                                Toast.makeText(MainActivity.this, "我的任务", Toast.LENGTH_SHORT).show();
                                break;

                            case 2:
                                Toast.makeText(MainActivity.this, "个人中心", Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }
                });

        //  mBottomtab.updataTab(1); // 切到某个tab ， 默认是0
    }
}
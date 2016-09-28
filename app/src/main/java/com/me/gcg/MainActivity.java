package com.me.gcg;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.me.gcg.bottombar.view.MyBottomBar;

public class MainActivity extends AppCompatActivity {

    private MyBottomBar mBottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBottomBar= (MyBottomBar) findViewById(R.id.bottombar);
        mBottomBar.setOnItemClickListener(new MyBottomBar.BottombarCallback() {
            @Override
            public void onItemClicker(int position) {
                Toast.makeText(MainActivity.this, "" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }
}

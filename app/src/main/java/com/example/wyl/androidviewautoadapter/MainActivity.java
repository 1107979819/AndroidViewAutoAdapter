package com.example.wyl.androidviewautoadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ViewAutoAdapter.getInstance().fitView(this,R.id.textView2,100,100);
        ViewAutoAdapter.getInstance().fitView(this,R.id.unuse_textView2,100,100);
    }
}

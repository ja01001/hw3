package com.example.ja010.week4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;


public class Main2Activity extends AppCompatActivity {
    TabHost th;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        th =(TabHost)findViewById(R.id.tabhost1);
        th.setup();
        TabHost.TabSpec tas1 = th.newTabSpec("A").setContent(new TabHost.TabContentFactory() {
            @Override
            public View createTabContent(String tag) {
                View view = View.inflate(Main2Activity.this,R.layout.tt,null); // 외부 xml 객체화
                return view;
            }
        }).setIndicator("BMI 계산기");
        TabHost.TabSpec tas2 = th.newTabSpec("B").setContent(new TabHost.TabContentFactory() {
            @Override
            public View createTabContent(String tag) {
                View view = View.inflate(Main2Activity.this,R.layout.tt,null); // 외부 xml 객체화
                return view;
            }
        }).setIndicator("ㄱㄱ");
        /*View view = View.inflate(Main2Activity.this,R.layout.tt,null);
        nool(tas1,tas2,view);
*/
        th.addTab(tas1);
        th.addTab(tas2);

    }
    void tabob(){


    }
    void nool(TabHost.TabSpec a, TabHost.TabSpec b, View v){

    }
    void btn(){

    }
}

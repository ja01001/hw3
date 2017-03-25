package com.example.ja010.week4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;


public class Main2Activity extends AppCompatActivity {
    TabHost th;
    TextView tv1;
    EditText e1,e2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tabob();
        tv1 =(TextView)findViewById(R.id.tx4);
        e1  =(EditText)findViewById(R.id.et1);
        e2  =(EditText)findViewById(R.id.et2);

    }
    void tabob(){
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
                View view = View.inflate(Main2Activity.this,R.layout.ty,null); // 외부 xml 객체화
                return view;
            }
        }).setIndicator("면적 계산기");

        th.addTab(tas1);
        th.addTab(tas2);

    }


     void zero(String a, String b){
            float cmx,cmy;
            if(a.getBytes().length !=0 && b.getBytes().length !=0){
                cmx = Float.parseFloat(a);
                cmy = Float.parseFloat(b);
            }
            else if(b.getBytes().length ==0){
                cmy = 0;
                cmx = Float.parseFloat(a);
            }
            else if(a.getBytes().length == 0){
                cmy = Float.parseFloat(b);
                cmx = 0;
            }
            else{
                cmx =0;
                cmy =0;
            }
            cal(cmx,cmy);
        }
    public void clcl(View v){
        if(v.getId() == R.id.b1){
            String cm = e1.getText().toString();
            String kg = e2.getText().toString();
            zero(cm,kg);
        }
        else if(v.getId() == R.id.bt1){

        }
        else{

        }
    }
    void cal(float a, float b){
        float zz;
        if(a == 0){
            zz = 0;
        }
        else {
            zz = b / (a/100 * a/100);
        }
        if(zz >=25.0){
            tv1.setText("비만입니다.");
        }
        else if(zz>=23.0){
            tv1.setText("과체중 입니다.");
        }
        else if(zz>=18.5){
            tv1.setText("정상입니다.");
        }
        else{
            tv1.setText("체중부족입니다.");
        }

    }
}


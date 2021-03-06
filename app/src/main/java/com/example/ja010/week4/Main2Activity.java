package com.example.ja010.week4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.text.Format;


public class Main2Activity extends AppCompatActivity {
    TabHost th;
    TextView tv1,tt1;
    EditText e1,e2,e3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        tabob();
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


     void zero(String a, String b){ // 입력값이 없을때;
         Toast.makeText(getApplicationContext(),"asd",Toast.LENGTH_SHORT).show();
            if(a.getBytes().length ==0){
                e1.requestFocus();
                Toast.makeText(getApplicationContext(),"값을 입력하세요.",Toast.LENGTH_SHORT).show();
            }
            else if(b.getBytes().length ==0){
                e2.requestFocus();
                Toast.makeText(getApplicationContext(),"값을 입력하세요.",Toast.LENGTH_SHORT).show();

            }
            else if(a.getBytes().length == 0&&b.getBytes().length ==0){
                e1.requestFocus();
                Toast.makeText(getApplicationContext(),"값을 입력하세요.",Toast.LENGTH_SHORT).show();
            }
        }
    public void clcl(View v){


        if(v.getId() == R.id.b1){
            tv1 =(TextView)findViewById(R.id.tx4);
            e1  =(EditText)findViewById(R.id.et1);
            e2  =(EditText)findViewById(R.id.et2);
            //Toast.makeText(getApplicationContext(),"asd",Toast.LENGTH_SHORT).show();
            String cm = e1.getText().toString();
            String kg = e2.getText().toString();
        //    Toast.makeText(getApplicationContext(),"asd",Toast.LENGTH_SHORT).show();
            if(cm.getBytes().length ==0||kg.getBytes().length ==0){
                zero(cm,kg);
       //         Toast.makeText(getApplicationContext(),"asd",Toast.LENGTH_SHORT).show();
            }
            else{//Toast.makeText(getApplicationContext(),"asd",Toast.LENGTH_SHORT).show();
                cal(Float.parseFloat(cm),Float.parseFloat(kg));
            }
        }
        else if(v.getId() == R.id.bt1){
            e3  =(EditText)findViewById(R.id.ett1);
            String y = e3.getText().toString();

//            Toast.makeText(getApplicationContext(),"asd",Toast.LENGTH_SHORT).show();// 오류 검출
            if(y.getBytes().length== 0){
                zero_mak();
            }
            else {
                cal2(y);
            }
        }
        else{
            e3  =(EditText)findViewById(R.id.ett1);
            String y = e3.getText().toString();
            if(y.getBytes().length== 0){
                zero_mak();
            }
            else {
                cal3(y);
            }
        }
    }
    void cal(float a,  float b){
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
    void cal2(String a){
        tt1 =(TextView)findViewById(R.id.tt2);
        double b=Double.parseDouble(a)*3.305785;
        double xx =Double.parseDouble(String.format("%.2f",b));
            tt1.setText(xx+"제곱 미터");
    }
    void cal3(String a){
        tt1 =(TextView)findViewById(R.id.tt2);
        double b=Double.parseDouble(a)*0.3025;
        double xx =Double.parseDouble(String.format("%.2f",b));
        tt1.setText(xx+"평형");
    }
    void zero_mak(){
        e3.requestFocus();
        Toast.makeText(getApplicationContext(),"다시 입력하세요",Toast.LENGTH_SHORT).show();
    }
}


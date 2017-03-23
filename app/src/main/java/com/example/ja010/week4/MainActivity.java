package com.example.ja010.week4;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    RelativeLayout r1;
    TextView tc,ts;
    ImageView im1,im2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("메뉴를 눌러보세요.");
        r1 = (RelativeLayout)findViewById(R.id.re);
        im1 = (ImageView)findViewById(R.id.img1);
        tc = (TextView)findViewById(R.id.t1);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menus,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int t1 = item.getItemId();
        switch (t1){
            case R.id.red:
                r1.setBackgroundColor(Color.RED);
                break;
            case R.id.blue:
                r1.setBackgroundColor(Color.BLUE);
                break;
            case R.id.yellow:
                r1.setBackgroundColor(Color.YELLOW);
                break;
            case R.id.turn:
                im1.setRotation(im1.getRotation()+30);
                break;
            case R.id.tt:
                if(item.isChecked()){
                    item.setChecked(false);
                    tc.setVisibility(View.INVISIBLE);
                }
                else{
                    item.setChecked(true);
                    tc.setVisibility(View.VISIBLE);

                }
                break;
            case R.id.big:
                if(item.isChecked()){
                    item.setChecked(false);
                    im1.setScaleX(1.0f);
                    im1.setScaleY(1.0f);

                }
                else{
                    item.setChecked(true);
                    im1.setScaleX(2.0f);
                    im1.setScaleY(2.0f);

                }
                break;
            case R.id.ch:
                im1.setImageResource(R.drawable.ch);
                im1.setRotation(0);
                tc.setText("겁나맛있는 치킨");
                item.setChecked(true);
                break;
            case R.id.sp:
                im1.setImageResource(R.drawable.spa);
                tc.setText("새콤한 스파게티");
                im1.setRotation(0);
                item.setChecked(true);
                break;
        }


        return super.onOptionsItemSelected(item);
    }

}

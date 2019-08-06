package com.shinhoandroid.eventdistribution;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.shinhoandroid.eventdistribution.refresh.RefreshActivity;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void bt1(View view){

        Intent intent = new Intent(this,MultiTouchView1Activity.class);

        this.startActivity(intent);
    }


    public void bt2(View view){

        Intent intent = new Intent(this,MultiTouchView2Activity.class);

        this.startActivity(intent);
    }

    public void bt3(View view){

        Intent intent = new Intent(this,MultiTouchView3Activity.class);

        this.startActivity(intent);
    }

    public void bt4(View view){

        Intent intent = new Intent(this,ScalableImageActivity.class);

        this.startActivity(intent);
    }

    public void bt5(View view){

        Intent intent = new Intent(this,GestureDetectorCompatActivity.class);

        this.startActivity(intent);
    }

    public void bt6(View view){

        Intent intent = new Intent(this, RefreshActivity.class);

        this.startActivity(intent);
    }

}

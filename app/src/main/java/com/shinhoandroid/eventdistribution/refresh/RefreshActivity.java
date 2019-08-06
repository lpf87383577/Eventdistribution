package com.shinhoandroid.eventdistribution.refresh;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.shinhoandroid.eventdistribution.L;
import com.shinhoandroid.eventdistribution.R;

public class RefreshActivity extends AppCompatActivity {

    RefreshableView refreshableView;
    ListView listView;
    ArrayAdapter<String> adapter;
    String[] items = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L" };

    Handler mHandler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            L.e("结束刷新");
            refreshableView.finishRefreshing();
        }

    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresh);



        refreshableView = (RefreshableView) findViewById(R.id.refreshable_view);
        listView = (ListView) findViewById(R.id.list_view);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);
        refreshableView.setOnRefreshListener(new RefreshableView.PullToRefreshListener() {
            @Override
            public void onRefresh() {

                mHandler.sendEmptyMessageDelayed(1,3000);
            }
        }, 0);

    }
}

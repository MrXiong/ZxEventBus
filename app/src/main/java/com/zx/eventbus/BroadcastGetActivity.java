package com.zx.eventbus;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class BroadcastGetActivity extends BaseActivity {

    private ListView mLvList;
    ArrayList updateCount = new ArrayList();
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_get);
        mLvList = (ListView) findViewById(R.id.lv_list);
        registerReceiver(updateSuccessReceiver, updateSuccessFilter);
        adapter = new ArrayAdapter<String>(BroadcastGetActivity.this,android.R.layout.simple_list_item_1,updateCount);
        mLvList.setAdapter(adapter);

    }

    IntentFilter updateSuccessFilter = new IntentFilter(FILTER_ACTION_UPDATE_SUCCESS);
    BroadcastReceiver updateSuccessReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            ArrayList thisupdateCount = intent.getStringArrayListExtra(EXTRA_COUNT);
            updateCount.clear();
            updateCount.addAll(thisupdateCount);
                adapter.notifyDataSetChanged();
        }
    };


    @Override
    protected void onResume() {
        super.onResume();
        


    }

    @Override
    protected void onDestroy() {
        if (updateSuccessReceiver != null) {
            unregisterReceiver(updateSuccessReceiver);
        }
        super.onDestroy();
    }
}

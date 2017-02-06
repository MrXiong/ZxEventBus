package com.zx.eventbus;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.zhy.base.adapter.ViewHolder;
import com.zhy.base.adapter.recyclerview.CommonAdapter;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.Bind;
import butterknife.ButterKnife;

public class BroadcastSendActivity extends BaseActivity {


    @Bind(R.id.rv_list)
    RecyclerView rvList;
    private ArrayList list;
    private Handler handler;
    private CommonAdapter commonAdapter;
    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_send);
        ButterKnife.bind(this);
        list = new ArrayList();
        init();

        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if(msg.what ==1) {
                    list.add("test" + i++);
                    commonAdapter.notifyDataSetChanged();
                    Intent intent = new Intent(FILTER_ACTION_UPDATE_SUCCESS);
                    intent.putStringArrayListExtra(EXTRA_COUNT, list);
                   sendBroadcast(intent);
                }
            }
        };
    }

    private void init() {
        rvList.setLayoutManager(new LinearLayoutManager(this));
        commonAdapter = new CommonAdapter<String>(this, R.layout.listitem_test, list) {
            @Override
            public void convert(ViewHolder holder, String o) {
                holder.setText(R.id.tv_test, o);
            }

        };
        rvList.setAdapter(commonAdapter);

        new Timer().schedule(new TimerTask() {
                      public void run() {
                          Message message = handler.obtainMessage();
                          message.what = 1;
                          handler.sendMessage(message);
                      }
                  },
                1000,1000);
    }

    public void sendSuccess(View v) {

        startActivity(new Intent(this,BroadcastGetActivity.class));
    }
}

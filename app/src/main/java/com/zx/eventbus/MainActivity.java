package com.zx.eventbus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.zx.eventbus.event.FirstEvent;
import com.zx.eventbus.event.SecondEvent;
import com.zx.eventbus.event.ThirdEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    public void gotoBroadSend(View v) {
        startActivity(new Intent(this, BroadcastSendActivity.class));
    }

    public void gotoBroadGet(View v) {
        startActivity(new Intent(this, BroadcastGetActivity.class));
    }

    public void gotoEventSend(View v) {
        startActivity(new Intent(this, EventBusSendActivity.class));
    }

    public void gotoEventGet(View v) {
        startActivity(new Intent(this, EventBusGetActivity.class));
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }



    @Subscribe
    public void onEventMainThread(FirstEvent event){
        String msg = "onEventMainThread收到了消息：" + event.getMsg();
        Log.d("harvic", msg);
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
    //SecondEvent接收函数一
    @Subscribe(threadMode = ThreadMode.MAIN,priority = 100, sticky = true) //在ui线程执行，优先级为100
    public void myonEventMainThread(SecondEvent event) {
        Log.d("harvic", "onEventMainThread收到了消息：" + event.getMsg());
    }
    //SecondEvent接收函数二
    @Subscribe
    public void onEventBackgroundThread(SecondEvent event){
        Log.d("harvic", "onEventBackground收到了消息：" + event.getMsg());
    }
    //SecondEvent接收函数三
    @Subscribe
    public void onEventAsync(SecondEvent event){
        Log.d("harvic", "onEventAsync收到了消息：" + event.getMsg());
    }
    //SecondEvent接收函数4
    @Subscribe
    public void onEvent(SecondEvent event){
        Log.d("harvic", "onEvent收到了消息：" + event.getMsg());
    }
    @Subscribe
    public void onEventMainThread(ThirdEvent event){
        String msg = "onEventMainThread收到了消息：" + event.getMsg();
        Log.d("harvic", msg);
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}

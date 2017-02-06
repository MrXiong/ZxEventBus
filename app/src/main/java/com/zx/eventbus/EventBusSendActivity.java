package com.zx.eventbus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.zx.eventbus.event.FirstEvent;
import com.zx.eventbus.event.SecondEvent;
import com.zx.eventbus.event.ThirdEvent;

import org.greenrobot.eventbus.EventBus;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EventBusSendActivity extends AppCompatActivity {

    @Bind(R.id.btn_send1)
    Button btnSend1;
    @Bind(R.id.btn_send2)
    Button btnSend2;
    @Bind(R.id.btn_send3)
    Button btnSend3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus_send);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.btn_send1, R.id.btn_send2, R.id.btn_send3})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_send1:
                EventBus.getDefault().post(new FirstEvent("第一步。。。"));
                break;
            case R.id.btn_send2:
                EventBus.getDefault().post(new SecondEvent("第二步。。。"));
                break;
            case R.id.btn_send3:
                EventBus.getDefault().post(new ThirdEvent("第三步。。。"));
                break;
        }
    }
}

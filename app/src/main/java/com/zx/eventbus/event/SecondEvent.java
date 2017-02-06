package com.zx.eventbus.event;

/**
 * Created by Administrator on 2017/2/5.
 */
public class SecondEvent {
    private String mMsg;

    public SecondEvent(String msg) {
        mMsg = msg;
    }

    public String getMsg() {
        return mMsg;
    }
}

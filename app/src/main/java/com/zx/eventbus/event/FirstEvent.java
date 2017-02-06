package com.zx.eventbus.event;

/**
 * Created by Administrator on 2017/2/5.
 */
public class FirstEvent {
    private String mMsg;

    public FirstEvent(String msg) {
        mMsg = msg;
    }

    public String getMsg() {
        return mMsg;
    }
}

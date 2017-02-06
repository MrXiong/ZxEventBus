package com.zx.eventbus.event;

/**
 * Created by Administrator on 2017/2/5.
 */
public class ThirdEvent{
    private String mMsg;

    public ThirdEvent(String msg) {
        mMsg = msg;
    }

    public String getMsg() {
        return mMsg;
    }
}

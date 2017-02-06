package com.zx.eventbus;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Administrator on 2017/2/6.
 */
public class EventBusHelper {

    public static void register(Object subscriber) {
        if (subscriber != null && !EventBus.getDefault().isRegistered(subscriber)) {
            EventBus.getDefault().register(subscriber);
        }
    }
    public static void unregister(Object subscriber) {
        if (subscriber != null && !EventBus.getDefault().isRegistered(subscriber)) {
            EventBus.getDefault().unregister(subscriber);
        }
    }

/*    相信大多数使用过EventBus 2.4的同学或多或少的使用过：

            EventBus.getDefault().postSticky(new VoteEvent(obj));
    EventBus.getDefault().registerSticky(this);
    你会发现非常的麻烦，那么在3.0中：

            EventBus.getDefault().postSticky(new VoteEvent(obj));
    EventBus.getDefault().register(this);
    @Subscribe(sticky = true)*/

}
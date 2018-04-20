package com.tools.interesting.eventbusexample;

import android.util.Log;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by fhw on 2018/4/10.
 */

public class ThreadModeFunction {

    public static final String TAG = "ThreadModeFunction";

    public void registerOn(){
        EventBus.getDefault().register(this);
    }
    public void unregisterOff(){
        EventBus.getDefault().unregister(this);
    }

    // Called in the same thread (default)
    // ThreadMode is optional here
    @Subscribe(threadMode = ThreadMode.POSTING, sticky = true)
    public void onMessage(EventTypeSecond eventTypeSecond) {
        Log.d(TAG, eventTypeSecond.getMsg());
    }


    // Called in Android UI's main thread
    @Subscribe(threadMode = ThreadMode.MAIN_ORDERED)
    public void onMessage1(MessageEvent event) {
        Log.d(TAG, event.message);
    }

    // Called in the background thread
    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onMessage2(MessageEvent event){
        Log.d(TAG, event.message);
    }

    // Called in a separate thread
    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void onMessage3(MessageEvent event){
        Log.d(TAG, event.message);
    }

    // Called in Android UI's main thread
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessage4(MessageEvent event) {
        Log.d(TAG, event.message);
    }
}

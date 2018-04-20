package com.tools.interesting.eventbusexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {

    private int count = 0;
    private ThreadModeFunction threadModeFunction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        threadModeFunction = new ThreadModeFunction();
    }


    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }


    public void eventRegister(View view){
        threadModeFunction.registerOn();
    }
    public void eventUnregister(View view){
        threadModeFunction.unregisterOff();
    }
    public void sendMain(View view){
        count++;
        EventBus.getDefault().post(new MessageEvent("sendMain : "+count));
    }
    public void sendPosting(View view){
        count++;
        EventBus.getDefault().post(new EventTypeSecond("sendPosting : "+count));
    }
    public void sendMainOrdered(View view){
        count++;
        EventBus.getDefault().post(new MessageEvent("sendMainOrdered : "+count));
    }
    public void sendBackground(View view){
        count++;
        EventBus.getDefault().post(new MessageEvent("sendBackground : "+count));
    }
    public void sendAsync(View view){
        count++;
        EventBus.getDefault().post(new MessageEvent("sendAsync : "+count));
    }

}

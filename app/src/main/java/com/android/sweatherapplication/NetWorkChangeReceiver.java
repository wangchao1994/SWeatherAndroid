package com.android.sweatherapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.android.sweatherapplication.event.NetChangeEvent;
import com.android.sweatherapplication.utils.AppNetworkMgr;

import org.greenrobot.eventbus.EventBus;

public class NetWorkChangeReceiver extends BroadcastReceiver {
    private static boolean isChanged = false;
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("wangchao","NetWorkChangeReceiver isConnected==== "+AppNetworkMgr.isNetworkConnected(context));
        //EventBus.getDefault().post(new NetChangeEvent(AppNetworkMgr.isNetworkConnected(context)));
        if (AppNetworkMgr.isNetworkConnected(context)){
            Log.d("wangchao","NetWorkChangeReceiver true isChanged==== "+isChanged);
            if (!isChanged){
                isChanged = true;
                EventBus.getDefault().post(new NetChangeEvent(true));
            }
        }else {
            Log.d("wangchao","NetWorkChangeReceiver false isChanged==== "+isChanged);
            if (isChanged){
                isChanged = false;
                EventBus.getDefault().post(new NetChangeEvent(false));
            }
        }
    }
}

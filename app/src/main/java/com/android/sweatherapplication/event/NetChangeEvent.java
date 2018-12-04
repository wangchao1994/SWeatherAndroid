package com.android.sweatherapplication.event;

public class NetChangeEvent {
    public boolean isNetConnected;
    public NetChangeEvent(boolean isNetWorkConnected){
        isNetConnected = isNetWorkConnected;
    }
}

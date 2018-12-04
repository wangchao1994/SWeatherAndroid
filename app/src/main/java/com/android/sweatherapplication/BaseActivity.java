package com.android.sweatherapplication;

import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.android.sweatherapplication.event.NetChangeEvent;
import com.android.sweatherapplication.utils.AppManager;
import com.android.sweatherapplication.utils.AppNetworkMgr;
import com.android.sweatherapplication.utils.StatusBarUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public abstract class BaseActivity extends AppCompatActivity{
    protected SApplication mSApplication;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSApplication = SApplication.getInstance();
        ActionBar supportActionBar = getSupportActionBar();
        assert supportActionBar!=null;
        supportActionBar.hide();
        StatusBarUtil.setStatusColor(getWindow(), ContextCompat.getColor(this, R.color.colorPrimary), 1f);
        EventBus.getDefault().register(this);
        AppManager.getAppManager().addActivity(this);
        getLayoutId();
        initEventData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        hasNetWorkChangeStatus(AppNetworkMgr.isNetworkConnected(mSApplication));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onNetEvent(NetChangeEvent netChangeEvent){
        hasNetWorkChangeStatus(netChangeEvent.isNetConnected);
    }

    private void hasNetWorkChangeStatus(boolean isNetConnected) {
        if (mSApplication.getCheckNetValue()){
            if (isNetConnected){
                //Toast.makeText(mSApplication,"NET CONNECT",Toast.LENGTH_SHORT).show();
            }else{
                //Toast.makeText(mSApplication,"NET UNCONNECT",Toast.LENGTH_SHORT).show();
            }
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        AppManager.getAppManager().removeActivity(this);
    }

    @Override
    public void finish() {
        super.finish();
        //处理全局view结束remove
    }
    protected abstract void getLayoutId();
    protected abstract void initEventData();

}

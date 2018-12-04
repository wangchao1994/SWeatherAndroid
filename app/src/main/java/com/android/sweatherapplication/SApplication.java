package com.android.sweatherapplication;

import android.app.Application;

import com.android.sweatherapplication.utils.GlobalHandler;
import com.android.sweatherapplication.utils.PreferencesUtils;

import org.litepal.LitePal;

import java.util.Locale;
import java.util.logging.Handler;

public class SApplication extends Application {
    private static SApplication instance;
    private static boolean isCheckNetWork = true;
    private PreferencesUtils mPreferencesUtils;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        LitePal.initialize(this);
        mPreferencesUtils = new PreferencesUtils(this);
    }
    public static SApplication getInstance(){
        return instance;
    }

    /**
     * check NetWork
     * @param isCheckNet
     */
    public void setIsCheckNetWork(boolean isCheckNet){
        isCheckNetWork = isCheckNet;
    }
    public boolean getCheckNetValue(){
        return isCheckNetWork;
    }

    //fragments id
    public void setCityId(int value){
        mPreferencesUtils.putInt(SWConfig.WEATHER_ID,value);
    }
    public int getCityId(){
        return mPreferencesUtils.getInt(SWConfig.WEATHER_ID);
    }

    //get current language
    public String getCurrentLocale(){
        return Locale.getDefault().getLanguage();
    }
}

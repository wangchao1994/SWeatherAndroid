package com.android.sweatherapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.android.sweatherapplication.db.DBHelper;
import com.android.sweatherapplication.event.LocalInfoEvent;
import com.android.sweatherapplication.adapter.FragAdapter;
import com.android.sweatherapplication.model.CityInfo;


import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends BaseActivity{

    private DrawerLayout mDrawerLayout;
    private Toolbar mToolbar;
    private TextView mTitleText;
    private ViewPager mViewPager;
    private NavigationView mNavigationView;
    private CircleIndicator mCircleIndicator;
    private List<WeatherFragment> weatherFragmentList;
    private FragAdapter mWeahterAdapter;
    private AMapLocationClient locationClient;
    private AMapLocationClientOption mLocationOption;

    @Override
    protected void getLayoutId() {
        setContentView(R.layout.activity_main);
        initView();
        initToolBarSet();
        initNavigationView();
        initLocationOption();
    }

    private void initLocationOption() {
        //初始化client
        locationClient = new AMapLocationClient(mSApplication);
        mLocationOption = getDefaultOption();
        //设置定位参数
        locationClient.setLocationOption(mLocationOption);
        // 设置定位监听
        locationClient.setLocationListener(mlocationListener);
        // 启动定位
        locationClient.startLocation();
    }
    /**
     * 默认的定位参数
     *
     */
    private AMapLocationClientOption getDefaultOption(){
        AMapLocationClientOption mOption = new AMapLocationClientOption();
        //可选，设置定位模式，可选的模式有高精度、仅设备、仅网络。默认为高精度模式
        mOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        //可选，设置是否gps优先，只在高精度模式下有效。默认关闭
        mOption.setGpsFirst(false);
        //可选，设置网络请求超时时间。默认为30秒。在仅设备模式下无效
        mOption.setHttpTimeOut(30000);
        //可选，设置定位间隔。默认为2秒
        mOption.setInterval(2000);
        //可选，设置是否返回逆地理地址信息。默认是true
        mOption.setNeedAddress(true);
        //可选，设置是否单次定位。默认是false
        mOption.setOnceLocation(false);
        //可选，设置是否等待wifi刷新，默认为false.如果设置为true,会自动变为单次定位，持续定位时不要使用
        mOption.setOnceLocationLatest(false);
        //可选， 设置网络请求的协议。可选HTTP或者HTTPS。默认为HTTP
        AMapLocationClientOption.setLocationProtocol(AMapLocationClientOption.AMapLocationProtocol.HTTP);
        //可选，设置是否使用传感器。默认是false
        mOption.setSensorEnable(false);
        //可选，设置是否开启wifi扫描。默认为true，如果设置为false会同时停止主动刷新，停止以后完全依赖于系统刷新，定位位置可能存在误差
        mOption.setWifiScan(true);
        //可选，设置是否使用缓存定位，默认为true
        mOption.setLocationCacheEnable(true);
        return mOption;
    }

    /**
     * 定位监听
     */
    AMapLocationListener mlocationListener = new AMapLocationListener() {

        @Override
        public void onLocationChanged(AMapLocation amapLocation) {
            if (null != amapLocation ) {
                /**
                 * 根据高德定位SDK获取经纬度
                 * 获取当地位置的经纬度
                 * 解析定位结果
                 * */
                if (amapLocation != null) {
                    if (amapLocation.getErrorCode() == 0) {
//可在其中解析amapLocation获取相应内容。
                    }else {
                        //定位失败时，可通过ErrCode（错误码）信息来确定失败的原因，errInfo是错误信息，详见错误码表。
                        Log.e("AmapError","location Error, ErrCode:"
                                + amapLocation.getErrorCode() + ", errInfo:"
                                + amapLocation.getErrorInfo());
                    }
                }
                Log.d("wangchao","amapLocation city=========="+amapLocation.getErrorInfo());
                locationClient.stopLocation();
            }
        }
    };

    @Override
    protected void initEventData() {
        initFragmentsData();
    }

    private void initFragmentsData() {
        weatherFragmentList = new ArrayList<>();
        List<CityInfo> weatherInfosList = LitePal.findAll(CityInfo.class);
        Log.d("wangchao","weatherInfosList===="+weatherInfosList.size());
        for (int i = 0;i<weatherInfosList.size();i++){
            if (i == 0){
                WeatherFragment weaFragment = new WeatherFragment();
                Bundle args1 = new Bundle();
                args1.putString(SWConfig.FRAGEMENT_ARG_CITY, weatherInfosList.get(i).getCity());
                args1.putBoolean(SWConfig.FRAGEMENT_CITY_DEFAULT, true);
                weaFragment.setArguments(args1);
                weatherFragmentList.add(weaFragment);
            }else{
                WeatherFragment weaFragment = new WeatherFragment();
                Bundle args1 = new Bundle();
                args1.putString(SWConfig.FRAGEMENT_ARG_CITY, weatherInfosList.get(i).getCity());
                args1.putBoolean(SWConfig.FRAGEMENT_CITY_DEFAULT, false);
                weaFragment.setArguments(args1);
                weatherFragmentList.add(weaFragment);
            }
        }
        mWeahterAdapter = new FragAdapter(getSupportFragmentManager(),weatherFragmentList);
        mViewPager.setAdapter(mWeahterAdapter);
        mWeahterAdapter.notifyDataSetChanged();

        int cityId = mSApplication.getCityId();
        mViewPager.setCurrentItem(cityId);
        mViewPager.setOffscreenPageLimit(weatherFragmentList.size());
        //指示器
        if (weatherInfosList.size() == 1){
            mCircleIndicator.setVisibility(View.INVISIBLE);
        }else{
            mCircleIndicator.setVisibility(View.VISIBLE);
            mCircleIndicator.setViewPager(mViewPager);
            mWeahterAdapter.registerDataSetObserver(mCircleIndicator.getDataSetObserver());
        }
    }
    private void initToolBarSet() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                //获取mDrawerLayout中的第一个子布局，也就是布局中的RelativeLayout
                //获取抽屉的view
                View mContent = mDrawerLayout.getChildAt(0);
                float scale = 1 - slideOffset;
                float endScale = 0.8f + scale * 0.2f;
                float startScale = 1 - 0.3f * scale;
                //设置左边菜单滑动后的占据屏幕大小
                drawerView.setScaleX(startScale);
                drawerView.setScaleY(startScale);
                //设置菜单透明度
                drawerView.setAlpha(0.6f + 0.4f * (1 - scale));
                //设置内容界面水平和垂直方向偏转量
                //在滑动时内容界面的宽度为 屏幕宽度减去菜单界面所占宽度
                mContent.setTranslationX(drawerView.getMeasuredWidth() * (1 - scale));
                //设置内容界面操作无效（比如有button就会点击无效）
                mContent.invalidate();
                //设置右边菜单滑动后的占据屏幕大小
                mContent.setScaleX(endScale);
                mContent.setScaleY(endScale);
            }
        };
        toggle.syncState();
        mDrawerLayout.addDrawerListener(toggle);
    }

    private void initNavigationView() {
        mNavigationView.getMenu().findItem(R.id.nav_item_wan_android)
                .setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        startActivity(new Intent(MainActivity.this,CityManagerActivity.class));
                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                });

        mNavigationView.getMenu().findItem(R.id.nav_item_my_collect)
                .setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        startActivity(new Intent(MainActivity.this,AddCityActivity.class));
                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                });
        mNavigationView.getMenu().findItem(R.id.nav_item_setting)
                .setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        startActivity(new Intent(MainActivity.this,CityManagerActivity.class));
                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                });
    }

    private void initView() {
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mToolbar = findViewById(R.id.common_toolbar);
        mTitleText = findViewById(R.id.common_toolbar_title_tv);
        mViewPager = findViewById(R.id.main_viewpager);
        mNavigationView = findViewById(R.id.nav_view);
        mCircleIndicator = findViewById(R.id.indicator);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mlocationListener != null){
            locationClient.unRegisterLocationListener(mlocationListener);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onLocalInfoEvent(LocalInfoEvent localInfoEvent){
        if (weatherFragmentList != null){
            //执行下拉刷新
            Log.d("wangchao","onLocalInfoEvent====city="+localInfoEvent.city);
            //save city
            if (localInfoEvent.city != null){
                DBHelper.saveCity(new CityInfo(),localInfoEvent.city);
                weatherFragmentList.get(0).pullToRefresh();
            }
        }
    }

}

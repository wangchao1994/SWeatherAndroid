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
import android.widget.Toast;

import com.android.sweatherapplication.db.DBHelper;
import com.android.sweatherapplication.event.LocalInfoEvent;
import com.android.sweatherapplication.adapter.FragAdapter;
import com.android.sweatherapplication.model.CityInfo;
import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends BaseActivity{

    private DrawerLayout mDrawerLayout;
    private Toolbar mToorbar;
    private TextView mTitleText;
    private ViewPager mViewPager;
    private NavigationView mNavigationView;
    private CircleIndicator mCircleIndicator;
    private LocationClient locationClient;
    private MyLocationListener myLocationListener;
    private List<WeatherFragment> weatherFragmentList;
    private FragAdapter mWeahterAdapter;
    @Override
    protected void getLayoutId() {
        setContentView(R.layout.activity_main);
        initView();
        initToolBarSet();
        initNavigationView();
        initLocationOption();
    }
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
        //指示器1
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
                this, mDrawerLayout, mToorbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
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
                        Toast.makeText(mSApplication,"3",Toast.LENGTH_SHORT).show();
                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                });
    }

    private void initView() {
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mToorbar = findViewById(R.id.common_toolbar);
        mTitleText = findViewById(R.id.common_toolbar_title_tv);
        mViewPager = findViewById(R.id.main_viewpager);
        mNavigationView = findViewById(R.id.nav_view);
        mCircleIndicator = findViewById(R.id.indicator);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (myLocationListener != null)
        locationClient.unRegisterLocationListener(myLocationListener);
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
    /**
     * 实现定位回调
     */
    public class MyLocationListener extends BDAbstractLocationListener{
        @Override
        public void onReceiveLocation(BDLocation location){
            //获取纬度信息
            double latitude = location.getLatitude();
            //获取经度信息
            double longitude = location.getLongitude();
            Log.d("wangchao","latitude=="+latitude+"    longitude="+longitude);
            Log.d("wangchao","latitude=="+location.getDistrict());//浦东新区
            //EventBus.getDefault().post(new LocalInfoEvent(location.getCity(),location.getDistrict()));
            EventBus.getDefault().post(new LocalInfoEvent("Shanghai"));
            locationClient.stop();
        }
    }
    /**
     * 初始化定位参数配置
     */
    private void initLocationOption() {
        //定位服务的客户端。宿主程序在客户端声明此类，并调用，目前只支持在主线程中启动
        locationClient = new LocationClient(mSApplication);
        //声明LocationClient类实例并配置定位参数
        LocationClientOption locationOption = new LocationClientOption();
        myLocationListener = new MyLocationListener();
        //注册监听函数
        locationClient.registerLocationListener(myLocationListener);
        //可选，默认高精度，设置定位模式，高精度，低功耗，仅设备
        locationOption.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
        //可选，默认gcj02，设置返回的定位结果坐标系，如果配合百度地图使用，建议设置为bd09ll;
        locationOption.setCoorType("bd09ll");
        //可选，默认0，即仅定位一次，设置发起连续定位请求的间隔需要大于等于1000ms才是有效的
        locationOption.setScanSpan(1000);
        //可选，设置是否需要地址信息，默认不需要
        locationOption.setIsNeedAddress(true);
        //可选，设置是否需要地址描述
        locationOption.setIsNeedLocationDescribe(true);
        //可选，设置是否需要设备方向结果
        locationOption.setNeedDeviceDirect(false);
        //可选，默认false，设置是否当gps有效时按照1S1次频率输出GPS结果
        locationOption.setLocationNotify(true);
        //可选，默认true，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死
        locationOption.setIgnoreKillProcess(true);
        //可选，默认false，设置是否需要位置语义化结果，可以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近”
        locationOption.setIsNeedLocationDescribe(true);
        //可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到
        locationOption.setIsNeedLocationPoiList(true);
        //可选，默认false，设置是否收集CRASH信息，默认收集
        locationOption.SetIgnoreCacheException(false);
        //可选，默认false，设置是否开启Gps定位
        locationOption.setOpenGps(true);
        //可选，默认false，设置定位时是否需要海拔信息，默认不需要，除基础定位版本都可用
        locationOption.setIsNeedAltitude(false);
        //设置打开自动回调位置模式，该开关打开后，期间只要定位SDK检测到位置变化就会主动回调给开发者，该模式下开发者无需再关心定位间隔是多少，定位SDK本身发现位置变化就会及时回调给开发者
        locationOption.setOpenAutoNotifyMode();
        //设置打开自动回调位置模式，该开关打开后，期间只要定位SDK检测到位置变化就会主动回调给开发者
        locationOption.setOpenAutoNotifyMode(3000,1, LocationClientOption.LOC_SENSITIVITY_HIGHT);
        locationClient.setLocOption(locationOption);
        //开始定位
        locationClient.start();
    }
}

package com.android.sweatherapplication;


import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import com.android.mylibrary.pulltorefresh.library.PullToRefreshBase;
import com.android.mylibrary.pulltorefresh.library.PullToRefreshScrollView;
import com.android.sweatherapplication.event.QueryBeanEvent;
import com.android.sweatherapplication.model.WeatherContent;
import com.android.sweatherapplication.net.RetrofitApi;
import com.android.sweatherapplication.net.RetrofitHelper;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
/**
 * A simple {@link Fragment} subclass.
 */
public class WeatherFragment extends BaseFragment{
    private View view;
    private TextView mTvCityName;
    private PullToRefreshScrollView mPullToRefreshScrollView;
    private TextView mTvCityDate;
    private TextView mTvCityTemp;
    private String cityName;
    private boolean isCityDefault;
    private long mLastActiveUpdateTime;
    private static final String SQLQUERY_SQL="select woeid from geo.places(1) where text=\\\"\"+cityName+\", ak\\\")";
    private static final String SQLQUERY_BASE="select * from weather.forecast where woeid in ("+SQLQUERY_SQL+")";
    public WeatherFragment() {
        // Required empty public constructor
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        Bundle arguments = getArguments();
        assert arguments != null;
        cityName = arguments.getString(SWConfig.FRAGEMENT_ARG_CITY);
        isCityDefault = arguments.getBoolean(SWConfig.FRAGEMENT_CITY_DEFAULT);
        mTvCityName.setText(cityName);
        pullToRefresh();
    }



    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_weather_layout, container, false);
        initViewRes();
        return view;
    }

    private void initViewRes() {
        mTvCityName = view.findViewById(R.id.tv_main_city);
        mTvCityDate = view.findViewById(R.id.tv_main_date);
        mTvCityTemp = view.findViewById(R.id.tv_main_city_temp);
        mPullToRefreshScrollView = view.findViewById(R.id.pull_refresh_scrollview);
        setPullToRefresh();
    }

    private void setPullToRefresh() {
        mPullToRefreshScrollView.getLoadingLayoutProxy().setPullLabel(getString(R.string.pull_to_refresh));
        mPullToRefreshScrollView.getLoadingLayoutProxy().setRefreshingLabel(getString(R.string.refreshing));
        mPullToRefreshScrollView.getLoadingLayoutProxy().setReleaseLabel(getString(R.string.leave_to_refresh));
        mPullToRefreshScrollView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ScrollView>() {

            @Override
            public void onRefresh(PullToRefreshBase<ScrollView> refreshView) {
                updateCityWeather(cityName);
            }
        });
        //setTopActionabarBg(R.drawable.topactionbar_bg_01);
    }

    public void pullToRefresh() {
        new Handler().postDelayed(mRunToRresh,500);
    }

    /**
     * update data
     */
    Runnable mRunToRresh = new Runnable(){
        @Override
        public void run() {
           // if (getActivity()!= null &&!getActivity().isFinishing()){
                if(!hasActiveUpdated()){
                    mPullToRefreshScrollView.setRefreshing();
                    updateCityWeather(cityName);
                }
            //}
        }
    };
    /**
     * 更新天气
     * @param cityName
     */
    private void updateCityWeather(final String cityName) {
        Log.d("wangchao","SQLQUERY_BASE cityName=="+cityName);
        new Thread(new Runnable() {
            @Override
            public void run() {
                RetrofitHelper.getInstance().create(RetrofitApi.class, SWConfig.BASE_URL)
                        //.getWeatherData("select * from weather.forecast where woeid in (select woeid from geo.places(1) where text=\"上海, ak\")")
                        .getWeatherData("select * from weather.forecast where woeid="+2151849+" and u=\"c\"")                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<WeatherContent>() {
                            @Override
                            public void onCompleted() {
                            }

                            @Override
                            public void onError(Throwable e) {
                            }

                            @Override
                            public void onNext(WeatherContent weatherContent) {
                                String created = weatherContent.getQuery().getCreated();
                                Log.d("wangchao","created==="+created);
                                WeatherContent.QueryBean query = weatherContent.getQuery();
                                EventBus.getDefault().post(new QueryBeanEvent(query));
                                stopPullToRerefresh();
                            }
                        });
            }
        }).start();
    }

    /**
     * 是否3秒内更新过
     * @return
     */
    private boolean hasActiveUpdated() {
        if (mLastActiveUpdateTime == 0) {
            return false;
        }
        long now = SystemClock.elapsedRealtime();
        long timeD = now - mLastActiveUpdateTime;
        // 间隔3秒内不再自动更新
        return timeD <= 3000;
    }
    /**
     * stopAnimation
     */
    private void stopPullToRerefresh() {
        mPullToRefreshScrollView.onRefreshComplete();
        mLastActiveUpdateTime = SystemClock.elapsedRealtime();
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onQueryEvent(QueryBeanEvent queryBeanEvent){
        Log.d("wangchao","queryBeanEvent==="+queryBeanEvent.mQueryBean.getCreated());
        mTvCityTemp.setText(queryBeanEvent.mQueryBean.getResults().getChannel().getItem().getCondition().getTemp());
        mTvCityDate.setText(queryBeanEvent.mQueryBean.getResults().getChannel().getItem().getCondition().getDate());
    }

}

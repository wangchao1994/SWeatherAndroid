package com.android.sweatherapplication;

import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.android.sweatherapplication.db.DBHelper;
import com.android.sweatherapplication.event.SearchCityEvent;
import com.android.sweatherapplication.model.CityContent;
import com.android.sweatherapplication.model.CityInfo;
import com.android.sweatherapplication.model.WeatherContent;
import com.android.sweatherapplication.net.RetrofitApi;
import com.android.sweatherapplication.net.RetrofitHelper;
import com.android.sweatherapplication.view.CommonDialogFragment;
import com.android.sweatherapplication.view.DialogFragmentHelper;
import com.android.sweatherapplication.view.IDialogResultListener;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class SearchCityActivity extends BaseActivity implements View.OnClickListener{
    private TextView tv_search_city;
    private String woeidString;
    private ImageButton mIbAddCity;
    private String searchCityName;
    @Override
    protected void getLayoutId() {
        setContentView(R.layout.activity_search_city);
        initView();
    }

    private void initView() {
        tv_search_city = findViewById(R.id.tv_search_city);
        mIbAddCity = findViewById(R.id.ib_add_city);
        mIbAddCity.setOnClickListener(this);
    }

    @Override
    protected void initEventData() {
        Log.d("wangchao","woeidString=========="+woeidString);
        new Thread(new Runnable() {
            @Override
            public void run() {
                RetrofitHelper.getInstance().create(RetrofitApi.class,SWConfig.BASE_URL)
                        .getWeatherData("select * from weather.forecast where woeid="+woeidString+" and u=\"c\"")
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<WeatherContent>() {
                            @Override
                            public void onCompleted() {
                            }
                            @Override
                            public void onError(Throwable e) {
                                Log.d("wangchao","onSearchCityEvent---onError--------"+e.getMessage());
                            }
                            @Override
                            public void onNext(WeatherContent weatherContent) {
                               parseWeatherData(weatherContent);
                            }
                        });
            }
        }).start();
    }
    /**
     * 解析数据
     * @param weatherContent
     */
    private void parseWeatherData(WeatherContent weatherContent) {
        String city = weatherContent.getQuery().getResults().getChannel().getLocation().getCity();
        Log.d("wangchao","onSearchCityEvent-----------"+city);
        searchCityName = city;
        tv_search_city.setText(searchCityName);
    }

    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void onSearchCityEvent(SearchCityEvent searchCityEvent){
        woeidString = searchCityEvent.woeid;
        Log.d("wangchao","searchCityEvent-===="+searchCityEvent.woeid);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ib_add_city:
                DialogFragmentHelper.showConfirmDialog(getSupportFragmentManager(), "Add To MainPage？", new IDialogResultListener<Integer>() {
                    @Override
                    public void onDataResult(Integer result) {
                        if (!"".equals(searchCityName) && searchCityName != null){
                            DBHelper.saveCity(new CityInfo(),searchCityName);
                        }
                    }
                }, true, new CommonDialogFragment.OnDialogCancelListener() {
                    @Override
                    public void onCancel() {
                    }
                });
                break;
        }
    }
    @Override
    protected void onDestoryEvent() {

    }
}

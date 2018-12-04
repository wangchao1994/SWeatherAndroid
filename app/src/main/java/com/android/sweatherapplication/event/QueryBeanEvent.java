package com.android.sweatherapplication.event;

import com.android.sweatherapplication.model.WeatherContent;

public class QueryBeanEvent {
    public WeatherContent.QueryBean mQueryBean;
    public QueryBeanEvent(WeatherContent.QueryBean queryBean){
        this.mQueryBean = queryBean;
    }
}

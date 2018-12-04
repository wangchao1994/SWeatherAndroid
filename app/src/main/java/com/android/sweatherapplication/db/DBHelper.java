package com.android.sweatherapplication.db;

import com.android.sweatherapplication.model.CityInfo;

import org.litepal.LitePal;

import java.util.List;

public class DBHelper {
    //city weather
    public static void saveCity(CityInfo weatherInfo, String city){
        weatherInfo.setCity(city);
        weatherInfo.save();
    }
    //location city
    public static List<CityInfo> getListCityInfo(){
        List<CityInfo> cityInfoList = LitePal.findAll(CityInfo.class);
        return cityInfoList;
    }
}

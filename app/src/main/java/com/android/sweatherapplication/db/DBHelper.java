package com.android.sweatherapplication.db;

import com.android.sweatherapplication.model.CityInfo;

public class DBHelper {
    //city weather
    public static void saveCity(CityInfo weatherInfo, String city){
        weatherInfo.setCity(city);
        weatherInfo.save();
    }
}

package com.android.sweatherapplication.net;

import com.android.sweatherapplication.model.CityContent;
import com.android.sweatherapplication.model.WeatherContent;


import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface RetrofitApi {
    /**
     * MOb weather
     *   @GET("v1/weather/query?key=164a1b6066c53")
         Call<GetWeatherInfoResponse> getWeatherInfo(@Query("city") String city, @Query("province") String province);
         @GET("v1/weather/citys?key=164a1b6066c53")
         Call<GetCitiesInfoRespone> getCities();
     * @param username user name
     * @param password password
     * @return 登陆数据
     */

    @GET("v1/public/yql?format=json")
    Observable<WeatherContent> getWeatherData(@Query("q") String q);

    @GET("v1/public/yql?format=json")
    Observable<CityContent> getCityListData(@Query("q") String q);
}

package com.android.sweatherapplication.net;

import com.android.sweatherapplication.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {
    private static final long TIMEOUT = 10;
    private static RetrofitHelper mInstance;
    private OkHttpClient.Builder mOkHttpClient;

    public static RetrofitHelper getInstance(){
        if (null == mInstance){
            synchronized (RetrofitHelper.class){
                if (null == mInstance){
                    mInstance = new RetrofitHelper();
                }
            }
        }
        return mInstance;
    }
    public RetrofitHelper(){
        initRetrofit();
    }

    private void initRetrofit() {
        mOkHttpClient = new OkHttpClient.Builder()
                .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT, TimeUnit.SECONDS);
        if (BuildConfig.DEBUG){
        //如果是Debug模式，则添加日志拦截器
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            mOkHttpClient.addInterceptor(httpLoggingInterceptor);
        }
    }
    /**
     * 创建API
     */
    public <T> T create(Class<T> clazz,String baseUrl){
        checkNotNull(baseUrl,"BaseUrl is Null--------------------");
        checkNotNull(clazz,"clazz is Null--------------------");
        return new Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(mOkHttpClient.build())
                .build()
                .create(clazz);
    }
    /**
     * 检查对象是否为空
     * */
    private <T> T checkNotNull(T object, String s) {
        if (object == null){
            throw new NullPointerException(s);
        }
        return object;
    }

}

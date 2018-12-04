package com.android.sweatherapplication.model;

import org.litepal.annotation.Column;
import org.litepal.crud.LitePalSupport;

public class CityInfo extends LitePalSupport {
    @Column(unique = true, defaultValue = "unknown")
    private String city;

    private String temp;
    private String date;
    private String lastBuildDate;

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLastBuildDate() {
        return lastBuildDate;
    }

    public void setLastBuildDate(String lastBuildDate) {
        this.lastBuildDate = lastBuildDate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

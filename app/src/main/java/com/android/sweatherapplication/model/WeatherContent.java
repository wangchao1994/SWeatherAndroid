package com.android.sweatherapplication.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherContent {

    /**
     * query : {"count":1,"created":"2018-11-30T05:10:44Z","lang":"en-US","results":{"channel":{"units":{"distance":"mi","pressure":"in","speed":"mph","temperature":"F"},"title":"Yahoo! Weather - Hsi-an, Shaanxi, CN","link":"http://us.rd.yahoo.com/dailynews/rss/weather/Country__Country/*https://weather.yahoo.com/country/state/city-2155661/","description":"Yahoo! Weather for Hsi-an, Shaanxi, CN","language":"en-us","lastBuildDate":"Fri, 30 Nov 2018 01:10 PM CST","ttl":"60","location":{"city":"Hsi-an","country":"China","region":" Shaanxi"},"wind":{"chill":"46","direction":"225","speed":"5"},"atmosphere":{"humidity":"61","pressure":"975.0","rising":"0","visibility":"16.1"},"astronomy":{"sunrise":"7:32 am","sunset":"5:35 pm"},"image":{"title":"Yahoo! Weather","width":"142","height":"18","link":"http://weather.yahoo.com","url":"http://l.yimg.com/a/i/brand/purplelogo//uh/us/news-wea.gif"},"item":{"title":"Conditions for Hsi-an, Shaanxi, CN at 12:00 PM CST","lat":"34.2603","long":"108.9356","link":"http://us.rd.yahoo.com/dailynews/rss/weather/Country__Country/*https://weather.yahoo.com/country/state/city-2155661/","pubDate":"Fri, 30 Nov 2018 12:00 PM CST","condition":{"code":"26","date":"Fri, 30 Nov 2018 12:00 PM CST","temp":"48","text":"Cloudy"},"forecast":[{"code":"28","date":"30 Nov 2018","day":"Fri","high":"53","low":"38","text":"Mostly Cloudy"},{"code":"28","date":"01 Dec 2018","day":"Sat","high":"55","low":"34","text":"Mostly Cloudy"},{"code":"30","date":"02 Dec 2018","day":"Sun","high":"52","low":"34","text":"Partly Cloudy"},{"code":"28","date":"03 Dec 2018","day":"Mon","high":"47","low":"30","text":"Mostly Cloudy"},{"code":"34","date":"04 Dec 2018","day":"Tue","high":"47","low":"24","text":"Mostly Sunny"},{"code":"28","date":"05 Dec 2018","day":"Wed","high":"41","low":"20","text":"Mostly Cloudy"},{"code":"30","date":"06 Dec 2018","day":"Thu","high":"41","low":"24","text":"Partly Cloudy"},{"code":"30","date":"07 Dec 2018","day":"Fri","high":"40","low":"21","text":"Partly Cloudy"},{"code":"30","date":"08 Dec 2018","day":"Sat","high":"41","low":"19","text":"Partly Cloudy"},{"code":"34","date":"09 Dec 2018","day":"Sun","high":"42","low":"19","text":"Mostly Sunny"}],"description":"<![CDATA[<img src=\"http://l.yimg.com/a/i/us/we/52/26.gif\"/>\n<BR />\n<b>Current Conditions:<\/b>\n<BR />Cloudy\n<BR />\n<BR />\n<b>Forecast:<\/b>\n<BR /> Fri - Mostly Cloudy. High: 53Low: 38\n<BR /> Sat - Mostly Cloudy. High: 55Low: 34\n<BR /> Sun - Partly Cloudy. High: 52Low: 34\n<BR /> Mon - Mostly Cloudy. High: 47Low: 30\n<BR /> Tue - Mostly Sunny. High: 47Low: 24\n<BR />\n<BR />\n<a href=\"http://us.rd.yahoo.com/dailynews/rss/weather/Country__Country/*https://weather.yahoo.com/country/state/city-2155661/\">Full Forecast at Yahoo! Weather<\/a>\n<BR />\n<BR />\n<BR />\n]]>","guid":{"isPermaLink":"false"}}}}}
     */

    private QueryBean query;

    public QueryBean getQuery() {
        return query;
    }

    public void setQuery(QueryBean query) {
        this.query = query;
    }

    public static class QueryBean {
        /**
         * count : 1
         * created : 2018-11-30T05:10:44Z
         * lang : en-US
         * results : {"channel":{"units":{"distance":"mi","pressure":"in","speed":"mph","temperature":"F"},"title":"Yahoo! Weather - Hsi-an, Shaanxi, CN","link":"http://us.rd.yahoo.com/dailynews/rss/weather/Country__Country/*https://weather.yahoo.com/country/state/city-2155661/","description":"Yahoo! Weather for Hsi-an, Shaanxi, CN","language":"en-us","lastBuildDate":"Fri, 30 Nov 2018 01:10 PM CST","ttl":"60","location":{"city":"Hsi-an","country":"China","region":" Shaanxi"},"wind":{"chill":"46","direction":"225","speed":"5"},"atmosphere":{"humidity":"61","pressure":"975.0","rising":"0","visibility":"16.1"},"astronomy":{"sunrise":"7:32 am","sunset":"5:35 pm"},"image":{"title":"Yahoo! Weather","width":"142","height":"18","link":"http://weather.yahoo.com","url":"http://l.yimg.com/a/i/brand/purplelogo//uh/us/news-wea.gif"},"item":{"title":"Conditions for Hsi-an, Shaanxi, CN at 12:00 PM CST","lat":"34.2603","long":"108.9356","link":"http://us.rd.yahoo.com/dailynews/rss/weather/Country__Country/*https://weather.yahoo.com/country/state/city-2155661/","pubDate":"Fri, 30 Nov 2018 12:00 PM CST","condition":{"code":"26","date":"Fri, 30 Nov 2018 12:00 PM CST","temp":"48","text":"Cloudy"},"forecast":[{"code":"28","date":"30 Nov 2018","day":"Fri","high":"53","low":"38","text":"Mostly Cloudy"},{"code":"28","date":"01 Dec 2018","day":"Sat","high":"55","low":"34","text":"Mostly Cloudy"},{"code":"30","date":"02 Dec 2018","day":"Sun","high":"52","low":"34","text":"Partly Cloudy"},{"code":"28","date":"03 Dec 2018","day":"Mon","high":"47","low":"30","text":"Mostly Cloudy"},{"code":"34","date":"04 Dec 2018","day":"Tue","high":"47","low":"24","text":"Mostly Sunny"},{"code":"28","date":"05 Dec 2018","day":"Wed","high":"41","low":"20","text":"Mostly Cloudy"},{"code":"30","date":"06 Dec 2018","day":"Thu","high":"41","low":"24","text":"Partly Cloudy"},{"code":"30","date":"07 Dec 2018","day":"Fri","high":"40","low":"21","text":"Partly Cloudy"},{"code":"30","date":"08 Dec 2018","day":"Sat","high":"41","low":"19","text":"Partly Cloudy"},{"code":"34","date":"09 Dec 2018","day":"Sun","high":"42","low":"19","text":"Mostly Sunny"}],"description":"<![CDATA[<img src=\"http://l.yimg.com/a/i/us/we/52/26.gif\"/>\n<BR />\n<b>Current Conditions:<\/b>\n<BR />Cloudy\n<BR />\n<BR />\n<b>Forecast:<\/b>\n<BR /> Fri - Mostly Cloudy. High: 53Low: 38\n<BR /> Sat - Mostly Cloudy. High: 55Low: 34\n<BR /> Sun - Partly Cloudy. High: 52Low: 34\n<BR /> Mon - Mostly Cloudy. High: 47Low: 30\n<BR /> Tue - Mostly Sunny. High: 47Low: 24\n<BR />\n<BR />\n<a href=\"http://us.rd.yahoo.com/dailynews/rss/weather/Country__Country/*https://weather.yahoo.com/country/state/city-2155661/\">Full Forecast at Yahoo! Weather<\/a>\n<BR />\n<BR />\n<BR />\n]]>","guid":{"isPermaLink":"false"}}}}
         */

        private int count;
        private String created;
        private String lang;
        private ResultsBean results;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getCreated() {
            return created;
        }

        public void setCreated(String created) {
            this.created = created;
        }

        public String getLang() {
            return lang;
        }

        public void setLang(String lang) {
            this.lang = lang;
        }

        public ResultsBean getResults() {
            return results;
        }

        public void setResults(ResultsBean results) {
            this.results = results;
        }

        public static class ResultsBean {
            /**
             * channel : {"units":{"distance":"mi","pressure":"in","speed":"mph","temperature":"F"},"title":"Yahoo! Weather - Hsi-an, Shaanxi, CN","link":"http://us.rd.yahoo.com/dailynews/rss/weather/Country__Country/*https://weather.yahoo.com/country/state/city-2155661/","description":"Yahoo! Weather for Hsi-an, Shaanxi, CN","language":"en-us","lastBuildDate":"Fri, 30 Nov 2018 01:10 PM CST","ttl":"60","location":{"city":"Hsi-an","country":"China","region":" Shaanxi"},"wind":{"chill":"46","direction":"225","speed":"5"},"atmosphere":{"humidity":"61","pressure":"975.0","rising":"0","visibility":"16.1"},"astronomy":{"sunrise":"7:32 am","sunset":"5:35 pm"},"image":{"title":"Yahoo! Weather","width":"142","height":"18","link":"http://weather.yahoo.com","url":"http://l.yimg.com/a/i/brand/purplelogo//uh/us/news-wea.gif"},"item":{"title":"Conditions for Hsi-an, Shaanxi, CN at 12:00 PM CST","lat":"34.2603","long":"108.9356","link":"http://us.rd.yahoo.com/dailynews/rss/weather/Country__Country/*https://weather.yahoo.com/country/state/city-2155661/","pubDate":"Fri, 30 Nov 2018 12:00 PM CST","condition":{"code":"26","date":"Fri, 30 Nov 2018 12:00 PM CST","temp":"48","text":"Cloudy"},"forecast":[{"code":"28","date":"30 Nov 2018","day":"Fri","high":"53","low":"38","text":"Mostly Cloudy"},{"code":"28","date":"01 Dec 2018","day":"Sat","high":"55","low":"34","text":"Mostly Cloudy"},{"code":"30","date":"02 Dec 2018","day":"Sun","high":"52","low":"34","text":"Partly Cloudy"},{"code":"28","date":"03 Dec 2018","day":"Mon","high":"47","low":"30","text":"Mostly Cloudy"},{"code":"34","date":"04 Dec 2018","day":"Tue","high":"47","low":"24","text":"Mostly Sunny"},{"code":"28","date":"05 Dec 2018","day":"Wed","high":"41","low":"20","text":"Mostly Cloudy"},{"code":"30","date":"06 Dec 2018","day":"Thu","high":"41","low":"24","text":"Partly Cloudy"},{"code":"30","date":"07 Dec 2018","day":"Fri","high":"40","low":"21","text":"Partly Cloudy"},{"code":"30","date":"08 Dec 2018","day":"Sat","high":"41","low":"19","text":"Partly Cloudy"},{"code":"34","date":"09 Dec 2018","day":"Sun","high":"42","low":"19","text":"Mostly Sunny"}],"description":"<![CDATA[<img src=\"http://l.yimg.com/a/i/us/we/52/26.gif\"/>\n<BR />\n<b>Current Conditions:<\/b>\n<BR />Cloudy\n<BR />\n<BR />\n<b>Forecast:<\/b>\n<BR /> Fri - Mostly Cloudy. High: 53Low: 38\n<BR /> Sat - Mostly Cloudy. High: 55Low: 34\n<BR /> Sun - Partly Cloudy. High: 52Low: 34\n<BR /> Mon - Mostly Cloudy. High: 47Low: 30\n<BR /> Tue - Mostly Sunny. High: 47Low: 24\n<BR />\n<BR />\n<a href=\"http://us.rd.yahoo.com/dailynews/rss/weather/Country__Country/*https://weather.yahoo.com/country/state/city-2155661/\">Full Forecast at Yahoo! Weather<\/a>\n<BR />\n<BR />\n<BR />\n]]>","guid":{"isPermaLink":"false"}}}
             */

            private ChannelBean channel;

            public ChannelBean getChannel() {
                return channel;
            }

            public void setChannel(ChannelBean channel) {
                this.channel = channel;
            }

            public static class ChannelBean {
                /**
                 * units : {"distance":"mi","pressure":"in","speed":"mph","temperature":"F"}
                 * title : Yahoo! Weather - Hsi-an, Shaanxi, CN
                 * link : http://us.rd.yahoo.com/dailynews/rss/weather/Country__Country/*https://weather.yahoo.com/country/state/city-2155661/
                 * description : Yahoo! Weather for Hsi-an, Shaanxi, CN
                 * language : en-us
                 * lastBuildDate : Fri, 30 Nov 2018 01:10 PM CST
                 * ttl : 60
                 * location : {"city":"Hsi-an","country":"China","region":" Shaanxi"}
                 * wind : {"chill":"46","direction":"225","speed":"5"}
                 * atmosphere : {"humidity":"61","pressure":"975.0","rising":"0","visibility":"16.1"}
                 * astronomy : {"sunrise":"7:32 am","sunset":"5:35 pm"}
                 * image : {"title":"Yahoo! Weather","width":"142","height":"18","link":"http://weather.yahoo.com","url":"http://l.yimg.com/a/i/brand/purplelogo//uh/us/news-wea.gif"}
                 * item : {"title":"Conditions for Hsi-an, Shaanxi, CN at 12:00 PM CST","lat":"34.2603","long":"108.9356","link":"http://us.rd.yahoo.com/dailynews/rss/weather/Country__Country/*https://weather.yahoo.com/country/state/city-2155661/","pubDate":"Fri, 30 Nov 2018 12:00 PM CST","condition":{"code":"26","date":"Fri, 30 Nov 2018 12:00 PM CST","temp":"48","text":"Cloudy"},"forecast":[{"code":"28","date":"30 Nov 2018","day":"Fri","high":"53","low":"38","text":"Mostly Cloudy"},{"code":"28","date":"01 Dec 2018","day":"Sat","high":"55","low":"34","text":"Mostly Cloudy"},{"code":"30","date":"02 Dec 2018","day":"Sun","high":"52","low":"34","text":"Partly Cloudy"},{"code":"28","date":"03 Dec 2018","day":"Mon","high":"47","low":"30","text":"Mostly Cloudy"},{"code":"34","date":"04 Dec 2018","day":"Tue","high":"47","low":"24","text":"Mostly Sunny"},{"code":"28","date":"05 Dec 2018","day":"Wed","high":"41","low":"20","text":"Mostly Cloudy"},{"code":"30","date":"06 Dec 2018","day":"Thu","high":"41","low":"24","text":"Partly Cloudy"},{"code":"30","date":"07 Dec 2018","day":"Fri","high":"40","low":"21","text":"Partly Cloudy"},{"code":"30","date":"08 Dec 2018","day":"Sat","high":"41","low":"19","text":"Partly Cloudy"},{"code":"34","date":"09 Dec 2018","day":"Sun","high":"42","low":"19","text":"Mostly Sunny"}],"description":"<![CDATA[<img src=\"http://l.yimg.com/a/i/us/we/52/26.gif\"/>\n<BR />\n<b>Current Conditions:<\/b>\n<BR />Cloudy\n<BR />\n<BR />\n<b>Forecast:<\/b>\n<BR /> Fri - Mostly Cloudy. High: 53Low: 38\n<BR /> Sat - Mostly Cloudy. High: 55Low: 34\n<BR /> Sun - Partly Cloudy. High: 52Low: 34\n<BR /> Mon - Mostly Cloudy. High: 47Low: 30\n<BR /> Tue - Mostly Sunny. High: 47Low: 24\n<BR />\n<BR />\n<a href=\"http://us.rd.yahoo.com/dailynews/rss/weather/Country__Country/*https://weather.yahoo.com/country/state/city-2155661/\">Full Forecast at Yahoo! Weather<\/a>\n<BR />\n<BR />\n<BR />\n]]>","guid":{"isPermaLink":"false"}}
                 */

                private UnitsBean units;
                private String title;
                private String link;
                private String description;
                private String language;
                private String lastBuildDate;
                private String ttl;
                private LocationBean location;
                private WindBean wind;
                private AtmosphereBean atmosphere;
                private AstronomyBean astronomy;
                private ImageBean image;
                private ItemBean item;

                public UnitsBean getUnits() {
                    return units;
                }

                public void setUnits(UnitsBean units) {
                    this.units = units;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getLink() {
                    return link;
                }

                public void setLink(String link) {
                    this.link = link;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public String getLanguage() {
                    return language;
                }

                public void setLanguage(String language) {
                    this.language = language;
                }

                public String getLastBuildDate() {
                    return lastBuildDate;
                }

                public void setLastBuildDate(String lastBuildDate) {
                    this.lastBuildDate = lastBuildDate;
                }

                public String getTtl() {
                    return ttl;
                }

                public void setTtl(String ttl) {
                    this.ttl = ttl;
                }

                public LocationBean getLocation() {
                    return location;
                }

                public void setLocation(LocationBean location) {
                    this.location = location;
                }

                public WindBean getWind() {
                    return wind;
                }

                public void setWind(WindBean wind) {
                    this.wind = wind;
                }

                public AtmosphereBean getAtmosphere() {
                    return atmosphere;
                }

                public void setAtmosphere(AtmosphereBean atmosphere) {
                    this.atmosphere = atmosphere;
                }

                public AstronomyBean getAstronomy() {
                    return astronomy;
                }

                public void setAstronomy(AstronomyBean astronomy) {
                    this.astronomy = astronomy;
                }

                public ImageBean getImage() {
                    return image;
                }

                public void setImage(ImageBean image) {
                    this.image = image;
                }

                public ItemBean getItem() {
                    return item;
                }

                public void setItem(ItemBean item) {
                    this.item = item;
                }

                public static class UnitsBean {
                    /**
                     * distance : mi
                     * pressure : in
                     * speed : mph
                     * temperature : F
                     */

                    private String distance;
                    private String pressure;
                    private String speed;
                    private String temperature;

                    public String getDistance() {
                        return distance;
                    }

                    public void setDistance(String distance) {
                        this.distance = distance;
                    }

                    public String getPressure() {
                        return pressure;
                    }

                    public void setPressure(String pressure) {
                        this.pressure = pressure;
                    }

                    public String getSpeed() {
                        return speed;
                    }

                    public void setSpeed(String speed) {
                        this.speed = speed;
                    }

                    public String getTemperature() {
                        return temperature;
                    }

                    public void setTemperature(String temperature) {
                        this.temperature = temperature;
                    }
                }

                public static class LocationBean {
                    /**
                     * city : Hsi-an
                     * country : China
                     * region :  Shaanxi
                     */

                    private String city;
                    private String country;
                    private String region;

                    public String getCity() {
                        return city;
                    }

                    public void setCity(String city) {
                        this.city = city;
                    }

                    public String getCountry() {
                        return country;
                    }

                    public void setCountry(String country) {
                        this.country = country;
                    }

                    public String getRegion() {
                        return region;
                    }

                    public void setRegion(String region) {
                        this.region = region;
                    }
                }

                public static class WindBean {
                    /**
                     * chill : 46
                     * direction : 225
                     * speed : 5
                     */

                    private String chill;
                    private String direction;
                    private String speed;

                    public String getChill() {
                        return chill;
                    }

                    public void setChill(String chill) {
                        this.chill = chill;
                    }

                    public String getDirection() {
                        return direction;
                    }

                    public void setDirection(String direction) {
                        this.direction = direction;
                    }

                    public String getSpeed() {
                        return speed;
                    }

                    public void setSpeed(String speed) {
                        this.speed = speed;
                    }
                }

                public static class AtmosphereBean {
                    /**
                     * humidity : 61
                     * pressure : 975.0
                     * rising : 0
                     * visibility : 16.1
                     */

                    private String humidity;
                    private String pressure;
                    private String rising;
                    private String visibility;

                    public String getHumidity() {
                        return humidity;
                    }

                    public void setHumidity(String humidity) {
                        this.humidity = humidity;
                    }

                    public String getPressure() {
                        return pressure;
                    }

                    public void setPressure(String pressure) {
                        this.pressure = pressure;
                    }

                    public String getRising() {
                        return rising;
                    }

                    public void setRising(String rising) {
                        this.rising = rising;
                    }

                    public String getVisibility() {
                        return visibility;
                    }

                    public void setVisibility(String visibility) {
                        this.visibility = visibility;
                    }
                }

                public static class AstronomyBean {
                    /**
                     * sunrise : 7:32 am
                     * sunset : 5:35 pm
                     */

                    private String sunrise;
                    private String sunset;

                    public String getSunrise() {
                        return sunrise;
                    }

                    public void setSunrise(String sunrise) {
                        this.sunrise = sunrise;
                    }

                    public String getSunset() {
                        return sunset;
                    }

                    public void setSunset(String sunset) {
                        this.sunset = sunset;
                    }
                }

                public static class ImageBean {
                    /**
                     * title : Yahoo! Weather
                     * width : 142
                     * height : 18
                     * link : http://weather.yahoo.com
                     * url : http://l.yimg.com/a/i/brand/purplelogo//uh/us/news-wea.gif
                     */

                    private String title;
                    private String width;
                    private String height;
                    private String link;
                    private String url;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getWidth() {
                        return width;
                    }

                    public void setWidth(String width) {
                        this.width = width;
                    }

                    public String getHeight() {
                        return height;
                    }

                    public void setHeight(String height) {
                        this.height = height;
                    }

                    public String getLink() {
                        return link;
                    }

                    public void setLink(String link) {
                        this.link = link;
                    }

                    public String getUrl() {
                        return url;
                    }

                    public void setUrl(String url) {
                        this.url = url;
                    }
                }

                public static class ItemBean {
                    /**
                     * title : Conditions for Hsi-an, Shaanxi, CN at 12:00 PM CST
                     * lat : 34.2603
                     * long : 108.9356
                     * link : http://us.rd.yahoo.com/dailynews/rss/weather/Country__Country/*https://weather.yahoo.com/country/state/city-2155661/
                     * pubDate : Fri, 30 Nov 2018 12:00 PM CST
                     * condition : {"code":"26","date":"Fri, 30 Nov 2018 12:00 PM CST","temp":"48","text":"Cloudy"}
                     * forecast : [{"code":"28","date":"30 Nov 2018","day":"Fri","high":"53","low":"38","text":"Mostly Cloudy"},{"code":"28","date":"01 Dec 2018","day":"Sat","high":"55","low":"34","text":"Mostly Cloudy"},{"code":"30","date":"02 Dec 2018","day":"Sun","high":"52","low":"34","text":"Partly Cloudy"},{"code":"28","date":"03 Dec 2018","day":"Mon","high":"47","low":"30","text":"Mostly Cloudy"},{"code":"34","date":"04 Dec 2018","day":"Tue","high":"47","low":"24","text":"Mostly Sunny"},{"code":"28","date":"05 Dec 2018","day":"Wed","high":"41","low":"20","text":"Mostly Cloudy"},{"code":"30","date":"06 Dec 2018","day":"Thu","high":"41","low":"24","text":"Partly Cloudy"},{"code":"30","date":"07 Dec 2018","day":"Fri","high":"40","low":"21","text":"Partly Cloudy"},{"code":"30","date":"08 Dec 2018","day":"Sat","high":"41","low":"19","text":"Partly Cloudy"},{"code":"34","date":"09 Dec 2018","day":"Sun","high":"42","low":"19","text":"Mostly Sunny"}]
                     * description : <![CDATA[<img src="http://l.yimg.com/a/i/us/we/52/26.gif"/>
                     <BR />
                     <b>Current Conditions:</b>
                     <BR />Cloudy
                     <BR />
                     <BR />
                     <b>Forecast:</b>
                     <BR /> Fri - Mostly Cloudy. High: 53Low: 38
                     <BR /> Sat - Mostly Cloudy. High: 55Low: 34
                     <BR /> Sun - Partly Cloudy. High: 52Low: 34
                     <BR /> Mon - Mostly Cloudy. High: 47Low: 30
                     <BR /> Tue - Mostly Sunny. High: 47Low: 24
                     <BR />
                     <BR />
                     <a href="http://us.rd.yahoo.com/dailynews/rss/weather/Country__Country/*https://weather.yahoo.com/country/state/city-2155661/">Full Forecast at Yahoo! Weather</a>
                     <BR />
                     <BR />
                     <BR />
                     ]]>
                     * guid : {"isPermaLink":"false"}
                     */

                    private String title;
                    private String lat;
                    @SerializedName("long")
                    private String longX;
                    private String link;
                    private String pubDate;
                    private ConditionBean condition;
                    private String description;
                    private GuidBean guid;
                    private List<ForecastBean> forecast;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getLat() {
                        return lat;
                    }

                    public void setLat(String lat) {
                        this.lat = lat;
                    }

                    public String getLongX() {
                        return longX;
                    }

                    public void setLongX(String longX) {
                        this.longX = longX;
                    }

                    public String getLink() {
                        return link;
                    }

                    public void setLink(String link) {
                        this.link = link;
                    }

                    public String getPubDate() {
                        return pubDate;
                    }

                    public void setPubDate(String pubDate) {
                        this.pubDate = pubDate;
                    }

                    public ConditionBean getCondition() {
                        return condition;
                    }

                    public void setCondition(ConditionBean condition) {
                        this.condition = condition;
                    }

                    public String getDescription() {
                        return description;
                    }

                    public void setDescription(String description) {
                        this.description = description;
                    }

                    public GuidBean getGuid() {
                        return guid;
                    }

                    public void setGuid(GuidBean guid) {
                        this.guid = guid;
                    }

                    public List<ForecastBean> getForecast() {
                        return forecast;
                    }

                    public void setForecast(List<ForecastBean> forecast) {
                        this.forecast = forecast;
                    }

                    public static class ConditionBean {
                        /**
                         * code : 26
                         * date : Fri, 30 Nov 2018 12:00 PM CST
                         * temp : 48
                         * text : Cloudy
                         */

                        private String code;
                        private String date;
                        private String temp;
                        private String text;

                        public String getCode() {
                            return code;
                        }

                        public void setCode(String code) {
                            this.code = code;
                        }

                        public String getDate() {
                            return date;
                        }

                        public void setDate(String date) {
                            this.date = date;
                        }

                        public String getTemp() {
                            return temp;
                        }

                        public void setTemp(String temp) {
                            this.temp = temp;
                        }

                        public String getText() {
                            return text;
                        }

                        public void setText(String text) {
                            this.text = text;
                        }
                    }

                    public static class GuidBean {
                        /**
                         * isPermaLink : false
                         */

                        private String isPermaLink;

                        public String getIsPermaLink() {
                            return isPermaLink;
                        }

                        public void setIsPermaLink(String isPermaLink) {
                            this.isPermaLink = isPermaLink;
                        }
                    }

                    public static class ForecastBean {
                        /**
                         * code : 28
                         * date : 30 Nov 2018
                         * day : Fri
                         * high : 53
                         * low : 38
                         * text : Mostly Cloudy
                         */

                        private String code;
                        private String date;
                        private String day;
                        private String high;
                        private String low;
                        private String text;

                        public String getCode() {
                            return code;
                        }

                        public void setCode(String code) {
                            this.code = code;
                        }

                        public String getDate() {
                            return date;
                        }

                        public void setDate(String date) {
                            this.date = date;
                        }

                        public String getDay() {
                            return day;
                        }

                        public void setDay(String day) {
                            this.day = day;
                        }

                        public String getHigh() {
                            return high;
                        }

                        public void setHigh(String high) {
                            this.high = high;
                        }

                        public String getLow() {
                            return low;
                        }

                        public void setLow(String low) {
                            this.low = low;
                        }

                        public String getText() {
                            return text;
                        }

                        public void setText(String text) {
                            this.text = text;
                        }
                    }
                }
            }
        }
    }
}

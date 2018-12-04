package com.android.sweatherapplication.model;

import java.util.List;

public class CityContent {

    /**
     * query : {"count":3,"created":"2018-12-03T09:33:20Z","lang":"en-US","results":{"place":[{"name":"United States","country":null,"admin1":null,"admin2":null,"woeid":"23424977","timezone":{"type":"Time Zone","woeid":"28350914","content":"Europe/Rome"}},{"name":"American","country":{"code":"IT","type":"Country","woeid":"23424853","content":"Italy"},"admin1":{"code":"IT-ER","type":"Region","woeid":"7153334","content":"Emilia Romagna"},"admin2":{"code":"","type":"Province","woeid":"15022641","content":"Rimini"},"timezone":{"type":"Time Zone","woeid":"28350914","content":"Europe/Rome"},"woeid":"90124356"},{"name":"American","country":{"code":"AR","type":"Country","woeid":"23424747","content":"Argentina"},"admin1":{"code":"AR-BA","type":"Province","woeid":"2344675","content":"Buenos Aires Province"},"admin2":{"code":"","type":"Department","woeid":"20070758","content":"Tres de Febrero"},"timezone":{"type":"Time Zone","woeid":"56043551","content":"America/Argentina/Buenos_Aires"},"woeid":"91824399"}]}}
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
         * count : 3
         * created : 2018-12-03T09:33:20Z
         * lang : en-US
         * results : {"place":[{"name":"United States","country":null,"admin1":null,"admin2":null,"woeid":"23424977"},{"name":"American","country":{"code":"IT","type":"Country","woeid":"23424853","content":"Italy"},"admin1":{"code":"IT-ER","type":"Region","woeid":"7153334","content":"Emilia Romagna"},"admin2":{"code":"","type":"Province","woeid":"15022641","content":"Rimini"},"timezone":{"type":"Time Zone","woeid":"28350914","content":"Europe/Rome"},"woeid":"90124356"},{"name":"American","country":{"code":"AR","type":"Country","woeid":"23424747","content":"Argentina"},"admin1":{"code":"AR-BA","type":"Province","woeid":"2344675","content":"Buenos Aires Province"},"admin2":{"code":"","type":"Department","woeid":"20070758","content":"Tres de Febrero"},"timezone":{"type":"Time Zone","woeid":"56043551","content":"America/Argentina/Buenos_Aires"},"woeid":"91824399"}]}
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
            private List<PlaceBean> place;

            public List<PlaceBean> getPlace() {
                return place;
            }

            public void setPlace(List<PlaceBean> place) {
                this.place = place;
            }

            public static class PlaceBean {
                /**
                 * name : United States
                 * country : null
                 * admin1 : null
                 * admin2 : null
                 * woeid : 23424977
                 * timezone : {"type":"Time Zone","woeid":"28350914","content":"Europe/Rome"}
                 */

                private String name;
                private Object country;
                private Object admin1;
                private Object admin2;
                private String woeid;
                private TimezoneBean timezone;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public Object getCountry() {
                    return country;
                }

                public void setCountry(Object country) {
                    this.country = country;
                }

                public Object getAdmin1() {
                    return admin1;
                }

                public void setAdmin1(Object admin1) {
                    this.admin1 = admin1;
                }

                public Object getAdmin2() {
                    return admin2;
                }

                public void setAdmin2(Object admin2) {
                    this.admin2 = admin2;
                }

                public String getWoeid() {
                    return woeid;
                }

                public void setWoeid(String woeid) {
                    this.woeid = woeid;
                }

                public TimezoneBean getTimezone() {
                    return timezone;
                }

                public void setTimezone(TimezoneBean timezone) {
                    this.timezone = timezone;
                }

                public static class TimezoneBean {
                    /**
                     * type : Time Zone
                     * woeid : 28350914
                     * content : Europe/Rome
                     */

                    private String type;
                    private String woeid;
                    private String content;

                    public String getType() {
                        return type;
                    }

                    public void setType(String type) {
                        this.type = type;
                    }

                    public String getWoeid() {
                        return woeid;
                    }

                    public void setWoeid(String woeid) {
                        this.woeid = woeid;
                    }

                    public String getContent() {
                        return content;
                    }

                    public void setContent(String content) {
                        this.content = content;
                    }
                }
            }
        }
    }
}

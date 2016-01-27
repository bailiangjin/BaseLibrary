package com.kevin.building.demo.networkdemo.weather.model;

/**
 * 作者：bailiangjin  bailiangjin@gmail.com
 * 创建时间：15/12/11 20:50
 */
public class WeatherCityInfo {

    /**
     * city : 北京
     * cityid : 101010100
     * temp1 : 18℃
     * temp2 : 30℃
     * weather : 多云转晴
     * img1 : n1.gif
     * img2 : d0.gif
     * ptime : 18:00
     */

    private WeatherinfoEntity weatherinfo;

    public void setWeatherinfo(WeatherinfoEntity weatherinfo) {
        this.weatherinfo = weatherinfo;
    }

    public WeatherinfoEntity getWeatherinfo() {
        return weatherinfo;
    }

    public static class WeatherinfoEntity {
        private String city;
        private String cityid;
        private String temp1;
        private String temp2;
        private String weather;
        private String img1;
        private String img2;
        private String ptime;

        public void setCity(String city) {
            this.city = city;
        }

        public void setCityid(String cityid) {
            this.cityid = cityid;
        }

        public void setTemp1(String temp1) {
            this.temp1 = temp1;
        }

        public void setTemp2(String temp2) {
            this.temp2 = temp2;
        }

        public void setWeather(String weather) {
            this.weather = weather;
        }

        public void setImg1(String img1) {
            this.img1 = img1;
        }

        public void setImg2(String img2) {
            this.img2 = img2;
        }

        public void setPtime(String ptime) {
            this.ptime = ptime;
        }

        public String getCity() {
            return city;
        }

        public String getCityid() {
            return cityid;
        }

        public String getTemp1() {
            return temp1;
        }

        public String getTemp2() {
            return temp2;
        }

        public String getWeather() {
            return weather;
        }

        public String getImg1() {
            return img1;
        }

        public String getImg2() {
            return img2;
        }

        public String getPtime() {
            return ptime;
        }
    }
}

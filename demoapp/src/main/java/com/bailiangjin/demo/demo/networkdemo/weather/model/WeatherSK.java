package com.bailiangjin.demo.demo.networkdemo.weather.model;

/**
 * 作者：bailiangjin  bailiangjin@gmail.com
 * 创建时间：15/12/11 20:51
 */
public class WeatherSK {

    /**
     * city : 北京
     * cityid : 101010100
     * temp : 19
     * WD : 西南风
     * WS : 1级
     * SD : 56%
     * WSE : 1
     * time : 23:45
     * isRadar : 1
     * Radar : JC_RADAR_AZ9010_JB
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
        private String temp;
        private String WD;
        private String WS;
        private String SD;
        private String WSE;
        private String time;
        private String isRadar;
        private String Radar;

        public void setCity(String city) {
            this.city = city;
        }

        public void setCityid(String cityid) {
            this.cityid = cityid;
        }

        public void setTemp(String temp) {
            this.temp = temp;
        }

        public void setWD(String WD) {
            this.WD = WD;
        }

        public void setWS(String WS) {
            this.WS = WS;
        }

        public void setSD(String SD) {
            this.SD = SD;
        }

        public void setWSE(String WSE) {
            this.WSE = WSE;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public void setIsRadar(String isRadar) {
            this.isRadar = isRadar;
        }

        public void setRadar(String Radar) {
            this.Radar = Radar;
        }

        public String getCity() {
            return city;
        }

        public String getCityid() {
            return cityid;
        }

        public String getTemp() {
            return temp;
        }

        public String getWD() {
            return WD;
        }

        public String getWS() {
            return WS;
        }

        public String getSD() {
            return SD;
        }

        public String getWSE() {
            return WSE;
        }

        public String getTime() {
            return time;
        }

        public String getIsRadar() {
            return isRadar;
        }

        public String getRadar() {
            return Radar;
        }
    }
}

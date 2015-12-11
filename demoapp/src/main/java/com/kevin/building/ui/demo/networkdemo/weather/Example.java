
package com.kevin.building.ui.demo.networkdemo.weather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Example {

    @SerializedName("weatherinfo")
    @Expose
    public Weatherinfo weatherinfo;

    public Weatherinfo getWeatherinfo() {
        return weatherinfo;
    }

    public void setWeatherinfo(Weatherinfo weatherinfo) {
        this.weatherinfo = weatherinfo;
    }

    public class Weatherinfo {

        @SerializedName("city")
        @Expose
        public String city;
        @SerializedName("cityid")
        @Expose
        public String cityid;
        @SerializedName("temp")
        @Expose
        public String temp;
        @SerializedName("WD")
        @Expose
        public String WD;
        @SerializedName("WS")
        @Expose
        public String WS;
        @SerializedName("SD")
        @Expose
        public String SD;
        @SerializedName("WSE")
        @Expose
        public String WSE;
        @SerializedName("time")
        @Expose
        public String time;
        @SerializedName("isRadar")
        @Expose
        public String isRadar;
        @SerializedName("Radar")
        @Expose
        public String Radar;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCityid() {
            return cityid;
        }

        public void setCityid(String cityid) {
            this.cityid = cityid;
        }

        public String getTemp() {
            return temp;
        }

        public void setTemp(String temp) {
            this.temp = temp;
        }

        public String getWD() {
            return WD;
        }

        public void setWD(String WD) {
            this.WD = WD;
        }

        public String getWS() {
            return WS;
        }

        public void setWS(String WS) {
            this.WS = WS;
        }

        public String getSD() {
            return SD;
        }

        public void setSD(String SD) {
            this.SD = SD;
        }

        public String getWSE() {
            return WSE;
        }

        public void setWSE(String WSE) {
            this.WSE = WSE;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getIsRadar() {
            return isRadar;
        }

        public void setIsRadar(String isRadar) {
            this.isRadar = isRadar;
        }

        public String getRadar() {
            return Radar;
        }

        public void setRadar(String radar) {
            Radar = radar;
        }
    }


}

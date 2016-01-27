package com.kevin.building.demo.networkdemo.weather;

import com.kevin.building.demo.networkdemo.weather.config.WeatherConfig;

/**
 * Author:  liangjin.bai
 * Email: bailiangjin@gmail.com
 * Create Time: 2015/12/11 11:22
 */
public class WeatherRequest {

    private String cityId;
    private String cityInfoUrl;
    private String skUrl;
    private String detailUrl;


    public WeatherRequest(String cityId) {
        this.cityId = cityId;
        this.cityInfoUrl = WeatherConfig.cityInfoUrlPrifix + cityId + WeatherConfig.urlPostfix;
        this.skUrl = WeatherConfig.skUrlPrifix + cityId + WeatherConfig.urlPostfix;
        this.detailUrl = WeatherConfig.detailUrlPrifix + cityId + WeatherConfig.urlPostfix;
    }

    public String getCityId() {
        return cityId;
    }

    public String getCityInfoUrl() {
        return cityInfoUrl;
    }

    public String getSkUrl() {
        return skUrl;
    }

    public String getDetailUrl() {
        return detailUrl;
    }


}

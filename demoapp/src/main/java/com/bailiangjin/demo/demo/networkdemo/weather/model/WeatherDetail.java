package com.bailiangjin.demo.demo.networkdemo.weather.model;

/**
 * 作者：bailiangjin  bailiangjin@gmail.com
 * 创建时间：15/12/11 20:46
 */
public class WeatherDetail {


    /**
     * city : 北京
     * city_en : beijing
     * date_y : 2013年5月13日
     * date :
     * week : 星期一
     * fchh : 18
     * cityid : 101010100
     * temp1 : 18℃~30℃
     * temp2 : 15℃~28℃
     * temp3 : 14℃~26℃
     * temp4 : 16℃~27℃
     * temp5 : 15℃~33℃
     * temp6 : 19℃~31℃
     * tempF1 : 64.4℉~86℉
     * tempF2 : 59℉~82.4℉
     * tempF3 : 57.2℉~78.8℉
     * tempF4 : 60.8℉~80.6℉
     * tempF5 : 59℉~91.4℉
     * tempF6 : 66.2℉~87.8℉
     * weather1 : 多云转晴
     * weather2 : 晴
     * weather3 : 多云转阴
     * weather4 : 小雨转阴
     * weather5 : 晴
     * weather6 : 阴
     * img1 : 1
     * img2 : 0
     * img3 : 0
     * img4 : 99
     * img5 : 1
     * img6 : 2
     * img7 : 7
     * img8 : 2
     * img9 : 0
     * img10 : 99
     * img11 : 2
     * img12 : 99
     * img_single : 0
     * img_title1 : 多云
     * img_title2 : 晴
     * img_title3 : 晴
     * img_title4 : 晴
     * img_title5 : 多云
     * img_title6 : 阴
     * img_title7 : 小雨
     * img_title8 : 阴
     * img_title9 : 晴
     * img_title10 : 晴
     * img_title11 : 阴
     * img_title12 : 阴
     * img_title_single : 晴
     * wind1 : 北风3-4级
     * wind2 : 微风
     * wind3 : 微风
     * wind4 : 微风
     * wind5 : 微风
     * wind6 : 微风
     * fx1 : 北风
     * fx2 : 北风
     * fl1 : 3-4级
     * fl2 : 小于3级
     * fl3 : 小于3级
     * fl4 : 小于3级
     * fl5 : 小于3级
     * fl6 : 小于3级
     * index : 舒适
     * index_d : 较凉爽，建议着长袖衬裤等春秋过渡装。体弱者宜着长袖衬衫和马甲。但昼夜温差较大，请适当增减衣服。
     * index48 : 热
     * index48_d : 天气较热，建议着短裙、短裤、短套装、T恤等夏季服装。年老体弱者宜着长袖衬衫和单裤。
     * index_uv : 很强
     * index48_uv : 强
     * index_xc : 适宜
     * index_tr : 适宜
     * index_co : 较舒适
     * st1 : 29
     * st2 : 16
     * st3 : 29
     * st4 : 16
     * st5 : 28
     * st6 : 14
     * index_cl : 较适宜
     * index_ls : 极适宜
     * index_ag : 易发
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
        private String city_en;
        private String date_y;
        private String date;
        private String week;
        private String fchh;
        private String cityid;
        private String temp1;
        private String temp2;
        private String temp3;
        private String temp4;
        private String temp5;
        private String temp6;
        private String tempF1;
        private String tempF2;
        private String tempF3;
        private String tempF4;
        private String tempF5;
        private String tempF6;
        private String weather1;
        private String weather2;
        private String weather3;
        private String weather4;
        private String weather5;
        private String weather6;
        private String img1;
        private String img2;
        private String img3;
        private String img4;
        private String img5;
        private String img6;
        private String img7;
        private String img8;
        private String img9;
        private String img10;
        private String img11;
        private String img12;
        private String img_single;
        private String img_title1;
        private String img_title2;
        private String img_title3;
        private String img_title4;
        private String img_title5;
        private String img_title6;
        private String img_title7;
        private String img_title8;
        private String img_title9;
        private String img_title10;
        private String img_title11;
        private String img_title12;
        private String img_title_single;
        private String wind1;
        private String wind2;
        private String wind3;
        private String wind4;
        private String wind5;
        private String wind6;
        private String fx1;
        private String fx2;
        private String fl1;
        private String fl2;
        private String fl3;
        private String fl4;
        private String fl5;
        private String fl6;
        private String index;
        private String index_d;
        private String index48;
        private String index48_d;
        private String index_uv;
        private String index48_uv;
        private String index_xc;
        private String index_tr;
        private String index_co;
        private String st1;
        private String st2;
        private String st3;
        private String st4;
        private String st5;
        private String st6;
        private String index_cl;
        private String index_ls;
        private String index_ag;

        public void setCity(String city) {
            this.city = city;
        }

        public void setCity_en(String city_en) {
            this.city_en = city_en;
        }

        public void setDate_y(String date_y) {
            this.date_y = date_y;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public void setWeek(String week) {
            this.week = week;
        }

        public void setFchh(String fchh) {
            this.fchh = fchh;
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

        public void setTemp3(String temp3) {
            this.temp3 = temp3;
        }

        public void setTemp4(String temp4) {
            this.temp4 = temp4;
        }

        public void setTemp5(String temp5) {
            this.temp5 = temp5;
        }

        public void setTemp6(String temp6) {
            this.temp6 = temp6;
        }

        public void setTempF1(String tempF1) {
            this.tempF1 = tempF1;
        }

        public void setTempF2(String tempF2) {
            this.tempF2 = tempF2;
        }

        public void setTempF3(String tempF3) {
            this.tempF3 = tempF3;
        }

        public void setTempF4(String tempF4) {
            this.tempF4 = tempF4;
        }

        public void setTempF5(String tempF5) {
            this.tempF5 = tempF5;
        }

        public void setTempF6(String tempF6) {
            this.tempF6 = tempF6;
        }

        public void setWeather1(String weather1) {
            this.weather1 = weather1;
        }

        public void setWeather2(String weather2) {
            this.weather2 = weather2;
        }

        public void setWeather3(String weather3) {
            this.weather3 = weather3;
        }

        public void setWeather4(String weather4) {
            this.weather4 = weather4;
        }

        public void setWeather5(String weather5) {
            this.weather5 = weather5;
        }

        public void setWeather6(String weather6) {
            this.weather6 = weather6;
        }

        public void setImg1(String img1) {
            this.img1 = img1;
        }

        public void setImg2(String img2) {
            this.img2 = img2;
        }

        public void setImg3(String img3) {
            this.img3 = img3;
        }

        public void setImg4(String img4) {
            this.img4 = img4;
        }

        public void setImg5(String img5) {
            this.img5 = img5;
        }

        public void setImg6(String img6) {
            this.img6 = img6;
        }

        public void setImg7(String img7) {
            this.img7 = img7;
        }

        public void setImg8(String img8) {
            this.img8 = img8;
        }

        public void setImg9(String img9) {
            this.img9 = img9;
        }

        public void setImg10(String img10) {
            this.img10 = img10;
        }

        public void setImg11(String img11) {
            this.img11 = img11;
        }

        public void setImg12(String img12) {
            this.img12 = img12;
        }

        public void setImg_single(String img_single) {
            this.img_single = img_single;
        }

        public void setImg_title1(String img_title1) {
            this.img_title1 = img_title1;
        }

        public void setImg_title2(String img_title2) {
            this.img_title2 = img_title2;
        }

        public void setImg_title3(String img_title3) {
            this.img_title3 = img_title3;
        }

        public void setImg_title4(String img_title4) {
            this.img_title4 = img_title4;
        }

        public void setImg_title5(String img_title5) {
            this.img_title5 = img_title5;
        }

        public void setImg_title6(String img_title6) {
            this.img_title6 = img_title6;
        }

        public void setImg_title7(String img_title7) {
            this.img_title7 = img_title7;
        }

        public void setImg_title8(String img_title8) {
            this.img_title8 = img_title8;
        }

        public void setImg_title9(String img_title9) {
            this.img_title9 = img_title9;
        }

        public void setImg_title10(String img_title10) {
            this.img_title10 = img_title10;
        }

        public void setImg_title11(String img_title11) {
            this.img_title11 = img_title11;
        }

        public void setImg_title12(String img_title12) {
            this.img_title12 = img_title12;
        }

        public void setImg_title_single(String img_title_single) {
            this.img_title_single = img_title_single;
        }

        public void setWind1(String wind1) {
            this.wind1 = wind1;
        }

        public void setWind2(String wind2) {
            this.wind2 = wind2;
        }

        public void setWind3(String wind3) {
            this.wind3 = wind3;
        }

        public void setWind4(String wind4) {
            this.wind4 = wind4;
        }

        public void setWind5(String wind5) {
            this.wind5 = wind5;
        }

        public void setWind6(String wind6) {
            this.wind6 = wind6;
        }

        public void setFx1(String fx1) {
            this.fx1 = fx1;
        }

        public void setFx2(String fx2) {
            this.fx2 = fx2;
        }

        public void setFl1(String fl1) {
            this.fl1 = fl1;
        }

        public void setFl2(String fl2) {
            this.fl2 = fl2;
        }

        public void setFl3(String fl3) {
            this.fl3 = fl3;
        }

        public void setFl4(String fl4) {
            this.fl4 = fl4;
        }

        public void setFl5(String fl5) {
            this.fl5 = fl5;
        }

        public void setFl6(String fl6) {
            this.fl6 = fl6;
        }

        public void setIndex(String index) {
            this.index = index;
        }

        public void setIndex_d(String index_d) {
            this.index_d = index_d;
        }

        public void setIndex48(String index48) {
            this.index48 = index48;
        }

        public void setIndex48_d(String index48_d) {
            this.index48_d = index48_d;
        }

        public void setIndex_uv(String index_uv) {
            this.index_uv = index_uv;
        }

        public void setIndex48_uv(String index48_uv) {
            this.index48_uv = index48_uv;
        }

        public void setIndex_xc(String index_xc) {
            this.index_xc = index_xc;
        }

        public void setIndex_tr(String index_tr) {
            this.index_tr = index_tr;
        }

        public void setIndex_co(String index_co) {
            this.index_co = index_co;
        }

        public void setSt1(String st1) {
            this.st1 = st1;
        }

        public void setSt2(String st2) {
            this.st2 = st2;
        }

        public void setSt3(String st3) {
            this.st3 = st3;
        }

        public void setSt4(String st4) {
            this.st4 = st4;
        }

        public void setSt5(String st5) {
            this.st5 = st5;
        }

        public void setSt6(String st6) {
            this.st6 = st6;
        }

        public void setIndex_cl(String index_cl) {
            this.index_cl = index_cl;
        }

        public void setIndex_ls(String index_ls) {
            this.index_ls = index_ls;
        }

        public void setIndex_ag(String index_ag) {
            this.index_ag = index_ag;
        }

        public String getCity() {
            return city;
        }

        public String getCity_en() {
            return city_en;
        }

        public String getDate_y() {
            return date_y;
        }

        public String getDate() {
            return date;
        }

        public String getWeek() {
            return week;
        }

        public String getFchh() {
            return fchh;
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

        public String getTemp3() {
            return temp3;
        }

        public String getTemp4() {
            return temp4;
        }

        public String getTemp5() {
            return temp5;
        }

        public String getTemp6() {
            return temp6;
        }

        public String getTempF1() {
            return tempF1;
        }

        public String getTempF2() {
            return tempF2;
        }

        public String getTempF3() {
            return tempF3;
        }

        public String getTempF4() {
            return tempF4;
        }

        public String getTempF5() {
            return tempF5;
        }

        public String getTempF6() {
            return tempF6;
        }

        public String getWeather1() {
            return weather1;
        }

        public String getWeather2() {
            return weather2;
        }

        public String getWeather3() {
            return weather3;
        }

        public String getWeather4() {
            return weather4;
        }

        public String getWeather5() {
            return weather5;
        }

        public String getWeather6() {
            return weather6;
        }

        public String getImg1() {
            return img1;
        }

        public String getImg2() {
            return img2;
        }

        public String getImg3() {
            return img3;
        }

        public String getImg4() {
            return img4;
        }

        public String getImg5() {
            return img5;
        }

        public String getImg6() {
            return img6;
        }

        public String getImg7() {
            return img7;
        }

        public String getImg8() {
            return img8;
        }

        public String getImg9() {
            return img9;
        }

        public String getImg10() {
            return img10;
        }

        public String getImg11() {
            return img11;
        }

        public String getImg12() {
            return img12;
        }

        public String getImg_single() {
            return img_single;
        }

        public String getImg_title1() {
            return img_title1;
        }

        public String getImg_title2() {
            return img_title2;
        }

        public String getImg_title3() {
            return img_title3;
        }

        public String getImg_title4() {
            return img_title4;
        }

        public String getImg_title5() {
            return img_title5;
        }

        public String getImg_title6() {
            return img_title6;
        }

        public String getImg_title7() {
            return img_title7;
        }

        public String getImg_title8() {
            return img_title8;
        }

        public String getImg_title9() {
            return img_title9;
        }

        public String getImg_title10() {
            return img_title10;
        }

        public String getImg_title11() {
            return img_title11;
        }

        public String getImg_title12() {
            return img_title12;
        }

        public String getImg_title_single() {
            return img_title_single;
        }

        public String getWind1() {
            return wind1;
        }

        public String getWind2() {
            return wind2;
        }

        public String getWind3() {
            return wind3;
        }

        public String getWind4() {
            return wind4;
        }

        public String getWind5() {
            return wind5;
        }

        public String getWind6() {
            return wind6;
        }

        public String getFx1() {
            return fx1;
        }

        public String getFx2() {
            return fx2;
        }

        public String getFl1() {
            return fl1;
        }

        public String getFl2() {
            return fl2;
        }

        public String getFl3() {
            return fl3;
        }

        public String getFl4() {
            return fl4;
        }

        public String getFl5() {
            return fl5;
        }

        public String getFl6() {
            return fl6;
        }

        public String getIndex() {
            return index;
        }

        public String getIndex_d() {
            return index_d;
        }

        public String getIndex48() {
            return index48;
        }

        public String getIndex48_d() {
            return index48_d;
        }

        public String getIndex_uv() {
            return index_uv;
        }

        public String getIndex48_uv() {
            return index48_uv;
        }

        public String getIndex_xc() {
            return index_xc;
        }

        public String getIndex_tr() {
            return index_tr;
        }

        public String getIndex_co() {
            return index_co;
        }

        public String getSt1() {
            return st1;
        }

        public String getSt2() {
            return st2;
        }

        public String getSt3() {
            return st3;
        }

        public String getSt4() {
            return st4;
        }

        public String getSt5() {
            return st5;
        }

        public String getSt6() {
            return st6;
        }

        public String getIndex_cl() {
            return index_cl;
        }

        public String getIndex_ls() {
            return index_ls;
        }

        public String getIndex_ag() {
            return index_ag;
        }
    }
}

package weather.weatherproject.presenter.bean;

import com.thinkpage.lib.api.TPWeatherNow;

import weather.weatherproject.view.bean.NowWeather;

/**
 * 业务工具类
 * Created by glh on 2016-06-23.
 */
public class BeanUtil {
    /**
     * 创建实况天气数据
     *
     * @param response
     * @return
     */
    public static NowWeather createNowWeather(TPWeatherNow response) {
        NowWeather nowWeather = new NowWeather();
        nowWeather.text = response.text;
        nowWeather.lastUpdateDate = response.lastUpdateDate;
        nowWeather.temperature = response.temperature;
        nowWeather.windScale = response.windScale;
        return nowWeather;
    }
}

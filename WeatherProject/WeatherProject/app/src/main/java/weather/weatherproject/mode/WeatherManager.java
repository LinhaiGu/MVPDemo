package weather.weatherproject.mode;

import com.thinkpage.lib.api.TPCity;
import com.thinkpage.lib.api.TPListeners;
import com.thinkpage.lib.api.TPWeatherManager;
import com.thinkpage.lib.api.TPWeatherNow;

import weather.weatherproject.WeatherApplication;

/**
 * 天气管理类
 * Created by glh on 2016-06-23.
 */
public class WeatherManager {

    public static final WeatherManager instance = new WeatherManager();

    public interface WeatherListener{
        void onSuccess(TPWeatherNow response);

        void onFailed(String errString);
    }


    /**
     * 获取指定城市的实况天气。
     *
     * @param city
     * @param listener
     */
    public void getNowWeather(String city, final WeatherListener listener) {

        WeatherApplication.weatherManager.getWeatherNow(new TPCity(city), TPWeatherManager.TPWeatherReportLanguage.kSimplifiedChinese, TPWeatherManager.TPTemperatureUnit.kCelsius, new TPListeners.TPWeatherNowListener() {
            @Override
            public void onTPWeatherNowAvailable(TPWeatherNow tpWeatherNow, String s) {
                if (tpWeatherNow != null) {
                    listener.onSuccess(tpWeatherNow);
                } else {
                    listener.onFailed(s);
                }
            }
        });
    }

}

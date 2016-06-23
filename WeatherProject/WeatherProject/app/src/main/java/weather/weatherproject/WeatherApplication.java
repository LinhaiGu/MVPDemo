package weather.weatherproject;

import android.app.Application;

import com.thinkpage.lib.api.TPWeatherManager;

/**
 * Created by glh on 2016-06-23.
 */
public class WeatherApplication extends Application {

    public static TPWeatherManager weatherManager;

    @Override
    public void onCreate() {
        super.onCreate();
        initWeather();
    }

    /**
     * 初始化WeatherManager
     */
    private void initWeather(){
        weatherManager = TPWeatherManager.sharedWeatherManager();
        //使用心知天气官网获取的key和用户id初始化WeatherManager
        weatherManager.initWithKeyAndUserId("9qymisgxng5au4hu","UE8440B558");
    }
}

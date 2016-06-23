package weather.weatherproject.presenter.weather;

import weather.weatherproject.presenter.IPresenter;
import weather.weatherproject.presenter.IView;
import weather.weatherproject.view.bean.NowWeather;

/**
 * 获取天气的约定类，用于组合IWeatherView和IWeatherPresenter
 * Created by glh on 2016-06-23.
 */
public interface WeatherContract {
    interface IWeatherView extends IView {
        //获取指定城市的实况天气
        void showNowWeather(NowWeather result);

        void error(String error);
    }

    interface IWeatherPresenter extends IPresenter<IWeatherView> {
        void getWeather(String city);
    }
}

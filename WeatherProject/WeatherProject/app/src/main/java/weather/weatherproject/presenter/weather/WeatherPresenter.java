package weather.weatherproject.presenter.weather;

import com.thinkpage.lib.api.TPWeatherNow;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import weather.weatherproject.mode.WeatherManager;
import weather.weatherproject.presenter.bean.BeanUtil;

/**
 * 获取天气的Presenter
 * Created by glh on 2016-06-23.
 */
public class WeatherPresenter implements WeatherContract.IWeatherPresenter {

    private WeatherContract.IWeatherView mIWeatherView;
    private WeatherManager mWeatherManager = WeatherManager.instance;
    private ExecutorService mExecutorService = Executors.newFixedThreadPool(5);

    @Override
    public void init(WeatherContract.IWeatherView view) {
        this.mIWeatherView = view;
        mIWeatherView.initView();
    }

    @Override
    public void getWeather(final String city) {
        mExecutorService.execute(new Runnable() {
            @Override
            public void run() {
                mWeatherManager.getNowWeather(city, new WeatherManager.WeatherListener() {
                    @Override
                    public void onSuccess(TPWeatherNow response) {
                        mIWeatherView.showNowWeather(BeanUtil.createNowWeather(response));
                    }

                    @Override
                    public void onFailed(String errString) {
                        mIWeatherView.error(errString);
                    }
                });
            }
        });
    }


    @Override
    public void onStop() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStart() {

    }

}

package weather.weatherproject.view.weather;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import weather.weatherproject.R;
import weather.weatherproject.presenter.IPresenter;
import weather.weatherproject.presenter.weather.WeatherContract;
import weather.weatherproject.presenter.weather.WeatherPresenter;
import weather.weatherproject.view.base.BaseActivity;
import weather.weatherproject.view.bean.NowWeather;

/**
 * 天气界面
 * Created by glh on 2016-06-23.
 */
public class WeatherActivity extends BaseActivity implements WeatherContract.IWeatherView {

    private WeatherPresenter mWeatherPresenter = new WeatherPresenter();

    private TextView tv_show;
    private Button btn_now_weather;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected IPresenter[] getPresenters() {
        return new IPresenter[]{mWeatherPresenter};
    }

    @Override
    protected void onInitPresenters() {
        mWeatherPresenter.init(this);
    }

    @Override
    protected void initEvent() {
        btn_now_weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(WeatherActivity.this, "onclick", Toast.LENGTH_SHORT).show();
                mWeatherPresenter.getWeather("shanghai");
            }
        });
    }

    @Override
    public void showNowWeather(NowWeather result) {
        tv_show.setText(result.toString());
    }

    @Override
    public void error(String error) {
        tv_show.setText(error);
    }

    @Override
    public void initView() {
        tv_show = (TextView) findViewById(R.id.tv_show);
        btn_now_weather = (Button) findViewById(R.id.btn_now_weather);
    }
}

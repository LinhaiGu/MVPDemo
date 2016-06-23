package weather.weatherproject.view.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 实况天气
 * Created by glh on 2016-06-23.
 */
public class NowWeather {
    // 天气现象文字，例如“多云”
    public String text;
    // 温度，单位为c摄氏度或f华氏度
    public int temperature;
    // 风力等级
    public double windScale;
    // 数据更新时间（该城市的本地时间）
    public Date lastUpdateDate;

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return text + "," + temperature + "摄氏度," + "风力为" + windScale + "级,更新时间为" + dateFormat.format(lastUpdateDate);
    }
}

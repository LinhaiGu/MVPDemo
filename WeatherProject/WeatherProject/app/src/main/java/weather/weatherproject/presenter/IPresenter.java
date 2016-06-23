package weather.weatherproject.presenter;

/**
 *
 * Created by glh on 2016-06-23.
 */
public interface IPresenter<V extends IView> {
    void onStop();

    void onResume();

    void onDestroy();

    void onPause();

    void onStart();

    void init(V view);
}

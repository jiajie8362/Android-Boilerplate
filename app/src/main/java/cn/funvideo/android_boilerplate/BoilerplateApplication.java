package cn.funvideo.android_boilerplate;

import android.app.Application;
import android.content.Context;

import org.androidannotations.annotations.EApplication;

@EApplication
public class BoilerplateApplication extends Application {
    public static BoilerplateApplication instance;

    public static BoilerplateApplication getInstance() {
        return instance;
    }

    public static BoilerplateApplication application() {
        return getInstance();
    }

    public static Context applicationContext() {
        return application().getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        init();
    }

    private void init() {
        instance = this;
    }
}

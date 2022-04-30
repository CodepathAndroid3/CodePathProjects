package com.codewithsean.sdw;

import android.app.Application;
import com.parse.Parse;
import com.parse.ParseObject;



public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // Register your parse models
        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("FEYOfgbgs79zKrq3NMhp2Pyc3egY6kVXVOdNH8U9")
                .clientKey("0XfzPpo1RZes8Yv6wPUeeK8bWoxoBsNPvXsO0mY0")
                .server("https://parseapi.back4app.com")
                .build()
        );

    }
}

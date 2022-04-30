package com.codewithsean.sdw;

import android.app.Application;

import com.codewithsean.sdw.models.Shows;
import com.parse.Parse;
import com.parse.ParseObject;



public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // Register your parse models
        //ParseObject.registerSubclass(Shows.class);

        //register parse models
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("RjdP0VXXJ9nUO4FmZvDyFJsaARUnvfhG71p2oVqa")
                .clientKey("heOpiPxWdMqAU3RHQqhvatQJ9KWrMtfGyYbrLkqS")
                .server("https://parseapi.back4app.com")
                .build()
        );

    }
}

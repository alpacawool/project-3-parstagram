package com.patriciabooth.project_3_parstagram;

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
                .applicationId("62noGWfXUNFGscGPOBynPJA2GZgk4Fpvg0z2QWwi")
                .clientKey("hKes4XQu9gvcCLZWVREsDClEcbIVEP4ciKuVrprh")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}

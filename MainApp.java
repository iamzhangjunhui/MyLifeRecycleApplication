package com.example.kaylee.myliferecycleapplication;

import android.app.Application;

/**
 * Created by kaylee on 2017/12/7.
 */

public class MainApp extends Application {
    private AppExecutors mAppExecutors;
    @Override
    public void onCreate() {
        super.onCreate();
        mAppExecutors=new AppExecutors();
    }
    private AppDataBase getDatabase(){
      return  AppDataBase.getInstance(this,mAppExecutors);
    }
    private UserRepository getRepository(){
        return UserRepository.getInstance();
    }
}

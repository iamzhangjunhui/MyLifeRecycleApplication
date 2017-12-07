package com.example.kaylee.myliferecycleapplication;

import android.arch.lifecycle.MutableLiveData;

import java.util.List;

/**
 * Created by kaylee on 2017/12/7.
 */

public class UserRepository {
    private MutableLiveData<List<User>> mObservableUser;
    private static   UserRepository instance;
    private AppDataBase mDatabase;
    private  UserRepository(AppDataBase appDataBase) {
        this.mDatabase=appDataBase;
        mObservableUser=new MutableLiveData<>();

        mObservableUser.setValue(mDatabase.userDao().findAllUser());
    }
    public static UserRepository getInstance(AppDataBase appDataBase){
        if (instance==null){
            synchronized (UserRepository.class){
                if (instance==null){
                    instance=new UserRepository(appDataBase);
                }
            }
        }
       return instance;
    }

}

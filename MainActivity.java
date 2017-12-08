package com.example.kaylee.myliferecycleapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        User userEntity = new User("zhang",23);
        AppDataBase.getInstance(getApplicationContext()).userDao().insertUser(userEntity);
//                "  AppDatabase.getDatabase(getApplicationContext()).getUserEntityDao().addUser(userEntity);

    }
}

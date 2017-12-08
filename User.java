package com.example.kaylee.myliferecycleapplication;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by kaylee on 2017/12/7.
 */
@Entity(tableName = "user")
public class User {
    @PrimaryKey(autoGenerate = true)int id;
    String name;
    int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User( String name, int age) {
        this.name = name;
        this.age = age;
    }


}

package com.example.kaylee.myliferecycleapplication;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by kaylee on 2017/12/7.
 */
@Dao
public interface UserDao  {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertUser(User user);

    @Query("SELECT * FROM User")
    public List<User> findAllUser();

    @Query("SELECT * FROM User WHERE id = :userId")
    public User findUser(int id);

    @Update(onConflict = OnConflictStrategy.IGNORE)
    public void update(User user);

    @Delete()
    public void delete(User user);

}

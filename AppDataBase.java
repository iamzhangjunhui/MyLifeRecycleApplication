package com.example.kaylee.myliferecycleapplication;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.VisibleForTesting;


/**
 * Created by kaylee on 2017/12/7.
 */
@Database(entities = {User.class}, version = 1,exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {
    private static AppDataBase sInstance;

    @VisibleForTesting
    public static final String DATABASE_NAME = "basic-sample-db";

    public abstract UserDao userDao();
//    private final MutableLiveData<Boolean> mIsDatabaseCreated=new MutableLiveData<>();

    public static AppDataBase getInstance(final Context context) {
        if (sInstance == null) {
            synchronized (AppDataBase.class) {
                if (sInstance == null) {
//                    sInstance = buildDatabase(context.getApplicationContext(), executors);
//                    sInstance.updateDatabaseCreated(context.getApplicationContext());
                    sInstance=Room.databaseBuilder(context,AppDataBase.class,DATABASE_NAME).build();
                }
            }
        }
        return sInstance;
    }
    public  void onDestroy(){
        sInstance=null;
    }
//    private static AppDataBase buildDatabase(final Context appContext, final AppExecutors executors){
//        return Room.databaseBuilder(appContext,AppDataBase.class,DATABASE_NAME).addCallback(new Callback() {
//            @Override
//            public void onCreate(@NonNull SupportSQLiteDatabase db) {
//                super.onCreate(db);
//                executors.diskIO().execute(new Runnable() {
//                    @Override
//                    public void run() {
//                        final AppDataBase dataBase=AppDataBase.getInstance(appContext,executors);
//                        final User user=new User(1,"zhang",12);
//                        dataBase.runInTransaction(new Runnable() {
//                            @Override
//                            public void run() {
//                                dataBase.userDao().insertUser(user);
//                            }
//                        });
//
//                    }
//                });
//            }
//
//        }).build();
//    }
//    private void updateDatabaseCreated(final Context context){
//        if (context.getDatabasePath(DATABASE_NAME).exists()){
//            setDatabaseCreated();
//        }
//    }
//    private void setDatabaseCreated(){
//        mIsDatabaseCreated.postValue(true);
//    }
//    public LiveData<Boolean> getDatabaseCreated() {
//        return mIsDatabaseCreated;
//    }
}

package com.qxy.wltyVideo.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.qxy.wltyVideo.models.RankItemBean;

//我的数据库
@Database(entities = {RankItemBean.class}, version = 1)
public abstract class MyDatabase extends RoomDatabase
{
    private static final String DATABASE_NAME = "my_db";

    private static MyDatabase databaseInstance;

    public static synchronized MyDatabase getInstance(Context context)
    {
        if(databaseInstance == null)
        {
            databaseInstance = Room
                    .databaseBuilder(context.getApplicationContext(), MyDatabase.class, DATABASE_NAME)
                    .build();
        }
        return databaseInstance;
    }

    public abstract VideoDao videoDao();
}
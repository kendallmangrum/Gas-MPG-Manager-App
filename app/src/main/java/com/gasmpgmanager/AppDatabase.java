package com.gasmpgmanager;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Gas.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract GasDao getGasDao();

    public static AppDatabase INSTANCE;

    private static String DATABASE_NAME = "gas";

    public static AppDatabase getDBInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, DATABASE_NAME).allowMainThreadQueries().build();
        }
        return INSTANCE;
    }
}

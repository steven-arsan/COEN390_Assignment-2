package com.my_course_coen390.assignment_2.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.my_course_coen390.assignment_2.database.dao.AccessDAO;
import com.my_course_coen390.assignment_2.database.dao.ProfileDao;
import com.my_course_coen390.assignment_2.database.entity.Access;
import com.my_course_coen390.assignment_2.database.entity.Profile;


@Database(entities = {Profile.class, Access.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static volatile AppDatabase instance;
    private static final String DB_NAME = "profiledatabase";
    protected AppDatabase(){}

    private static AppDatabase create(Context context) {
        return Room.databaseBuilder(context, AppDatabase.class,DB_NAME).allowMainThreadQueries().build();
    }

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = create(context);
        }
        return instance;
    }

    public abstract ProfileDao profileDao();
    public abstract AccessDAO accessDAO();
}


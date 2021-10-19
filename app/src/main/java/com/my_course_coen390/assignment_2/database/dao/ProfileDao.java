package com.my_course_coen390.assignment_2.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.my_course_coen390.assignment_2.database.entity.Profile;

import java.util.List;

@Dao
public interface ProfileDao {

    @Query("SELECT * FROM profile_table ORDER BY Surname ASC")
    List<Profile> getAll();

    @Query("SELECT COUNT(*)")
    int numColumns();

    @Insert
    void insertAll(Profile profile);

   @Query("SELECT * FROM profile_table WHERE profile_id=:profile_id")
    Profile findById(int profile_id);
}

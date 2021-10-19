package com.my_course_coen390.assignment_2.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.my_course_coen390.assignment_2.database.entity.Access;

import java.util.List;

@Dao
public interface AccessDAO {

    @Insert
    void InsertAll_all(Access access);

    @Query("SELECT * FROM access_table")
    List<Access> getAllFields();

}

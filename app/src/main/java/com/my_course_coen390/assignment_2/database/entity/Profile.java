package com.my_course_coen390.assignment_2.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "profile_table")
public class Profile {
    @PrimaryKey (autoGenerate = false)
    public int profile_id;
    @ColumnInfo(name="Surname")
    public String profile_surname;
    @ColumnInfo(name = "Name")
    public String profile_name;
    @ColumnInfo(name = "GPA")
    public double profile_gpa;

    public Profile(int profile_id, String profile_surname, String profile_name, double profile_gpa) {
        this.profile_id = profile_id;
        this.profile_surname = profile_surname;
        this.profile_name = profile_name;
        this.profile_gpa = profile_gpa;
    }
}


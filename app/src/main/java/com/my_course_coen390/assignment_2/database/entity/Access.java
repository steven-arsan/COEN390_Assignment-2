package com.my_course_coen390.assignment_2.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity (tableName = "access_table")
public class Access {
    @PrimaryKey (autoGenerate = true)
    public int access_id;
    @ColumnInfo(name = "Profile ID#")
    public int profile_id;
    @ColumnInfo(name = "Access Type")
    public String access_type;
    @ColumnInfo(name = "Timestamp")
    public String time_stamp;

    public Access(int access_id, int profile_id, String access_type, String time_stamp) {
        this.access_id = access_id;
        this.profile_id = profile_id;
        this.access_type = access_type;
        this.time_stamp = time_stamp;
    }
}

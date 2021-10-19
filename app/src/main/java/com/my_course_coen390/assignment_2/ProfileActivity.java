package com.my_course_coen390.assignment_2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.my_course_coen390.assignment_2.database.AppDatabase;
import com.my_course_coen390.assignment_2.database.entity.Access;
import com.my_course_coen390.assignment_2.database.entity.Profile;

import java.util.List;
import java.util.Objects;

public class ProfileActivity extends AppCompatActivity {

    protected TextView profileSurnameTextView;
    protected TextView profileNameTextView;
    protected TextView profileIDTextView;
    protected TextView profileGPATextView;
    protected RecyclerView accessRecyclerView;
    protected profileActivityRecyclerView profileActivityRecyclerView;
    protected AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profileSurnameTextView = findViewById(R.id.profileSurnameTextView);
        profileNameTextView = findViewById(R.id.profileNameTextView);
        profileIDTextView = findViewById(R.id.profileIDTextView);
        profileGPATextView = findViewById(R.id.profileGPATextView);
        profileSurnameTextView.setText("");
        profileNameTextView.setText("");
        profileIDTextView.setText("");
        profileGPATextView.setText("");

        //Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        Toolbar toolbar = findViewById(R.id.toolbarActivity);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Profile Activity");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();

       int id = intent.getIntExtra("profile_ID", 0);
       if (id != 0){
           AppDatabase db = AppDatabase.getInstance(this);
           Profile profile = db.profileDao().findById(id);

           profileSurnameTextView.setText("Surname: " + profile.profile_surname);
           profileNameTextView.setText("Name: " + profile.profile_name);
           profileIDTextView.setText("ID: " + profile.profile_id + "");
           profileGPATextView.setText("GPA: " + profile.profile_gpa + "");
       }

      //  setupAccessRecyclerView();
    }

    protected void setupAccessRecyclerView() {
        List<Access> accesses = db.accessDAO().getAllFields();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        profileActivityRecyclerView = new profileActivityRecyclerView(accesses);

        accessRecyclerView = findViewById(R.id.accessRecyclerView);
        accessRecyclerView.setLayoutManager(linearLayoutManager);
        accessRecyclerView.setAdapter(profileActivityRecyclerView);
    }
}
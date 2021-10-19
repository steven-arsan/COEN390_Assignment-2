package com.my_course_coen390.assignment_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.my_course_coen390.assignment_2.database.AppDatabase;
import com.my_course_coen390.assignment_2.database.entity.Access;
import com.my_course_coen390.assignment_2.database.entity.Profile;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    protected FloatingActionButton insertProfileButton;
    protected RecyclerView profilesRecyclerView;
    protected profileRecyclerViewAdapter profileRecyclerViewAdapter;
    protected AppDatabase db;
    public int m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = AppDatabase.getInstance(getApplicationContext());

      //  db.profileDao().insertAll(new Profile(3, "Lahoud", "Tiya", 3.48));
      //  db.profileDao().insertAll(new Profile(4, "Arsan", "Steven", 1));

        //db.accessDAO().InsertAll_all(new Access(0, 2211, "Created", "11:44:22"));

        insertProfileButton = findViewById(R.id.insertButton);

        insertProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsertProfileDialog dialog = new InsertProfileDialog();
                dialog.show(getSupportFragmentManager(), "Insert profile dialog");
            }
        });

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Main Activity");

        setupRecyclerView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return true;
    }

    protected void setupRecyclerView() {
        List<Profile> profiles = db.profileDao().getAll();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        profileRecyclerViewAdapter = new profileRecyclerViewAdapter(profiles);

        profilesRecyclerView = findViewById(R.id.profilesRecyclerView);
        profilesRecyclerView.setLayoutManager(linearLayoutManager);
        profilesRecyclerView.setAdapter(profileRecyclerViewAdapter);
    }




    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.id_mode:
                // m=0;//Display by ID
                // mode();
                return true;
            case R.id.name_mode:
                // m=1;//Display by Name
                // mode();
                 return true;
        }
        return super.onOptionsItemSelected(item);
    }


   /* int mode() {
        if (m==1) {
            return 1;
        }
        else if (m==2) {
            return 2;
        }
        else
            return 0;
    } */
}
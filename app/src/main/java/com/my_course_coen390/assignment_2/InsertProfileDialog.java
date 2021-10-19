package com.my_course_coen390.assignment_2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.my_course_coen390.assignment_2.database.AppDatabase;
import com.my_course_coen390.assignment_2.database.entity.Profile;

public class InsertProfileDialog extends DialogFragment {

    protected EditText profileSurnameEditText;
    protected EditText profileNameEditText;
    protected EditText profileIDEditText;
    protected EditText profileGPAEditText;

    protected Button saveButton;
    protected Button cancelButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.dialogfragment_insert_profile, container);

        profileSurnameEditText = view.findViewById(R.id.profileSurnameDialog);
        profileNameEditText = view.findViewById(R.id.profileNameDialog);
        profileIDEditText = view.findViewById(R.id.profileIDDialog);
        profileGPAEditText = view.findViewById(R.id.profileGPADialog);

        saveButton = view.findViewById(R.id.saveButtonDialog);
        cancelButton = view.findViewById(R.id.cancelButtonDialog);

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String profileSurname = profileSurnameEditText.getText().toString();
                String profileName = profileNameEditText.getText().toString();
                String profileID = profileIDEditText.getText().toString();
                String profileGPA = profileGPAEditText.getText().toString();

                if ( profileSurname.equals("") || profileName.equals("") || profileID.equals("") || profileGPA.equals("")) {
                    Toast.makeText(getContext(), "Please enter values", Toast.LENGTH_SHORT).show();
                    return;
                }

                AppDatabase db = AppDatabase.getInstance(getContext());
                db.profileDao().insertAll(new Profile(Integer.valueOf(profileID), profileSurname, profileName, Double.parseDouble(profileGPA)));
                Toast.makeText(getContext(), "Profile saved successfully", Toast.LENGTH_SHORT).show();
                ((MainActivity) requireActivity()).setupRecyclerView();
                dismiss();
            }
        });
        return view;
    }
}

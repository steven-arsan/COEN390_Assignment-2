package com.my_course_coen390.assignment_2;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.my_course_coen390.assignment_2.database.entity.Profile;

import java.util.List;

public class profileRecyclerViewAdapter extends RecyclerView.Adapter<profileRecyclerViewAdapter.ViewHolder>{


    private List<Profile> localDataSet;
   //private numColumns() local;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView profileSurname_Name_TextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            profileSurname_Name_TextView = itemView.findViewById(R.id.profileSurname_Name_textView);
        }

        public TextView getProfileSurname_Name_TextView(){return profileSurname_Name_TextView;}
    }

    public profileRecyclerViewAdapter(List<Profile> localDataSet) {
        this.localDataSet = localDataSet;
    }

    @NonNull
    @Override
    public profileRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.profile_recyclerview_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull profileRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.getProfileSurname_Name_TextView().setText( localDataSet.get(position).profile_surname + ", " + localDataSet.get(position).profile_name);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = holder.getLayoutPosition();
                Intent intent = new Intent(v.getContext(), ProfileActivity.class);
                intent.putExtra("profile_ID", localDataSet.get(pos).profile_id);
                v.getContext().startActivity(intent);
            }
        });
       }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}

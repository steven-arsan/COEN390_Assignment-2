package com.my_course_coen390.assignment_2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.my_course_coen390.assignment_2.database.entity.Access;
import com.my_course_coen390.assignment_2.database.entity.Profile;

import org.w3c.dom.Text;

import java.util.List;

public class profileActivityRecyclerView extends RecyclerView.Adapter<profileActivityRecyclerView.ViewHolder> {


    private List<Access> localAcessSet;
    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView accessTextView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            accessTextView = itemView.findViewById(R.id.accessTextView);
        }

        public TextView getAccessTextView() {return accessTextView;}

    }

    public profileActivityRecyclerView(List<Access> localAcessSet){
        this.localAcessSet = localAcessSet;
    }
    @NonNull
    @Override
    public profileActivityRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.profileactivity_recycler_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull profileActivityRecyclerView.ViewHolder holder, int position) {
        holder.getAccessTextView().setText(localAcessSet.get(position).access_type);
    }

    @Override
    public int getItemCount() {
       return localAcessSet.size();
    }
}

package com.jpmorgan.a20210402_krikorherlopian_nycschools.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.jpmorgan.a20210402_krikorherlopian_nycschools.R;
import com.jpmorgan.a20210402_krikorherlopian_nycschools.model.School;

import java.util.List;

public class SchoolListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<School> schools;
    Context context;
    int lastPosition = -1;
    private SchoolItemClickListener listener;
    public SchoolListAdapter(List<School> schools, Context context, SchoolItemClickListener listener){
        this.schools = schools;
        this.context = context;
        this.listener = listener;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_school, parent, false);
        return new SchoolHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        SchoolHolder holderItem = (SchoolHolder) holder;
        configureViewHolder(holderItem, position);
    }

    private void configureViewHolder(final SchoolHolder holder, final int position) {

        Animation anim;
        if(position > lastPosition){
            anim = AnimationUtils.loadAnimation(context,R.anim.up_from_bottom);
        }
        else{
            anim = AnimationUtils.loadAnimation(context,R.anim.down_from_top);
        }
        lastPosition = position;
        holder.itemView.startAnimation(anim);
        holder.setInformation(schools.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onSchoolClicked(schools.get(position));
            }
        });
    }


    @Override
    public void onViewDetachedFromWindow(@NonNull RecyclerView.ViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.itemView.clearAnimation();
    }

    @Override
    public int getItemCount() {
        return schools.size();
    }
    public interface SchoolItemClickListener {
        void onSchoolClicked(School school);
    }
}


class SchoolHolder extends RecyclerView.ViewHolder{
    TextView schoolNameView;
    TextView schoolLocationView;
    TextView contactInfo;
    public SchoolHolder(View itemView) {
        super(itemView);
        schoolNameView = itemView.findViewById(R.id.school_name);
        schoolLocationView = itemView.findViewById(R.id.school_location);
        contactInfo = itemView.findViewById(R.id.contact_info);
    }
    public void setInformation(School school){
        schoolNameView.setText(school.getSchoolName());
        schoolLocationView.setText(school.getCity());
        if(school.getSchoolEmail() != null && school.getPhoneNumber() != null){
            contactInfo.setText(school.getSchoolEmail()+" , "+school.getPhoneNumber());
        }
        else if(school.getSchoolEmail() != null ){
            contactInfo.setText(school.getSchoolEmail());
        }
        else if(school.getPhoneNumber() != null ){
           contactInfo.setText(school.getPhoneNumber());
        }
    }
}

package com.example.android.hyperschedule_android;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {
    private ArrayList<Course> mCourseList;
    private ArrayList<Course> mCourseListFull;
    public CourseAdapter(ArrayList<Course> mCourseList)
    {
        this.mCourseList = mCourseList;
        mCourseListFull = new ArrayList<>(mCourseList);
    }
    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        CourseViewHolder cvh = new CourseViewHolder(v);
        return cvh;
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        Course mCurrentCourse = mCourseList.get(position);
        try
        {
            holder.mCourseName.setText(mCurrentCourse.getmCourseName());
            holder.mCourseCode.setText(mCurrentCourse.getmCourseCode());
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return mCourseList.size();
    }

    public static class CourseViewHolder extends RecyclerView.ViewHolder{
        public TextView mCourseName, mCourseCode;
        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);
            mCourseCode = itemView.findViewById(R.id.textview1);
            mCourseName = itemView.findViewById(R.id.textview2);

        }
    }
}

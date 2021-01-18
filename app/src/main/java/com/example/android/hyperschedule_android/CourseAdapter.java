package com.example.android.hyperschedule_android;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> implements Filterable {
    private ArrayList<Course> mCourseList;
    private ArrayList<Course> mCourseListFull;
    private Filter mCourseFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<Course> mFilteredList = new ArrayList<>(mCourseListFull);
            if (constraint == null || constraint.length() == 0) {
                mFilteredList.addAll(mCourseListFull);
            } else {
                String[] filterpatterns = constraint.toString().toLowerCase().split(" ");
                for (Course c : mCourseListFull) {
                    for (String a : filterpatterns) {
                        if (!c.getSearchCode().toLowerCase().contains(a)) {
                            mFilteredList.remove(c);
                            System.out.println(c.getSearchCode());
                            System.out.println(a);
                        }
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = mFilteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mCourseList.clear();
            mCourseList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

    public CourseAdapter(ArrayList<Course> mCourseList) {
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
        try {
            holder.mCourseName.setText(mCurrentCourse.getmCourseName());
            holder.mCourseCode.setText(mCurrentCourse.getmCourseCode());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return mCourseList.size();
    }

    @Override
    public Filter getFilter() {
        return mCourseFilter;
    }

    public static class CourseViewHolder extends RecyclerView.ViewHolder {
        public TextView mCourseName, mCourseCode;

        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);
            mCourseCode = itemView.findViewById(R.id.textview1);
            mCourseName = itemView.findViewById(R.id.textview2);

        }
    }
}

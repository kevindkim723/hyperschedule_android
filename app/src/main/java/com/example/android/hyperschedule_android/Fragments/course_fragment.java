package com.example.android.hyperschedule_android.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.hyperschedule_android.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class course_fragment extends Fragment {
    private TextView l1,l2,l3,l4,l5,l6;
    private View dline;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.course_frag,container, false);
        Bundle bundle = this.getArguments();
        l1 = v.findViewById(R.id.course_title);
        l2 = v.findViewById(R.id.course_loc);
        l3 = v.findViewById(R.id.course_instructors);
        l4 = v.findViewById(R.id.course_credits);
        l5 = v.findViewById(R.id.course_description);
        l6 = v.findViewById(R.id.course_seats);
        dline = v.findViewById(R.id.dline);

        l1.setText(bundle.getString("1"));
        l2.setText(bundle.getString("2"));
        l3.setText(bundle.getString("3"));
        l4.setText(bundle.getString("4"));
        if (!bundle.getString("5").equals("null"))
        {
            l5.setText(bundle.getString("5"));
        }
        else
        {
            l5.setVisibility(View.GONE);
            dline.setVisibility(View.GONE);
        }
        l6.setText(bundle.getString("6"));


        return v;
    }
}

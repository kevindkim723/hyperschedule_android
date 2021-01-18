package com.example.android.hyperschedule_android.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.android.hyperschedule_android.Course;
import com.example.android.hyperschedule_android.CourseAdapter;
import com.example.android.hyperschedule_android.Database;
import com.example.android.hyperschedule_android.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class main_fragment extends Fragment {

    static final String URL = "https://hyperschedule.herokuapp.com/api/v3/courses?school=hmc";
    private ArrayList<Course> mCourseList;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private CourseAdapter mCourseAdapter;
    private Database mDatabase;
    private int i;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.main_frag, container, false);
        System.out.println("THIS SHOULD BE DONE FIRST");
        setHasOptionsMenu(true);
        /*
        code for toolbar
         */
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setUpRecyclerView(view);

    }

    private void setUpRecyclerView(View v) {
        System.out.println("database has been parsedA");
        mRecyclerView = v.findViewById(R.id.mRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        JSONParse();


    }

    private void JSONParse() {
        RequestQueue mQueue = Volley.newRequestQueue(getActivity());
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {

                    JSONObject data = response.getJSONObject("data");
                    System.out.println("I AM FINISHED ----------------------------------------------------------------------------00-0-0-0-0");
                    JSONObject courses = data.getJSONObject("courses");
                    ArrayList<Course> mCourseList = getAllCourses(courses);
                    if (mCourseAdapter == null) {
                        mCourseAdapter = new CourseAdapter(mCourseList);
                        mRecyclerView.setAdapter(mCourseAdapter);
                    } else {
                        mCourseAdapter.notifyDataSetChanged();
                    }



       /* mRecyclerView = v.findViewById(R.id.mRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getContext());
        mCourseAdapter = new CourseAdapter(mCourseList);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mCourseAdapter);*/

                    System.out.println(courses.toString());
                } catch (JSONException e) {
                    System.out.println("URRUCKED");
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("WE HAVE FOUND AN ERROr");
                error.printStackTrace();
            }
        });
        mQueue.add(request);
    }

    public ArrayList<Course> getAllCourses(JSONObject courses) {
        ArrayList<Course> arr = new ArrayList<>();
        Iterator<String> itr = courses.keys();
        while (itr.hasNext()) {
            try {
                Course c = new Course(courses.getJSONObject(itr.next()));
                arr.add(c);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return arr;

    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.search_menu, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mCourseAdapter.getFilter().filter(newText);
                return false;
            }
        });

    }
}

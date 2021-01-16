package com.example.android.hyperschedule_android;

import android.content.Context;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

public class Database {
    private static Context context;
    private View v;
    private static final String url = "";
    private JSONObject courseObject;

    public Database(Context context, View v) {
        this.context = context;
        this.v = v;
    }

    public void parse() {
        RequestQueue mQueue = Volley.newRequestQueue(context);
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {

                    JSONObject data = response.getJSONObject("data");
                    System.out.println("I AM FINISHED ----------------------------------------------------------------------------00-0-0-0-0");
                    JSONObject  courses = data.getJSONObject("courses");
                    courseObject = courses;

                    ArrayList<Course> mCourseList = getAllCourses(courses);



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



    public Course getCourse(String courseKey) throws JSONException {

        JSONObject course = courseObject.getJSONObject(courseKey);
        Course c = new Course(course);
        return c;

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

    private static class scraper implements Runnable {
        private JSONObject courses;

        @Override
        public void run() {
            RequestQueue mQueue = Volley.newRequestQueue(context);
            JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {

                        JSONObject data = response.getJSONObject("data");
                        System.out.println("I AM FINISHED ----------------------------------------------------------------------------00-0-0-0-0");
                        courses = data.getJSONObject("courses");
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

        public JSONObject getCourses() {
            return courses;
        }
    }


}

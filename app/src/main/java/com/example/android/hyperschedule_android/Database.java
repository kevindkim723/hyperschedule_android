package com.example.android.hyperschedule_android;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class Database {
    static final String URL = "https://hyperschedule.herokuapp.com/api/v3/courses?school=hmc";
    static JSONObject courses;

    public static void load(Context context) {
        RequestQueue mQueue = VolleySingleton.getInstance(context).getRequestQueue();
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject data = response.getJSONObject("data");
                    System.out.println();
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
                error.printStackTrace();
            }
        });
        mQueue.add(request);
    }

    public static Course getCourse(String courseKey) throws JSONException  {

        JSONObject course = courses.getJSONObject(courseKey);
        Course c = new Course(course);
        return c;

    }


}

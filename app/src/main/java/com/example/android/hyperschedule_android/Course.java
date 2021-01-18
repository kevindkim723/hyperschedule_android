package com.example.android.hyperschedule_android;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Course {
    private JSONObject course;
    private String mCourseName, mCourseCode, mCourseDescription;
    private int mCourseCredits;
    private String[] mInstructors;

    public Course(JSONObject course) {
        this.course = course;
        try
        {
            update(course);
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }

    }

    public void update(JSONObject course) throws JSONException {
        this.course = course;
        mCourseCode = getmCourseCode();
        mCourseName = getmCourseName();
        mCourseCredits = getmCourseCredits();
        mCourseDescription = getmCourseDescription();
        mInstructors = getmInstructors();

    }

    public String getmCourseName() throws JSONException {
        return course.getString("courseName");
    }


    public String getmCourseCode() throws JSONException {
        return course.getString("courseCode");
    }


    public int getmCourseCredits() throws JSONException {
        return course.getInt("courseCredits");
    }


    public String getmCourseDescription() throws JSONException {
        return course.getString("courseDescription");
    }


    public String getmCourseEnrollmentStatus() throws JSONException {
        return course.getString("courseEnrollmentStatus");
    }


    public String getmCourseTerm() throws JSONException {
        return course.getString("courseTerm");
    }


    public String getmScheduleDays() throws JSONException {
        return course.getJSONObject("courseSchedule").getJSONObject("0").getString("scheduleDays");
    }


    public String getmScheduleEndDate() throws JSONException {
        return course.getJSONObject("courseSchedule").getJSONObject("0").getString("scheduleEndDate");
    }


    public String getmScheduleEndTime() throws JSONException {
        return course.getJSONObject("courseSchedule").getJSONObject("0").getString("scheduleEndTime");
    }


    public String getmScheduleLocation() throws JSONException {
        return course.getJSONObject("courseSchedule").getJSONObject("0").getString("scheduleLocation");
    }


    public String getmScheduleStartDate() throws JSONException {
        return course.getJSONObject("courseSchedule").getJSONObject("0").getString("scheduleStartDate");
    }


    public String getmScheduleStartTime() throws JSONException {
        return course.getJSONObject("courseSchedule").getJSONObject("0").getString("scheduleStartTime");
    }


    public String getmScheduleTermCount() throws JSONException {
        return course.getJSONObject("courseSchedule").getJSONObject("0").getString("scheduleTermCount");
    }


    public int getmCourseSeatsFilled() throws JSONException {

        return course.getInt("courseSeatsFilled");
    }


    public int getmCourseSeatsTotal() throws JSONException {
        return course.getInt("courseSeatsTotal");
    }


    public String[] getmInstructors() throws JSONException {
        JSONArray arr = course.getJSONArray("courseInstructors");
        String[] instructors = new String[arr.length()];
        for (int i = 0; i < arr.length(); i++) {
            instructors[i] = arr.get(i).toString();
        }
        return instructors;
    }

    public String[] getmCourseSortKey() throws JSONException {
        String[] sortkey = new String[5];
        JSONArray arr = course.getJSONArray("courseSortKey");
        for (int i = 0; i < 5; i++) {
            sortkey[i] = arr.get(i).toString();
        }
        return sortkey;
    }

    public String getSearchCode() {
        /*
        returns a string with only the expressions/keywords of this course that are relevant in "searching" for this course (name, instructors, etc)
         */
        StringBuilder sb = new StringBuilder();
        try {
            for (String s : mInstructors) {
                sb.append(s);
                sb.append(" ");

            }
        }
        catch (Exception e )
        {
            e.printStackTrace();
        }

        sb.append(mCourseCode);
        sb.append(" ");
        sb.append(mCourseName);
        return sb.toString();

    }


}

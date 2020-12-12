package com.example.android.hyperschedule_android;

public class Course {
    private String mCourseName, mCourseCode, mCourseDescription, mCourseEnrollmentStatus, mCourseTerm;
    private String mScheduleDays,mScheduleEndDate, mScheduleEndTime, mScheduleLocation,mScheduleStartDate,mScheduleStartTime,mScheduleTermCount;
    private int mCourseCredits, mCourseSeatsFilled, mCourseSeatsTotal;
    private String[] mInstructors;


    /**
     *
     * @param mCourseName
     * @param mCourseCode
     * @param mCourseCredits
     * @param mCourseDescription
     * @param mCourseEnrollmentStatus
     * @param mCourseTerm
     * @param mScheduleDays
     * @param mScheduleEndDate
     * @param mScheduleEndTime
     * @param mScheduleLocation
     * @param mScheduleStartDate
     * @param mScheduleStartTime
     * @param mScheduleTermCount
     * @param mCourseSeatsFilled
     * @param mCourseSeatsTotal
     * @param mInstructors
     */
    public Coursesdsss(String mCourseName, String mCourseCode, int mCourseCredits, String mCourseDescription, String mCourseEnrollmentStatus, String mCourseTerm, String mScheduleDays, String mScheduleEndDate, String mScheduleEndTime, String mScheduleLocation, String mScheduleStartDate, String mScheduleStartTime, String mScheduleTermCount, int mCourseSeatsFilled, int mCourseSeatsTotal, String[] mInstructors) {
        this.mCourseName = mCourseName;
        this.mCourseCode = mCourseCode;
        this.mCourseCredits = mCourseCredits;
        this.mCourseDescription = mCourseDescription;
        this.mCourseEnrollmentStatus = mCourseEnrollmentStatus;
        this.mCourseTerm = mCourseTerm;
        this.mScheduleDays = mScheduleDays;
        this.mScheduleEndDate = mScheduleEndDate;
        this.mScheduleEndTime = mScheduleEndTime;
        this.mScheduleLocation = mScheduleLocation;
        this.mScheduleStartDate = mScheduleStartDate;
        this.mScheduleStartTime = mScheduleStartTime;
        this.mScheduleTermCount = mScheduleTermCount;
        this.mCourseSeatsFilled = mCourseSeatsFilled;
        this.mCourseSeatsTotal = mCourseSeatsTotal;
        this.mInstructors = mInstructors;
    }
    public void update()
    {

    }

    public String getmCourseName() {
        return mCourseName;
    }

    public void setmCourseName(String mCourseName) {
        this.mCourseName = mCourseName;
    }

    public String getmCourseCode() {
        return mCourseCode;
    }

    public void setmCourseCode(String mCourseCode) {
        this.mCourseCode = mCourseCode;
    }

    public int getmCourseCredits() {
        return mCourseCredits;
    }

    public void setmCourseCredits(String mCourseCredits) {
        this.mCourseCredits = mCourseCredits;
    }

    public String getmCourseDescription() {
        return mCourseDescription;
    }

    public void setmCourseDescription(String mCourseDescription) {
        this.mCourseDescription = mCourseDescription;
    }

    public String getmCourseEnrollmentStatus() {
        return mCourseEnrollmentStatus;
    }

    public void setmCourseEnrollmentStatus(String mCourseEnrollmentStatus) {
        this.mCourseEnrollmentStatus = mCourseEnrollmentStatus;
    }

    public String getmCourseTerm() {
        return mCourseTerm;
    }

    public void setmCourseTerm(String mCourseTerm) {
        this.mCourseTerm = mCourseTerm;
    }

    public String getmScheduleDays() {
        return mScheduleDays;
    }

    public void setmScheduleDays(String mScheduleDays) {
        this.mScheduleDays = mScheduleDays;
    }

    public String getmScheduleEndDate() {
        return mScheduleEndDate;
    }

    public void setmScheduleEndDate(String mScheduleEndDate) {
        this.mScheduleEndDate = mScheduleEndDate;
    }

    public String getmScheduleEndTime() {
        return mScheduleEndTime;
    }

    public void setmScheduleEndTime(String mScheduleEndTime) {
        this.mScheduleEndTime = mScheduleEndTime;
    }

    public String getmScheduleLocation() {
        return mScheduleLocation;
    }

    public void setmScheduleLocation(String mScheduleLocation) {
        this.mScheduleLocation = mScheduleLocation;
    }

    public String getmScheduleStartDate() {
        return mScheduleStartDate;
    }

    public void setmScheduleStartDate(String mScheduleStartDate) {
        this.mScheduleStartDate = mScheduleStartDate;
    }

    public String getmScheduleStartTime() {
        return mScheduleStartTime;
    }

    public void setmScheduleStartTime(String mScheduleStartTime) {
        this.mScheduleStartTime = mScheduleStartTime;
    }

    public String getmScheduleTermCount() {
        return mScheduleTermCount;
    }

    public void setmScheduleTermCount(String mScheduleTermCount) {
        this.mScheduleTermCount = mScheduleTermCount;
    }

    public int getmCourseSeatsFilled() {
        return mCourseSeatsFilled;
    }

    public void setmCourseSeatsFilled(int mCourseSeatsFilled) {
        this.mCourseSeatsFilled = mCourseSeatsFilled;
    }

    public int getmCourseSeatsTotal() {
        return mCourseSeatsTotal;
    }

    public void setmCourseSeatsTotal(int mCourseSeatsTotal) {
        this.mCourseSeatsTotal = mCourseSeatsTotal;
    }

    public String[] getmInstructors() {
        return mInstructors;
    }

    public void setmInstructors(String[] mInstructors) {
        this.mInstructors = mInstructors;
    }
}

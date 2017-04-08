package com.example.android.quakereport;

/**
 * Created by Zach on 4/7/2017.
 */

public class Earthquake {

    // Name of City where earthquake occurred
    private String mCity;

    // Magnitude of earthquake
    private String mMag;

    // Time (in milliseconds) of earthquake
    private long mTimeInMilliseconds;

    /**
     * Create Earthquake object
     *
     * @param cityName - City where the earthquake occurred
     * @param mag - magnitude of earthquake
     * @param time - time (in milliseconds) of earthquake
     */

    public Earthquake(String mag, String cityName, long time) {
        mCity = cityName;
        mMag = mag;
        mTimeInMilliseconds = time;
    }

    /**
     * Get the name of the city where earthquake occurred
     */
    public String getCity() { return mCity; }

    /**
     * Get the magnitude of the earthquake
     */
    public String getMag() { return mMag; }

    /**
     * Get the time of the earthquake
     */
    public long getTime() { return mTimeInMilliseconds; }

}

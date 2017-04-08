package com.example.android.quakereport;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Zach on 4/7/2017.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context    The current context. Used to inflate the layout file.
     * @param earthquake A List of Earthquake objects to display in a list
     */
    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> earthquake) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for three TextViews, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0
        super(context, 0, earthquake);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */

    @NonNull
    @Override

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;

        // Check if the existing view is being reused, otherwise inflate the view
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        // Get the {@link Earthquake} object located at this position in the list
        Earthquake currentEarthquake = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID magnitude
        TextView magTextView = (TextView) listItemView.findViewById(R.id.magnitude);
        // Get the magnitude from the current Earthquake object and set this text on the magnitude
        // TextView
        magTextView.setText(currentEarthquake.getMag());

        // Find the TextView in the list_item.xml layout with the ID city
        TextView cityTextView = (TextView) listItemView.findViewById(R.id.city);
        // Get the CityName from the current Earthquake object and set this text on the city
        // TextView
        cityTextView.setText(currentEarthquake.getCity());

        // Create a date object from the time in milliseconds
        Date dateObj = new Date(currentEarthquake.getTime());

        // Formats the date string to look like June 15, 1991
        String dateFormatted = formatDate(dateObj);
        // Find the date TextView
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date);
        // Set the text to display the correct date format
        dateTextView.setText(dateFormatted);

        // Formats the time string to look like 3:00PM
        String timeFormatted = formatTime(dateObj);
        // Find the time TextView
        TextView timeTextView = (TextView) listItemView.findViewById(R.id.time);
        // Set the text to display the correct time format
        timeTextView.setText(timeFormatted);

        // Return the whole list item layout (containing 3 TextViews) so that it can be shown
        // in the ListView
        return listItemView;
    }

    /**
     * Return the formatted date string (i.e. "Jun 15, 1991") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "3:00 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

}

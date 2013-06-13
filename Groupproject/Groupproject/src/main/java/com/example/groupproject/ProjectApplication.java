package com.example.groupproject;

import android.app.Application;
import android.util.Log;

import java.util.Calendar;

/**
 * Created by toddfrisch on 6/3/13.
 */
public class ProjectApplication extends Application {

    private static final String TAG = "ProjectApplication";
    public static final boolean L = true;

    EventData eventData;

    @Override
    public void onCreate() {
        super.onCreate();

        eventData = new EventData(this);

        if (L) { Log.d(TAG, "Echo: ProjectApplication onCreate()"); }

        //debug
        addDataToDatabase();
    }

    private void addDataToDatabase() {

        Event event = new Event();

        event.setTime(Calendar.getInstance().getTimeInMillis());
        event.setAddress(new Address("20901 Cypress Way", "Lynnwood", StateCode.WA, "98019"));
        event.setDescription("description");
        event.setHeader("header");
        event.setLatitude(0);
        event.setLongitude(0);
        event.setName("name");

        eventData.insert(event);
    }
}

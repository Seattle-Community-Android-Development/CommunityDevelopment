package com.example.groupproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.Calendar;

/**
 * Created by toddfrisch on 5/31/13.
 */
public class EventData {
    public static final String DB_NAME = "events.db";
    public static final int DB_VERSION = 1;
    public static final String TABLE = "events";
    public static final String _ID = "_id";
    public static final String C_EVENT_NAME = "event_name";
    public static final String C_EVENT_HEADER = "event_header";
    public static final String C_EVENT_DESCRIPTION = "event_description";
    public static final String C_EVENT_TIME = "event_time";
    public static final String C_EVENT_LONGITUDE = "event_longitude";
    public static final String C_EVENT_LATITUDE = "event_latitude";
    public static final String C_EVENT_ADDRESS = "event_address";
    private final String TAG = getClass().getSimpleName();
    SQLiteDatabase db;
    private Context context;
    private DBHelper dbHelper;

    public EventData(Context context) {
        this.context = context;
        dbHelper = new DBHelper(context);
    }

    public void insert(Event event) {
        ContentValues values = new ContentValues();
        values.put(C_EVENT_NAME, event.getName());
        values.put(C_EVENT_HEADER, event.getHeader());
        values.put(C_EVENT_DESCRIPTION, event.getDescription());
        //values.put(C_EVENT_TIME, event.getTime());
        values.put(C_EVENT_TIME, Calendar.getInstance().getTimeInMillis());
        values.put(C_EVENT_LONGITUDE, event.getLongitude());
        values.put(C_EVENT_LATITUDE, event.getLatitude());
        values.put(C_EVENT_ADDRESS, event.getAddress().toString());

        db = dbHelper.getWritableDatabase();
        db.insert(TABLE, null, values);
        //db.close();

    }


    public Cursor query() {

        db = dbHelper.getReadableDatabase();

        // this is equivalent to select * you could fill in the rest of the parameters be making an array of columns or saying what you want it to be ordered by
        Cursor cursor = db.query(TABLE, null, null, null, null, null, null);
        //db.close();
        return cursor;
    }

    class DBHelper extends SQLiteOpenHelper {

        DBHelper(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }

        //did not make any not null or primary key. I thought we could do the data checking at the insertion point.
        //also there needs to be a way for the dates that have already happened to be taken out of the database.
        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            String sql = String.format("CREATE TABLE %s (%s INTEGER primary key autoincrement, %s text, %s text, %s text, %s int, %s real, %s real, %s text)", TABLE, _ID, C_EVENT_NAME, C_EVENT_HEADER, C_EVENT_DESCRIPTION, C_EVENT_TIME, C_EVENT_LONGITUDE, C_EVENT_LATITUDE, C_EVENT_ADDRESS);

            if (ProjectApplication.L) {
                Log.d(TAG, "db (DBHelper) = " + db);
            }

            db = sqLiteDatabase;
            db.execSQL(sql);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int i, int i2) {
            //make into an alter table statement, however it is not necessary for this table.
            db.execSQL("drop table if exists " + TABLE);
            onCreate(db);
        }
    }
}

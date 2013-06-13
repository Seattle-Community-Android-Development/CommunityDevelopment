package com.example.groupproject;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

/**
 * Created by toddfrisch on 5/27/13.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class EventMapListFragment extends Fragment {


    private final String TAG = getClass().getSimpleName();

    static final String[] FROM = {EventData.C_EVENT_NAME, EventData.C_EVENT_DESCRIPTION, EventData.C_EVENT_TIME};
    static final int[] TO = {R.id.text_event, R.id.text_description, R.id.text_event_time};
    Cursor cursor;
    SimpleCursorAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(ProjectApplication.L) {Log.d(TAG, "Echo: EventMapListFragment.onCreate()");}

    }

    @Override
    public void onActivityCreated(Bundle bundle){
        super.onActivityCreated(bundle);

        populateListViewFromDatabase();
    }

    private void populateListViewFromDatabase() {
        cursor = ((ProjectApplication)getActivity().getApplication()).eventData.query();

        adapter = new SimpleCursorAdapter(getActivity(), R.layout.row, cursor, FROM, TO);

        adapter.setViewBinder(VIEW_BINDER);

        if (ProjectApplication.L) {
            Log.d(TAG, "onCreate; getView() = " + getView());
        }

        ListView listView = (ListView) getView().findViewById(R.id.portrait_small_event_list);

        if (ProjectApplication.L) {
            Log.d(TAG, "onCreate; listView = " + listView);
        }

        listView.setAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.map_list_fragment, container, false);
    }

    static final SimpleCursorAdapter.ViewBinder VIEW_BINDER = new SimpleCursorAdapter.ViewBinder() {
        @Override
        public boolean setViewValue(View view, Cursor cursor, int columnIndex) {
            if (view.getId() != R.id.text_event_time) return false;
            //could also have done if (cursor.getColumnIndex(StatusData.C_CREATED_AT)!=columnIndex) return false;  this just checks that you have the right data

            long time = cursor.getLong( cursor.getColumnIndex(EventData.C_EVENT_TIME));

            //here adjust vs time at GMT
            String relativeTime = DateUtils.getRelativeTimeSpanString(time).toString(); //it was a CharSequence
            ((TextView)view).setText(relativeTime);
            return true;

        }
    };
}

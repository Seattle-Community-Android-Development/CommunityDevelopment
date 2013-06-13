package com.example.groupproject;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.Calendar;

/**
 * Created by toddfrisch and Donald Subert on 5/31/13.
 */
public class AddEventFragment extends Fragment
{
    private final String TAG = getClass().getSimpleName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        setUpEventListening();
    }

    private void setUpEventListening() {

        Button timeButton = (Button) getActivity().findViewById(R.id.editText_event_time);
        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePickerDialog();
            }
        });

        Button dateButton = (Button) getActivity().findViewById(R.id.editText_event_date);
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.add_event_fragment, container, false);
    }

    public void showTimePickerDialog() {

        if (ProjectApplication.L) {
            Log.d(TAG, "showTimePickerDialog()");
        }

        DialogFragment newFragment = new TimePickerFragment();
        newFragment.setTargetFragment(this, 0);
        newFragment.show(getFragmentManager(), "timePicker");
    }

    public void showDatePickerDialog() {

        if (ProjectApplication.L) {
            Log.d(TAG, "showDatePickerDialog()");
        }

        DialogFragment newFragment = new DatePickerFragment();
        newFragment.setTargetFragment(this, 0);
        newFragment.show(getFragmentManager(), "datePicker");
    }

    public void setTime(String time) {
        Button timeButton = (Button) getActivity().findViewById(R.id.editText_event_time);
        timeButton.setText(time);
    }

    public void setDate(String date) {
        Button dateButton = (Button) getActivity().findViewById(R.id.editText_event_date);
        dateButton.setText(date);
    }

    //-----------------------------------------this does not include the date/time or address for simplicity to see if the application works as expected through this phase. should probably go back after execution of this method.
//should be shifted to an AsyncTask
    public void onClick(View view){

        EditText eventName = (EditText)getActivity().findViewById(R.id.editText_event_name);
        EditText eventTime = (EditText)getActivity().findViewById(R.id.editText_event_time);
        EditText eventDate = (EditText)getActivity().findViewById(R.id.editText_event_date);
        EditText eventAddress = (EditText)getActivity().findViewById(R.id.editText_event_address);
        EditText eventHeader = (EditText)getActivity().findViewById(R.id.editText_event_header);
        EditText eventDescription = (EditText)getActivity().findViewById(R.id.editText_event_description);

        //St
        //Calendar calendar =


        Event event = new Event();
        event.setName(eventName.getText().toString());
        event.setHeader(eventHeader.getText().toString());
        event.setDescription(eventDescription.getText().toString());
        //event.se


        ((ProjectApplication) getActivity().getApplication()).eventData.insert(event);





    }

}

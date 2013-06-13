package com.example.groupproject;

import android.app.DialogFragment;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.Calendar;

/**
 * Created by toddfrisch on 5/31/13.
 */
public class AddEventFragment extends Fragment
{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.add_event_fragment, container, false);
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

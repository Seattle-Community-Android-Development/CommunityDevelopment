package com.example.groupproject;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

/**
 * Created by toddfrisch on 5/27/13.
 */
public class SingleViewActivity extends Activity {

    private final String TAG = getClass().getSimpleName();
    private final boolean L = true;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (L) Log.i(TAG, "OnCreate" + (savedInstanceState == null ? " Restored state" : ""));

        //setContentView(R.layout.activity_single_view);

        ActionBar bar = getActionBar();
        bar.setDisplayShowTitleEnabled(false);
        bar.setDisplayShowTitleEnabled(false);


        setUpSpinner();
    }

    private void setUpSpinner() {

        getActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);

        Spinner spinner = (Spinner)findViewById(R.id.spinner);


        SpinnerAdapter mSpinnerAdapter = ArrayAdapter.createFromResource(this, R.array.menu_spinner, android.R.layout.simple_spinner_dropdown_item);
        ActionBar.OnNavigationListener mNavigationCallback = new ActionBar.OnNavigationListener() {
            // Get the same strings provided for the drop-down's ArrayAdapter
            String[] strings = getResources().getStringArray(R.array.menu_spinner);


            @Override
            public boolean onNavigationItemSelected(int position, long itemID) {

                Fragment newFragment;
                FragmentTransaction ft = getFragmentManager().beginTransaction();

                switch (position) {
                    case 0:

                        if (L) Log.i(TAG, "Spinner Navigation: case 0");


                        newFragment = new EventMapListFragment();
                        ft.replace(android.R.id.content, newFragment, strings[position]);
                        ft.commit();
                        return true;
                    case 1:

                        if (L) Log.i(TAG, "Spinner Navigation: case 1");



                        newFragment = new MyEventsFragment();
                        ft.replace(android.R.id.content, newFragment, strings[position]);
                        ft.commit();
                        return true;
                    case 2:

                        if (L) Log.i(TAG, "Spinner Navigation: case 2");



                        newFragment = new MyGroupsFragment();
                        ft.replace(android.R.id.content, newFragment, strings[position]);
                        ft.commit();
                        return true;
                    default:
                        return true; //changed from false
                }
            }
        };

        getActionBar().setListNavigationCallbacks(mSpinnerAdapter, mNavigationCallback);

        if (L) Log.i(TAG, "Set Up Spinner");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return true;


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.add_event:
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(android.R.id.content, new AddEventFragment());
                transaction.addToBackStack(null);
                transaction.commit();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        if (L) Log.i(TAG, "OnRestart");

    }

    @Override
    protected void onStart() {
        super.onStart();
        if (L) Log.i(TAG, "OnStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (L) Log.i(TAG, "onResume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        if (L) Log.i(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (L) Log.i(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (L) Log.i(TAG, "onDestroy" + (isFinishing() ? "Finishing" : ""));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (L) Log.i(TAG, "onSavedInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if (L) Log.i(TAG, "OnRestoreInstanceState"); //book has a Ternary statement here for saved data
    }

}

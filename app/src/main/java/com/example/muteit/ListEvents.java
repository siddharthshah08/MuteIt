package com.example.muteit;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import org.lucasr.twowayview.TwoWayView;

import java.util.ArrayList;


public class ListEvents extends ActionBarActivity {

    final Context context = this;
    private ArrayAdapter<String> arrayAdapter;
    private ListView eventListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_events);

        eventListView = (ListView) findViewById(R.id.listEvents);
        arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1);

        eventListView.setAdapter(arrayAdapter);

        eventListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_events, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id){
            case R.id.action_add:
                startDialogForNewEvent();
                break;
            case R.id.action_settings:
                break;
        }

        return false;
    }

    private void startDialogForNewEvent() {
        LayoutInflater li = LayoutInflater.from(context);
        View promptsView = li.inflate(R.layout.dialog_setup_event, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                context);

        // set prompts.xml to alertdialog builder
        alertDialogBuilder.setView(promptsView);
        ArrayList<String> selectedItems = new ArrayList<String>();
        selectedItems.add("Every Day");


        ArrayAdapter<String> aItems = new ArrayAdapter<String>(this, R.layout.simple_list_item_1, selectedItems);
        TwoWayView lvTest = (TwoWayView) promptsView.findViewById(R.id.lvItems);
        lvTest.setAdapter(aItems);

//        lvTest.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startDialogForRepeatingDays();
//            }
//

//        });


        // set dialog message
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                // get user input and set it to result
                                // edit text
                                arrayAdapter.add("Item added");

                                arrayAdapter.notifyDataSetChanged();

                            }
                        })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                dialog.cancel();
                            }
                        });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
    }

    public void startDialogForRepeatingDays(View v) {

        LayoutInflater li = LayoutInflater.from(context);
        View promptsView = li.inflate(R.layout.dialog_list_days, null);

        ListView daysListView = (ListView) promptsView.findViewById(R.id.listDays);
        ArrayAdapter<String> daysArrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_multiple_choice);
        daysArrayAdapter.add("Monday");
        daysArrayAdapter.add("Tuesday");
        daysArrayAdapter.add("Wednesday");
        daysArrayAdapter.add("Thursday");
        daysArrayAdapter.add("Friday");
        daysArrayAdapter.add("Saturday");
        daysArrayAdapter.add("Sunday");

        daysListView.setAdapter(daysArrayAdapter);


        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                context);

        // set prompts.xml to alertdialog builder
        alertDialogBuilder.setView(promptsView);

        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {


                            }
                        })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                dialog.cancel();
                            }
                        });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();

    }
}

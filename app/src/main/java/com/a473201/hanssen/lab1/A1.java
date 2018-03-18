package com.a473201.hanssen.lab1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView;
import java.util.ArrayList;
import java.util.List;
import android.widget.ArrayAdapter;
import android.content.Intent;
import android.content.SharedPreferences;


/*
    NOTE
    This app uses a singleton "Store" to share data between activities instead of intents.
 */



public class A1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a1);

        setup();
    }

    private void setup() {
        // Add data and event listeners to widgets.
        addItemsToSpinner();
        addListenerOnButton();
        addListenerOnSpinner();

        // Get preferences from cache.
        getUserPreferences();
    }

    private void addItemsToSpinner() {
        Spinner spinner = findViewById(R.id.L1);
        List<String> list = new ArrayList<String>();

        // Add some values to adapter.
        for(int i = 1; i < 20; ++i){
            list.add("Item " + i);
        }

        // Add adapter to list.
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
    }

    private void addListenerOnButton() {
        Button button = findViewById(R.id.B1);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Store store = Store.getInstance();

                // Adds the value from text field (T1) to the store.
                store.T1_value = ((TextView)findViewById(R.id.T1)).getText().toString();

                // Starts new activity (A2).
                startActivity(new Intent(A1.this, A2.class));
            }
        });
    }

    private void addListenerOnSpinner() {
        final Spinner spinner = findViewById(R.id.L1);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            // One the following function are called when user updates spinner value.
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                // Caches selected spinner position.
                SharedPreferences sharedPref = getSharedPreferences("preferences",0);
                SharedPreferences.Editor prefEditor = sharedPref.edit();
                prefEditor.putInt("userChoiceSpinner", position);
                prefEditor.apply();
            }

            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
    }

    private void getUserPreferences() {
        final Spinner spinner = findViewById(R.id.L1);

        SharedPreferences sharedPref = getSharedPreferences("preferences", MODE_PRIVATE);
        int spinnerValue = sharedPref.getInt("userChoiceSpinner",-1);
        if (spinnerValue != -1) {
            spinner.setSelection(spinnerValue);
        }
    }

}

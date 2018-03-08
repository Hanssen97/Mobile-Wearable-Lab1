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



public class A1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a1);

        addItemsToSpinner();
        addListenerOnButton();
        addListenerOnSpinner();
        getUserPreferences();
    }

    private void addItemsToSpinner() {
        Spinner spinner = findViewById(R.id.L1);
        List<String> list = new ArrayList<String>();

        for(int i=1; i<100; ++i){
            list.add("Item " + i);
        }

        // copy pasta
        // http://www.mkyong.com/android/android-spinner-drop-down-list-example/
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

    }

    private void addListenerOnButton() {
        Button button = findViewById(R.id.B1);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Store store = Store.getInstance();
                store.T1_value = ((TextView)findViewById(R.id.T1)).getText().toString();

                startActivity(new Intent(A1.this, A2.class));
            }
        });
    }

    private void addListenerOnSpinner() {
        final Spinner spinner = findViewById(R.id.L1);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
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

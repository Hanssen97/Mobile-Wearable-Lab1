package com.a473201.hanssen.lab1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class A3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a3);

        setup();
    }

    private void setup() {
        addListenerOnButton();
    }

    private void addListenerOnButton() {
        Button button = findViewById(R.id.B3);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Store store = Store.getInstance();
                // Update store.
                store.T4_value = ((TextView)findViewById(R.id.T4)).getText().toString();


                // Starts new activity (A2).
                startActivity(new Intent(A3.this, A2.class));
            }
        });
    }
}

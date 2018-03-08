package com.a473201.hanssen.lab1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class A2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a2);

        // Global Store
        Store store = Store.getInstance();


        TextView T2 = findViewById(R.id.T2);
        TextView T3 = findViewById(R.id.T3);


        T2.setText( "Hello " + String.valueOf(store.T1_value) );
        T3.setText( "From A3: " + String.valueOf(store.T4_value) );

        addListenerOnButton();
    }

    private void addListenerOnButton() {
        Button button = findViewById(R.id.B2);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Store store = Store.getInstance();
                store.T2_value = ((TextView)findViewById(R.id.T2)).getText().toString();
                store.T3_value = ((TextView)findViewById(R.id.T3)).getText().toString();

                startActivity(new Intent(A2.this, A3.class));
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(A2.this, A1.class));
    }
}
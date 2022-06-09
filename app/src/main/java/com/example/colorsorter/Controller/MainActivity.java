package com.example.colorsorter.Controller;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.colorsorter.Model.Data;
import com.example.colorsorter.R;

public class MainActivity extends AppCompatActivity {

    private TextView textViewTitle, textViewMac;
    private Button buttonValidate;
    private EditText editTextMac;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewMac = (TextView) findViewById(R.id.textViewMac);
        textViewTitle = (TextView) findViewById(R.id.textViewTitle);
        buttonValidate = (Button) findViewById(R.id.buttonValidate);
        editTextMac = (EditText) findViewById(R.id.editTextMac);

        Intent myIntent = getIntent();
        String mac = myIntent.getStringExtra("MAC");
        editTextMac.setText(mac);

        buttonValidate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!(editTextMac.getText().toString().length() == 17)){
                    //Popup erreor MAC
                    AlertDialog.Builder alertBuilder = new AlertDialog.Builder(MainActivity.this);
                    alertBuilder.setMessage("Veuillez saisir une adresse mac valide");
                    alertBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            //User OK
                        }
                    });

                    //Alert
                    AlertDialog alerteMac = alertBuilder.create();
                    alerteMac.show();
                } else {
                    Intent actionActivity = new Intent(MainActivity.this, ActionActivity.class);
                    actionActivity.putExtra("MAC",editTextMac.getText().toString());
                    startActivity(actionActivity);
                }


            }
        });

    };

}
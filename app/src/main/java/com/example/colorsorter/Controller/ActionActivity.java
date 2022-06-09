package com.example.colorsorter.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.colorsorter.Model.Data;
import com.example.colorsorter.R;

public class ActionActivity extends AppCompatActivity {

    private Button buttonEnvoi;
    private TextView textViewMacChoisi;
    private Data data = new Data();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action);

        buttonEnvoi = (Button) findViewById(R.id.buttonEnvoi);
        textViewMacChoisi = (TextView) findViewById(R.id.textViewMacChoisi);

        Intent myIntent = getIntent();
        String mac = myIntent.getStringExtra("MAC");

        data.setAdresseMac(mac);
        textViewMacChoisi.setText(mac);

        buttonEnvoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent MainActivity = new Intent(ActionActivity.this, MainActivity.class);
                MainActivity.putExtra("MAC",data.getAdresseMac());
                startActivity(MainActivity);
            }
        });

    }
}
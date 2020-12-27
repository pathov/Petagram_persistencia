package com.example.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

public class Acerca_de extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);
        /* CODIGO PARA DECLARAR EL TOOLBAR */
        Toolbar ActionBar = (Toolbar) findViewById(R.id.ActionBar);
        setSupportActionBar(ActionBar);
        //ActionBar.setNavigationIcon(R.attr.homeAsUpIndicator);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }
}
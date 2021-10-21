package com.example.exauni2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Spinner spFichas;
    private EditText etJugador1, etJugador2;
    private Button btIniciarJugego;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spFichas = (Spinner) findViewById(R.id.spFichas);
        etJugador1 =(EditText) findViewById(R.id.etJugador1);
        etJugador2 =(EditText) findViewById(R.id.etJugador2);
        btIniciarJugego = (Button) findViewById(R.id.btIniciarJugego);
        String[] fichas={"6", "12", "18","24"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, fichas);
        spFichas.setAdapter(adapter);
    }
}
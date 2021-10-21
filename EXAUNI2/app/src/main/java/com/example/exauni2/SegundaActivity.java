package com.example.exauni2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SegundaActivity extends AppCompatActivity {

    private TextView tvJugador1, tvJugador2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        tvJugador1 = (TextView) findViewById(R.id.tvJugador1);
        tvJugador2 = (TextView) findViewById(R.id.tvJugador2);

        Bundle bundle = getIntent().getExtras();
        String nombre1 = bundle.getString("jugador1");
        tvJugador1.setText(nombre1);
        String nombre2 = bundle.getString("jugador2");
        tvJugador2.setText(nombre2);

    }
}

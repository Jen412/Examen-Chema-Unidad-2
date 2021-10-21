package com.example.exauni2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Spinner spFichas;
    private EditText etJugador1, etJugador2;
    private final static int NOMBRE_REQUEST_CODE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etJugador1 = (EditText) findViewById(R.id.etJugador1);
        etJugador2 = (EditText) findViewById(R.id.etJugador2);


        spFichas = (Spinner) findViewById(R.id.spFichas);
        String[] fichas={"6", "12", "18","24"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, fichas);
        spFichas.setAdapter(adapter);

    }

    public void lanzarActivity(View view){
        //LANZAR LA SEGUNDA ACTIVITY
        Intent intent = new Intent(this, SegundaActivity.class);
        intent.putExtra("jugador1",etJugador1.getText().toString());
        intent.putExtra("jugador2",etJugador2.getText().toString());
        startActivityForResult(intent, NOMBRE_REQUEST_CODE);
    }
}

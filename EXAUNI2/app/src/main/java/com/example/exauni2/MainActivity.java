package com.example.exauni2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

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
        String nombreJugador1, nombreJugador2;
        int fichas;
        String mensaje = getString(R.string.mensaje_error);
        if (etJugador1.getText().length()> 0 && etJugador1.getText().length()> 0) {
            nombreJugador1 = etJugador1.getText().toString();
            nombreJugador2 = etJugador2.getText().toString();
            fichas = Integer.parseInt(spFichas.getSelectedItem().toString());
            Intent intent = new Intent(this, SegundaActivity.class);
            intent.putExtra("jugador1",nombreJugador1);
            intent.putExtra("jugador2",nombreJugador2);
            intent.putExtra("fichas", fichas);
            startActivityForResult(intent, NOMBRE_REQUEST_CODE);
            etJugador1.setText("");
            etJugador2.setText("");
        }
        else{
            AlertDialog.Builder dialogo = new AlertDialog.Builder(this);
            dialogo.setTitle("Error");
            dialogo.setMessage(mensaje);
            dialogo.setPositiveButton("Aceptar", null);
            dialogo.show();
        }
    }
}

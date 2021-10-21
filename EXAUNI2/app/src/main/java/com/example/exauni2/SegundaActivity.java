package com.example.exauni2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SegundaActivity extends AppCompatActivity {

    private TextView tvJugador1, tvJugador2, tvFichasJugador1, tvFichasJugador2, tvMesa, tvGanador;
    private int jugador1, jugador2, mesa;
    private String nombre1 = "", nombre2 = "", mensajeVictoria = "";
    private boolean jugador = true; //Jugador 1 es true y jugador 2 es false
    private Button btLanzar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        tvJugador1 = (TextView) findViewById(R.id.tvJugador1);
        tvJugador2 = (TextView) findViewById(R.id.tvJugador2);
        tvFichasJugador1 = (TextView) findViewById(R.id.tvFichasJugador1);
        tvFichasJugador2 = (TextView) findViewById(R.id.tvFichasJugador2);
        tvMesa = (TextView) findViewById(R.id.tvMesa);
        tvGanador = (TextView) findViewById(R.id.tvGanador);
        btLanzar = (Button)findViewById(R.id.btLanzar);

        Bundle bundle = getIntent().getExtras();
        nombre1 = bundle.getString("jugador1");
        tvJugador1.setText(nombre1);
        nombre2 = bundle.getString("jugador2");
        tvJugador2.setText(nombre2);
        int fichas = bundle.getInt("fichas");
        mesa = 6;
        jugador2= fichas-3;
        jugador1= fichas-3;
        tvFichasJugador1.setText("No. Fichas: "+String.valueOf(jugador1));
        tvFichasJugador2.setText("No. Fichas: "+String.valueOf(jugador2));
        tvMesa.setText(String.valueOf(mesa));
        tvJugador1.setTextColor(Color.BLUE);
        tvJugador2.setTextColor(Color.GREEN);
    }

    public void lanzamiento(View view){
        String leyenda = "";
        int numero = (int) (Math.random() * 6) + 1;;
        switch(numero){
            case 1:
                leyenda = "-1";
                if(jugador){
                    jugador1 -= 1;
                    jugador = false;
                }
                else{
                    jugador2 -= 1;
                    jugador = true;
                }
                mesa += 1;
                break;
            case 2:
                leyenda = "-2";
                if(jugador){
                    jugador1 -= 2;
                    jugador = false;
                }
                else{
                    jugador2 -= 2;
                    jugador = true;
                }
                mesa += 2;
                break;
            case 3:
                leyenda = "-3";
                if(jugador){
                    jugador1 -= 3;
                    jugador = false;
                }
                else{
                    jugador2 -= 3;
                    jugador = true;
                }
                mesa += 3;
                break;
            case 4:
                leyenda = "+1";
                if(jugador){
                    jugador1 += 1;
                    jugador = false;
                }
                else {
                    jugador2 += 1;
                    jugador = true;
                }
                mesa -= 1;
                break;
            case 5:
                leyenda = "+2";
                if(jugador){
                    jugador1 += 2;
                    jugador = false;
                }
                else{
                    jugador2 += 2;
                    jugador = true;
                }
                mesa -= 2;
                break;
            case 6:
                leyenda = "+3";
                if(jugador){
                    jugador1 += 3;
                    jugador = false;
                }
                else{
                    jugador2 += 3;
                    jugador = true;
                }
                mesa -= 3;
        }
        if(jugador1<0 || (jugador1<1 && mesa<0)){ // FIN DEL JUEGO
            mensajeVictoria = (nombre2 + " " + getString(R.string.mensaje_ganaste));
            tvGanador.setText(mensajeVictoria);
            tvGanador.setVisibility(View.VISIBLE);
            btLanzar.setEnabled(false);
            //finish();

        }
        else if(jugador2<0 || (jugador2<0 && mesa<0)){ // FIN DEL JUEGO
            mensajeVictoria = (nombre1 + " " + getString(R.string.mensaje_ganaste));
            tvGanador.setText(mensajeVictoria);
            tvGanador.setVisibility(View.VISIBLE);
            btLanzar.setEnabled(false);
            //finish();
        }
        else {
            if(mesa<0) { // Verificación de si hay 0 en la mesa
                mesa = 2;
                jugador1 -= 1;
                jugador2 -= 1;
            }

            if(jugador){
                tvJugador2.setTextColor(Color.GREEN);
                tvJugador1.setTextColor(Color.BLUE);
            }
            else{
                tvJugador2.setTextColor(Color.BLUE);
                tvJugador1.setTextColor(Color.GREEN);
            }
            tvFichasJugador1.setText("No. Fichas: "+String.valueOf(jugador1));
            tvFichasJugador2.setText("No. Fichas: "+String.valueOf(jugador2));
            tvMesa.setText(String.valueOf(mesa));
            Toast.makeText(this, leyenda, Toast.LENGTH_SHORT).show();
        }
    }
}

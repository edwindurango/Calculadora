package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {

    Button vCero, vUno, vDos, vTres, vCuatro, vCinco, vSeis, vSiete, vOcho, vNueve,
            vPunto, vClear, vIgual, vMas, vMenos, vPor, vDividido,vPorcentaje,vMasEntreMenos;

    TextView vResultado;
    Double  vNumero1 = 0.0;
    Double vNumero2 = 0.0;

    Double vOperacion;

    Integer vTipoOperacion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vCero = findViewById(R.id.button_0);
        vUno = findViewById(R.id.button_1);
        vDos = findViewById(R.id.button_2);
        vTres = findViewById(R.id.button_3);
        vCuatro = findViewById(R.id.button_4);
        vCinco = findViewById(R.id.button_5);
        vSeis = findViewById(R.id.button_6);
        vSiete = findViewById(R.id.button_7);
        vOcho = findViewById(R.id.button_8);
        vNueve = findViewById(R.id.button_9);
        vMas = findViewById(R.id.button_suma);
        vMenos = findViewById(R.id.button_resta);
        vPor = findViewById(R.id.button_multiplica);
        vDividido = findViewById(R.id.button_divide);
        vPunto = findViewById(R.id.button_decimal);
        vIgual = findViewById(R.id.button_igual);
        vClear = findViewById(R.id.button_ac);
        vPorcentaje=findViewById(R.id.button_porcentaje);
        vResultado = findViewById(R.id.result);
        vMasEntreMenos=findViewById(R.id.button_mas_entre_menos);

        vCero.setOnClickListener(this);
        vUno.setOnClickListener(this);
        vDos.setOnClickListener(this);
        vTres.setOnClickListener(this);
        vCuatro.setOnClickListener(this);
        vCinco.setOnClickListener(this);
        vSeis.setOnClickListener(this);
        vSiete.setOnClickListener(this);
        vOcho.setOnClickListener(this);
        vNueve.setOnClickListener(this);
        vMas.setOnClickListener(this);
        vMenos.setOnClickListener(this);
        vPor.setOnClickListener(this);
        vDividido.setOnClickListener(this);
        vPunto.setOnClickListener(this);
        vIgual.setOnClickListener(this);
        vClear.setOnClickListener(this);
        vPorcentaje.setOnClickListener(this);
        vMasEntreMenos.setOnClickListener(this);
    }

    public void indicarNumero(String numero) {
        vResultado.setText(vResultado.getText() + numero);
    }

    public void onClick(View v) {
        if (v.getId() == R.id.button_0) {
            indicarNumero("0");
        }
        if (v.getId() == R.id.button_1) {
            indicarNumero("1");
        }
        if (v.getId() == R.id.button_2) {
            indicarNumero("2");
        }
        if (v.getId() == R.id.button_3) {
            indicarNumero("3");
        }
        if (v.getId() == R.id.button_4) {
            indicarNumero("4");
        }
        if (v.getId() == R.id.button_5) {
            indicarNumero("5");
        }
        if (v.getId() == R.id.button_6) {
            indicarNumero("6");
        }
        if (v.getId() == R.id.button_7) {
            indicarNumero("7");
        }
        if (v.getId() == R.id.button_8) {
            indicarNumero("8");
        }
        if (v.getId() == R.id.button_9) {
            indicarNumero("9");
        }

        if (v.getId() == R.id.button_decimal) {
            indicarNumero(".");
        }
        if (v.getId() == R.id.button_ac) {
            Limpiar();
        }
        if (v.getId() == R.id.button_suma) {
            operSuma();
        }
        if (v.getId() == R.id.button_resta) {
            operResta();
        }
        if (v.getId() == R.id.button_multiplica) {
            operMultiplicacion();
        }
        if (v.getId() == R.id.button_divide) {
            operDivision();
        }
        if (v.getId() == R.id.button_igual) {
            operIgualdad();
        }

        if (v.getId() == R.id.button_porcentaje) {
            operPorcentaje() ;
        }

        if (v.getId() == R.id.button_mas_entre_menos) {
            cambiarSigno();
        }
    }

    public void Limpiar() {
        vResultado.setText("");
    }

    public Double obtenerPorcentaje(){
        vNumero2 = (Double.parseDouble(vResultado.getText().toString()));
        Double total;
        total=vNumero1*(vNumero2/100.0);
        return  total;
    }


    public void operSuma() {
        vNumero1 = (Double.parseDouble(vResultado.getText().toString()));
        vTipoOperacion = 1;
        Limpiar();
    }

    public void operResta() {
        vNumero1 = (Double.parseDouble(vResultado.getText().toString()));
        vTipoOperacion = 2;
        Limpiar();
    }

    private void operMultiplicacion() {
        vNumero1 = (Double.parseDouble (vResultado.getText().toString()));
        vTipoOperacion = 3;
        Limpiar();
    }

    public void operDivision() {
        vNumero1 = (Double.parseDouble(vResultado.getText().toString()));
        vTipoOperacion = 4;
        Limpiar();
    }

    public void operPorcentaje() {
        vNumero2 = (Double.parseDouble(vResultado.getText().toString()));
        vTipoOperacion = 5;
        //Limpiar();

    }

    public void operMasEntreMenos() {
        vNumero1 = (Double.parseDouble(vResultado.getText().toString()));
        vTipoOperacion = 6;
        //Limpiar();
    }

    public void cambiarSigno(){
        vNumero1 = (Double.parseDouble(vResultado.getText().toString()));
        Double resultado;
        resultado = vNumero1*-1;
        vResultado.setText(resultado.toString());
    }

    public void operIgualdad() {
        vNumero2 = (Double.parseDouble(vResultado.getText().toString()));
        if (vTipoOperacion.equals(1)) {
            vOperacion = vNumero1 + vNumero2;
        }
        else if (vTipoOperacion.equals(2)) {
            vOperacion = vNumero1 - vNumero2;
        }
        else if (vTipoOperacion.equals(3)) {
            vOperacion = vNumero1 * vNumero2;
        }
        else if (vTipoOperacion.equals(4)) {
            vOperacion = vNumero1 / vNumero2;
        }
        if (vTipoOperacion.equals(5)) {

            vOperacion=obtenerPorcentaje();

        }


        vResultado.setText(vOperacion.toString());

    }



}
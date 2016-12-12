package com.miramicodigo.studyjam_ii_java_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tvCantidad;
    private EditText etPrecio;
    private TextView tvTotal;

    private int cantidad = 1;
    private int res = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCantidad = (TextView) findViewById(R.id.tvCantidad);
        etPrecio = (EditText) findViewById(R.id.etPrecio);
        tvTotal = (TextView) findViewById(R.id.tvResultado);

        tvCantidad.setText(cantidad+"");
    }

    public void menos(View view) {
        cantidad = Integer.parseInt(tvCantidad.getText().toString());
        if (cantidad > 1) {
            res = cantidad - 1;
            tvCantidad.setText(res+"");
        }
    }
    public void mas(View view) {
        cantidad = Integer.parseInt(tvCantidad.getText().toString());
        res = cantidad + 1;
        tvCantidad.setText(res+"");
    }
    public void calcular(View view) {
        if(etPrecio.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(),
                    "Debe colocar el precio",
                    Toast.LENGTH_SHORT).show();
        } else {
            cantidad = Integer.parseInt(tvCantidad.getText().toString());
            double precio = Double.parseDouble(etPrecio.getText().toString());
            double resultado = cantidad * precio;
            tvTotal.setText("Bs. "+resultado);
        }
    }

    public void borrar(View v) {
        tvCantidad.setText("1");
        etPrecio.setText("");
        tvTotal.setText("Bs. 0");
    }
}

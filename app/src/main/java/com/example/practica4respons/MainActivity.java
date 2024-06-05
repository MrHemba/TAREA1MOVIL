package com.example.practica4respons;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnFecha;
    TextView txtFecha, txtNombre, txtApellido, txtEmpresa, txtTelefono, txtCorreo, txtFeecha;
    private int dia, mes, ano;

    private Spinner spinner;


    //Principal
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnFecha = (Button) findViewById(R.id.btnFecha);
         txtFecha = (TextView) findViewById(R.id.txtFecha);
          txtNombre = (EditText)findViewById(R.id.txtNombre);
          txtApellido = (EditText)findViewById(R.id.txtApellido);
          txtEmpresa = (EditText)findViewById(R.id.txtEmpresa);
          txtTelefono = (EditText)findViewById(R.id.txtTelefono);
          txtCorreo = (EditText)findViewById(R.id.txtCorreo);
          txtFeecha = (EditText)findViewById(R.id.txtFecha);

         btnFecha.setOnClickListener(this);

         //spinner Seleccionar Sexo
         spinner = (Spinner) findViewById(R.id.spinner);
         String [] respuesta = {"Genero","Hombre", "Mujer","Otro" };
         ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, respuesta);
         adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
         spinner.setAdapter(adapter);

    }
    @Override

    //metodo para la fecha
    public void onClick(View v) {
       if(v==btnFecha){
       final Calendar c= Calendar.getInstance();

       dia=c.get(Calendar.DAY_OF_MONTH);
       mes=c.get(Calendar.MONTH);
       ano=c.get(Calendar.YEAR);

           DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
               @Override
               public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                   txtFecha.setText(dayOfMonth+"/"+(month+1)+"/"+year);
               }
           },ano,mes,dia);
           datePickerDialog.show();
           }
    }
    //metodo para enviar
    public void btEnviar(View view)
    {

        Intent intent = new Intent(  MainActivity.this, MainActivity2.class);

        Bundle b = new Bundle();
        b.putString("NOMBRE",txtNombre.getText().toString());
        b.putString("APELLIDO",txtApellido.getText().toString());
        b.putString("EMPRESA",txtEmpresa.getText().toString());
        b.putString("TELEFONO",txtTelefono.getText().toString());
        b.putString("CORREO",txtCorreo.getText().toString());
        b.putString("FECHA",txtFeecha.getText().toString());
        b.putString("GENERO",spinner.getSelectedItem().toString());

        intent.putExtras(b);

        startActivity(intent);
    }

    //metodo para limpiar
        public void onClick2(View v) {

        txtNombre.setText("");
        txtApellido.setText("");
        txtEmpresa.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
        txtFeecha.setText("");
        spinner.setSelection(0);
        }

}
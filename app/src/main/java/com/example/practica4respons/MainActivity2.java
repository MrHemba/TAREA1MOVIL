package com.example.practica4respons;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TextView txtNomSend = (TextView)findViewById(R.id.txtNomSend);
        TextView txtApeSend = (TextView)findViewById(R.id.txtApeSend);
        TextView txtEmpSend = (TextView)findViewById(R.id.txtEmpSend);
        TextView txtTelfSend = (TextView)findViewById(R.id.txtTelfSend);
        TextView txtCorrSend = (TextView)findViewById(R.id.txtCorrSend);
        TextView txtFechSend = (TextView)findViewById(R.id.txtFechSend);
        TextView txtGenero = (TextView)findViewById(R.id.txtGenero);

        Bundle bundle = this.getIntent().getExtras();

        txtNomSend.setText( bundle.getString("NOMBRE"));
        txtApeSend.setText( bundle.getString("APELLIDO"));
        txtEmpSend.setText( bundle.getString("EMPRESA"));
        txtTelfSend.setText( bundle.getString("TELEFONO"));
        txtCorrSend.setText( bundle.getString("CORREO"));
        txtFechSend.setText( bundle.getString("FECHA"));
        txtGenero.setText( bundle.getString("GENERO"));


    }

    public void btVolver(View view)
    {
        Intent intent = new Intent(  MainActivity2.this, MainActivity.class);
        startActivity(intent);
    }
}
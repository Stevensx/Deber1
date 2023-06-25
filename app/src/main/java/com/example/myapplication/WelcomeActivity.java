package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        // Localizar los controles
        TextView txtSaludo = findViewById(R.id.txtBienvenido);

        // Se recupera la información pasada en el intent
        Bundle bundle = getIntent().getExtras();

        // Obtener el género del bundle
        String genero = bundle.getString("Genero");

        // Obtener el nombre del bundle
        String nombre = bundle.getString("Nombres");

        // Obtener la fecha de nacimiento del bundle
        String fechaNacimiento = bundle.getString("FechaNacimiento");

        // Construir el saludo dependiendo del género y agregar la fecha de nacimiento
        String saludo;
        if (genero.equals("Masculino")) {
            saludo = "¡Bienvenido, " + nombre + "!";
        } else if (genero.equals("Femenino")) {
            saludo = "¡Bienvenida, " + nombre + "!";
        } else {
            saludo = "¡Bienvenido(a), " + nombre + "!";
        }

        // Construir el mensaje a mostrar
        String mensaje = saludo + "\n" +
                "Género: " + genero + "\n" +
                "Ciudad: " + bundle.getString("Ciudad") + "\n" +
                "Celular: " + bundle.getString("Celular") + "\n" +
                "Correo: " + bundle.getString("Correo") + "\n" +
                "Fecha de Nacimiento: " + fechaNacimiento;

        // Mostrar el mensaje en el TextView
        txtSaludo.setText(mensaje);
    }
}
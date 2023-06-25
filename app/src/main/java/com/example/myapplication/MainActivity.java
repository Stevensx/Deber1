package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {

    private Calendar fechaNacimiento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etFechaNacimiento = findViewById(R.id.etFechaNacimiento);
        fechaNacimiento = Calendar.getInstance();

        etFechaNacimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int year = fechaNacimiento.get(Calendar.YEAR);
                int month = fechaNacimiento.get(Calendar.MONTH);
                int day = fechaNacimiento.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                fechaNacimiento.set(year, month, dayOfMonth);

                                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                                etFechaNacimiento.setText(sdf.format(fechaNacimiento.getTime()));
                            }
                        }, year, month, day);

                datePickerDialog.show();
            }
        });
    }

    public void btnEnviar(View view) {
        EditText Nombres = findViewById(R.id.txtNombres);
        EditText Apellidos = findViewById(R.id.txtApellidos);
        EditText Ciudad = findViewById(R.id.txtCiudad);
        EditText Celular = findViewById(R.id.txtCelular);
        EditText Correo = findViewById(R.id.txtEmail);
        RadioGroup Genero = findViewById(R.id.radioGroupGenero);

        String nomb = Nombres.getText().toString();
        String apell = Apellidos.getText().toString();
        String city = Ciudad.getText().toString();
        String celu = Celular.getText().toString();
        String email = Correo.getText().toString();
        String generoSeleccionado = "";

        int selectedId = Genero.getCheckedRadioButtonId();
        if (selectedId != -1) {
            RadioButton radioButton = findViewById(selectedId);
            generoSeleccionado = radioButton.getText().toString();
        }

        Bundle b = new Bundle();
        b.putString("Nombres", nomb);
        b.putString("Apellidos", apell);
        b.putString("Ciudad", city);
        b.putString("Celular", celu);
        b.putString("Correo", email);
        b.putString("Genero", generoSeleccionado);

        // Obtener la fecha de nacimiento
        EditText etFechaNacimiento = findViewById(R.id.etFechaNacimiento);
        String fechaNacimientoString = etFechaNacimiento.getText().toString();
        b.putString("FechaNacimiento", fechaNacimientoString);

        Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
        intent.putExtras(b);
        startActivity(intent);
    }

    public void btlimpiar(View view) {
        EditText Nombres = findViewById(R.id.txtNombres);
        EditText Apellidos = findViewById(R.id.txtApellidos);
        EditText Ciudad = findViewById(R.id.txtCiudad);
        EditText Celular = findViewById(R.id.txtCelular);
        EditText Correo = findViewById(R.id.txtEmail);
        EditText etFechaNacimiento = findViewById(R.id.etFechaNacimiento);

        Nombres.setText("");
        Apellidos.setText("");
        Ciudad.setText("");
        Celular.setText("");
        Correo.setText("");
        etFechaNacimiento.setText("");
    }
}
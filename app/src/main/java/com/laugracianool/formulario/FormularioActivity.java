package com.laugracianool.formulario;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;

import java.util.Calendar;

public class FormularioActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText eNombre, ePassword, eRepassword, eCorreo, eFechadeNacimiento;
    private TextView tResultado,hobbis;
    private Spinner sCiudades;
    private String sexo = "Masculino", Ciudad = "Medellin";
    private int año, mes , día ;
    private Button botonFechadeNacimiento;
    private static final int Tipo_dialogo = 0;
    private static DatePickerDialog.OnDateSetListener selectordeFecha;
    public CheckBox cocinar, EscucharMúsica, Bailar, HacerDeporte;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        eNombre = findViewById(R.id.eNombre);
        ePassword = findViewById(R.id.ePassword);
        eRepassword = findViewById(R.id.eRepPassword);
        eCorreo = findViewById(R.id.eCorreo);
        tResultado = findViewById(R.id.tResultado);
        sCiudades = findViewById(R.id.sCiudades);
        eFechadeNacimiento = findViewById(R.id.eFechadeNacimiento);
        botonFechadeNacimiento = findViewById(R.id.botonFechadeNacimiento);
        hobbis = findViewById(R.id.hobbis);
        Calendar Calendario = Calendar.getInstance();
        día = Calendario.get(Calendar.DAY_OF_MONTH);
        mes = Calendario.get(Calendar.MONTH);
        año = Calendario.get(Calendar.YEAR);
        mostrarFecha();
        cocinar = findViewById(R.id.cocinar);
        Bailar = findViewById(R.id.bailar);
        HacerDeporte = findViewById(R.id.HacerDeporte);
        EscucharMúsica = findViewById(R.id.EscucharMúsica);
        selectordeFecha = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                año = year;
                mes = month;
                día = dayOfMonth;
                mostrarFecha();


            }
        };

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Ciudades, android.R.layout.simple_spinner_item);


        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sCiudades.setAdapter(adapter);

        sCiudades.setOnItemSelectedListener(this);

    }
    public void mostrarFecha (){
        eFechadeNacimiento.setText(día+"/"+(mes+1)+"/"+año);
    }

    public void guardarClicked(View view) {
        String name, pass, repass, email,fechanacimiento,hobbi;

        name = eNombre.getText().toString();
        pass = ePassword.getText().toString();
        repass = eRepassword.getText().toString();
        email = eCorreo.getText().toString();
        fechanacimiento = eFechadeNacimiento.getText().toString();
        hobbi = hobbis.getText().toString();

        if (name.equals("") || pass.equals("") || repass.equals("") || email.equals(""))
            Toast.makeText(getApplicationContext(), "Debe de digitar todos los campos",Toast.LENGTH_SHORT).show();
        else
        if (pass.equals(repass))
            tResultado.setText(name+"  - "+email+" - "+sexo+" - "+Ciudad+" - "+fechanacimiento+" - "+hobbi);
        else
            Toast.makeText(getApplicationContext(), "Las contraseñas no son iguales", Toast.LENGTH_SHORT).show();
    }
    public void onRadioButtonClicked(View view){
        int id = view.getId();

        if (id == R.id.rMasculino)
            sexo= "Masculino";
        else
            sexo="Femenino";

    }

    @Override
    protected Dialog onCreateDialog(int id){
        switch (id){
            case 0:
                return new DatePickerDialog(this,selectordeFecha,año,mes,día);
        }
        return null;
    }
    public void mostrarCalendario (View control){ showDialog(Tipo_dialogo);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Ciudad = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public void onCheckboxClicked(View view) {

        if(cocinar.isChecked()){
            hobbis.setText(cocinar.getText());
        }else{

        } if (Bailar.isChecked()){
            hobbis.setText(Bailar.getText());
        }else{

        }if (HacerDeporte.isChecked()){
            hobbis.setText(HacerDeporte.getText());
        }else {

        }if (EscucharMúsica.isChecked()){
                hobbis.setText(EscucharMúsica.getText());
            }else {
            }
        }

    }



package es.studium.mialarma;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.sql.Time;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button miBoton;
    EditText hora;
    int horas;
    int minutos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        miBoton = findViewById(R.id.myButton);
        miBoton.setOnClickListener(this);
        hora = findViewById(R.id.editTextTime);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.myButton){
            String[] partes = hora.getText().toString().split(":");
            horas = Integer.parseInt(partes[0]);
            minutos = Integer.parseInt(partes[1]);
            crearAlarma();
        }
    }

    public void crearAlarma(){
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, "Mensaje!")
                .putExtra(AlarmClock.EXTRA_HOUR, horas)
                .putExtra(AlarmClock.EXTRA_MINUTES, minutos);
        if (intent.resolveActivity(getPackageManager()) != null){
           startActivity(intent);
        }
    }
}
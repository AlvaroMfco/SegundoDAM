package es.studium.practica3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    CalendarView calendarView;
    TextView txtFecha;
    Button btnAceptar;
    String fecha="";
    EditText txtanio;
    Button btnIr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //Referencias
        calendarView = findViewById(R.id.calendarView);
        calendarView.setFirstDayOfWeek(Calendar.MONDAY);
        btnAceptar = findViewById(R.id.btnAceptar);
        txtFecha = findViewById(R.id.txtFecha);
        txtanio = findViewById(R.id.txtAnio);
        btnIr = findViewById(R.id.btnIr);

        //Listeners
        btnAceptar.setOnClickListener(this);
        btnIr.setOnClickListener(this);

        //Configurar el CalendarView
        calendarView.setOnDateChangeListener((calendarView, anio, mes, dia) -> {
            fecha = dia + "/" + (mes + 1) + "/" + anio;
            String mensaje = getString(R.string.prefijoFecha) + " " + fecha;
            txtFecha.setText(mensaje);
        });
    }

    @Override
    public void onClick(View view) {
        //Cuando se pulsa "Aceptar"
        if (view.getId() == R.id.btnAceptar) {
            if (!txtFecha.getText().toString().isEmpty()) {
                Intent intent = new Intent(this, MainActivity2.class);
                intent.putExtra("fecha", fecha);
                startActivity(intent);
            }
            else {
                Toast.makeText(this, getString(R.string.error), Toast.LENGTH_SHORT).show();
                return;
            }
        }
        //Cuando se pulsa "Ir"
        if (view.getId() == R.id.btnIr) {
            String anio = txtanio.getText().toString();
            if (!anio.isEmpty()) {
                try {
                    int anioInt = Integer.parseInt(anio);
                    if (anioInt <= 0 || anioInt > 2099 ) {
                        Toast.makeText(this, getString(R.string.errorFecha), Toast.LENGTH_SHORT).show();
                        txtFecha.setText("");
                        return;
                    }
                    //Configurar el CalendarView para mostrar enero de ese año
                    Calendar calendar = Calendar.getInstance();
                    calendar.set(anioInt, Calendar.JANUARY, 1);  // Enero de ese año
                    calendarView.setDate(calendar.getTimeInMillis(), true, true);
                    txtFecha.setText("");
                    txtanio.setText("");

                } catch (NumberFormatException e) {
                    Toast.makeText(this, getString(R.string.errorFecha), Toast.LENGTH_SHORT).show();
                }
            }
            else {
                txtFecha.setText("");
                Toast.makeText(this, getString(R.string.anioVacio), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
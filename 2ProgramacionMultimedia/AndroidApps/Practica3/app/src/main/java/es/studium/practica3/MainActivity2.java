package es.studium.practica3;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;


public class MainActivity2 extends AppCompatActivity {
    String fecha;
    String signo;
    int edad;
    TextView txtSigno;
    TextView txtEdad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        EdgeToEdge.enable(this);
        fecha = getIntent().getStringExtra("fecha");

        //Afirmar que fecha no es null
        assert fecha != null;

        //Obtener signo
        signo = obtenerSigno(fecha);

        txtSigno = findViewById(R.id.txtSigno);
        txtSigno.setText(signo);
        txtEdad = findViewById(R.id.txtEdad);

        //Calcular edad
        edad = calcularEdad(fecha);

        //Mostrar edad
        if(edad < 0){
            txtEdad.setText(getString(R.string.error2));
        }
        else if(edad == 0){
            txtEdad.setText(getString(R.string.bebe));
        }
        else{
            String mensaje = getString(R.string.tienes) + " " + edad + " " + getString(R.string.anios);
            txtEdad.setText(mensaje);
        }

        //Cargar imagen
        cargarImagen(signo);
    }

    private int calcularEdad(String fechaNacimiento) {
        String[] partesFecha = fechaNacimiento.split("/");
        int dia = Integer.parseInt(partesFecha[0]);
        int mes = Integer.parseInt(partesFecha[1]);
        int anio = Integer.parseInt(partesFecha[2]);

        //Almacenar la fecha y hora actuales
        Calendar fechaNacimientoCal = Calendar.getInstance();
        //Setear los parámetros de fecha de nacimiento
        fechaNacimientoCal.set(anio, mes - 1, dia);

        //Almacenar la fecha y hora actuales sin modificar
        Calendar fechaActual = Calendar.getInstance();
        int edad = fechaActual.get(Calendar.YEAR) - fechaNacimientoCal.get(Calendar.YEAR);

        //Si el cumpleaños aún no ha sido este año
        if (fechaActual.get(Calendar.MONTH) < fechaNacimientoCal.get(Calendar.MONTH) ||
                (fechaActual.get(Calendar.MONTH) == fechaNacimientoCal.get(Calendar.MONTH) &&
                        fechaActual.get(Calendar.DAY_OF_MONTH) < fechaNacimientoCal.get(Calendar.DAY_OF_MONTH))) {
            edad--;
        }
        return edad;
    }





    private String obtenerSigno(String fecha) {
        String[] partesFecha = fecha.split("/"); // Separar día, mes y año
        int dia = Integer.parseInt(partesFecha[0]);
        int mes = Integer.parseInt(partesFecha[1]);

        if ((mes == 1 && dia >= 20) || (mes == 2 && dia <= 18)) {
            return getString(R.string.acuario);
        }
        else if (mes == 2 || mes == 3 && dia <= 20) {
            return getString(R.string.piscis);
        }
        else if (mes == 3 || mes == 4 && dia <= 19) {
            return getString(R.string.aries);
        }
        else if (mes == 4 || mes == 5 && dia <= 20) {
            return getString(R.string.tauro);
        }
        else if (mes == 5 || mes == 6 && dia <= 20) {
            return getString(R.string.geminis);
        }
        else if (mes == 6 || mes == 7 && dia <= 22) {
            return getString(R.string.cancer);
        }
        else if (mes == 7 || mes == 8 && dia <= 22) {
            return getString(R.string.leo);
        }
        else if (mes == 8 || mes == 9 && dia <= 22) {
            return getString(R.string.virgo);
        }
        else if (mes == 9 || mes == 10 && dia <= 22) {
            return getString(R.string.libra);
        }
        else if (mes == 10 || mes == 11 && dia <= 21) {
            return getString(R.string.escorpio);
        }
        else if (mes == 11 || mes == 12 && dia <= 21) {
            return getString(R.string.sagitario);
        }
        else if (mes == 12 || mes == 1) {
            return getString(R.string.capricornio);
        }
        return getString(R.string.sagitario);
    }

    private void cargarImagen(String signo) {
        ImageView ivSigno = findViewById(R.id.ivSigno);
        if (signo.equals(getString(R.string.acuario))) {
            ivSigno.setImageResource(R.drawable.acuario);
        }
        else if (signo.equals(getString(R.string.piscis))) {
            ivSigno.setImageResource(R.drawable.piscis);
        }
        else if (signo.equals(getString(R.string.aries))) {
            ivSigno.setImageResource(R.drawable.aries);
        }
        else if (signo.equals(getString(R.string.tauro))) {
            ivSigno.setImageResource(R.drawable.tauro);
        }
        else if (signo.equals(getString(R.string.geminis))) {
            ivSigno.setImageResource(R.drawable.geminis);
        }
        else if (signo.equals(getString(R.string.cancer))) {
            ivSigno.setImageResource(R.drawable.cancer);
        }
        else if (signo.equals(getString(R.string.leo))) {
            ivSigno.setImageResource(R.drawable.leo);
        }
        else if (signo.equals(getString(R.string.virgo))) {
            ivSigno.setImageResource(R.drawable.virgo);
        }
        else if (signo.equals(getString(R.string.libra))) {
            ivSigno.setImageResource(R.drawable.libra);
        }
        else if (signo.equals(getString(R.string.escorpio))) {
            ivSigno.setImageResource(R.drawable.escorpio);
        }
        else if (signo.equals(getString(R.string.sagitario))) {
            ivSigno.setImageResource(R.drawable.sagitario);
        }
        else if (signo.equals(getString(R.string.capricornio))) {
            ivSigno.setImageResource(R.drawable.capricornio);
        }
    }
}
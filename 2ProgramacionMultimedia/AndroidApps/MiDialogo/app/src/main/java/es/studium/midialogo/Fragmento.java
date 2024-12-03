package es.studium.midialogo;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.util.Random;

public class Fragmento extends Fragment implements View.OnClickListener {

    private ProgressBar txtFuerza, txtVida, txtMagia, txtVelocidad;
    private TextView nFuerza, nVida, nMagia, nVelocidad, nombre;
    private ImageView img;
    String frase, nombrePj;
    ImageButton reiniciar;
    OnNuevoDialogoListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragmento, container, false);
        // Inicializar los TextViews
        txtFuerza = view.findViewById(R.id.txtFuerza);
        txtVida = view.findViewById(R.id.txtVida);
        txtMagia = view.findViewById(R.id.txtMagia);
        txtVelocidad = view.findViewById(R.id.txtVelocidad);
        img = view.findViewById(R.id.imgPj);
        nFuerza = view.findViewById(R.id.nFuerza);
        nVida = view.findViewById(R.id.nVida);
        nMagia = view.findViewById(R.id.nMagia);
        nVelocidad = view.findViewById(R.id.nVelocidad);
        nombre = view.findViewById(R.id.lblNombre);
        reiniciar = view.findViewById(R.id.btnReiniciar);
        reiniciar.setOnClickListener(this);

        // Generar números aleatorios
        generarStats();
        return view;
    }

    //Método para generar los números aleatorios
    public void generarStats() {
        Random random = new Random();
        int fuerza = random.nextInt(21);  // Entre 0 y 20
        int vida = random.nextInt(101);   // Entre 0 y 100
        int magia = random.nextInt(11);   // Entre 0 y 10
        int velocidad = random.nextInt(6); // Entre 0 y 10

        //Actualizar los TextViews con los números generados
        nFuerza.setText(String.valueOf(fuerza));
        nVida.setText(String.valueOf(vida));
        nMagia.setText(String.valueOf(magia));
        nVelocidad.setText(String.valueOf(velocidad));

        //Rellenar barra
        txtFuerza.setProgress((fuerza * 100) / 20);
        txtVida.setProgress((vida * 100) / 100);
        txtMagia.setProgress((magia * 100) / 10);
        txtVelocidad.setProgress((velocidad * 100) / 5);

        //No se obtienen datos hasta que haya argumentos
        if (getArguments() != null) {
            recibirDatos();
        }
        nombre.setText(nombrePj);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void recibirDatos() {
        Bundle datos = getArguments();
        frase = datos.getString("frase");
        nombrePj = datos.getString("nombre");
        if (frase == null || nombrePj == null) {
            Log.d("RecibiendoDatos", "Datos nulos");
        } else {
            cambiarImagen();
        }
    }

    public void cambiarImagen() {
        switch (frase) {
            case "Hombre_Elfo_Arquero":
                img.setImageResource(R.drawable.elfo_arquero);
                break;
            case "Hombre_Elfo_Guerrero":
                img.setImageResource(R.drawable.elfo_guerrero);
                break;
            case "Hombre_Elfo_Mago":
                img.setImageResource(R.drawable.elfo_mago);
                break;
            case "Hombre_Elfo_Herrero":
                img.setImageResource(R.drawable.elfo_herrero);
                break;
            case "Hombre_Elfo_Minero":
                img.setImageResource(R.drawable.elfo_minero);
                break;
            case "Mujer_Elfo_Arquero":
                img.setImageResource(R.drawable.elfa_arquera);
                break;
            case "Mujer_Elfo_Guerrero":
                img.setImageResource(R.drawable.elfa_guerrera);
                break;
            case "Mujer_Elfo_Mago":
                img.setImageResource(R.drawable.elfa_maga);
                break;
            case "Mujer_Elfo_Herrero":
                img.setImageResource(R.drawable.elfa_herrera);
                break;
            case "Mujer_Elfo_Minero":
                img.setImageResource(R.drawable.elfa_minera);
                break;
            case "Hombre_Enano_Arquero":
                img.setImageResource(R.drawable.enano_arquero);
                break;
            case "Hombre_Enano_Guerrero":
                img.setImageResource(R.drawable.enano_guerrero);
                break;
            case "Hombre_Enano_Mago":
                img.setImageResource(R.drawable.enano_mago);
                break;
            case "Hombre_Enano_Herrero":
                img.setImageResource(R.drawable.enano_herrero);
                break;
            case "Hombre_Enano_Minero":
                img.setImageResource(R.drawable.enano_minero);
                break;
            case "Mujer_Enano_Arquero":
                img.setImageResource(R.drawable.enana_arquera);
                break;
            case "Mujer_Enano_Guerrero":
                img.setImageResource(R.drawable.enana_guerrera);
                break;
            case "Mujer_Enano_Mago":
                img.setImageResource(R.drawable.enana_maga);
                break;
            case "Mujer_Enano_Herrero":
                img.setImageResource(R.drawable.enana_herrera);
                break;
            case "Mujer_Enano_Minero":
                img.setImageResource(R.drawable.enana_minera);
                break;
            case "Hombre_Hobbit_Arquero":
                img.setImageResource(R.drawable.hobbit_arquero);
                break;
            case "Hombre_Hobbit_Guerrero":
                img.setImageResource(R.drawable.hobbit_guerrero);
                break;
            case "Hombre_Hobbit_Mago":
                img.setImageResource(R.drawable.hobbit_mago);
                break;
            case "Hombre_Hobbit_Herrero":
                img.setImageResource(R.drawable.hobbit_herrero);
                break;
            case "Hombre_Hobbit_Minero":
                img.setImageResource(R.drawable.hobbit_minero);
                break;
            case "Mujer_Hobbit_Arquero":
                img.setImageResource(R.drawable.hobbit_arquera);
                break;
            case "Mujer_Hobbit_Guerrero":
                img.setImageResource(R.drawable.hobbit_guerrera);
                break;
            case "Mujer_Hobbit_Mago":
                img.setImageResource(R.drawable.hobbit_maga);
                break;
            case "Mujer_Hobbit_Herrero":
                img.setImageResource(R.drawable.hobbit_herrera);
                break;
            case "Mujer_Hobbit_Minero":
                img.setImageResource(R.drawable.hobbit_minera);
                break;
            case "Hombre_Humano_Arquero":
                img.setImageResource(R.drawable.hombre_arquero);
                break;
            case "Hombre_Humano_Guerrero":
                img.setImageResource(R.drawable.hombre_guerrero);
                break;
            case "Hombre_Humano_Mago":
                img.setImageResource(R.drawable.hombre_mago);
                break;
            case "Hombre_Humano_Herrero":
                img.setImageResource(R.drawable.hombre_herrero);
                break;
            case "Hombre_Humano_Minero":
                img.setImageResource(R.drawable.hombre_minero);
                break;
            case "Mujer_Humano_Arquero":
                img.setImageResource(R.drawable.mujer_arquera);
                break;
            case "Mujer_Humano_Guerrero":
                img.setImageResource(R.drawable.mujer_guerrera);
                break;
            case "Mujer_Humano_Mago":
                img.setImageResource(R.drawable.mujer_maga);
                break;
            case "Mujer_Humano_Herrero":
                img.setImageResource(R.drawable.mujer_herrera);
                break;
            case "Mujer_Humano_Minero":
                img.setImageResource(R.drawable.mujer_minera);
                break;
        }
    }

    @Override
    public void onClick(View view) {
        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        ft.hide(Fragmento.this);
        ft.commit();
        listener.mostrarDlgNombre();
    }

    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener = (OnNuevoDialogoListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + getString(R.string.avisoListener));
        }
    }
}

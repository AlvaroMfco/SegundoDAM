package es.studium.midialogo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;


public class DlgClase extends DialogFragment {
    OnNuevoDialogoListener listener;
    Spinner spinnerClase;
    String clase;

    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialogo_clase, null);
        spinnerClase = view.findViewById(R.id.spinnerClase);


        builder.setView(view);
        builder.setTitle(getString(R.string.eligeClase))
                .setPositiveButton(getString(R.string.siguiente), new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        clase = spinnerClase.getSelectedItem().toString();
                        try {
                            if (spinnerClase.getSelectedItemPosition() == 0) {
                                Toast.makeText(getActivity(), getString(R.string.claseVacia), Toast.LENGTH_LONG).show();
                                listener.mostrarDlgClase();
                                return;
                            }
                            listener.setDatosPj(clase, 3);
                            listener.enviarDatos();
                            dialog.dismiss();
                        } catch (Exception e) {
                            Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                        dialog.dismiss();
                    }
                })
                .setNegativeButton(getString(R.string.cancelar), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        listener.mostrarComenzar();
                        dialog.dismiss();
                    }
                });
        return builder.create();
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

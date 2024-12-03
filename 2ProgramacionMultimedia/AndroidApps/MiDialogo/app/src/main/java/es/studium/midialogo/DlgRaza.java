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

public class DlgRaza extends DialogFragment {
    OnNuevoDialogoListener listener;
    Spinner spinnerRaza;
    String raza;

    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialogo_raza, null);
        spinnerRaza = view.findViewById(R.id.spinnerRaza);

        builder.setView(view);
        builder.setTitle(getString(R.string.eligeRaza))
                .setPositiveButton(getString(R.string.siguiente), new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        raza = spinnerRaza.getSelectedItem().toString();
                        try {
                            if(spinnerRaza.getSelectedItemPosition()==0){
                                Toast.makeText(getActivity(), getString(R.string.razaVacia), Toast.LENGTH_LONG).show();
                                listener.mostrarDlgRaza();
                                return;
                            }
                            listener.setDatosPj(raza, 2);
                            listener.mostrarDlgClase();
                            dialog.dismiss();
                        } catch (Exception e) {
                            Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_LONG).show();
                        }
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

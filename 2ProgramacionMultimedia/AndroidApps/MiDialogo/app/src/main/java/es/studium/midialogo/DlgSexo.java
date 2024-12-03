package es.studium.midialogo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class DlgSexo extends DialogFragment {
    OnNuevoDialogoListener listener;
    RadioGroup radioGroup;
    RadioButton radioHombre, radioMujer;
    String sexo;
@NonNull
public Dialog onCreateDialog(Bundle savedInstanceState) {
    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
    LayoutInflater inflater = getActivity().getLayoutInflater();
    View view = inflater.inflate(R.layout.dialogo_sexo, null);
    radioGroup = view.findViewById(R.id.radioGroup);
    radioHombre = view.findViewById(R.id.radioHombre);
    radioMujer = view.findViewById(R.id.radioMujer);

    builder.setView(view);
    builder.setTitle(getString(R.string.eligeSexo))
            .setPositiveButton(getString(R.string.siguiente), new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int i) {
                    sexo = radioHombre.isChecked() ? getString(R.string.sexoHombre) : getString(R.string.sexoMujer);
                    try {
                        if (radioGroup.getCheckedRadioButtonId() == -1) {
                            Toast.makeText(getActivity(), getString(R.string.sexoVacio), Toast.LENGTH_LONG).show();
                            listener.mostrarDlgSexo();
                            return;
                        }
                        listener.setDatosPj(sexo,1);
                        listener.mostrarDlgRaza();
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
    public void onAttach(Context context){
        super.onAttach(context);
        try{
            listener = (OnNuevoDialogoListener) context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString() + getString(R.string.avisoListener));
        }
    }
}

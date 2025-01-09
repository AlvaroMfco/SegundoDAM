package es.studium.davinciapp.ui.escultor;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import es.studium.davinciapp.databinding.FragmentEscultorBinding;

public class EscultorFragment extends Fragment {

    private FragmentEscultorBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        EscultorViewModel galleryViewModel =
                new ViewModelProvider(this).get(EscultorViewModel.class);

        binding = FragmentEscultorBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textEscultor;
        galleryViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
package es.studium.davinciapp.ui.cientifico;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import es.studium.davinciapp.databinding.FragmentCientificoBinding;

public class CientificoFragment extends Fragment {

    private FragmentCientificoBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CientificoViewModel slideshowViewModel =
                new ViewModelProvider(this).get(CientificoViewModel.class);

        binding = FragmentCientificoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textCientifico;
        slideshowViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
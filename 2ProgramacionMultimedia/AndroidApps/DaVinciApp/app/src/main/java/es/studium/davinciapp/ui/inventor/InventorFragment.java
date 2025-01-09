package es.studium.davinciapp.ui.inventor;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import es.studium.davinciapp.databinding.FragmentInventorBinding;

public class InventorFragment extends Fragment {

    private FragmentInventorBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        InventorViewModel homeViewModel =
                new ViewModelProvider(this).get(InventorViewModel.class);

        binding = FragmentInventorBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textInventor;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
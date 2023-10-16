package com.example.abubakir_turakulov_hw_2_3;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class SecondFragment extends Fragment {

    private TextView sizeText;
    private Button btnBack;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initListener();
    }

    private void navigateToFirstFragment() {
        FirstFragment firstFragment = new FirstFragment();
        replaceFragment(firstFragment);
    }

    private void updateTextSize(int textSize) {
        sizeText.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
        sizeText.setText(String.valueOf(textSize));
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragmentContainer, fragment);
        transaction.commit();
    }

    private void initView(View view) {
        sizeText = view.findViewById(R.id.size);
        btnBack = view.findViewById(R.id.btn_back);

        Bundle bundle = getArguments();
        if (bundle != null) {
            int textSize = bundle.getInt("textSize", 36);
            updateTextSize(textSize);
        }
    }

    private void initListener() {
        btnBack.setOnClickListener(v -> navigateToFirstFragment());
    }
}

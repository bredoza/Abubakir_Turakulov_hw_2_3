package com.example.abubakir_turakulov_hw_2_3;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class FirstFragment extends Fragment {

    private TextView helloTextView;
    private Button plusButton;
    private Button minusButton;
    private Button nextButton;
    private int textSize = 36;
    private View rootView;

    private static final String TEXT_SIZE_KEY = "textSize";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_first, container, false);
        helloTextView = rootView.findViewById(R.id.hello);
        helloTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
        plusButton = rootView.findViewById(R.id.btn_plus);
        minusButton = rootView.findViewById(R.id.btn_minus);
        nextButton = rootView.findViewById(R.id.btn_next);
        initListeners();
        return rootView;
    }

    private void initListeners() {
        plusButton.setOnClickListener(v -> updateTextSize(textSize + 1));
        minusButton.setOnClickListener(v -> updateTextSize(textSize - 1));
        nextButton.setOnClickListener(v -> navigateToNextFragment());
    }

    private void updateTextSize(int newSize) {
        textSize = newSize;
        helloTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, newSize);
    }

    private void navigateToNextFragment() {
        Bundle bundle = new Bundle();
        bundle.putInt(TEXT_SIZE_KEY, textSize);

        SecondFragment textSizeFragment = new SecondFragment();
        textSizeFragment.setArguments(bundle);

        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainer, textSizeFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}

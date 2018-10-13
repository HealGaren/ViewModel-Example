package com.hyangdam.myapplication;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ThirdFragment extends Fragment {

    TextView textTest;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_third, container, false);

        textTest = view.findViewById(R.id.textTest);

        return view;
    }

    int getTextColorByCount(int count) {

        switch (count) {
            case 1:
            case 2:
            case 3:
                return Color.RED;
            case 4:
            case 5:
            case 6:
                return Color.GREEN;
            case 7:
            case 8:
            case 9:
                return Color.BLUE;
            default:
                return Color.BLACK;
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        final MainViewModel viewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);
        viewModel.countValue.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                textTest.setTextColor(getTextColorByCount(integer));
            }
        });
    }
}

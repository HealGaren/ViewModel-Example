package com.hyangdam.myapplication;

import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    MediatorLiveData<Integer> countValue = new MediatorLiveData<>();

    public MainViewModel() {
        countValue.setValue(0);
    }

    public void increaseCount() {
        countValue.setValue(countValue.getValue() + 1);
    }

    public void decreaseCount() {
        countValue.setValue(countValue.getValue() - 1);
    }
}

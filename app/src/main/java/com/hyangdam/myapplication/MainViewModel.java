package com.hyangdam.myapplication;

import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.Nullable;

public class MainViewModel extends ViewModel {

    public MutableLiveData<Integer> countValue = new MutableLiveData<>();

    public MediatorLiveData<String> countValueString = new MediatorLiveData<>();

    public MainViewModel() {
        countValue.setValue(0);

        countValueString.addSource(countValue, new Observer<Integer>() {
                @Override
                public void onChanged(@Nullable Integer integer) {
                    countValueString.postValue(integer.toString());
                }
        });
    }

    public void increaseCount() {
        countValue.setValue(countValue.getValue() + 1);
    }

    public void decreaseCount() {
        countValue.setValue(countValue.getValue() - 1);
    }
}

package com.ajinkyad.mvparchitecture.listing;

import android.content.Context;
import android.os.Handler;

import com.ajinkyad.mvparchitecture.R;

import java.util.Arrays;
import java.util.List;

public class ListingInteractorImplementor implements ListingInteractor {

    private OnDataFetchedListener onDataFetchedListener;
    private Context context;

    ListingInteractorImplementor(Context context, OnDataFetchedListener onDataFetchedListener) {
        this.context = context;
        this.onDataFetchedListener = onDataFetchedListener;
    }


    @Override
    public void fetchOSList() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (onDataFetchedListener != null) {
                    List<String> osList = Arrays.asList(context.getResources().getStringArray(R.array.oslist));
                    onDataFetchedListener.onSuccess(osList);
                }
            }
        }, 1500);
    }
}

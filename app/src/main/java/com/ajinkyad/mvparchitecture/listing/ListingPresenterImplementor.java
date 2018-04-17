package com.ajinkyad.mvparchitecture.listing;

import android.content.Context;
import android.os.Handler;

import java.util.List;

public class ListingPresenterImplementor implements ListingPresenter, OnDataFetchedListener {

    private ListingView listingView;
    private ListingInteractor listingInteractor;
    private Context context;

    ListingPresenterImplementor(Context context, ListingView listingView) {
        this.context=context;
        this.listingView = listingView;
        this.listingInteractor = new ListingInteractorImplementor(context,this);
    }

    @Override
    public void onFailure() {
        if (listingView != null) {

            listingView.hideLoader();
            listingView.setErrorMessage();

        }
    }

    @Override
    public void onSuccess(List<String> osList) {

        if (listingView != null) {

            listingView.hideLoader();
            listingView.renderList(osList);

        }
    }

    @Override
    public void fetchData() {

        if (listingView != null) {

            listingView.showLoader();

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    listingInteractor.fetchOSList();

                }
            }, 1500);

        }
    }
}

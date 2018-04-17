package com.ajinkyad.mvparchitecture.listing;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.ajinkyad.mvparchitecture.R;

import java.util.List;

public class ListingActivity extends AppCompatActivity implements ListingView {

    private RecyclerView recyclerViewOSList;
    private ListingPresenter listingPresenter;

    private ProgressDialog pgLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listing);

        listingPresenter = new ListingPresenterImplementor(this, this);

        recyclerViewOSList = findViewById(R.id.recyclerViewOSList);
        listingPresenter.fetchData();

    }

    @Override
    public void showLoader() {
        try {
            pgLoader = new ProgressDialog(this);
            pgLoader.setMessage("Loading...");
            pgLoader.setCancelable(false);
            pgLoader.setIndeterminate(true);
            pgLoader.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void hideLoader() {
        try {
            if (pgLoader != null && pgLoader.isShowing())
                pgLoader.dismiss();
            pgLoader = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void renderList(List<String> osList) {

        ListAdapter listAdapter = new ListAdapter(this, osList);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        recyclerViewOSList.setLayoutManager(linearLayoutManager);

        recyclerViewOSList.setAdapter(listAdapter);
    }

    @Override
    public void setErrorMessage() {

        Toast.makeText(this, "Something went Wrong !!", Toast.LENGTH_SHORT).show();
    }

}

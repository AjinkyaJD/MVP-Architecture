package com.ajinkyad.mvparchitecture.listing;

import java.util.List;

public interface ListingView {

     void showLoader();

     void hideLoader();

     void renderList(List<String> osList);

     void setErrorMessage();
}

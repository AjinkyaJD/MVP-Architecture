package com.ajinkyad.mvparchitecture.listing;

import java.util.List;

public interface OnDataFetchedListener {

    void onFailure();

    void onSuccess(List<String> osList);
}

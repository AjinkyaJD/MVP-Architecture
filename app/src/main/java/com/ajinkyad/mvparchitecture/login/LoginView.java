package com.ajinkyad.mvparchitecture.login;

public interface LoginView {

     void showLoader();

     void hideLoader();

     void setEmailEmptyError();

     void setPasswordEmptyError();

     void navigateToListingScreen();

     void setLoginErrorMessage();
}

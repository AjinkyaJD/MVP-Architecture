package com.ajinkyad.mvparchitecture.login;

import android.os.Handler;
import android.text.TextUtils;

public class LoginPresenterImplementor implements LoginPresenter, OnLoginFinishedListener {

    private LoginView loginView;
    private LoginInteractor loginInteractor;

    LoginPresenterImplementor(LoginView loginView) {
        this.loginView = loginView;
        this.loginInteractor = new LoginInteractorImplementor(this);
    }

    @Override
    public void performLogin(final String emailID, final String password) {

        if (loginView != null) {

            loginView.showLoader();

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    if (TextUtils.isEmpty(emailID)) {
                        loginView.hideLoader();
                        loginView.setEmailEmptyError();
                    } else if (TextUtils.isEmpty(password)) {
                        loginView.hideLoader();
                        loginView.setPasswordEmptyError();
                    } else {
                        loginInteractor.signInUser(emailID, password);
                    }

                }
            }, 1500);

        }
    }

    @Override
    public void onFailure() {
        if (loginView != null) {

            loginView.hideLoader();
            loginView.setLoginErrorMessage();

        }
    }

    @Override
    public void onSuccess() {

        if (loginView != null) {

            loginView.hideLoader();
            loginView.navigateToListingScreen();

        }
    }
}

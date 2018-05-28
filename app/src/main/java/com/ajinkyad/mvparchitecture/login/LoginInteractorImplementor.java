package com.ajinkyad.mvparchitecture.login;

import android.os.Handler;

public class LoginInteractorImplementor implements LoginInteractor {

    private OnLoginFinishedListener onLoginFinishedListener;

    LoginInteractorImplementor(OnLoginFinishedListener onLoginFinishedListener) {
        this.onLoginFinishedListener = onLoginFinishedListener;
    }

    LoginInteractorImplementor() {

    }

    @Override
    public void signInUser(final String username, final String password) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (onLoginFinishedListener != null) {
                    if (validCredentials(username, password)) {
                        onLoginFinishedListener.onSuccess();
                    } else {
                        onLoginFinishedListener.onFailure();
                    }
                }
            }
        }, 1500);

    }

    public boolean validCredentials(String username, String password) {

        if (username.trim().equals("test@test.com") && password.trim().equals("password")) {
            return true;
        } else {
            return false;
        }
    }


}

package com.ajinkyad.mvparchitecture.login;

import android.os.Handler;

public class LoginInteractorImplementor implements LoginInteractor {

    private OnLoginFinishedListener onLoginFinishedListener;

    LoginInteractorImplementor(OnLoginFinishedListener onLoginFinishedListener) {
        this.onLoginFinishedListener = onLoginFinishedListener;
    }

    @Override
    public void signInUser(final String username, final String password) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (onLoginFinishedListener != null) {
                    if (username.trim().equals("test@test.com") && password.trim().equals("password")) {
                        onLoginFinishedListener.onSuccess();
                    } else {
                        onLoginFinishedListener.onFailure();
                    }
                }
            }
        }, 1500);

    }
}

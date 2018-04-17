package com.ajinkyad.mvparchitecture.login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ajinkyad.mvparchitecture.R;
import com.ajinkyad.mvparchitecture.listing.ListingActivity;

public class LoginActivity extends AppCompatActivity implements LoginView {

    private Button btnLogin;
    private EditText editTextEmailID, editTextPassword;
    private LoginPresenter loginPresenter;

    private ProgressDialog pgLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginPresenter = new LoginPresenterImplementor(this);

        btnLogin = findViewById(R.id.btnLogin);
        editTextEmailID = findViewById(R.id.editTextEmailID);
        editTextPassword = findViewById(R.id.editTextPassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                loginPresenter.performLogin(editTextEmailID.getText().toString().trim(), editTextPassword.getText().toString().trim());
            }
        });

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
    public void setEmailEmptyError() {

        Toast.makeText(this, "Please enter email id", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPasswordEmptyError() {
        Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void navigateToListingScreen() {
        Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, ListingActivity.class));
    }

    @Override
    public void setLoginErrorMessage() {
        Toast.makeText(this, "Login Failure", Toast.LENGTH_SHORT).show();
    }
}

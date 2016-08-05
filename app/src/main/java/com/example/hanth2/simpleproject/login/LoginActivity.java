package com.example.hanth2.simpleproject.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hanth2.simpleproject.R;
import com.example.hanth2.simpleproject.activity.MainActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by HanTH2 on 8/5/2016.
 */
public class LoginActivity extends AppCompatActivity {
    @InjectView(R.id.username_edt)
    EditText userName;
    @InjectView(R.id.password_edt)
    EditText password;
    private LoginPresenter mPresenter;

    private LoginView mView = new LoginView() {
        @Override
        public void showErrorMessage(String message) {
            Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void showSuccessMessage() {
            Toast.makeText(LoginActivity.this, "Login success!", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void showProgressDialog() {
            // TODO
        }

        @Override
        public void dismissProgressDialog() {
            // TODO
        }
    };

    private LoginRouter mRouter = new LoginRouter() {
        @Override
        public void openMainScreen() {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.inject(this);
        // Init presenter with View and Router.
        mPresenter = new LoginPresenterImpl(mView, mRouter);
    }

    @OnClick(R.id.login_btn)
    void onClickLogin() {
        // Login
        mPresenter.onLoginButtonClick(userName.getText().toString(),
                password.getText().toString());
    }

}

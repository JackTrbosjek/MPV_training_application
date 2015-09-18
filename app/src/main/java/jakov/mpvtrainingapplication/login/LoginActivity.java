package jakov.mpvtrainingapplication.login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jakov.mpvtrainingapplication.R;
import jakov.mpvtrainingapplication.main.MainActivity;

public class LoginActivity extends AppCompatActivity implements LoginView {

    @Bind(R.id.loginUsername)
    EditText etUsername;
    @Bind(R.id.loginPassword)
    EditText etPassword;

    private ProgressDialog progressDialog;

    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        loginPresenter= new LoginPresenterImpl(this);
    }

    @OnClick(R.id.loginLogin)
    public void loginClicked(View v){
        String username=etUsername.getText().toString();
        String password=etPassword.getText().toString();
        loginPresenter.checkUserData(username,password);
    }

    @Override
    public void showProgress() {
        progressDialog= ProgressDialog.show(this,"Login","Validating data");
    }

    @Override
    public void hideProgress() {
        progressDialog.dismiss();
    }

    @Override
    public void setUsernameError() {
        Toast.makeText(this,"Username not correct!",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPasswordError() {
        Toast.makeText(this,"Password not correct!",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void navigateToHome() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    @Override
    public void showMessage(String message) {

    }
}

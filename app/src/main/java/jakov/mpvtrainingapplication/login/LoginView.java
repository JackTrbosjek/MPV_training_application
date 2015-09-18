package jakov.mpvtrainingapplication.login;

/**
 * Created by Jack on 17.9.2015..
 */
public interface LoginView {
    public void showProgress();
    public void hideProgress();
    public void setUsernameError();
    public void setPasswordError();
    public void navigateToHome();
    public void showMessage(String message);
}

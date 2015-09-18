package jakov.mpvtrainingapplication.login;

/**
 * Created by Jack on 17.9.2015..
 */
public interface OnLoginFinishListener {
    public void onSuccess();
    public void onUsernameError();
    public void onPasswordError();
}

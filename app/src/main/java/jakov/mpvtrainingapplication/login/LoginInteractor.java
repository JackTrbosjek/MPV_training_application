package jakov.mpvtrainingapplication.login;

/**
 * Created by Jack on 17.9.2015..
 */
public interface LoginInteractor {
    public void login(String username, String password, OnLoginFinishListener listener);
}

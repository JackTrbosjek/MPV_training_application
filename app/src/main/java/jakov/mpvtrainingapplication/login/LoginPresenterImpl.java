package jakov.mpvtrainingapplication.login;

/**
 * Created by Jack on 17.9.2015..
 */
public class LoginPresenterImpl implements LoginPresenter,OnLoginFinishListener {
    private LoginView loginView;
    private LoginInteractor loginInteractor;

    public LoginPresenterImpl(LoginView loginView){
        this.loginView=loginView;
        loginInteractor = new LoginInteractorImpl();
    }

    @Override
    public void checkUserData(String username, String password) {
        loginView.showProgress();
        loginInteractor.login(username,password,this);
    }

    @Override
    public void onSuccess() {
        loginView.hideProgress();
        loginView.showMessage("Login successful!");
        loginView.navigateToHome();
    }

    @Override
    public void onUsernameError() {
        loginView.hideProgress();
        loginView.setUsernameError();
    }

    @Override
    public void onPasswordError() {
        loginView.hideProgress();
        loginView.setPasswordError();
    }
}

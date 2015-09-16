package jakov.mpvtrainingapplication.main;

import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by Jack on 16.9.2015..
 */
public interface MainView {
    public void showProgress();

    public void hideProgress();

    public void addItem(String item);

    public void removeItem(String item);

    public void showMessage(String message);
}

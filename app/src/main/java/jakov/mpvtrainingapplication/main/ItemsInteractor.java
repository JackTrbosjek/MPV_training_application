package jakov.mpvtrainingapplication.main;

import java.util.List;

/**
 * Created by Jack on 16.9.2015..
 */
public interface ItemsInteractor {
    public void addItem(String item,OnItemAddFinishListener listener);

    public void removeItem(String item,OnItemRemoveFinishListener listener);

    public List<String> getList();
}

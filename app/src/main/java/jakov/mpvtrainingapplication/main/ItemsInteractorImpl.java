package jakov.mpvtrainingapplication.main;

import android.os.Handler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jack on 16.9.2015..
 */
public class ItemsInteractorImpl implements ItemsInteractor {
    private List<String> list;

    public ItemsInteractorImpl(){
        list=new ArrayList<String>();
    }

    @Override
    public void addItem(final String item,final OnItemAddFinishListener listener) {
        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                list.add(item);
                listener.onAddFinish(item);
            }
        }, 1000);
    }

    @Override
    public void removeItem(final String item,final OnItemRemoveFinishListener listener) {
        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                list.remove(item);
                listener.onRemoveFinish(item);
            }
        }, 1000);
    }

    @Override
    public List<String> getList() {
        return list;
    }
}

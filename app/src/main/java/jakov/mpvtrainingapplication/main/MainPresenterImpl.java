package jakov.mpvtrainingapplication.main;

import java.util.List;

/**
 * Created by Jack on 16.9.2015..
 */
public class MainPresenterImpl implements MainPresenter,OnItemAddFinishListener,OnItemRemoveFinishListener {

    private MainView mainView;
    private ItemsInteractor itemsInteractor;

    public MainPresenterImpl(MainView mainView){
        this.mainView=mainView;
        itemsInteractor= new ItemsInteractorImpl();
    }


    @Override
    public void onItemClicked(String item) {
        mainView.showProgress();
        itemsInteractor.removeItem(item,this);
    }

    @Override
    public void onAddItemClicked(String item) {
        mainView.showProgress();
        itemsInteractor.addItem(item,this);
    }

    @Override
    public void onAddFinish(String item) {
        mainView.hideProgress();
        mainView.addItem(item);
        mainView.showMessage("Item added: "+item);
    }

    @Override
    public void onRemoveFinish(String item) {
        mainView.hideProgress();
        mainView.removeItem(item);
        mainView.showMessage("Item removed: "+item);
    }
}

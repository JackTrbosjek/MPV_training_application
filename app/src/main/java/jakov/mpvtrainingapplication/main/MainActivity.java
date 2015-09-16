package jakov.mpvtrainingapplication.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jakov.mpvtrainingapplication.R;

public class MainActivity extends AppCompatActivity implements MainView,AdapterView.OnItemClickListener {


    @Bind(R.id.mainItemText)
    EditText etItemText;
    @Bind(R.id.mainItemsListView)
    ListView itemsListView;
    private ArrayAdapter<String> adapter;
    @Bind(R.id.mainProgressBar)
    ProgressBar progressBar;

    private MainPresenter mainPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mainPresenter= new MainPresenterImpl(this);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,new ArrayList<String>());
        itemsListView.setAdapter(adapter);
        itemsListView.setOnItemClickListener(this);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void addItem(String item) {
        adapter.add(item);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void removeItem(String item) {
        adapter.remove(item);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.mainAdd)
    public void addClicked(View v){
        String text=etItemText.getText().toString();
        mainPresenter.onAddItemClicked(text);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        mainPresenter.onItemClicked(adapter.getItem(position));
    }
}

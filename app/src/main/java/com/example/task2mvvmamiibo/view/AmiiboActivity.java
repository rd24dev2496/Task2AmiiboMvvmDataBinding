package com.example.task2mvvmamiibo.view;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.example.task2mvvmamiibo.R;
import com.example.task2mvvmamiibo.databinding.ActivityAmiiboBinding;
import com.example.task2mvvmamiibo.viewmodel.AmiiboViewModel;
import java.util.Observable;
import java.util.Observer;


public class AmiiboActivity extends AppCompatActivity implements Observer {
    private AmiiboViewModel amiiboViewModel;
    private ActivityAmiiboBinding binding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataBinding();
        setupListAmiiboView(binding.recyclerAmiibo);
        setupObserver(amiiboViewModel);
    }

    private void setupObserver(Observable observable) {
        observable.addObserver(this);
    }

    private void setupListAmiiboView(RecyclerView recyclerAmiibo) {
        AmiiboAdapter adapter = new AmiiboAdapter();
        recyclerAmiibo.setAdapter(adapter);
        recyclerAmiibo.setHasFixedSize(true);
    }
    private void initDataBinding() {
       binding = DataBindingUtil.setContentView(this, R.layout.activity_amiibo);
        amiiboViewModel=new AmiiboViewModel(this);
        binding.setMainViewModel(amiiboViewModel);
    }
    @Override
    public void update(Observable observable, Object data) {
        if (observable instanceof AmiiboViewModel) {
            AmiiboAdapter amiiboAdapter = (AmiiboAdapter) binding.recyclerAmiibo.getAdapter();
            AmiiboViewModel amiiboViewModel = (AmiiboViewModel) observable;
            if (amiiboViewModel != null) {
                amiiboAdapter.setPeopleList(amiiboViewModel.getPeopleList());
            }
        }

    }

}
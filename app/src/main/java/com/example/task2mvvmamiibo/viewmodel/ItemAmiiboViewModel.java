package com.example.task2mvvmamiibo.viewmodel;

import android.content.Context;
import android.view.View;
import androidx.databinding.BaseObservable;
import com.example.task2mvvmamiibo.model.Amiibo;

public class ItemAmiiboViewModel extends BaseObservable {
    private final Context context;
    private Amiibo amiibo;


    public ItemAmiiboViewModel(Context context ,Amiibo amiibo) {
        this.amiibo = amiibo;
        this.context=context;
    }
    public String getAmiiboSeries() {
        return amiibo.getAmiiboSeries();
    }

    public String getCharacter() {
        return amiibo.getCharacter();
    }

    public String getHead() { return amiibo.getHead();
    }

    public String getName() { return amiibo.getName();
    }
    public String getGameSeries() { return amiibo.getGameSeries();
    }

    public void onItemClick(View view) {
       // context.startActivity(AmiiboActivity.launchDetail(view.getContext(), amiibo));
    }
    public void setPeople(Amiibo amiibo) {
        this.amiibo = amiibo;
        notifyChange();
    }

}

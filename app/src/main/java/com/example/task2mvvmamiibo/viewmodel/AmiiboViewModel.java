package com.example.task2mvvmamiibo.viewmodel;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

import com.example.task2mvvmamiibo.AmiiboApplication;
import com.example.task2mvvmamiibo.data.AmiiboFactory;
import com.example.task2mvvmamiibo.data.AmiiboResponse;
import com.example.task2mvvmamiibo.data.AmiiboService;
import com.example.task2mvvmamiibo.model.Amiibo;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class AmiiboViewModel extends Observable {

    public ObservableInt amiiboRecycler;
    public ObservableField<String> messageLabel;
    private List<Amiibo> amiiboList;
    private Context context;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public AmiiboViewModel(@NonNull Context context) {

        this.context = context;
        this.amiiboList=new ArrayList<>();
        amiiboRecycler = new ObservableInt(View.GONE);
         }

    public void onClickFabLoad(View view) {
        initializeViews();
        fetchPeopleList();
    }

    private void fetchPeopleList() {
        AmiiboApplication amiiboApplication = AmiiboApplication.create(context);
        AmiiboService amiiboService = amiiboApplication.getAmiiboService();

        Disposable disposable = amiiboService.fetchamiibo(AmiiboFactory.RANDOM_USER_URL)
                .subscribeOn(amiiboApplication.subscribeScheduler())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<AmiiboResponse>() {
                    @Override
                    public void accept(AmiiboResponse amiiboResponse) {
                        changePeopleDataSet(amiiboResponse.getAmiiboList());
                        amiiboRecycler.set(View.VISIBLE);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) {
                          amiiboRecycler.set(View.GONE);
                        throwable.printStackTrace();
                    }
                });

        compositeDisposable.add(disposable);


    }

    public void initializeViews() {
        amiiboRecycler.set(View.GONE);

    }


    private void changePeopleDataSet(List<Amiibo> amiibos) {
        amiiboList.addAll(amiibos);
        setChanged();
        notifyObservers();
    }

    public List<Amiibo> getPeopleList() {
        return amiiboList;
    }

    public void reset() {
        compositeDisposable.dispose();
        compositeDisposable = null;
        context = null;
    }
    public void update(Observable observable, Object o) {

    }
}

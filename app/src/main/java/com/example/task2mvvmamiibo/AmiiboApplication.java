package com.example.task2mvvmamiibo;

import android.content.Context;
import androidx.multidex.MultiDexApplication;
import com.example.task2mvvmamiibo.data.AmiiboFactory;
import com.example.task2mvvmamiibo.data.AmiiboService;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

public class AmiiboApplication extends MultiDexApplication {

  private AmiiboService amiiboService;
  private Scheduler scheduler;

  private static com.example.task2mvvmamiibo.AmiiboApplication get(Context context) {
    return (com.example.task2mvvmamiibo.AmiiboApplication) context.getApplicationContext();
  }

  public static com.example.task2mvvmamiibo.AmiiboApplication create(Context context) {
    return com.example.task2mvvmamiibo.AmiiboApplication.get(context);
  }

  public AmiiboService getAmiiboService() {
    if (amiiboService == null) {
      amiiboService = AmiiboFactory.create();
    }
    return amiiboService;
  }

  public Scheduler subscribeScheduler() {
    if (scheduler == null) {
      scheduler = Schedulers.io();
    }
    return scheduler;
  }
}

package com.mostafa.ustask_mostafaibrahim.Repository.Repo.Base;

import android.content.Context;

import com.mostafa.ustask_mostafaibrahim.Application.App;
import com.mostafa.ustask_mostafaibrahim.Repository.Database.Creation.DatabaseCreator;
import com.mostafa.ustask_mostafaibrahim.Repository.Server.Client.RetrofitClient;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public abstract class BaseRepo<D> {

    protected DatabaseCreator mDb;
    protected Context context;
    protected RetrofitClient webServiceConsumer;
    protected Executor executor = Executors.newSingleThreadExecutor();

    public BaseRepo() {
        this.context = App.getAppContext();
        this.mDb = DatabaseCreator.getInstance(context);
        this.webServiceConsumer = RetrofitClient.sharedInstance;

    }


    public abstract D getDao();


    public void redefineServerUrl() {
        webServiceConsumer.redefineServerUrl();
    }
}

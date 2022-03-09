package com.mostafa.ustask_mostafaibrahim.Repository.Repo.Base;

import android.content.Context;

import com.mostafa.ustask_mostafaibrahim.Application.App;
import com.mostafa.ustask_mostafaibrahim.Repository.Database.Creation.DatabaseCreator;
import com.mostafa.ustask_mostafaibrahim.Repository.Server.Consumer.WebServiceConsumer;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public abstract class BaseDataProvider<D> {

    protected DatabaseCreator mDb;
    protected Context context;
    protected WebServiceConsumer webServiceConsumer;
    protected Executor executor = Executors.newSingleThreadExecutor();

    public BaseDataProvider() {
        this.context = App.getAppContext();
        this.mDb = DatabaseCreator.getInstance(context);
        this.webServiceConsumer = WebServiceConsumer.sharedInstance;

    }


    public abstract D getDao();


    public void redefineServerUrl() {
        webServiceConsumer.redefineServerUrl();
    }
}

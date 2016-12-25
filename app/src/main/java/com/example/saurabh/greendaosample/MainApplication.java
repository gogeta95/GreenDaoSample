package com.example.saurabh.greendaosample;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.saurabh.greendaosample.dao.DaoMaster;
import com.example.saurabh.greendaosample.dao.DaoSession;

/**
 * Created by saurabh on 26/12/16.
 */

public class MainApplication extends Application {
    private static final String DB_NAME="DAO.db";
    private static DaoSession daoSession;
    @Override
    public void onCreate() {
        super.onCreate();
        SQLiteOpenHelper helper = new DaoMaster.DevOpenHelper(this, DB_NAME, null);
        SQLiteDatabase sqLiteDatabase = helper.getWritableDatabase();
        DaoMaster daoMaster= new DaoMaster(sqLiteDatabase);
        daoSession=daoMaster.newSession();

    }

    public static DaoSession getDaoSession() {
        return daoSession;
    }
}

package com.test.totaldemp.application;

import android.app.Application;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import com.test.totaldemp.gen.DaoMaster;
import com.test.totaldemp.gen.DaoSession;

import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2018/7/4.
 */
public class MyApplication extends Application {

    private DaoMaster.DevOpenHelper mHelper;
    private SQLiteDatabase db;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;

    public static MyApplication instances;

    @Override
    public void onCreate() {
        super.onCreate();
        instances = this;
//        setDatabase();
    }

    public static MyApplication getInstances() {
        return instances;
    }

    /**
     * 设置greenDao
     */
    private void setDatabase() {
        // 通过 DaoMaster 的内部类 DevOpenHelper，你可以得到一个便利的 SQLiteOpenHelper 对象。
        // 可能你已经注意到了，你并不需要去编写「CREATE TABLE」这样的 SQL 语句，因为 greenDAO 已经帮你做了。
        // 注意：默认的 DaoMaster.DevOpenHelper 会在数据库升级时，删除所有的表，意味着这将导致数据的丢失。
        // 所以，在正式的项目中，你还应该做一层封装，来实现数据库的安全升级。
        mHelper = new DaoMaster.DevOpenHelper(this, "notes-db", null);
        db = mHelper.getWritableDatabase();
        // 注意：该数据库连接属于 DaoMaster，所以多个 Session 指的是相同的数据库连接。
        mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }

    public SQLiteDatabase getDb() {
        return db;
    }

    //重载这个方法，是用来打开SD卡上的数据库的，android 2.3及以下会调用这个方法。
    @Override
    public SQLiteDatabase openOrCreateDatabase(String name, int mode, SQLiteDatabase.CursorFactory factory) {
        SQLiteDatabase result = SQLiteDatabase.openOrCreateDatabase(getDatabasePath(name), null);
        return result;
    }

    //Android 4.0会调用此方法获取数据库。
    @Override
    public SQLiteDatabase openOrCreateDatabase(String name, int mode, SQLiteDatabase.CursorFactory factory,
                                               DatabaseErrorHandler errorHandler) {
        SQLiteDatabase result = SQLiteDatabase.openOrCreateDatabase(getDatabasePath(name), null);
        return result;
    }

    @Override
    public File getDatabasePath(String name) {
        File parentFile = new File(Environment.getExternalStorageDirectory() + File.separator +
                "smartDB" + File.separator);
        if (!parentFile.exists()) {
            boolean mkParentRes = parentFile.mkdirs();
        }

        File realDBFile = new File(parentFile, name);
        if (!realDBFile.exists()) {
            try {
                realDBFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return realDBFile;

    }
}
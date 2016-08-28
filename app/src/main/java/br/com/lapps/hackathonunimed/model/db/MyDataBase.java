package br.com.lapps.hackathonunimed.model.db;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by Orochi on 27/08/2016.
 */
@Database(name = MyDataBase.NAME, version = MyDataBase.VERSION)

public class MyDataBase {
    public static final String NAME = "MyDataBase";

    public static final int VERSION = 1;
}


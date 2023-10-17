package com.multimediaconvertor.Data;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.multimediaconvertor.Params.params;

public class myDBHandler extends SQLiteOpenHelper {
    public myDBHandler(Context context){
        super(context, params.DB_NAME,null,params.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    String create = "CREATE TABLE " + params.TABLE_NAME + " (" +params.KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +params.KEY_NAME + " TEXT, " +params.KEY_DATE + " DATE, " +params.KEY_PATH + " TEXT)";
    Log.d("dbHistory","Query is Running" + create);
    db.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
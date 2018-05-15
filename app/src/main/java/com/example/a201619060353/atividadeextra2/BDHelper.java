package com.example.a201619060353.atividadeextra2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by 201619060353 on 03/04/2018.
 */

public class BDHelper extends SQLiteOpenHelper {
    //Singleton
    private static BDHelper bdInstance = null;
    private Context bdContext;
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "empresa.db";
    private static final String TABLE_CARGO = "cargo";
    private static final String TABLE_FUNC = "funcionario";
    private static final String TABLE_CREATE_FUNC =
            "CREATE TABLE IF NOT EXISTS funcionario (" +
                    "func_id integer primary key, " +
                    "func_nome text not null, " +
                    "func_cargo integer not null," +
                    "func_salario real not null, " +
                    "foreign key(func_cargo) references cargo(cargo_id));";
    private static final String TABLE_CREATE_CARGO =
            "CREATE TABLE IF NOT EXISTS cargo (" +
                    "cargo_id integer primary key, " +
                    "cargo_nome text unique not null);";

    private SQLiteDatabase db;

    private BDHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        bdContext = context;
    }

    public static BDHelper getBDInstance(Context context){
        if (bdInstance == null)
            bdInstance = new BDHelper(context.getApplicationContext());
        return bdInstance;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLE_CREATE_CARGO);
        sqLiteDatabase.execSQL(TABLE_CREATE_FUNC);
        this.db = sqLiteDatabase;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FUNC);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CARGO);
        onCreate(db);
    }
}

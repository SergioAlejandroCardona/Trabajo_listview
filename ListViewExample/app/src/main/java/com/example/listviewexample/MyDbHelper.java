package com.example.listviewexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.listviewexample.Models.Car;

import java.util.ArrayList;

public class MyDbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    private static final String DAYABASE_NAME = "Cars.db";

    public MyDbHelper(Context context) {
        super(context, DAYABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Cars (Name TEXT PRIMARY KEY, CC TEXT, Model TEXT, Value TEXT, Url TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Cars");
        onCreate(db);
    }

    public void insertCars (SQLiteDatabase db, Car carro){

        ContentValues values = new ContentValues();
        values.put("Name", carro.getName());
        values.put("CC", carro.getCC());
        values.put("Model", carro.getModel());
        values.put("Value", carro.getValue());
        values.put("Url", carro.getUrl());

        db.insert("Cars", null, values);
    }

    public ArrayList<Car> selectCar (SQLiteDatabase db){

        ArrayList<Car> carro = new ArrayList<>();
        Cursor filas = db.rawQuery("SELECT * FROM Cars", null);
        if (filas.moveToFirst()){

            do {
                Car car = new Car(filas.getString(0), filas.getString(1), filas.getString(2),
                        filas.getString(3), filas.getString(4));
                carro.add(car);
            }while (filas.moveToNext());
        }
        return carro;
    }

    public void deleteAll() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM Cars");
    }

}

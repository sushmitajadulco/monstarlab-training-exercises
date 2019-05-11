package com.example.seatingarrangementapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.seatingarrangementapp.database.model.ReservationDB;
import com.example.seatingarrangementapp.model.User;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "reservation_db";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ReservationDB.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ReservationDB.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public long insertUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ReservationDB.COLUMN_FULL_NAME, user.getFullName());

        long id = db.insert(ReservationDB.TABLE_NAME, null, values);

        db.close();

        return id;
    }

    public ArrayList<User> getUsers(int beginId) {
        ArrayList<User> users = new ArrayList<>();
        int tableLimit = 5;

        String query = "SELECT * FROM " + ReservationDB.TABLE_NAME
                + " LIMIT " + beginId + ", "  + tableLimit;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setFullName(cursor.getString(cursor.getColumnIndex(ReservationDB.COLUMN_FULL_NAME)));

                users.add(user);
            } while (cursor.moveToNext());
        }
        db.close();

        return users;
    }

    public List<User> getAllUser() {
        List<User> users = new ArrayList<>();

        String query = "SELECT * FROM " + ReservationDB.TABLE_NAME
                + " " ;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setFullName(cursor.getString(cursor.getColumnIndex(ReservationDB.COLUMN_FULL_NAME)));

                users.add(user);
            } while (cursor.moveToNext());
        }
        db.close();

        return users;
    }

    public void deleteAllUsers() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(ReservationDB.TABLE_NAME, null, null);
        db.close();
    }
}

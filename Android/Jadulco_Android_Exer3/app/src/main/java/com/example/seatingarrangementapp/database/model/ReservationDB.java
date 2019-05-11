package com.example.seatingarrangementapp.database.model;

public class ReservationDB {

    public static final String TABLE_NAME = "reservation";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_FULL_NAME = "fullName";

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_FULL_NAME + " TEXT"
                    + ")";


    private String fullName;
    private int id;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ReservationDB(int id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

}

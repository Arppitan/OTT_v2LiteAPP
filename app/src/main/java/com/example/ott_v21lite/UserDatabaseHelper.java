package com.example.ott_v21lite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UserDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "UserDB";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "Users";
    // Define column names
    private static final String COLUMN_USERNAME = "Username";
    private static final String COLUMN_PASSWORD = "Password";
    private static final String COLUMN_DOB = "DOB";
    private static final String COLUMN_EMAIL = "Email";
    private static final String COLUMN_PHONE_NUMBER = "PhoneNumber";

    // Constructor
    public UserDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Create table query
    private static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_USERNAME + " TEXT PRIMARY KEY," +
                    COLUMN_PASSWORD + " TEXT," +
                    COLUMN_DOB + " TEXT," +
                    COLUMN_EMAIL + " TEXT," +
                    COLUMN_PHONE_NUMBER + " TEXT)";

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create the table
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed and create fresh
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // Method to insert user data into the database
    public boolean insertUserData(String username, String password, String dob, String email, String phoneNumber) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_USERNAME, username);
        contentValues.put(COLUMN_PASSWORD, password);
        contentValues.put(COLUMN_DOB, dob);
        contentValues.put(COLUMN_EMAIL, email);
        contentValues.put(COLUMN_PHONE_NUMBER, phoneNumber);
        long result = db.insert(TABLE_NAME, null, contentValues);
        return result != -1; // Returns true if data is inserted successfully
    }
        public android.database.Cursor getUserByUsernameAndPassword(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {COLUMN_USERNAME};
        String selection = COLUMN_USERNAME + " = ?" + " AND " + COLUMN_PASSWORD + " = ?";
        String[] selectionArgs = {username, password};
        Cursor cursor = db.query(TABLE_NAME, columns, selection, selectionArgs, null, null, null);
        return cursor;
    }

}

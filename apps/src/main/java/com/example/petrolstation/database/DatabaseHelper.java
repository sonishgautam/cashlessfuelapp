package com.example.petrolstation.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.petrolstation.Payment;

import java.util.ArrayList;
import java.util.List;


public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "paymentsManager";
    private static final String TABLE_paymentS = "payments";
    private static final String KEY_ID = "id";
    private static final String KEY_QUANTITY = "quantity";
    private static final String KEY_FUEL_TYPE = "FuelType";
    private static final String KEY_TOTAL_PRICE = "TotalPrice";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //3rd argument to be passed is CursorFactory instance
    }

    public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_paymentS);
        String CREATE_paymentS_TABLE = "CREATE TABLE " + TABLE_paymentS + "("+ KEY_ID + " INTEGER PRIMARY KEY," + KEY_QUANTITY + " TEXT," + KEY_FUEL_TYPE + " TEXT," + KEY_TOTAL_PRICE + " TEXT" +  ")";

        db.execSQL(CREATE_paymentS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_paymentS);

        // Create tables again
        onCreate(db);
    }

    // code to add the new Payment
    public void addPayment(Payment payment) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_QUANTITY, payment.getFuelQuantity());
        values.put(KEY_FUEL_TYPE, payment.getFuelType());
        values.put(KEY_TOTAL_PRICE, payment.getTotalPrice());

        // Inserting Row
        db.insert(TABLE_paymentS, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    // code to get the single payment
    Payment getpayment(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_paymentS, new String[] { KEY_ID,
                        KEY_QUANTITY, KEY_FUEL_TYPE,KEY_TOTAL_PRICE }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Payment payment = new Payment(Integer.parseInt(cursor.getString(0)),cursor.getString(1), cursor.getString(2),cursor.getString(3));
        // return payment
        return payment;
    }

    // code to get all payments in a list view
    public List<Payment> getAllpayments() {
        List<Payment> paymentList = new ArrayList<Payment>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_paymentS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Payment payment = new Payment();
                payment.setID(Integer.parseInt(cursor.getString(0)));
                payment.setFuelQuantity(cursor.getString(1));
                payment.setFuelType(cursor.getString(2));
                payment.setTotalPrice(cursor.getString(3));
                // Adding payment to list
                paymentList.add(payment);
            } while (cursor.moveToNext());
        }

        // return payment list
        return paymentList;
    }

    // code to update the single payment
    public int updatepayment(Payment payment) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_QUANTITY, payment.getFuelQuantity());
        values.put(KEY_FUEL_TYPE, payment.getFuelType());
        values.put(KEY_TOTAL_PRICE, payment.getTotalPrice());

        // updating row
        return db.update(TABLE_paymentS, values, KEY_ID + " = ?",
                new String[] { String.valueOf(payment.getID()) });
    }

    // Deleting single payment
    public void deletepayment(Payment payment) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_paymentS, KEY_ID + " = ?",
                new String[] { String.valueOf(payment.getID()) });
        db.close();
    }

    // Getting payments Count
    public int getpaymentsCount() {
        String countQuery = "SELECT  * FROM " + TABLE_paymentS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }

}
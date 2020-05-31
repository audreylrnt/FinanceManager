package com.example.financemanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.Date;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "FinanceManager";
    public static final int DB_VERSION = 1;

    public static final String TABLE_TRANSACTION = "BankTransaction";

    public static final String TRX_ID = "TransactionID";
    public static final String TRX_TYPE = "TransactionType";
    public static final String TRX_WALLET = "TransactionWallet";
    public static final String TRX_NOTES = "TransactionNotes";
    public static final String TRX_DATE = "TransactionDate";
    public static final String TRX_AMOUNT = "TransactionAmount";


    public static final String createTable = "CREATE TABLE " + TABLE_TRANSACTION + " ( " +
            TRX_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            TRX_TYPE + " TEXT, " +
            TRX_NOTES + " TEXT, " +
            TRX_DATE + " TEXT, " +
            TRX_AMOUNT + " DOUBLE );";


    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TRANSACTION);
        onCreate(db);
    }

    public boolean insertToTable(Transaction trx){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(TRX_TYPE, trx.getType());
        cv.put(TRX_NOTES, trx.getNotes());
        cv.put(TRX_WALLET, trx.getWallet());
        cv.put(TRX_DATE, trx.getDate());
        cv.put(TRX_AMOUNT, trx.getAmount());
        long res = db.insert(TABLE_TRANSACTION, null, cv);
        if(res == -1){
            return false;
        }
        else {
            return true;
        }
    }
}

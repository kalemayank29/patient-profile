package io.blinktech.patientprofile;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by mayank on 7/5/15.
 */
public class DBOpenHelper extends SQLiteOpenHelper{

    //Constants for db name and version
    private static final String DATABASE_NAME = "wall.db";
    private static final int DATABASE_VERSION = 1;

    //Constants for identifying table and columns
    public static final String TABLE_PROFILE = "profile";
    public static final String PATIENT_ID = "patient_id";
    public static final String PROFILE_ID = "_id";
    public static final String FAMILY_ID = "family_id";
    public static final String NAME = "name";
    public static final String AGE = "age";
    public static final String BLOOD = "blood";
    public static final String PREVIOUS = "previous";
    public static final String C_DISEASE = "c_disease";
    public static final String G_DISEASE = "g_disease";
    public static final String ALCOHOL = "alcohol";
    public static final String TOBACCO = "tobacco";
    public static final String DRUGS = "drugs";
    public static final String HOUSE_ID = "house_id";
    public static final String PHONE = "phone";
    public static final String NOTES = "notes";

    //SQL to create table
    private static final String PROFILE_CREATE =
            "CREATE TABLE " + TABLE_PROFILE + " (" +
                    PROFILE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    PATIENT_ID + " INTEGER NOT NULL, " +
                    FAMILY_ID + " INTEGER NOT NULL, " +
                    NAME + " TEXT NOT NULL," +
                    AGE + " INTEGER NOT NULL, " +
                    BLOOD + " TEXT NOT NULL," +
                    PREVIOUS + " TEXT default CURRENT_TIMESTAMP, " +
                    C_DISEASE + " TEXT, " +
                    G_DISEASE + " TEXT, " +
                    ALCOHOL + " TEXT, " +
                    TOBACCO + " TEXT, " +
                    DRUGS + " TEXT, " +
                    HOUSE_ID + " INTEGER NOT NULL, " +
                    PHONE + " INTEGER NOT NULL, " +
                    NOTES + " TEXT " +
                    ")";


    public DBOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(PROFILE_CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_PROFILE);
        onCreate(sqLiteDatabase);
    }
}

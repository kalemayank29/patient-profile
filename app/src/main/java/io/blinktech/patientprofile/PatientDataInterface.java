package io.blinktech.patientprofile;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.sql.SQLException;

/**
 * Created by mayank on 7/5/15.
 */
public class PatientDataInterface {
    private SQLiteDatabase database;
    private DBOpenHelper dbHelper;
    public long result;

    public PatientDataInterface(Context context){
        dbHelper = new DBOpenHelper(context);
    }

    public void open() throws SQLException {

        database = dbHelper.getWritableDatabase();

    }

    public void openRead() throws SQLException {

        database = dbHelper.getReadableDatabase();

    }

    public void close() throws SQLException {
        dbHelper.close();
    }

    public long createPatient(Patient element) throws SQLException {

        this.open();

        ContentValues value = new ContentValues();
        value.put(dbHelper.PATIENT_ID, element.getPatientId());
        value.put(dbHelper.FAMILY_ID, element.getFamilyId());
        value.put(dbHelper.HOUSE_ID, element.getHouseId());
        value.put(dbHelper.NAME, element.getName());
        value.put(dbHelper.AGE, element.getAge());
        value.put(dbHelper.BLOOD, element.getBloodGroup());
        value.put(dbHelper.PREVIOUS, element.getPreviousDate());
        value.put(dbHelper.C_DISEASE, element.getChronicDisease());
        value.put(dbHelper.G_DISEASE, element.getGeneticDisease());
        value.put(dbHelper.PHONE, element.getPhone());
        value.put(dbHelper.ALCOHOL, element.getAlcohol());
        value.put(dbHelper.TOBACCO, element.getTobacco());
        value.put(dbHelper.DRUGS, element.getDrugs());
        value.put(dbHelper.NOTES, element.getNotes());

        long newRowId;
        newRowId = this.database.insert(dbHelper.TABLE_PROFILE, null, value);

        this.close();

        return newRowId;
    }

    public Patient getPatient(int id) throws SQLException{
        this.openRead();

        Patient element = new Patient();

        String selection = "patient_id=?";
        String[] selectionArgs = new String[] { String.valueOf(id)};
        Cursor c = database.query(DBOpenHelper.TABLE_PROFILE,null,selection,selectionArgs,null,null,null);
        c.moveToFirst();
        element.setName(c.getString(c.getColumnIndexOrThrow(DBOpenHelper.NAME)));
        element.setPatientId(id);
        element.setFamilyId(c.getInt(c.getColumnIndexOrThrow(DBOpenHelper.FAMILY_ID)));
        element.setHouseId(c.getInt(c.getColumnIndexOrThrow(DBOpenHelper.HOUSE_ID)));
        element.setAge(c.getInt(c.getColumnIndexOrThrow(DBOpenHelper.AGE)));
        element.setPhone(c.getInt(c.getColumnIndexOrThrow(DBOpenHelper.PHONE)));
        element.setBloodGroup(c.getString(c.getColumnIndexOrThrow(DBOpenHelper.BLOOD)));
        element.setPreviousDate(c.getString(c.getColumnIndexOrThrow(DBOpenHelper.PREVIOUS)));
        element.setChronicDisease(c.getString(c.getColumnIndexOrThrow(DBOpenHelper.C_DISEASE)));
        element.setGeneticDisease(c.getString(c.getColumnIndexOrThrow(DBOpenHelper.G_DISEASE)));
        element.setAlcohol(c.getString(c.getColumnIndexOrThrow(DBOpenHelper.ALCOHOL)));
        element.setTobacco(c.getString(c.getColumnIndexOrThrow(DBOpenHelper.TOBACCO)));
        element.setDrugs(c.getString(c.getColumnIndexOrThrow(DBOpenHelper.DRUGS)));
        element.setNotes(c.getString(c.getColumnIndexOrThrow(DBOpenHelper.NOTES)));

        this.close();

        return element;

    }

}

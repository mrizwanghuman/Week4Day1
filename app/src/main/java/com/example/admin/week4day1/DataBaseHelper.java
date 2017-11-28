package com.example.admin.week4day1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.admin.week4day1.modal.Contact;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by  Admin on 11/27/2017.
 */

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="PersonContact";

    public static final int VERSION=1;

    public static final String TABLE_NAME ="Contact";
    public static final String COLUMN_FIRSTNAME ="FirstName";
    public static final String COLUMN_LASTNAME ="LastName";
    public static final String COLUMN_ID ="ID";
    public static final String COLUMN_MOMILENO ="MobileNo";
    public static final String COLUMN_HOMENO="HomeNo";
    private SQLiteDatabase db;


    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("+ COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT ," +
                COLUMN_FIRSTNAME+ " TEXT," + COLUMN_LASTNAME+ " TEXT,"+ COLUMN_MOMILENO +" TEXT,"+COLUMN_HOMENO+" TEXT"+")";
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public  long SaveContacts(Contact contacts){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
//        contentValues.put(COLUMN_ID, contacts.getId());
        contentValues.put(COLUMN_FIRSTNAME, contacts.getFirstName());
        contentValues.put(COLUMN_LASTNAME, contacts.getLastName());
        contentValues.put(COLUMN_MOMILENO, contacts.getMobileNumber());
        contentValues.put(COLUMN_HOMENO, contacts.getHomeNumber());
        long row = db.insert(TABLE_NAME, null,contentValues);
        return row;

    }
    public List<Contact> getContacts(){
        List<Contact> contactList = new ArrayList<>();
SQLiteDatabase db = this.getWritableDatabase();
String selectCont = "SELECT * FROM " +TABLE_NAME+ "";

        Cursor cursor = db.rawQuery(selectCont,null);
        if(cursor.moveToFirst()){
            do {
                Contact contact = new Contact(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));
                contactList.add(contact);
            }while (cursor.moveToNext());
        }

return  contactList;
    }

    public void deleteRow(int id){
        SQLiteDatabase db = this.getWritableDatabase();

        String deleteit = "DELETE FROM "+ TABLE_NAME + " WHERE ID="+id;
        db.execSQL(deleteit);
    }
    public void updateRecord(Contact contact){
        ContentValues editContentValues = new ContentValues();
        editContentValues.put(COLUMN_FIRSTNAME, contact.getFirstName());
        editContentValues.put(COLUMN_LASTNAME,contact.getLastName());
        editContentValues.put(COLUMN_MOMILENO, contact.getMobileNumber());
        editContentValues.put(COLUMN_HOMENO, contact.getHomeNumber());
//       String updateRec = "UPDATE " +TABLE_NAME +" SET "+ COLUMN_FIRSTNAME = fname + " WHERE ID=" + id;
//       db.execSQL(updateRec);
        db.update(TABLE_NAME, editContentValues,COLUMN_ID+ "=?", new String[]{String.valueOf(contact.getId())});
       // db.update(TABLE_NAME, editContentValues,"FirstName=? AND LastName=? AND MobileNo=? AND HomeNo=? AND ID="+id, new String[]{fname, lname,mobileN, homeN});
    }
}

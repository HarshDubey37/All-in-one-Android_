package com.jtp.hcontactlist.StudentManagementPortal.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;
import android.annotation.SuppressLint;
import android.widget.Toast;

import com.jtp.hcontactlist.classlist.Students;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("Range")
public class Dbmanager extends SQLiteOpenHelper {
    private static final String TABLE_STUDENT="std_table";
    private static final String KEY_NAME="sname";
    private static final String KEY_EMAIL="semail";
    private static final String KEY_ID="id";
    private static final String KEY_COURSE1="scourse1";
    private static final String KEY_COURSE2="scourse2";
    private static final String KEY_GENDER="sgender";
    private static final String KEY_MOBILE="smob";

    String CREATE_TABLE_STUDENT="CREATE TABLE " + TABLE_STUDENT + "("
            + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT,"
            + KEY_MOBILE + " TEXT,"
            + KEY_EMAIL + " TEXT,"
            + KEY_GENDER + " TEXT,"
            + KEY_COURSE1 + " TEXT,"
            + KEY_COURSE2 + " TEXT" + ")";

    Context context;

    public Dbmanager(@Nullable Context context){
        super(context,"harsh_database",null,1);
        this.context=context;
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL(CREATE_TABLE_STUDENT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENT);
            onCreate(sqLiteDatabase);
    }

    //now perform crud operation

    public long saveStudent(Students std){
        Log.d("DbManager","Going to insert data in table");
        SQLiteDatabase db=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(KEY_COURSE1,std.getScourse1());
        values.put(KEY_COURSE2,std.getScourse2());
        values.put(KEY_EMAIL,std.getSemail());
        values.put(KEY_GENDER,std.getSgender());
        values.put(KEY_MOBILE,std.getSmob());
        values.put(KEY_NAME,std.getSname());
        long id=db.insert(TABLE_STUDENT,null,values);
        Log.d("DbManager","Inserted student 1 in database "+id);

        return id;
    }

    @SuppressLint("Range")
    public List<Students> getAllStudent(){
     List<Students> stdl=new ArrayList<>();
    SQLiteDatabase db=getReadableDatabase();
    Cursor cursor=db.rawQuery("SELECT * FROM " + TABLE_STUDENT,null);
        Log.d("DbManager","get student 1 in database ");


        if(cursor.moveToFirst()){
        do{
            Students students=new Students();
            students.setSgender(cursor.getString(cursor.getColumnIndex(KEY_GENDER)));
            students.setScourse2(cursor.getString(cursor.getColumnIndex(KEY_COURSE2)));
            students.setScourse1(cursor.getString(cursor.getColumnIndex(KEY_COURSE1)));
            students.setSmob(cursor.getString(cursor.getColumnIndex(KEY_MOBILE)));
            students.setSname(cursor.getString(cursor.getColumnIndex(KEY_NAME)));
            students.setSemail(cursor.getString(cursor.getColumnIndex(KEY_EMAIL)));
            students.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(KEY_ID))));
            stdl.add(students);
        }while (cursor.moveToNext());

    }

    return stdl;
    }

    public int deleteStudent(int id){
        SQLiteDatabase sq=getWritableDatabase();

        int r=sq.delete(TABLE_STUDENT,KEY_ID + " = ?", new String[]{ String.valueOf(id)});
        Toast.makeText(context, "Deleted!!", Toast.LENGTH_SHORT).show();
        sq.close();
        return r;
    }
    public void updateStudent(Students s,int id){
        SQLiteDatabase sq=getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(KEY_NAME,s.getSname());
        cv.put(KEY_MOBILE,s.getSmob());
        cv.put(KEY_GENDER,s.getSgender());
        cv.put(KEY_EMAIL,s.getSemail());
        cv.put(KEY_COURSE1,s.getScourse1());
        cv.put(KEY_COURSE2,s.getScourse2());
        Log.d("checkupda dbman","dmadd id = "+s.getId());

        sq.update(TABLE_STUDENT,cv,KEY_ID + " LIKE ? ",new String[]{String.valueOf(id)});
        sq.close();
    }
    //Function to Delete all data from database
    public void deleteall(){
        SQLiteDatabase s=getWritableDatabase();
        s.execSQL("Delete from "+TABLE_STUDENT);
    }
}

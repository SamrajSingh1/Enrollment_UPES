package com.example.enrollmentupes1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.*;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataEntry extends SQLiteOpenHelper {
    public static final String dbname="enrollment.db";
    public static final String stable="tb";
    public DataEntry(@Nullable Context context) {
        super(context, dbname,null, 1);
       // SQLiteDatabase db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+stable+" ( id String Primary key not null,firstname text,lastname text,course text,gender text,password text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(" drop table  if exists "+stable);
        onCreate(db);
    }
    public boolean insertData(String s,String fname,String lname,String scourse,String gender,String password ){
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues cv=new ContentValues();
        cv.put("id",s);
        cv.put("firstname",fname);
        cv.put("lastname",lname);
        cv.put("course",scourse);
        cv.put("gender",gender);
        cv.put("password",password);
        long result= db.insert(stable,null,cv);
        if(result==-1)
            return false;
        else
            return true;
    }
    public boolean Authentication(String username ,String pass ){
        String []columns={"id"};
        SQLiteDatabase db=this.getWritableDatabase();
        String selection="id = ? and password = ?";
        String[] selectionArgs={username,pass} ;
        Cursor c=db.query(stable,columns,selection,selectionArgs,null,null,null);
        int count=c.getCount();
        c.close();
        close();
        if(count>0)
            return true;
        else
            return false;
    }
    public Cursor viewDataAll(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select id,firstname,lastname,course,gender from  "+stable,null);
        return res;
    }
    public Cursor viewData(String id){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select  id,firstname,lastname,course,gender from  "+stable+" where id= ?",new String[]{id});
        return res;
    }

    public boolean update1(String id,String fname ,String lname,String scourse,String gender,String password ){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("id",id);
        cv.put("firstname",fname);
        cv.put("lastname",lname);
        cv.put("course",scourse);
        cv.put("gender",gender);
        cv.put("password",password);
        db.update(stable , cv,"id=?",new String[] {id});
        return true;
    }

    public Integer delete1(String id){
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(stable,"id=?",new String[]{id});

    }


}

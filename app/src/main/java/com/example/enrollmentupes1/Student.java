package com.example.enrollmentupes1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;

public class Student extends AppCompatActivity {
    DataEntry x;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        x=new DataEntry(this);
    }
    public void viewData1(View view){
        Intent i=new Intent(this,Onestudent.class);
        startActivity(i);
    }
    public void viewDataAall(View view){
        DataEntry d=new DataEntry(this);
        Cursor res=d.viewDataAll();
        if(res.getCount()==0){
            //show message
            showMessage("Error","Nothing Found");
            return;
        }

        StringBuffer bf=new StringBuffer();
        while(res.moveToNext()){
            bf.append("Id : "+res.getString(0)+" \n" );
            bf.append("FIRST NAME : "+res.getString(1)+" \n" );
            bf.append("LAST NAME : "+res.getString(2)+" \n" );
            bf.append("COURSE : "+res.getString(3)+" \n" );
            bf.append("GENDER : "+res.getString(4)+" \n\n" );

        }
        showMessage("Data ",bf.toString());
    }

    public void showMessage(String title,String message){
        AlertDialog.Builder b=new AlertDialog.Builder(this);
        b.setTitle(title);
        b.setCancelable(true);
        b.setMessage(message);
        b.show();
    }
    public void update(View view){
        Intent i=new Intent(this,Update.class);
        startActivity(i);
    }
    public void delete(View view){
        Intent i=new Intent(this,Delete.class);
        startActivity(i);
    }
}

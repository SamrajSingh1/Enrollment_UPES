package com.example.enrollmentupes1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class Onestudent extends AppCompatActivity {
  EditText e1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onestudent);
        e1=(EditText)findViewById(R.id.editTextz6);
    }
    public void getDetail2(View v){
        DataEntry x=new DataEntry(this);
        Cursor res=x.viewData(e1.getText().toString());
        if(res.getCount()==0){
            //show message
            showMessage("Error","SAP Id doesn't Exist");
            return;
        }

        StringBuffer bf=new StringBuffer();
        while(res.moveToNext()){
            bf.append("Id : "+res.getString(0)+" \n" );
            bf.append("FIRST NAME : "+res.getString(1)+" \n" );
            bf.append("LAST NAME : "+res.getString(2)+" \n" );
            bf.append("COURSE : "+res.getString(3)+" \n" );
            bf.append("GENDER : "+res.getString(4)+" \n" );

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

}


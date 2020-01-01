package com.example.enrollmentupes1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Delete extends AppCompatActivity {
EditText e1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        e1=(EditText)findViewById(R.id.editText);
    }
    public void delete21(View v){
        DataEntry d=new DataEntry(this);
        Integer i= d.delete1(e1.getText().toString());
        e1.setText("");
        if(i>0)
            Toast.makeText(this,"Successfully Deleted",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this,"Failed",Toast.LENGTH_LONG).show();
    }
}

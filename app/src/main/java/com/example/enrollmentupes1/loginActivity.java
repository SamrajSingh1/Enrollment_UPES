package com.example.enrollmentupes1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity {
    EditText e1,e2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        e1=(EditText)findViewById(R.id.edit3);
        e2=(EditText)findViewById(R.id.edit4);
    }
    public void onclick(View view){
        DataEntry d=new DataEntry(this);
       if(d.Authentication(e1.getText().toString(),e2.getText().toString())) {
            Intent i = new Intent(this, Student.class);
            startActivity(i);
        }
        else
           Toast.makeText(this,"User doesn't exists",Toast.LENGTH_LONG).show();
    }
}

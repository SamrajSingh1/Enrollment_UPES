package com.example.enrollmentupes1;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
   public void register(View v){
       Intent i=new Intent(this,Register.class);
       startActivity(i);
   }
    public void exist(View v){
        Intent i=new Intent(this,loginActivity.class);
        startActivity(i);
    }
}

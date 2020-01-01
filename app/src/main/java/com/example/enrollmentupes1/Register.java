package com.example.enrollmentupes1;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;
import android.os.Bundle;
import android.widget.EditText;

public class Register extends AppCompatActivity {
    DataEntry myd;
    EditText e1,e2,e3,e4,e5,e6,e7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        myd=new DataEntry(this);
        e1=(EditText)findViewById(R.id.editText);
        e2=(EditText)findViewById(R.id.editText2);
        e3=(EditText)findViewById(R.id.editText3);
        e4=(EditText)findViewById(R.id.editText4);
        e5=(EditText)findViewById(R.id.editText5);
        e6=(EditText)findViewById(R.id.editText6);
        e7=(EditText)findViewById(R.id.editText7);

    }

    public void insert(View view){
        if(e1.getText().toString().length()==0){
            Toast.makeText(this , " SAP Id can't be Null",Toast.LENGTH_LONG).show();
            return ;
        }
        if(!(e6.getText().toString().equals(e7.getText().toString()))){
            Toast.makeText(this , " Password and Confirm Password should be same",Toast.LENGTH_LONG).show();
            return ;
        }

        boolean p=myd.insertData(e1.getText().toString(),e2.getText().toString(),e3.getText().toString(),e4.getText().toString(),e5.getText().toString(),e6.getText().toString());
        if(p==true)
            Toast.makeText(this,"Successfully Inserted",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this,"Failed",Toast.LENGTH_LONG).show();
        e1.setText("");
        e2.setText("");
        e3.setText("");
        e4.setText("");
        e5.setText("");
        e6.setText("");
        e7.setText("");
    }

}

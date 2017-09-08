package com.example.riyaz.sharedpref;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ed1, ed2, ed3;
    Button b1, b2;

    public static final String MyPREFERENCES = "MyPrefs";
    public static final String Name = "nameKey";
    public static final String Phone = "phoneKey";
    public static final String Email = "emailKey";

    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = (EditText) findViewById(R.id.editText);
        ed2 = (EditText) findViewById(R.id.editText2);
        ed3 = (EditText) findViewById(R.id.editText3);


        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button1);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, 0);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String n  = ed1.getText().toString();
                String ph = ed2.getText().toString();
                String e  = ed3.getText().toString();
                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.putString(Name, n);
                editor.putString(Phone, ph);
                editor.putString(Email, e);
                editor.commit();
                Toast.makeText(MainActivity.this, "Thanks", Toast.LENGTH_LONG).show();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//
//                SharedPreferences sharedPref = getApplicationContext().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
                ed1.setText(sharedpreferences.getString (Name,""));
                ed2.setText(sharedpreferences.getString(Phone, ""));
                ed3.setText(sharedpreferences.getString(Email, ""));

            }
        });
    }


}

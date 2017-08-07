package com.example.sid.sharedpref122;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName ,etAge,etCity,etPhone;
    Button  btnSave,btnShow;

    public static final String mMyPreference = "MyPref";
    public static final String mNameKey = "nameKey";
    public static final String mAgeKey = "ageKey";
    public static final String mPhoneKey = "phoneKey";
    public static final String mCityKey = "cityKey";

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText) findViewById(R.id.etEnterName);
        etAge = (EditText) findViewById(R.id.etEnterAge);
        etPhone = (EditText) findViewById(R.id.etEnterPhone);
        etCity = (EditText) findViewById(R.id.etEnterCity);

        btnSave = (Button) findViewById(R.id.btnSave);
        btnShow = (Button) findViewById(R.id.btnShow);

        final SharedPreferences sharedPreferences = getSharedPreferences(mMyPreference, Context.MODE_PRIVATE);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mName = etName.getText().toString();
                String mAge = etAge.getText().toString();
                String mCity = etCity.getText().toString();
                String mPhone  = etPhone.getText().toString();

                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString(mNameKey,mName);
                editor.putString(mAgeKey,mAge);
                editor.putString(mPhoneKey,mPhone);
                editor.putString(mCityKey,mCity);

                editor.commit();
                Toast.makeText(MainActivity.this,"Data is SAVED..!!",Toast.LENGTH_LONG).show();
            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,DataShow.class);
                startActivity(intent);

            }
        });
    }
}

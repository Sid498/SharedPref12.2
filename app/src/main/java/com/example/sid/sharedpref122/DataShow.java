package com.example.sid.sharedpref122;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.sid.sharedpref122.MainActivity.mAgeKey;
import static com.example.sid.sharedpref122.MainActivity.mCityKey;
import static com.example.sid.sharedpref122.MainActivity.mMyPreference;
import static com.example.sid.sharedpref122.MainActivity.mNameKey;
import static com.example.sid.sharedpref122.MainActivity.mPhoneKey;

public class DataShow extends AppCompatActivity {
    EditText etName ,etAge,etCity,etPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_show);

        SharedPreferences sharedPreferences = getSharedPreferences(mMyPreference,MODE_PRIVATE);



        etName = (EditText) findViewById(R.id.etEnterName1);
        etAge = (EditText) findViewById(R.id.etEnterAge1);
        etPhone = (EditText) findViewById(R.id.etEnterPhone1);
        etCity = (EditText) findViewById(R.id.etEnterCity1);

        String name = sharedPreferences.getString(mNameKey,"");
        String age = sharedPreferences.getString(mAgeKey,"");
        String phone = sharedPreferences.getString(mPhoneKey,"");
        String city = sharedPreferences.getString(mCityKey,"");

        etName.setText(name);
        etAge.setText(age);
        etPhone.setText(phone);
        etCity.setText(city);

        Toast.makeText(this," Name :"+etName.getText().toString()+"\n"+
                " Age :"+etAge.getText().toString()+"\n"+
                " Phone :"+etPhone.getText().toString()+"\n"+
                " City :"+etCity.getText().toString(),
                Toast.LENGTH_SHORT).show();
    }
}

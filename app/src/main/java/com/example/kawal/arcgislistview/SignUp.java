package com.example.kawal.arcgislistview;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity implements View.OnClickListener {

    EditText eTxtName, eTxtEmail, eTxtPhone, eTxtPassword, eTxtcnformPwd;
    Button btnSignUp;
    User user;
ContentResolver resolver;
    void initViews(){
        eTxtName = (EditText)findViewById(R.id.editName);
        eTxtEmail = (EditText)findViewById(R.id.editEmail);
        eTxtPhone = (EditText)findViewById(R.id.editPhone);
        eTxtPassword = (EditText)findViewById(R.id.editPassword);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        initViews();
        resolver = getContentResolver();

        user = new User();
        btnSignUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
if (view.getId() ==R.id.btnSignUp){
    user.setName(eTxtName.getText().toString().trim());
    user.setEmail(eTxtEmail.getText().toString().trim());
    user.setPhone(eTxtPhone.getText().toString().trim());
    user.setPassword(eTxtPassword.getText().toString().trim());
    insertUser();

}

    }

    void insertUser(){
        ContentValues values = new ContentValues();
        values.put(Util.NAME,user.getName());
        values.put(Util.PHONE,user.getPhone());
        values.put(Util.EMAIL,user.getEmail());
        values.put(Util.PASSWORD,user.getPassword());
       Uri uri =  resolver.insert(Util.User_URI,values);
        Toast.makeText(this,user.getName()+ " registered successfully with id "+uri.getLastPathSegment(), Toast.LENGTH_SHORT).show();
    }
}

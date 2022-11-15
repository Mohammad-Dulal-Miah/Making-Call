package com.dulali.makingcall;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.security.Permission;

public class MainActivity extends AppCompatActivity {

    private static final int PERMISSION_CODE =100 ;
    EditText number;
    ImageView telephone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number = findViewById(R.id.number);
        telephone = findViewById(R.id.telephone);

        if(ContextCompat.checkSelfPermission(MainActivity.this , Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CALL_PHONE}, PERMISSION_CODE);
        }

        telephone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNumber = number.getText().toString();

                Intent i = new Intent(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel: "+phoneNumber));
                startActivity(i);
            }
        });
    }
}
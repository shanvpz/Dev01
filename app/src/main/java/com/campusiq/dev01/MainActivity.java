package com.campusiq.dev01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CoreLib.ReqestPermissions(this);
        Toast.makeText(MainActivity.this,CoreLib.getIMEI(this),Toast.LENGTH_SHORT).show();
    }
}

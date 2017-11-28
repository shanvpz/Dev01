package com.campusiq.dev01;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.Games;

import static android.content.ContentValues.TAG;


public class MainActivity extends AppCompatActivity {
    GoogleApiClient apiClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CoreLib.ReqestPermissions(this);
        //CoreLib.ConnectGooglePlay(this);

        apiClient = new GoogleApiClient.Builder(this)
                .addApi(Games.API)
                .addScope(Games.SCOPE_GAMES)
                .enableAutoManage(this, new GoogleApiClient.OnConnectionFailedListener() {
                    @Override
                    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
                        Log.e(TAG, "Could not connect to Play games services"+connectionResult.getErrorCode());


                    }
                }).build();




        //Toast.makeText(MainActivity.this,CoreLib.getIMEI(this),Toast.LENGTH_SHORT).show();




    }
}

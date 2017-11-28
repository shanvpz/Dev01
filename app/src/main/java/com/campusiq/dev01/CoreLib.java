package com.campusiq.dev01;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.telephony.TelephonyManager;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.Games;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.util.List;

import static android.content.ContentValues.TAG;


/**
 * Created by campusiq on 27/11/17.
 */

public class CoreLib {
static GoogleApiClient googleApiClient;
    public static void ReqestPermissions(Activity activity) {
        Dexter.withActivity(activity)
                .withPermissions(
                        //Manifest.permission.CAMERA,
                        Manifest.permission.READ_PHONE_STATE,
                        Manifest.permission.READ_CONTACTS,
                        Manifest.permission.RECORD_AUDIO
                ).withListener(new MultiplePermissionsListener() {
            @Override
            public void onPermissionsChecked(MultiplePermissionsReport report) {/* ... */}

            @Override
            public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {/* ... */}
        }).check();
    }


    public static String getIMEI(Context ctx) {
        String ts = Context.TELEPHONY_SERVICE;
        TelephonyManager mTelephonyMgr = (TelephonyManager) ctx.getSystemService(ts);
        if (ActivityCompat.checkSelfPermission(ctx, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {

            //return true;
        }
        String imsi = mTelephonyMgr.getSubscriberId();
        String imei = mTelephonyMgr.getDeviceId();
        return imei;
    }

//    public static GoogleApiClient ConnectGooglePlay(Context ctx){
//        try {
//            googleApiClient = new GoogleApiClient.Builder(ctx)
//                    .addApi(Games.API)
//                    .addScope(Games.SCOPE_GAMES)
//                    .enableAutoManage((FragmentActivity) ctx, new GoogleApiClient.OnConnectionFailedListener() {
//                        @Override
//                        public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
//                            Log.e(TAG, "Could not connect to Play games services");
//
//                        }
//                    }).build();
//
//        }
//        catch (Exception e){
//            Log.i("from ConnectGooglePlay",e.getMessage());
//        }
//        return googleApiClient;
//    }


}

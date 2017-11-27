package com.campusiq.dev01;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.telephony.TelephonyManager;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.util.List;

import static android.content.Context.TELEPHONY_SERVICE;

/**
 * Created by campusiq on 27/11/17.
 */

public class CoreLib {

    public void ReqestPermissions(Activity activity){
        Dexter.withActivity(activity)
                .withPermissions(
                        //Manifest.permission.CAMERA,
                        Manifest.permission.READ_PHONE_STATE,
                        Manifest.permission.READ_CONTACTS,
                        Manifest.permission.RECORD_AUDIO
                ).withListener(new MultiplePermissionsListener() {
            @Override public void onPermissionsChecked(MultiplePermissionsReport report) {/* ... */}
            @Override public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {/* ... */}
        }).check();
    }

}

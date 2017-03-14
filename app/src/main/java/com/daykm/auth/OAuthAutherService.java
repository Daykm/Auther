package com.daykm.auth;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class OAuthAutherService extends Service {
    // Instance field that stores the authenticator object
    private OAuthAuther auther;

    @Override
    public void onCreate() {
        // Create a new authenticator object
        auther = new OAuthAuther(this);
    }

    /*
     * When the system binds to this Service to make the RPC call
     * return the authenticator's IBinder.
     */
    @Override
    public IBinder onBind(Intent intent) {
        return auther.getIBinder();
    }
}

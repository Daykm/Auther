package com.daykm.auth;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AuthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        AccountManager manager = (AccountManager) getSystemService(ACCOUNT_SERVICE);

        Account account = new Account("Demo account", getString(R.string.accountType));
        manager.addAccountExplicitly(account, null, null);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        }, 5000);
    }
}

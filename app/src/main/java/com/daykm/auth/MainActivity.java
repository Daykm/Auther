package com.daykm.auth;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        String accountType = getString(R.string.accountType);

        AccountManager manager = (AccountManager) getSystemService(ACCOUNT_SERVICE);

        Account[] accounts = manager.getAccountsByType(accountType);

        if(accounts.length == 0) {
            Bundle options = new Bundle();
            manager.addAccount(accountType, "", null, options, this, cb, null);
        } else {
            manager.getAuthToken(accounts[0], accountType, null, this, cb, new Handler(new Handler.Callback() {
                @Override
                public boolean handleMessage(Message msg) {
                    return false;
                }
            }));
        }
    }

    AccountManagerCallback<Bundle> cb = new AccountManagerCallback<Bundle>() {
        @Override
        public void run(AccountManagerFuture<Bundle> future) {
            Log.i("TEST", "fk");
        }
    };
}

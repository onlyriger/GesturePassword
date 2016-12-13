package com.example.riger.gesturepassword;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnClickListener {

    private static final String TAG = "MainActivity";

    public static final String LOCK = "lock";
    public static final String LOCK_KEY = "lock_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences preferences = getSharedPreferences(LOCK, MODE_PRIVATE);

        String lockPattenString = preferences.getString(LOCK_KEY, null);

        if (lockPattenString != null) {
            Intent intent = new Intent(this, LockActivity.class);
            startActivity(intent);

        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.lock:
                Intent intent = new Intent(this, LockSetupActivity.class);
                startActivity(intent);
                break;
            case R.id.unlock:
                getSharedPreferences(LOCK, MODE_PRIVATE).edit().clear().commit();
                break;

            default:
                break;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}

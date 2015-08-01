package com.codeblast.storagetype;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // check for possible getExternalStorageState() constants on Environment class:
        // MEDIA_UNKNOWN
        // MEDIA_REMOVED
        // MEDIA_UNMOUNTED
        // MEDIA_CHECKING
        // MEDIA_NOFS
        // MEDIA_MOUNTED             <--- SD card?
        // MEDIA_MOUNTED_READ_ONLY   <--- SD card?
        // MEDIA_SHARED
        // MEDIA_BAD_REMOVAL
        // MEDIA_UNMOUNTABLE
        Log.d(TAG, "getExternalStorageState: " + Environment.getExternalStorageState());
        Log.d(TAG, "isExternalStorageEmulated: " + Environment.isExternalStorageEmulated());
        Log.d(TAG, "isExternalStorageRemovable: " + Environment.isExternalStorageRemovable());
        Log.d(TAG, "getExternalCacheDir: " + getExternalCacheDir());
        Log.d(TAG, "getExternalFilesDir: " + getExternalFilesDir(null));

        /*
        The conclusion I've reached: the above returns the same values for my phone with a physical SD card
        installed, and an emulator with no SD, so this is not reliable. It's because your PRIMARY
        "external storage" isn't necessary physically external, it could be the device's own memory...
         */
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

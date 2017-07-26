package com.mobiwire.lockApps2;

import android.app.Activity;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Toast;


/*
Contains the code fro discard lock
all Activity(user interface) must extends this lass
we can exit lock in all activity
 */
public class BaseActivity extends Activity {

    private int countCLick;

    //----------------------- we use OnKeyLongPress & onBackPressed for discard Lock(4 time back & one time longPressBack)
    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            Log.e("OneApps","long press "+countCLick);
            if(countCLick==4){
                countCLick=0;
                Log.e("OneApps","start enable");
                Toast.makeText(getApplicationContext(),"Lock Disable",Toast.LENGTH_SHORT).show();
                PrefUtils.setKioskModeActive(false, getApplicationContext());   // set Lock mode : ON
            }else{
                countCLick = 0;
            }
            return true;
        }
        return super.onKeyLongPress(keyCode, event);
    }


    @Override
    public void onBackPressed() {
        countCLick=countCLick+1;
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        /*if(!hasFocus) {
            Intent closeDialog = new Intent(Intent.ACTION_CLOSE_SYSTEM_DIALOGS);
            sendBroadcast(closeDialog);
        }*/
    }
}

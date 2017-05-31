package com.tolahtoleh.tolahtolehbeta;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by KING on 22/05/2017.
 */

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Thread thread = new Thread() {
            public void run() {
                try {
                    sleep(1500);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    //if sudah login, ngecekshared pref
                    startActivity(new Intent(SplashActivity.this, Home.class));

                    //else
                    //startActivity(new Intent(SplashActivity.this, Home.class));
                    finish();
                }
            }
        };
        thread.start();
    }
}

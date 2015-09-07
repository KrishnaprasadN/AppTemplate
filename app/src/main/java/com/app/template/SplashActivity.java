package com.app.template;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        // Rename CategoryProvider to your class name and change request function name.
        CategoryProvider.getInstance(this).addCategoryListRequest();
        launchMainActivity();
    }

    private void launchMainActivity() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SplashActivity.this.startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        }, Constants.SPLASH_TIMEOUT);
    }
}

package com.lockscreen;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import android.view.View;
import android.view.WindowManager;
/**
 * Activity to start from React Native JavaScript, triggered via
 * {@link ActivityStarterModule#navigateToExample()}.
 */
public class MyActivity extends Activity {
@Override
 @CallSuper
 protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.my_activity);
    getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON|
    WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD|
    WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED|
    WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
    findViewById(R.id.trigger_alert_button).setEnabled(true);
    findViewById(R.id.go_back_button).setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        onBackPressed();
    }
    });
    findViewById(R.id.trigger_alert_button).setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        ActivityStarterModule.triggerAlert("Hello from " + MyActivity.class.getSimpleName());
    }
    });
 }
}
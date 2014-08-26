package com.example.song.bangbang.org.androiddemo;

import android.app.Activity;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * as you can guess, it's just a empyt activity.
 * 
 * used for memory analysis, or other purpose.
 * @author bysong
 *
 */
public class EmptyActivity extends Activity {

    private static final String TAG = EmptyActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty);
    }

}

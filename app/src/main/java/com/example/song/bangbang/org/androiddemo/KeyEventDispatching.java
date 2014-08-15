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
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;


public class KeyEventDispatching extends Activity {


    private static final String TAG = KeyEventDispatching.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_key_event_dispatching);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.key_event_dispatching, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        Log.d(TAG, "KeyEventDispatching dispatchKeyEvent. event: " + toString(event));
        boolean handled = super.dispatchKeyEvent(event);

        Log.d(TAG, "KeyEventDispatching dispatchKeyEvent. handled: " + handled + " event: " + toString(event));
        return handled;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        boolean handled =  super.onKeyDown(keyCode, event);

        Log.d(TAG, "KeyEventDispatching onKeyDown. handled: " + handled + " event: " + toString(event));

        return handled;
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        boolean handled =  super.onKeyUp(keyCode, event);

        Log.d(TAG, "KeyEventDispatching onKeyUp. handled: " + handled + " event: " + toString(event));

        return handled;
    }

    public static String toString(KeyEvent event) {
        return actionToString(event.getAction()) + "/" + event.getKeyCode();
    }
    
    public static String actionToString(int action) {
        switch (action) {
            case KeyEvent.ACTION_DOWN:
                return "ACTION_DOWN";
            case KeyEvent.ACTION_UP:
                return "ACTION_UP";
            case KeyEvent.ACTION_MULTIPLE:
                return "ACTION_MULTIPLE";
            default:
                return Integer.toString(action);
        }
    }

    public static class MyViewGroup extends LinearLayout {

        public MyViewGroup(Context context, AttributeSet attrs) {
            super(context, attrs);

            setOnKeyListener(new OnKeyListener() {
                @Override
                public boolean onKey(View v, int keyCode, KeyEvent event) {

                    Log.d(TAG, getContentDescription() + "MyViewGroup onKey. keyCode: " + keyCode + " event: " + KeyEventDispatching.toString(event));

                    return false;
                }
            });
        }

        @Override
        public boolean onKeyDown(int keyCode, KeyEvent event) {
            boolean handled =  super.onKeyDown(keyCode, event);

            Log.d(TAG, getContentDescription() + "MyViewGroup onKeyDown. handled: " + handled + " event: " + KeyEventDispatching.toString(event));

            return handled;
        }

        @Override
        public boolean onKeyUp(int keyCode, KeyEvent event) {
            boolean handled =  super.onKeyUp(keyCode, event);

            Log.d(TAG, getContentDescription() + "MyViewGroup onKeyUp. handled: " + handled + " event: " + KeyEventDispatching.toString(event));

            return handled;
        }

        @Override
        public boolean dispatchKeyEvent(KeyEvent event) {
            Log.d(TAG, getContentDescription() + "MyViewGroup dispatchKeyEvent. event: " + KeyEventDispatching.toString(event));
            boolean handled = super.dispatchKeyEvent(event);

            Log.d(TAG, getContentDescription() + "MyViewGroup dispatchKeyEvent. handled: " + handled + " event: " + KeyEventDispatching.toString(event));
            return handled;
        }
    }

    public static class MyButton extends Button {

        public MyButton(Context context, AttributeSet attrs) {
            super(context, attrs);

            setOnKeyListener(new OnKeyListener() {

                @Override
                public boolean onKey(View v, int keyCode, KeyEvent event) {

                    Log.d(TAG, getContentDescription() + "MyButton onKey. keyCode: " + keyCode + " event: " + KeyEventDispatching.toString(event));

                    return false;
                }
            });
        }

        @Override
        public boolean dispatchKeyEvent(KeyEvent event) {
            Log.d(TAG, getContentDescription() + "MyButton dispatchKeyEvent. event: " + KeyEventDispatching.toString(event));
            boolean handled = super.dispatchKeyEvent(event);

            Log.d(TAG, getContentDescription() + "MyButton dispatchKeyEvent. handled: " + handled + " event: " + KeyEventDispatching.toString(event));
            return handled;
        }

        @Override
        public boolean onKeyDown(int keyCode, KeyEvent event) {
            boolean handled =  super.onKeyDown(keyCode, event);

            Log.d(TAG, getContentDescription() + "MyButton onKeyDown. handled: " + handled + " event: " + KeyEventDispatching.toString(event));

            return handled;
        }

        @Override
        public boolean onKeyUp(int keyCode, KeyEvent event) {
            boolean handled =  super.onKeyUp(keyCode, event);

            Log.d(TAG, getContentDescription() + "MyButton onKeyUp. handled: " + handled + " event: " + KeyEventDispatching.toString(event));

            return handled;
        }
    }
}

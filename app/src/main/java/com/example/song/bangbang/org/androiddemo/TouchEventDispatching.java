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


public class TouchEventDispatching extends Activity {


    private static final String TAG = TouchEventDispatching.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_event_dispatching);
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
    
    public static String toString(MotionEvent ev) {
 		return actionToString(ev.getAction()) + "/" + ev.getX() + "," + ev.getY();
 	}
    
    public static String actionToString(int action) {
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                return "ACTION_DOWN";
            case MotionEvent.ACTION_UP:
                return "ACTION_UP";
            case MotionEvent.ACTION_CANCEL:
                return "ACTION_CANCEL";
            case MotionEvent.ACTION_OUTSIDE:
                return "ACTION_OUTSIDE";
            case MotionEvent.ACTION_MOVE:
                return "ACTION_MOVE";
            case MotionEvent.ACTION_HOVER_MOVE:
                return "ACTION_HOVER_MOVE";
            case MotionEvent.ACTION_SCROLL:
                return "ACTION_SCROLL";
            case MotionEvent.ACTION_HOVER_ENTER:
                return "ACTION_HOVER_ENTER";
            case MotionEvent.ACTION_HOVER_EXIT:
                return "ACTION_HOVER_EXIT";
        }
        int index = (action & MotionEvent.ACTION_POINTER_INDEX_MASK) >> MotionEvent.ACTION_POINTER_INDEX_SHIFT;
        switch (action & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_POINTER_DOWN:
                return "ACTION_POINTER_DOWN(" + index + ")";
            case MotionEvent.ACTION_POINTER_UP:
                return "ACTION_POINTER_UP(" + index + ")";
            default:
                return Integer.toString(action);
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.d(TAG, "KeyEventDispatching dispatchTouchEvent. ev: " + toString(event));

    	boolean handled =  super.dispatchTouchEvent(event);

        Log.d(TAG, "KeyEventDispatching dispatchTouchEvent. handled: " + handled + " ev: " + toString(event));
    	return handled;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
    	// TODO Auto-generated method stub
    	boolean handled =  super.onTouchEvent(event);

    	Log.d(TAG, "KeyEventDispatching onTouchEvent. handled: " + handled + " event: " + toString(event));
    	
    	return handled;
    }
    
    public static class MyViewGroup extends LinearLayout {

        public MyViewGroup(Context context, AttributeSet attrs) {
            super(context, attrs);
            
            setOnTouchListener(new OnTouchListener() {
				
				@Override
				public boolean onTouch(View v, MotionEvent event) {

                    Log.d(TAG, getContentDescription() + "MyViewGroup onTouch.  event: " + TouchEventDispatching.toString(event));

					return false;
				}
			});
        }

        @Override
        public boolean dispatchTouchEvent(MotionEvent event) {
            Log.d(TAG, "MyViewGroup dispatchTouchEvent. ev: " + TouchEventDispatching.toString(event));

        	boolean handled =  super.dispatchTouchEvent(event);

            Log.d(TAG, getContentDescription() + "MyViewGroup dispatchTouchEvent. handled: " + handled + " ev: " + TouchEventDispatching.toString(event));
        	return handled;
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
        	// TODO Auto-generated method stub
        	boolean handled =  super.onTouchEvent(event);

        	Log.d(TAG, getContentDescription() + "MyViewGroup onTouchEvent. handled: " + handled + " event: " + TouchEventDispatching.toString(event));
        	
        	return handled;
        }
        
        @Override
        public boolean onInterceptTouchEvent(MotionEvent event) {
        	// TODO Auto-generated method stub
        	boolean intercepted = super.onInterceptTouchEvent(event);
        	
           	Log.d(TAG, getContentDescription() + "MyViewGroup onInterceptTouchEvent. intercepted: " + intercepted + " event: " + TouchEventDispatching.toString(event));
    	
        	return intercepted;
        }
    }

    public static class MyButton extends Button {

        public MyButton(Context context, AttributeSet attrs) {
            super(context, attrs);
            
            setOnTouchListener(new OnTouchListener() {
				
				@Override
				public boolean onTouch(View v, MotionEvent event) {

                    Log.d(TAG, getContentDescription() + "MyButton onTouch.  event: " + TouchEventDispatching.toString(event));

					return false;
				}
			});
        }

        @Override
        public boolean dispatchTouchEvent(MotionEvent event) {
            Log.d(TAG, getContentDescription() + "MyViewGroup dispatchTouchEvent. ev: " + TouchEventDispatching.toString(event));

        	boolean handled =  super.dispatchTouchEvent(event);

            Log.d(TAG, getContentDescription() + "MyButton dispatchTouchEvent. handled: " + handled + " ev: " + TouchEventDispatching.toString(event));
        	return handled;
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
        	// TODO Auto-generated method stub
        	boolean handled =  super.onTouchEvent(event);

        	Log.d(TAG, getContentDescription() + "MyButton onTouchEvent. handled: " + handled + " event: " + TouchEventDispatching.toString(event));
        	
        	return handled;
        }
    }
}

package com.example.song.bangbang.org.androiddemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

// set build_res.sh
public class WhichResoucesActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_which_resource);
		
		((TextView)findViewById(R.id.which_res)).setText(R.string.auto_generated_res);
	}

}

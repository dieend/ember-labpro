package com.labpro.game.ember;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class MainActivity extends Activity implements OnTouchListener{
	private View cv;
	private boolean gameloop;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		DrawableManager.initInstance(getApplicationContext());
		cv = findViewById(R.id.custom_view);
	}
	@Override
	protected void onResume() {
		while (gameloop) {
			// game logic
			cv.invalidate(); // redraw
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		GL
		return false;
	}
}

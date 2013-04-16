package com.labpro.game.ember;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

public class MainGameActivity extends Activity {
	
	private static final String TAG = MainGameActivity.class.getSimpleName();
	private DisplayMetrics metrics;	
	private MainGameView mainGameView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		DrawableManager.initInstance(getApplicationContext());
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);		
		Log.d(TAG,"start game activity");
		metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics); // dapetin ukuran layar
		mainGameView = new MainGameView(this,metrics.widthPixels,metrics.heightPixels);
		setContentView(mainGameView);	
	}
	
	@Override
	protected void onPause() {
		Log.d(TAG,"onPause()");
		mainGameView.thread.setRunning(false); //matiin thread
		super.onPause();			
	}
}

package com.labpro.game.ember;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MainGameView extends SurfaceView implements SurfaceHolder.Callback {

	private static final String TAG = MainGameView.class.getSimpleName();
	public GameLoopThread thread;
	private Matrix matrix = new Matrix();	
	private Bitmap background; // gambar latar belakang
	Paint paint = new Paint();
	Options options = new BitmapFactory.Options();
	
	public MainGameView(Object context, int screenWidth, int screenHeight) {
		super((Context) context);
		getHolder().addCallback(this);
		setFocusable(true);
		
		loadResources();
	}
	
	@Override
	public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
	}

	@Override
	public void surfaceCreated(SurfaceHolder arg0) {
		// inisialisasi thread
		initThread();
		Log.d(TAG, "surface created");
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder arg0) {		
		releaseThread();
		Log.d(TAG, "surface destroyed");
	}
	
	private void loadResources() {
		background = BitmapFactory.decodeResource(getResources(),R.drawable.background, options);
	}
	
	// inisialisasi thread
	public void initThread() {
		if (thread == null || !thread.isAlive()) {
			// jika belom diinisialisasi threadnya atau threadnya sudah tidak hidup lagi, maka
			// instansiasi thread utama
			thread = new GameLoopThread(getHolder(), this);
			thread.start();
		}
		thread.setRunning(true);
	}
	 
	private void releaseThread() {
		boolean retry = true;
		while (retry) {
			try {
				thread.join();
				retry = false;
				thread = null;
			} catch (InterruptedException e) {
			}
		}
	}

	public void render(Canvas canvas) {		
		Log.d(TAG, "render");
		canvas.setMatrix(matrix);
		drawBackground(canvas);
	}

	public void update() {
		Log.d(TAG, "update");
	}
	
	public boolean onTouchEvent(MotionEvent event) {
		final int actioncode = event.getAction() & MotionEvent.ACTION_MASK;				
		switch (actioncode) {
			case MotionEvent.ACTION_DOWN:
				Log.d(TAG, "down at " + event.getX() + " " + event.getY());
				break;
			case MotionEvent.ACTION_MOVE:
				Log.d(TAG, "move at " + event.getX() + " " + event.getY());
				break;
			case MotionEvent.ACTION_UP:
				Log.d(TAG, "up at " + event.getX() + " " + event.getY());
				break;		
		}				
		return true;
	}	
	
	private void drawBackground(Canvas canvas) {
		canvas.drawColor(Color.BLACK);// clear screen
		paint.setFilterBitmap(true);
		paint.setDither(true);
		canvas.drawBitmap(background, 0, 0, paint);		
	}
}

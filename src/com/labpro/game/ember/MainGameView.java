package com.labpro.game.ember;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

@SuppressLint("ViewConstructor")
public class MainGameView extends SurfaceView implements SurfaceHolder.Callback {

	private static final String TAG = MainGameView.class.getSimpleName();
	public GameLoopThread thread;
	private Matrix matrix = new Matrix();	
	private Paint paint = new Paint();
	private Bitmap background; // gambar latar belakang
	
	private Waterdrop[] waters;
	private Bucket bucket;	
	private int score;
	private int delayCounter;
	private final int delay = 100;
	public MainGameView(Context context, int screenWidth, int screenHeight) {
		super(context);
		getHolder().addCallback(this);
		setFocusable(true);
		
		bucket = new Bucket(this, screenWidth, screenHeight);
		waters = new Waterdrop[20];
		for (int i=0; i<waters.length; i++) {
			waters[i] = new Waterdrop(this, screenWidth, screenHeight);
		}
		background = DrawableManager.getInstance().getBackgroundBitmap();
		score = 0;
		delayCounter = delay;
		paint.setTextSize(40);
		paint.setTypeface(Typeface.MONOSPACE);
		paint.setColor(Color.WHITE);
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
		canvas.setMatrix(matrix);
		drawBackground(canvas);
		bucket.draw(canvas);
		for (Waterdrop water:waters) if (water.isValid()) {
			water.draw(canvas);
		}
		canvas.drawText("" + score, 30, 30, paint);
	}
	private void spawnWater() {
		delayCounter += 1;
		if (delayCounter > delay) {
			delayCounter = 0;
			
			for (Waterdrop water:waters) if (!water.isValid()) {
				water.reset();
				return;
			}
		}
	}
	public void update() {
		spawnWater(); 
		for (Waterdrop water:waters) if (water.isValid()) {
			water.update();
			if (bucket.getRectangle().intersect(water.getRectangle())) {
				score += 10;
				water.reset();
			}
		}
	}
	
	public boolean onTouchEvent(MotionEvent event) {
		final int actioncode = event.getAction() & MotionEvent.ACTION_MASK;				
		switch (actioncode) {
			case MotionEvent.ACTION_DOWN:
				Log.d(TAG, "down at " + event.getX() + " " + event.getY());
				bucket.updatePosition((int)event.getX());
				break;
			case MotionEvent.ACTION_MOVE:
				Log.d(TAG, "move at " + event.getX() + " " + event.getY());
				bucket.updatePosition((int)event.getX());
				break;
			case MotionEvent.ACTION_UP:
				Log.d(TAG, "up at " + event.getX() + " " + event.getY());
				bucket.updatePosition((int)event.getX());
				break;		
		}				
		return true;
	}	
	
	private void drawBackground(Canvas canvas) {
		canvas.drawColor(Color.BLACK);// clear screen		
		canvas.drawBitmap(background, 0, 0, null);		
	}

}

package com.labpro.game.ember;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

public class Bucket {
	
	public int x, y; // titik tengah
	private Bitmap bitmap;	
	
	public Bucket(MainGameView mainGameView, int screenWidth, int screenHeight) {		
		bitmap = BitmapFactory.decodeResource(mainGameView.getResources(), R.drawable.bucket2);
		
		y = screenHeight - bitmap.getHeight() / 2;
		x = screenWidth / 2;
	}
	
	public void draw(Canvas canvas) {
		canvas.drawBitmap(bitmap, x - bitmap.getWidth() / 2, y - bitmap.getHeight() / 2, null);
	}
	
	public void update() {
	}
}

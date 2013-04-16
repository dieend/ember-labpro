package com.labpro.game.ember;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Bucket {
	
	private int x, y; // titik tengah
	private Bitmap bitmap;	
	
	public Bucket(MainGameView mainGameView, int screenWidth, int screenHeight) {		
		bitmap = DrawableManager.getInstance().getEmberBitmap();
		
		y = screenHeight - bitmap.getHeight() / 2; // initial position
		x = screenWidth / 2;
	}
	
	public void draw(Canvas canvas) {
		canvas.drawBitmap(bitmap, x - bitmap.getWidth() / 2, y - bitmap.getHeight() / 2, null);
	}
	public Rect getRectangle() {
		return new Rect(x - bitmap.getWidth()/2, y - bitmap.getHeight() / 2, x + bitmap.getWidth()/2, y + bitmap.getHeight() / 2);
	}
	public void updatePosition(int x) {
		this.x = x;
	}
}

package com.labpro.game.ember;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

public class Sprite extends Drawable{
	private Bitmap image;
	public Sprite(Bitmap bm) {
		image = bm;
	}
	@Override
	public void draw(Canvas canvas) {
		// TODO Auto-generated method stub
		// rotate and do everything to image here.
		
		Matrix matrix = new Matrix();
		Paint paint = new Paint();
		

		// setBounds(0, 0, 0, 0);
		canvas.drawBitmap(image, matrix, paint);
	}

	@Override
	public int getOpacity() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setAlpha(int alpha) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setColorFilter(ColorFilter cf) {
		// TODO Auto-generated method stub
		
	}
}

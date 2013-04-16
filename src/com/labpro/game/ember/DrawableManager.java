package com.labpro.game.ember;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;


public class DrawableManager{
	/**
	 * construct pake aplication context
	 * @param context
	 */
	public DrawableManager(Context context) {
		// TODO ganti gambar
		Resources r = context.getResources();
		emberBitmap = BitmapFactory.decodeResource(r, R.drawable.bucket);
		
	}
	public Bitmap getEmberBitmap(){
		assert emberBitmap != null;
		return emberBitmap;
	}
	private Bitmap emberBitmap;
	
}

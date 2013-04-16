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
	private DrawableManager(Context context) {
		// TODO ganti gambar
		Resources r = context.getResources();
		emberBitmap = BitmapFactory.decodeResource(r, R.drawable.bucket);
	}
	/**
	 * must be called only once
	 * @param context
	 */
	public static void initInstance(Context context) {
		assert instance == null;
		instance = new DrawableManager(context);
	}
	/**
	 * must have called initInstance() before
	 * @return
	 */
	public static DrawableManager getInstance() {
		assert instance != null;
		return instance;
	}
	public Bitmap getEmberBitmap(){
		assert emberBitmap != null;
		return emberBitmap;
	}
	
	private static DrawableManager instance;
	private Bitmap emberBitmap;
	
}

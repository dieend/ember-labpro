package com.labpro.game.ember;

import java.util.Random;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;


public class DrawableManager{
	/**
	 * construct pake aplication context
	 * @param context
	 */
	private Resources res;
	private DrawableManager(Context context) {
		// TODO ganti gambar
		res = context.getResources();
		rand = new Random();
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
		if (emberBitmap == null) {
			emberBitmap = BitmapFactory.decodeResource(res, R.drawable.bucket);
		}

		return emberBitmap;
	}
	public Bitmap getWaterdropBitmap() {
		if (waterDrop == null) {
			waterDrop = BitmapFactory.decodeResource(res, R.drawable.waterdrop1);
		}
		return waterDrop;
	}
	public Bitmap getBackgroundBitmap() {
		if (background == null) {
			background = BitmapFactory.decodeResource(res, R.drawable.background);
		}
		return background;
	}
	private static DrawableManager instance;
	private Bitmap emberBitmap;
	private Bitmap waterDrop;
	private Bitmap background;
	public final Random rand; 	
}

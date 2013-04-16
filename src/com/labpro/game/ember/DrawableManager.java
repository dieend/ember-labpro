package com.labpro.game.ember;

import android.content.Context;
import android.graphics.drawable.Drawable;


public class DrawableManager{
	/**
	 * construct pake aplication context
	 * @param context
	 */
	public DrawableManager(Context context) {
		// TODO ganti gambar
		emberImage = context.getResources().getDrawable(R.drawable.ic_launcher);
	}
	public Drawable getEmberImage(){
		assert emberImage != null;
		return emberImage;
	}
	private Drawable emberImage;
	
}

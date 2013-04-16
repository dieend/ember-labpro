/**
 *  This file is part of ember-labpro.
 *
 *  ember-labpro is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  ember-labpro is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with ember-labpro.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.labpro.game.ember;

import java.util.Random;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

/**
 * @author dieend
 *
 */
public class Waterdrop {
	private int x, y; // titik tengah
	private int speed;
	private Bitmap bitmap;	
	private int screenWidth;
	private int screenHeight;
	private Random rand;
	private boolean valid;
	public Waterdrop(MainGameView mainGameView, int screenWidth, int screenHeight) {
		this.screenHeight = screenHeight;
		this.screenWidth = screenWidth;
		bitmap = DrawableManager.getInstance().getWaterdropBitmap();
		speed = this.screenHeight / 50;
		y = 0; // initial position
		rand = DrawableManager.getInstance().rand;
		x = rand.nextInt(this.screenWidth); 
		valid = false;
	}

	public void draw(Canvas canvas) {
		canvas.drawBitmap(bitmap, x - bitmap.getWidth() / 2, y - bitmap.getHeight() / 2, null);
	}
	public Rect getRectangle() {
		return new Rect(x - bitmap.getWidth()/2, y - bitmap.getHeight() / 2, x + bitmap.getWidth()/2, y + bitmap.getHeight() / 2);
	}
	public void update() {
		y += speed;
		if (y >= screenHeight) {
			valid = false;
		}
	}
	public void reset() {
		valid = true;
		x = rand.nextInt(this.screenWidth);
		y = 0;
	}
	public boolean isValid() {
		return valid;
	}
}

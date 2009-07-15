package com.rubberdroid.droidsweeper;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Background {
	private Bitmap bitmap;
	private Rect src;
	private Rect dst;

	public Background(int width, int height, Resources resources) {
		bitmap = BitmapFactory.decodeResource(resources, R.drawable.beach);
		src = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
		dst = new Rect(0, 0, width, height);
	}

	public void draw(Canvas canvas) {
		canvas.drawBitmap(bitmap, src, dst, null);
	}
}

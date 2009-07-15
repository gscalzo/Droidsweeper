package com.rubberdroid.droidsweeper;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Tiles {
	private MineField mineField;
	private Bitmap tile;
	private Rect rectTile;
	private int tileSide;

	public Tiles(int w, int h, MineField mineField, Resources resources) {
		this.mineField = mineField;
		tile = BitmapFactory.decodeResource(resources, R.drawable.tile_blu);
		rectTile = new Rect(0, 0, tile.getWidth(), tile.getHeight());
		tileSide = w / 10;
	}

	public void draw(Canvas canvas) {
		for (int i = 0; i < mineField.width(); ++i)
			for (int j = 0; j < mineField.height(); ++j)
				drawTilesAt(i, j, canvas);
	}

	private void drawTilesAt(int i, int j, Canvas canvas) {
		if (!mineField.isVisible(i, j))
			canvas.drawBitmap(tile, rectTile, dstRect(i, j), null);
	}

	private Rect dstRect(int i, int j) {
		Rect dst = new Rect(i * tileSide, j * tileSide, (i + 1) * tileSide,
				(j + 1) * tileSide);
		return dst;
	}

}

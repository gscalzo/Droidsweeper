package com.rubberdroid.droidsweeper;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;

public class Tiles {
	public static final int PIXEL_FOR_TILE = 16;
	public static final int BOMB = 10;
	private MineField mineField;
	private Bitmap tile;
	private Rect rectTile;
	private int tileSide;
	private Paint numbersPaint;
	private BoardGraphicsManager boardGraphicsManager;

	public Tiles(int w, int h, MineField mineField, Resources resources,
			BoardGraphicsManager boardGraphicsManager) {
		this.mineField = mineField;
		tile = BitmapFactory.decodeResource(resources, R.drawable.cell_closed);
		rectTile = new Rect(0, 0, tile.getWidth(), tile.getHeight());
		tileSide = w / PIXEL_FOR_TILE;
		this.boardGraphicsManager = boardGraphicsManager;

		numbersPaint = createNumbersPaint(resources, R.color.numbers);
	}

	private Paint createNumbersPaint(Resources resources, int color) {
		Paint foreground = new Paint(Paint.ANTI_ALIAS_FLAG);
		foreground.setColor(resources.getColor(color));
		foreground.setStyle(Style.FILL);
		foreground.setFakeBoldText(true);
		foreground.setTextSize(tileSide * 0.75f);
		foreground.setTextAlign(Paint.Align.CENTER);
		return foreground;
	}

	public void draw(Canvas canvas) {
		for (int i = 0; i < mineField.width(); ++i)
			for (int j = 0; j < mineField.height(); ++j) {
				drawTilesAt(i, j, canvas);
				drawNumbersAt(i, j, canvas);
			}
	}

	private void drawNumbersAt(int i, int j, Canvas canvas) {
		float xTileCenter = tileSide / 2;
		float yTileCenter = tileSide / 2 - (heightCenterOfText()) / 2;
		Pair currentTileCoordinates = boardGraphicsManager.coordinatesFor(i, j);

		canvas.drawText(String.valueOf(mineField.valueAt(i, j)),
				currentTileCoordinates.a() + xTileCenter,
				currentTileCoordinates.b() + yTileCenter, numbersPaint);
	}

	private float heightCenterOfText() {
		FontMetrics fm = numbersPaint.getFontMetrics();
		return fm.ascent + fm.descent;
	}

	private void drawTilesAt(int i, int j, Canvas canvas) {
		if (mineField.isVisible(i, j) && mineField.valueAt(i, j) == 0)
			return;

		canvas.drawBitmap(tile, rectTile, dstRect(i, j), null);
	}

	private Rect dstRect(int i, int j) {
		Rect dst = new Rect(i * tileSide, j * tileSide, (i + 1) * tileSide,
				(j + 1) * tileSide);
		return dst;
	}

}

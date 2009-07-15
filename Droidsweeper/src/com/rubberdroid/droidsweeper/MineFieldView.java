package com.rubberdroid.droidsweeper;

import android.graphics.Canvas;
import android.view.View;

public class MineFieldView extends View {
	private Background background;
	private Tiles tiles;
	private MineField mineField;

	public MineFieldView(Game game, MineField mineField) {
		super(game);

		this.mineField = mineField;

		setFocusable(true);
		setFocusableInTouchMode(true);
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		background = new Background(w, h, getResources());
		tiles = new Tiles(w, h, mineField, getResources());
	}

	public void draw(Canvas canvas) {
		background.draw(canvas);
		tiles.draw(canvas);
		// drawTiles(canvas);
		// drawNumbers(canvas);
		// drawNotes(canvas);
		// drawNumberBoard(canvas);
		// drawButtons(canvas);
		// drawAlien(canvas);
	}

}

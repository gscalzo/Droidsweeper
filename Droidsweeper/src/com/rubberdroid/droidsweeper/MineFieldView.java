package com.rubberdroid.droidsweeper;

import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;

public class MineFieldView extends View {
	private Background background;
	private Tiles tiles;
	private MineField mineField;
	private BoardGraphicsManager boardGraphicsManager;

	public MineFieldView(Game game, MineField mineField, BoardGraphicsManager boardGraphicsManager) {
		super(game);

		this.mineField = mineField;
		this.boardGraphicsManager = boardGraphicsManager;

		setFocusable(true);
		setFocusableInTouchMode(true);
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		background = new Background(w, h, getResources());
		tiles = new Tiles(w, h, mineField, getResources(),boardGraphicsManager);
	}

	public void draw(Canvas canvas) {
		background.draw(canvas);
		tiles.draw(canvas);
	}

	private Game game() {
		return (Game) getContext();
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (game().isTouchManaged(event))
			return true;

		return super.onTouchEvent(event);
	}
}

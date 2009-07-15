package com.rubberdroid.droidsweeper;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

public class Game extends Activity {
	private BoardGraphicsManager boardGraphicsManager;
	private VisibilityManager board;
	private MineFieldView mineFieldView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		int diff = getIntent().getIntExtra(Droidsweeper.KEY_DIFFICULTY, -1);
		MineField mineField = createMineField(diff);
		board = new VisibilityManager(mineField);
		boardGraphicsManager = createBoardGraphicsManager();
		mineFieldView = new MineFieldView(this, mineField,boardGraphicsManager);


		setContentView(mineFieldView);
		mineFieldView.requestFocus();
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	}

	private BoardGraphicsManager createBoardGraphicsManager() {
		int w = getWindowManager().getDefaultDisplay().getWidth();
		int h = getWindowManager().getDefaultDisplay().getHeight();
		Log.d(Droidsweeper.TAG, "createBoardGraphicsManager: w  " + w + ", h "
				+ h);
		return new BoardGraphicsManager(w, h);
	}

	private MineField createMineField(int diff) {
		MineField result = new PuzzleGenerator().generate(10, 10, 10);
		return new PuzzlePositionFiller(result).filled();
	}

	public boolean isTouchManaged(MotionEvent event) {
		if (event.getAction() != MotionEvent.ACTION_DOWN)
			return false;

		int x = (int) event.getX();
		int y = (int) event.getY();

		Log.d(Droidsweeper.TAG, "onTouchEvent: x touch  " + x + ", y " + y);

		manageBoard(x, y);
		return true;
	}

	private void manageBoard(int x, int y) {
		Pair tileCoordinates = boardGraphicsManager.tileAt(x, y);
		if (tileCoordinates == Pair.NOT_VALID)
			return;
		board.select(tileCoordinates.a(), tileCoordinates.b());
		mineFieldView.invalidate();

	}
}

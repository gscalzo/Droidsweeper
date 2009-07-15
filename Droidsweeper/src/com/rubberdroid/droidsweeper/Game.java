package com.rubberdroid.droidsweeper;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;

public class Game extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		int diff = getIntent().getIntExtra(Droidsweeper.KEY_DIFFICULTY, -1);
		MineField mineField = createMineField(diff);
		MineFieldView mineFieldView = new MineFieldView(this, mineField);

		setContentView(mineFieldView);
		mineFieldView.requestFocus();
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	}

	private MineField createMineField(int diff) {
		MineField result = new PuzzleGenerator().generate(10, 10, 10);
		return new PuzzlePositionFiller(result).filled();
	}
}

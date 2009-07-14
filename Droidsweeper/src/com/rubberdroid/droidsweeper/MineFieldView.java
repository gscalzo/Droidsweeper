package com.rubberdroid.droidsweeper;

import android.view.View;

public class MineFieldView extends View {

	public MineFieldView(Game game, MineField mineField) {
		super(game);
		setFocusable(true);
		setFocusableInTouchMode(true);
}

}

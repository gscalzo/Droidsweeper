package com.rubberdroid.droidsweeper;

public class VisibilityManager {

	private MineField puzzle;

	public VisibilityManager(MineField puzzle) {
		this.puzzle = puzzle;
	}

	public MineField select(int i, int j) {
		if (puzzle.inBounds(i, j) && !puzzle.isVisible(i, j)) {
			puzzle.setVisible(i, j);

			if (puzzle.valueAt(i, j) == 0) {
				for (int r = -1; r <= 1; r++)
					for (int c = -1; c <= 1; c++)
						select(i + r, j + c);
			}
		}
		return puzzle;
	}

}

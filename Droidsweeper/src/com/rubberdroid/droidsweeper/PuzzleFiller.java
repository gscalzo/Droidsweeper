package com.rubberdroid.droidsweeper;

public class PuzzleFiller {
	private MineField puzzle;

	public PuzzleFiller(MineField puzzle) {
		this.puzzle = puzzle;
	}

	public MineField filled() {
		MineField toFill = puzzle.copy();
		for (int i = 0; i < puzzle.width(); ++i)
			for (int j = 0; j < puzzle.height(); ++j)
				toFill.setValueAt(i, j, minesCount(i, j));

		return toFill;
	}

	int minesCount(int i, int j) {
		if (puzzle.valueAt(i, j) == 10)
			return 10;
		int count = 0;
		for (int x = i - 1; x <= i + 1; ++x)
			for (int y = j - 1; y <= j + 1; ++y)
				if (isContained(x, y) && !areTheSame(i, j, x, y)
						&& containsMine(x, y))
					++count;
		return count;
	}

	private boolean containsMine(int x, int y) {
		return puzzle.valueAt(x, y) == 10;
	}

	private boolean areTheSame(int i, int j, int x, int y) {
		return (x == i && y == j);
	}

	private boolean isContained(int x, int y) {
		return x >= 0 && x < puzzle.width() && y >= 0 && y < puzzle.height();
	}

}

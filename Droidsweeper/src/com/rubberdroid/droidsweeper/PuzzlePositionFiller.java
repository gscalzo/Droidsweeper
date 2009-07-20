package com.rubberdroid.droidsweeper;

public class PuzzlePositionFiller {
	private MineField puzzle;

	public PuzzlePositionFiller(MineField puzzle) {
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
		if (puzzle.valueAt(i, j) == Tiles.BOMB)
			return Tiles.BOMB;
		int count = 0;
		for (int x = i - 1; x <= i + 1; ++x)
			for (int y = j - 1; y <= j + 1; ++y)
				if (puzzle.inBounds(x, y) && !areTheSame(i, j, x, y)
						&& containsMine(x, y))
					++count;
		return count;
	}

	private boolean containsMine(int x, int y) {
		return puzzle.valueAt(x, y) == Tiles.BOMB;
	}

	private boolean areTheSame(int i, int j, int x, int y) {
		return (x == i && y == j);
	}

}

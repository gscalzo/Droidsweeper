package com.rubberdroid.droidsweeper;

public class PuzzleFiller {
	private int[][] puzzle;

	public PuzzleFiller(int[][] puzzle) {
		this.puzzle = puzzle;
	}

	public int[][] filled() {
		int[][] toFill = puzzle.clone();
		for (int i = 0; i < puzzle[0].length; ++i)
			for (int j = 0; j < puzzle.length; ++j)
				toFill[j][i] = minesCount(i, j);

		return toFill;
	}

	int minesCount(int i, int j) {
		if (puzzle[j][i] == 10)
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
		return puzzle[y][x] == 10;
	}

	private boolean areTheSame(int i, int j, int x, int y) {
		return (x == i && y == j);
	}

	private boolean isContained(int x, int y) {
		return x >= 0 && x < puzzle[0].length && y >= 0 && y < puzzle.length;
	}

}

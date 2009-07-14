package com.rubberdroid.droidsweeper;

import java.util.Random;

public class PuzzleGenerator {
	private Random random = new Random();

	public MineField generate(int width, int height, int numOfBombs) {
		int[][] values = new int[height][width];
		MineField result = new MineField(values);

		addMines(result, numOfBombs);
		return result;
	}

	private void addMines(MineField mineField, int minesToAdd) {
		if (minesToAdd == 0)
			return;

		while (true) {
			int x = random.nextInt(mineField.width());
			int y = random.nextInt(mineField.height());
			if(!mineField.containsMine(x, y)){
				mineField.setMine(x,y);
				addMines(mineField, minesToAdd-1);
				return;
			}
		}
	}

}

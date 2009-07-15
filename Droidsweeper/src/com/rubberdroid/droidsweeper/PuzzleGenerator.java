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
			Pair randCoordinates = randCoordinates(mineField);
			if(!mineField.containsMine(randCoordinates.a(),randCoordinates.b())){
				mineField.setMine(randCoordinates.a(),randCoordinates.b());
				addMines(mineField, minesToAdd-1);
				return;
			}
		}
	}

	private Pair randCoordinates(MineField mineField) {
		int randValue=random.nextInt(mineField.width()*mineField.height());
		int y = randValue/mineField.width();
		int x = randValue-y*mineField.width();
		Pair randCoordinates=new Pair(x,y);
		return randCoordinates;
	}

}

package com.rubberdroid.droidsweeper;

import org.junit.Test;
import static org.junit.Assert.*;

public class PuzzleGeneratorTest {

	@Test
	public void aGeneratorShouldReturnAMineFieldWithBombs() {
		MineField mineField = new PuzzleGenerator().generate(5, 6, 2);
		assertEquals(5, mineField.width());
		assertEquals(6, mineField.height());
		assertEquals(2, countMines(mineField));
	}

	private int countMines(MineField mineField) {
		int count = 0;
		for (int i = 0; i < mineField.width(); ++i)
			for (int j = 0; j < mineField.height(); ++j)
				if (mineField.containsMine(i, j))
					++count;
		return count;
	}

}

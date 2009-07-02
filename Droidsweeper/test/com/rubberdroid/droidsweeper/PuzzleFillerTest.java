package com.rubberdroid.droidsweeper;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PuzzleFillerTest {
	int[][] squaredPuzzle = { { 0, 0, 10, 0 }, { 0, 10, 0, 0 }, { 0, 0, 0, 0 },
			{ 10, 0, 0, 10 } };

	int[][] rectPuzzle = { 
			{ 0, 0, 10, 0 }, 
			{ 0, 10, 0, 0 }, 
			{ 0, 0, 0, 0 },
			{ 10, 0, 0, 10 }, 
			{ 0, 10, 0, 0 }, 
			{ 0, 10, 10, 0 }, 
			};

	@Test
	public void aRectPuzzleShouldBeFilled() {
		int[][] expectedPuzzle = { 
				{ 1, 2, 10, 1 }, 
				{ 1, 10, 2, 1 },
				{ 2, 2, 2, 1 }, 
				{ 10, 2, 2, 10 }, 
				{ 3, 10, 4, 2 }, 
				{ 2, 10, 10, 1 }, 
				};

		PuzzleFiller filler = new PuzzleFiller(rectPuzzle);
		assertBoardEquals(expectedPuzzle, filler.filled());
	}

	@Test
	public void aSquaredPuzzleShouldBeFilled() {
		int[][] expectedPuzzle = { { 1, 2, 10, 1 }, { 1, 10, 2, 1 },
				{ 2, 2, 2, 1 }, { 10, 1, 1, 10 } };

		PuzzleFiller filler = new PuzzleFiller(squaredPuzzle);
		assertBoardEquals(expectedPuzzle, filler.filled());
	}

	private void assertBoardEquals(int[][] expectedPuzzle, int[][] filled) {
		for (int i = 0; i < expectedPuzzle[0].length; ++i)
			for (int j = 0; j < expectedPuzzle.length; ++j)
				assertEquals(expectedPuzzle[j][i], filled[j][i]);
	}

	@Test
	public void minesCountShouldReturnTheNumberOfMinesAround() {
		PuzzleFiller filler = new PuzzleFiller(squaredPuzzle);
		assertEquals(1, filler.minesCount(0, 0));
		assertEquals(1, filler.minesCount(3, 0));
		assertEquals(10, filler.minesCount(0, 3));
		assertEquals(1, filler.minesCount(0, 1));
		assertEquals(2, filler.minesCount(1, 2));
		assertEquals(2, filler.minesCount(2, 1));
		assertEquals(10, filler.minesCount(2, 0));
	}

}

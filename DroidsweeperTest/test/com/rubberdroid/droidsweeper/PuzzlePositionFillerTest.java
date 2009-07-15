package com.rubberdroid.droidsweeper;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PuzzlePositionFillerTest {
	MineField squaredPuzzle = new MineField(new int[][] { { 0, 0, 10, 0 },
			{ 0, 10, 0, 0 }, { 0, 0, 0, 0 }, { 10, 0, 0, 10 } });

	MineField rectPuzzle = new MineField(new int[][] { { 0, 0, 10, 0 }, { 0, 10, 0, 0 }, { 0, 0, 0, 0 },
			{ 10, 0, 0, 10 }, { 0, 10, 0, 0 }, { 0, 10, 10, 0 }, });

	@Test
	public void aRectPuzzleShouldBeFilled() {
		MineField expectedPuzzle = new MineField(new int[][] { { 1, 2, 10, 1 }, { 1, 10, 2, 1 },
				{ 2, 2, 2, 1 }, { 10, 2, 2, 10 }, { 3, 10, 4, 2 },
				{ 2, 10, 10, 1 }, });

		PuzzlePositionFiller filler = new PuzzlePositionFiller(rectPuzzle);
		assertEquals(expectedPuzzle, filler.filled());
	}

	@Test
	public void aSquaredPuzzleShouldBeFilled() {
		MineField expectedPuzzle = new MineField(new int[][] { { 1, 2, 10, 1 }, { 1, 10, 2, 1 },
				{ 2, 2, 2, 1 }, { 10, 1, 1, 10 } });

		PuzzlePositionFiller filler = new PuzzlePositionFiller(squaredPuzzle);
		assertEquals(expectedPuzzle, filler.filled());
	}

	@Test
	public void minesCountShouldReturnTheNumberOfMinesAround() {
		PuzzlePositionFiller filler = new PuzzlePositionFiller(squaredPuzzle);
		assertEquals(1, filler.minesCount(0, 0));
		assertEquals(1, filler.minesCount(3, 0));
		assertEquals(10, filler.minesCount(0, 3));
		assertEquals(1, filler.minesCount(0, 1));
		assertEquals(2, filler.minesCount(1, 2));
		assertEquals(2, filler.minesCount(2, 1));
		assertEquals(10, filler.minesCount(2, 0));
	}

}

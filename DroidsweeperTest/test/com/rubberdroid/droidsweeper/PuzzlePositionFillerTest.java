package com.rubberdroid.droidsweeper;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PuzzlePositionFillerTest {
	MineField squaredPuzzle = new MineField(new int[][] { { 0, 0, Tiles.BOMB, 0 },
			{ 0, Tiles.BOMB, 0, 0 }, { 0, 0, 0, 0 }, { Tiles.BOMB, 0, 0, Tiles.BOMB } });

	MineField rectPuzzle = new MineField(new int[][] { { 0, 0, Tiles.BOMB, 0 }, { 0, Tiles.BOMB, 0, 0 }, { 0, 0, 0, 0 },
			{ Tiles.BOMB, 0, 0, Tiles.BOMB }, { 0, Tiles.BOMB, 0, 0 }, { 0, Tiles.BOMB, Tiles.BOMB, 0 }, });

	@Test
	public void aRectPuzzleShouldBeFilled() {
		MineField expectedPuzzle = new MineField(new int[][] { { 1, 2, Tiles.BOMB, 1 }, { 1, Tiles.BOMB, 2, 1 },
				{ 2, 2, 2, 1 }, { Tiles.BOMB, 2, 2, Tiles.BOMB }, { 3, Tiles.BOMB, 4, 2 },
				{ 2, Tiles.BOMB, Tiles.BOMB, 1 }, });

		PuzzlePositionFiller filler = new PuzzlePositionFiller(rectPuzzle);
		assertEquals(expectedPuzzle, filler.filled());
	}

	@Test
	public void aSquaredPuzzleShouldBeFilled() {
		MineField expectedPuzzle = new MineField(new int[][] { { 1, 2, Tiles.BOMB, 1 }, { 1, Tiles.BOMB, 2, 1 },
				{ 2, 2, 2, 1 }, { Tiles.BOMB, 1, 1, Tiles.BOMB } });

		PuzzlePositionFiller filler = new PuzzlePositionFiller(squaredPuzzle);
		assertEquals(expectedPuzzle, filler.filled());
	}

	@Test
	public void minesCountShouldReturnTheNumberOfMinesAround() {
		PuzzlePositionFiller filler = new PuzzlePositionFiller(squaredPuzzle);
		assertEquals(1, filler.minesCount(0, 0));
		assertEquals(1, filler.minesCount(3, 0));
		assertEquals(Tiles.BOMB, filler.minesCount(0, 3));
		assertEquals(1, filler.minesCount(0, 1));
		assertEquals(2, filler.minesCount(1, 2));
		assertEquals(2, filler.minesCount(2, 1));
		assertEquals(Tiles.BOMB, filler.minesCount(2, 0));
	}

}

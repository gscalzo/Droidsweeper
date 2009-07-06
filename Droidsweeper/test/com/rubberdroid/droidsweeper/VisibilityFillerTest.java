package com.rubberdroid.droidsweeper;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class VisibilityFillerTest {
	MineField puzzle = new MineField(new int[][] { 
			{ 0, 1, 10, 1 },
			{ 0, 1, 1, 1 }, 
			{ 1, 1, 1, 0 }, 
			{ 1, 10, 1, 0 }, 
			{ 1, 2, 2, 1 },
			{ 0, 1, 10, 1 } });
	private VisibilityManager vManager;

	@Before
	public void setUp(){
		 vManager = new VisibilityManager(
				new PuzzlePositionFiller(puzzle).filled());		
	}
	
	@Test
	public void whenATileIsSelectedShouldChangeAllVisibilityAround() {
		boolean[][] expected = new boolean[][] { 
				{ true, true, false, false },
				{ true, true, false, false }, 
				{ true, true, false, false },
				{ false, false, false, false }, 
				{ false, false, false, false },
				{ false, false, false, false } };

		assertEqualsVisibility(expected, vManager.select(0, 0));
	}
	
	@Test
	public void whenATileIsSelectedShouldChangeAllVisibilityAround2() {
		boolean[][] expected = new boolean[][] { 
				{ false, false, false, false },
				{ false, false, true, true }, 
				{ false, false, true, true },
				{ false, false, true, true }, 
				{ false, false, true, true },
				{ false, false, false, false } };

		assertEqualsVisibility(expected, vManager.select(3, 2));
	}
	
	@Test
	public void whenATileIsSelectedShouldChangeAllVisibilityAround3() {
		boolean[][] expected = new boolean[][] { 
				{ false, true, false, false },
				{ false, false, false, false }, 
				{ false, false, false, false },
				{ false, false, false, false }, 
				{ false, false, false, false },
				{ false, false, false, false } };

		assertEqualsVisibility(expected, vManager.select(1, 0));
	}

	private void assertEqualsVisibility(boolean[][] expected, MineField modified) {
		for (int i = 0; i < expected[0].length; ++i)
			for (int j = 0; j < expected.length; ++j)
				assertEquals("[" + i + "] [" + j + "]", expected[j][i],
						modified.isVisible(i, j));
	}
}

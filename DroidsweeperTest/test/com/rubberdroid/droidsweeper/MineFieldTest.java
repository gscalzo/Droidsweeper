package com.rubberdroid.droidsweeper;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MineFieldTest {
	private MineField mineField;

	@Before
	public void setUp() {
		int[][] v1 = { { 1, 2, Tiles.BOMB, 1 }, { 1, Tiles.BOMB, 2, 1 }, { 2, 2, 2, 1 },
				{ Tiles.BOMB, 2, 2, Tiles.BOMB }, { 3, Tiles.BOMB, 4, 2 }, { 2, Tiles.BOMB, Tiles.BOMB, 1 }, };
		mineField = new MineField(v1);
	}

	@Test
	public void twoMineFieldsShouldBeEqualsIfTheyContainTheSameElements() {
		int[][] v1 = { { 1, 2, Tiles.BOMB, 1 }, { 1, Tiles.BOMB, 2, 1 }, { 2, 2, 2, 1 },
				{ Tiles.BOMB, 2, 2, Tiles.BOMB }, { 3, Tiles.BOMB, 4, 2 }, { 2, Tiles.BOMB, Tiles.BOMB, 1 }, };
		int[][] v2 = { { 0, 2, Tiles.BOMB, 1 }, { 1, Tiles.BOMB, 2, 1 }, { 2, 2, 2, 1 },
				{ Tiles.BOMB, 2, 2, Tiles.BOMB }, { 3, Tiles.BOMB, 4, 2 }, { 2, Tiles.BOMB, Tiles.BOMB, 1 }, };
		MineField first = new MineField(v1);
		MineField second = new MineField(v2);

		assertFalse(first.equals(second));
		v2[0][0] = 1;
		assertFalse(first.equals(second));
		MineField third = new MineField(v2);
		assertEquals(first, third);
	}

	@Test
	public void aMineFieldShouldReturnTheValueOfATile() {
		assertEquals(1, mineField.valueAt(0, 0));
		assertEquals(3, mineField.valueAt(0, 4));
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void aMineFieldShoulThrowsAnExceptionIfTryToReadNegativeColumn() {
		mineField.valueAt(-1, 0);
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void aMineFieldShoulThrowsAnExceptionIfTryToReadNegativeRow() {
		mineField.valueAt(0, -1);
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void aMineFieldShoulThrowsAnExceptionIfExceedColumn() {
		mineField.valueAt(100, 0);
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void aMineFieldShoulThrowsAnExceptionIfExceedRow() {
		mineField.valueAt(0, 100);
	}

	@Test
	public void itShouldBePossibleChangeTheValueOfATile() {
		assertEquals(1, mineField.valueAt(0, 0));
		mineField.setValueAt(0, 0, 3);
		assertEquals(3, mineField.valueAt(0, 0));
	}

	@Test
	public void aMineFieldShouldReturnTheWidth() {
		assertEquals(4, mineField.width());
	}

	@Test
	public void aMineFieldShouldReturnTheHeight() {
		assertEquals(6, mineField.height());
	}

	@Test
	public void aMineFieldShouldShouldBeClonable() {
		assertEquals(1, mineField.valueAt(0, 0));
		MineField cloned = mineField.copy();
		mineField.setValueAt(0, 0, 5);
		assertEquals(5, mineField.valueAt(0, 0));
		assertEquals(1, cloned.valueAt(0, 0));
	}

	@Test
	public void aMineFieldShouldReturnIfContainAMine() {
		assertFalse(mineField.containsMine(0,0));
		assertTrue(mineField.containsMine(2,0));
	}


}

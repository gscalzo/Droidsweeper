package com.rubberdroid.droidsweeper;

import org.junit.Test;
import static org.junit.Assert.*;

public class MineFieldTest {
	@Test
	public void twoMineFieldsShouldBeEqualsIfTheyContainTheSameElements() {
		int[][] v1 = { { 1, 2, 10, 1 }, { 1, 10, 2, 1 }, { 2, 2, 2, 1 },
				{ 10, 2, 2, 10 }, { 3, 10, 4, 2 }, { 2, 10, 10, 1 }, };
		int[][] v2 = { { 0, 2, 10, 1 }, { 1, 10, 2, 1 }, { 2, 2, 2, 1 },
				{ 10, 2, 2, 10 }, { 3, 10, 4, 2 }, { 2, 10, 10, 1 }, };
		MineField first = new MineField(v1);
		MineField second = new MineField(v2);

		assertFalse(first.equals(second));
		v2[0][0] = 1;
		assertFalse(first.equals(second));
		MineField third = new MineField(v2);
		assertEquals(first, third);

	}

}

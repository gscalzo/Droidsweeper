package com.rubberdroid.droidsweeper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class PairTest {
	@Test
	public void twoPairsShouldBeEqualsWhenContainsEqualsNumber() {
		assertEquals(new Pair(1, 2), new Pair(1, 2));
	}
	
	@Test
	public void aPairShouldBeDifferentFromNonPair() {
		assertFalse(new Pair(1, 2).equals("1"));
		assertFalse(new Pair(1, 2).equals(1));
	}
}

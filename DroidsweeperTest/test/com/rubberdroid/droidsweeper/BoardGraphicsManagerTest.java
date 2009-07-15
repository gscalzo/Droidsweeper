package com.rubberdroid.droidsweeper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BoardGraphicsManagerTest {

	@Test
	public void managerShouldReturnCoordinatesOfTileWhenSpaceCoordinatesAreProvided() {
		BoardGraphicsManager manager = new BoardGraphicsManager(320, 480);
		assertEquals(new Pair(0, 0), manager.tileAt(0, 0));
		assertEquals(new Pair(1, 0), manager.tileAt(32, 0));
		assertEquals(new Pair(2, 3), manager.tileAt(64, 96));
	}

	@Test
	public void managerShouldReturnNotValidPairWhenCoordinatesAreOutFromBoard() {
		BoardGraphicsManager manager = new BoardGraphicsManager(320, 480);
		assertEquals(Pair.NOT_VALID, manager.tileAt(321, 30));
		assertEquals(Pair.NOT_VALID, manager.tileAt(31, 320));
	}

	@Test
	public void managerShouldReturnCoordinatesForASpecificTile() {
		BoardGraphicsManager manager = new BoardGraphicsManager(320, 480);
		assertEquals(new Pair(32, 64), manager.coordinatesFor(1,2));
	}
}

package com.rubberdroid.droidsweeper;

public class BoardGraphicsManager {
	private int w;
	private int tileSide;

	public BoardGraphicsManager(int w, int h) {
		this.w = w;
		tileSide = w / Tiles.PIXEL_FOR_TILE;
	}

	public Pair tileAt(int i, int j) {
		if (i >= w || j >= w)
			return Pair.NOT_VALID;
		return new Pair(i / tileSide, j / tileSide);
	}

	public Pair coordinatesFor(int i, int j) {
		return new Pair(i * tileSide, j * tileSide);
	}

}

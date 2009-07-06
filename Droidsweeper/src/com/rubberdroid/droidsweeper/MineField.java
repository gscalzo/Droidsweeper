package com.rubberdroid.droidsweeper;

public class MineField {
	private int[][] tiles;
	private boolean[][] tilesVisibility;

	public MineField(int[][] values) {
		createVisibilityMatrix(values);
		copyTilesMatrix(values);
	}

	private void copyTilesMatrix(int[][] values) {
		tiles = new int[values.length][values[0].length];
		for (int i = 0; i < tiles[0].length; ++i)
			for (int j = 0; j < tiles.length; ++j)
				tiles[j][i] = values[j][i];
	}

	private void createVisibilityMatrix(int[][] values) {
		tilesVisibility = new boolean[values.length][values[0].length];
	}

	@Override
	public boolean equals(Object aThat) {
		if (this == aThat)
			return true;
		if (!(aThat instanceof MineField))
			return false;
		MineField that = (MineField) aThat;
		for (int i = 0; i < tiles[0].length; ++i)
			for (int j = 0; j < tiles.length; ++j)
				if (tiles[j][i] != that.tiles[j][i])
					return false;

		return true;

	}

	public int valueAt(int i, int j) {
		return tiles[j][i];
	}

	public void setValueAt(int i, int j, int value) {
		tiles[j][i] = value;
	}

	public int width() {
		return tiles[0].length;
	}

	public int height() {
		return tiles.length;
	}

	public MineField copy() {
		return new MineField(tiles);
	}

	public void setVisible(int i, int j) {
		tilesVisibility[j][i] = true;
	}

	public boolean isVisible(int i, int j) {
		return tilesVisibility[j][i];
	}

	public boolean inBounds(int i, int j) {
		return 0 <= i && i < width() && 0 <= j && j < height();
	}

}

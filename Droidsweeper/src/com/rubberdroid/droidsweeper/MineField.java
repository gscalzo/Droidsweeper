package com.rubberdroid.droidsweeper;

public class MineField {
	private int[][] tiles;

	public MineField(int[][] values) {
		tiles = new int[values.length][values[0].length];
		for (int i = 0; i < tiles[0].length; ++i)
			for (int j = 0; j < tiles.length; ++j)
				tiles[j][i] = values[j][i];
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
}

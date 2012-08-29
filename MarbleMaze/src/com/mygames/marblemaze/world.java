package com.mygames.marblemaze;
import com.badlogic.gdx.math.MathUtils;


public class world 
{
	final int iSizeX;
	final int iSizeY;
	final int [][] ttTiles;
	public world (int sizeX, int sizeY)
	{		
		iSizeX = sizeX ;
		iSizeY = sizeY ;
		ttTiles = new int [iSizeX][iSizeY];
		populate ();
	}
	private void populate ()
	{
		int i = 0;
		for ( ;i < iSizeX; ++i)
		{
			int j = 0 ;
			for ( ;j < iSizeY; ++j)
			{
				ttTiles [i][j]= MathUtils.random(enumTile.minTileType(), enumTile.maxTileType());
			}
		}
	}
}

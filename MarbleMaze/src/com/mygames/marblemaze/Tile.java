package com.mygames.marblemaze;
import com.mygames.marblemaze.enumTile;

public class Tile 
{
	public final enumTile eType ;
	public final static int iTileWidth = 48 ;
	public final static int iTileHeight = 48 ;
	public final int iPosX ;
	public final int iPosY ;
	public Tile (int type, int posX, int posY)
	{
		iPosX = posX;
		iPosY = posY;
		eType = enumTile.fromInt(type);
	}
}

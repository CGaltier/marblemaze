package com.mygames.marblemaze;

public class Level
{
	final int iLevelNumber ;
	int iTimePlayed ;
	public world wWorld ;
	final int iSizeX;
	final int iSizeY;
	public Level ( int iLevel )
	{
		iLevelNumber = iLevel ;
		iTimePlayed = 0 ;
		iSizeX = iSizeY = 30 ;
		wWorld = new world (iSizeX, iSizeY);
	}
}

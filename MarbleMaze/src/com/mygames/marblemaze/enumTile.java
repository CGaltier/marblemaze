package com.mygames.marblemaze;

public enum enumTile 
{
	eTileVoid	  (0.0),
	eTileStandard (1.0),
	eTileGlass    (0.5),
	eTileWood     (1.0),
	eTileGlue     (2.0);
	
	private final double dFriction;
	
	enumTile (double friction)
	{
		dFriction = friction;
	}
	double friction () {return dFriction;}
	
	static int minTileType (){return 0;}
	static int maxTileType (){return 4;}
	static enumTile fromInt (int iType)
	{
		switch (iType)
		{
			case 0:
				return enumTile.eTileVoid ;
			case 1:
					return enumTile.eTileStandard ;
			case 2:
					return enumTile.eTileGlass;
			case 3:
					return enumTile.eTileGlue;
			case 4:
					return enumTile.eTileWood;
			default :
					return enumTile.eTileStandard;		
		}
	}

}

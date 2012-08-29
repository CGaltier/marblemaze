package com.mygames.marblemaze;

import com.badlogic.gdx.math.Vector2;

public class marble 
{
	final int radius = 32 ;
	Vector2 direction ;
	Vector2 position ;
	float speed ;
	public marble (float posX, float posY)
	{
		direction = new Vector2 (0,0);
		position = new Vector2 (0,0);
		speed = 0;
	}
}

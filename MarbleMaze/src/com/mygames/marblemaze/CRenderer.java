package com.mygames.marblemaze;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;

public class CRenderer 
{
	OrthographicCamera cam;
	SpriteBatch batch;
	final Matrix4 matrix = new Matrix4();
	
	public CRenderer()
	{
		batch = new SpriteBatch();
		cam = new OrthographicCamera((float)Gdx.graphics.getWidth(),(float)Gdx.graphics.getHeight());			
		cam.position.set(0, 0, 10);
		cam.direction.set(0, 0, -1);
		cam.near = 1;
		cam.far = 100;		
		matrix.setToRotation(new Vector3(1, 0, 0), 90);		

	}

	public void render(float delta, CControl control, Level lLevel, mediaManager mManager) 
	{
        // the following code clears the screen with the given RGB color (black)
        Gdx.gl.glClearColor( 0f, 0f, 0f, 1f );
        Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT );

		cam.update();		
 
		batch.setProjectionMatrix(cam.combined);
		batch.setTransformMatrix(matrix);
		batch.begin();
		for ( int x = 0 ; x < lLevel.wWorld.iSizeX ; x++)
		{
			for ( int y = 0 ; y < lLevel.wWorld.iSizeY ; y++)
			{
				int iTileType = lLevel.wWorld.ttTiles[x][y];
				Sprite spriteTile = mManager.getSpriteTile (enumTile.fromInt (iTileType));
				//if (spriteTile)
				{
					spriteTile.setPosition(x, y);
					spriteTile.draw (batch);
				}
			}
		}
		batch.end() ; 
	}
	
	public void dispose ()
	{
		batch.dispose();
	}

}

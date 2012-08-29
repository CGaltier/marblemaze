package com.mygames.marblemaze;



import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

public class MarbleMazeGame implements ApplicationListener {
	CControl control;
	OrthographicCamera camera ;
	SpriteBatch batch ;
	Rectangle bucket ;
	Array <Rectangle> raindrops ;
	long lastDropTime ;
	mediaManager mMediaManager;
	world wworld ;
	marble marble ;
	Vector2 cameraPos ;
	@Override
	public void create() {	
		control = new CControl();
		mMediaManager = new mediaManager (); 
		mMediaManager.loadDefault();
		
		mMediaManager.rainMusic.play();
		
		camera = new OrthographicCamera ();
		camera.setToOrtho(false,mMediaManager.iScreenWidth,mMediaManager.iScreenHeight);
		
		batch = new SpriteBatch();
		bucket = new Rectangle ();
		bucket.x = mMediaManager.iScreenWidth/2 - mMediaManager.iBucketWidth/2;
		bucket.y = 20 ;
		bucket.width = mMediaManager.iBucketWidth ;
		bucket.height = mMediaManager.iBucketHeight ;
		
		raindrops = new Array <Rectangle>();
		spawnRaindrop();
		//-------------
		wworld = new world (30,20);
		marble = new marble (0,0);
		cameraPos = new Vector2 (0,0);
	}


	@Override
	public void dispose() {
        mMediaManager.dispose();
		batch.dispose();
	}

	@Override
	public void render() 
	{
		//control.update();
		moveCamera (control.getDirection().mul(control.speed));
		
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		renderWorld();
		renderMarble();
		batch.end();		
		
		
	}
	public void moveCamera(Vector2 translation)
	{
		Vector2 newCamPos = cameraPos.add(translation) ;
		float xmax = (wworld.iSizeX * Tile.iTileWidth ) /2 ;
		float xmin = -xmax;
		float ymax = (wworld.iSizeY * Tile.iTileHeight ) /2 ;
		float ymin = -ymax ;
		if (newCamPos.x > xmax && translation.x > 0)
			translation.x = 0 ;
		else
			if (newCamPos.x < xmin && translation.x < 0)
				translation.x =  0 ;

		if (newCamPos.y> ymax && translation.y > 0)
			translation.y = 0 ;
		else
			if (newCamPos.y < ymin && translation.y < 0)
				translation.y =  0 ;
		
		
		camera.translate(translation);
		camera.update();
	}
	void renderMarble ()
	{
		
	}
	void renderWorld()
	{
		float iTopLeftX = mMediaManager.iScreenWidth / 2  - (wworld.iSizeX / 2) * Tile.iTileWidth;
		float iTopLeftY = mMediaManager.iScreenHeight/2   - (wworld.iSizeY / 2) * Tile.iTileHeight;
		int i ;
		for (i=0 ; i < wworld.iSizeX ;i++)
		{
			int j ;
			for (j=0 ; j < wworld.iSizeY ; j++)
			{
				switch (enumTile.fromInt(wworld.ttTiles[i][j]))
				{
					case eTileStandard :
						batch.draw (mMediaManager.tile_standard_tex, iTopLeftX + i*Tile.iTileWidth, 
													   iTopLeftY + j*Tile.iTileHeight);
						break;
					case eTileWood :
						batch.draw (mMediaManager.tile_wood_tex, iTopLeftX + i*Tile.iTileWidth,
													   iTopLeftY + j*Tile.iTileHeight);
						break;
					case eTileGlass:
						batch.draw (mMediaManager.tile_glass_tex, iTopLeftX + i*Tile.iTileWidth,
													   iTopLeftY + j*Tile.iTileHeight);
						break;
					case eTileGlue:
						batch.draw (mMediaManager.tile_glue_tex, iTopLeftX + i*Tile.iTileWidth,
													   iTopLeftY + j*Tile.iTileHeight);
						break;
				}
			}
		}
		
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
	
	private void spawnRaindrop()
	{
		Rectangle raindrop = new Rectangle() ;
		raindrop.x = MathUtils.random(0,mMediaManager.iScreenWidth-mMediaManager.iDropWidth);
		raindrop.y = mMediaManager.iScreenHeight ;
		raindrop.width = mMediaManager.iDropWidth ;
		raindrop.height = mMediaManager.iDropHeight ;
		raindrops.add(raindrop);
		lastDropTime = TimeUtils.nanoTime();
	}
}
 
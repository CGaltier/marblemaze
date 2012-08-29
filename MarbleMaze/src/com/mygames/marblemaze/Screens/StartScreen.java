package com.mygames.marblemaze.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.mygames.marblemaze.CControl;
import com.mygames.marblemaze.CRenderer;
import com.mygames.marblemaze.GameMarbleMaze;
import com.mygames.marblemaze.Level;
import com.mygames.marblemaze.mediaManager;

public class StartScreen extends AbstractScreen
{
	mediaManager mManager ;
	Level lLevel ;
	CControl control ;
	CRenderer renderer;
	public StartScreen (GameMarbleMaze game)
	{
		super (game);
		mManager = new mediaManager();
		mManager.loadDefault();
		lLevel = new Level (0);
		control = new CControl ();
		renderer = new CRenderer ();
	}
	@Override
	public void render(float delta) 
	{
		control.update(delta);
        renderer.render(delta, control, lLevel, mManager);
        
	}

	@Override
	public void resize(int width, int height) 
	{
		
	}

	@Override
	public void show() 
	{
		Gdx.app.log( GameMarbleMaze.LOG, "Showing screen: " + getName() );
	}

	@Override
	public void hide() 
	{
		Gdx.app.log( GameMarbleMaze.LOG, "Hiding screen: " + getName() );
		dispose();
	}

	@Override
	public void pause() 
	{
		Gdx.app.log( GameMarbleMaze.LOG, "Pausing screen: " + getName() );
	}

	@Override
	public void resume() 
	{
		{
			Gdx.app.log( GameMarbleMaze.LOG, "Resuming screen: " + getName() );
		}
	}

	@Override
	public void dispose() 	
	{
		super.dispose();
		this.mManager.dispose();
	}
}

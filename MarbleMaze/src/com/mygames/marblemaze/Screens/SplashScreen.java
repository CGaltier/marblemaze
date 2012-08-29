package com.mygames.marblemaze.Screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.OnActionCompleted;
import com.badlogic.gdx.scenes.scene2d.actions.Delay;
import com.badlogic.gdx.scenes.scene2d.actions.FadeIn;
import com.badlogic.gdx.scenes.scene2d.actions.FadeOut;
import com.badlogic.gdx.scenes.scene2d.actions.Sequence;
import com.badlogic.gdx.scenes.scene2d.ui.Align;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Scaling;
import com.mygames.marblemaze.GameMarbleMaze;

public class SplashScreen extends AbstractScreen
{
	Texture splashTexture ;



	public SplashScreen (GameMarbleMaze game)
	{
		super (game);
	}
	

	@Override
	public void show() 
	{
		super.show();

	}

	@Override
	public void dispose() 
	{
		super.dispose();
		splashTexture.dispose();		
	}

	@Override
	public void resize (int width, int height)
	{
		super.resize(width, height);
	    Image splashImage ;
		 
		splashTexture = new Texture ("data/splash.png");
		splashTexture.setFilter (TextureFilter.Linear, TextureFilter.Linear);	
		TextureRegion splashTextureRegion = new TextureRegion (splashTexture, 0,0,640,480);
		splashImage = new Image (splashTextureRegion, Scaling.stretch, Align.BOTTOM | Align.LEFT);
		splashImage.color.a = 0f;
		splashImage.width = width;
		splashImage.height = height ;
		Sequence actions = Sequence.$(FadeIn.$(0.75f),Delay.$( FadeOut.$(0.75f), 1.75f ));
		actions.setCompletionListener(new OnActionCompleted()
		{
			@Override
			public void completed (Action action)
			{
				game.setScreen(game.getMenuScreen());
			}
		}
		);
		splashImage.action(actions);
		stage.addActor (splashImage);		
		//splashImage.invalidateHierarchy();		
	}
}

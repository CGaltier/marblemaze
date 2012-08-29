package com.mygames.marblemaze.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.FadeIn;
import com.badlogic.gdx.scenes.scene2d.ui.ClickListener;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.tablelayout.Table;
import com.badlogic.gdx.scenes.scene2d.ui.tablelayout.TableLayout;
import com.mygames.marblemaze.GameMarbleMaze;

public class HallOfFameScreen extends AbstractScreen
{
	//private Table table;
	public HallOfFameScreen (GameMarbleMaze game)
	{
		super (game);
	}
	@Override
	public void show ()
	{
		super.show();
		
	    
	}
	@Override
	public void resize (int width, int height)
	{
		super.resize(width, height);
		Table table = new Table (getSkin());
		table.width = width ;
		table.height = height ;
		
		//Sequence actions = Sequence.$(FadeIn.$(0.75f),Delay.$( FadeOut.$(0.75f), 1.75f ));
		table.color.a = 0f;
		table.action(FadeIn.$(0.75f));
		stage.addActor(table);
		TableLayout layout = table.getTableLayout();
		
		String level1Highscore;
		level1Highscore = "000";
		Label episode1Highscore = new Label (level1Highscore,getSkin());
		layout.register ("episode1Highscore", episode1Highscore );
		
		String level2Highscore;
		level2Highscore = "000";
		Label episode2Highscore = new Label (level2Highscore,getSkin());
		layout.register ("episode2Highscore", episode2Highscore );
		
		String level3Highscore;
		level3Highscore = "000";
		Label episode3Highscore = new Label (level3Highscore,getSkin());
		layout.register ("episode3Highscore", episode3Highscore );
		
		TextButton backButton = new TextButton ("Back to menu",getSkin());
		backButton.setClickListener(new ClickListener()
		{
			@Override
			public void click ( Actor actor, float x, float y)
			{
				game.setScreen(game.getMenuScreen());
			}			
		}) ;
		layout.register ("HallofFameButton", backButton);		
		
		layout.parse(Gdx.files.internal("data/layout-menus/halloffame.txt").readString());		

		table.invalidateHierarchy();
	}
}

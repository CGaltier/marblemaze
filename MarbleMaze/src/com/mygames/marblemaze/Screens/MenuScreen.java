package com.mygames.marblemaze.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.FadeIn;
import com.badlogic.gdx.scenes.scene2d.ui.ClickListener;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.tablelayout.Table;
import com.badlogic.gdx.scenes.scene2d.ui.tablelayout.TableLayout;
import com.mygames.marblemaze.GameMarbleMaze;

public class MenuScreen extends AbstractScreen
{
	private Table table ;
	public MenuScreen (GameMarbleMaze game)
	{
		super (game);
	}
	@Override
	public void show ()
	{
		Skin skin = super.getSkin();
		
	    table = new Table (getSkin());

		
		//Sequence actions = Sequence.$(FadeIn.$(0.75f),Delay.$( FadeOut.$(0.75f), 1.75f ));
		table.color.a = 0f;
		table.action(FadeIn.$(0.75f));
		stage.addActor(table);
		TableLayout layout = table.getTableLayout();
		
		TextButton startGameButton = new TextButton ("Start Game",skin);
		startGameButton.setClickListener(new ClickListener()
		{
			@Override
			public void click ( Actor actor, float x, float y)
			{
				game.setScreen(game.getStartScreen());
			}
		}) ;
		layout.register ("startGameButton", startGameButton);
		stage.addActor(startGameButton);
		
		TextButton optionsButton = new TextButton ("Options",skin);
		optionsButton .setClickListener(new ClickListener()
		{
			@Override
			public void click ( Actor actor, float x, float y)
			{
				game.setScreen(game.getOptionScreen());
			}			
		}) ;
		layout.register ("OptionsButton", optionsButton );
		stage.addActor(optionsButton);
		
		TextButton hallOfFameButton = new TextButton ("Hall of Fame",skin);
		hallOfFameButton.setClickListener(new ClickListener()
		{
			@Override
			public void click ( Actor actor, float x, float y)
			{
				game.setScreen(game.getHOFScreen());
			}			
		}) ;
		layout.register ("HallofFameButton", hallOfFameButton);		
		stage.addActor(hallOfFameButton);
		
		layout.parse(Gdx.files.internal("data/layout-menus/mainmenu.txt").readString());
		super.show();
	}
	@Override
	public void resize (int width, int height)
	{
		super.resize(width, height);
		table.width = width ;
		table.height = height ;
		table.invalidateHierarchy();
	}
}

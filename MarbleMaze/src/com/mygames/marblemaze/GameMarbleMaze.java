package com.mygames.marblemaze;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.FPSLogger;
import com.mygames.marblemaze.Screens.HallOfFameScreen;
import com.mygames.marblemaze.Screens.LevelScreen;
import com.mygames.marblemaze.Screens.MenuScreen;
import com.mygames.marblemaze.Screens.OptionScreen;
import com.mygames.marblemaze.Screens.ProfileScreen;
import com.mygames.marblemaze.Screens.SplashScreen;
import com.mygames.marblemaze.Screens.StartScreen;

public class GameMarbleMaze extends Game 
{
	public static final String LOG = GameMarbleMaze.class.getName();
	private FPSLogger fpsLogger ;

	public SplashScreen getSplashScreen()
	{
		return new SplashScreen (this);
	}
	public HallOfFameScreen getHOFScreen()
	{
		return new HallOfFameScreen (this);
	}
	public MenuScreen getMenuScreen()
	{
		return new MenuScreen (this);
	}
	public LevelScreen getLevelScreen()
	{
		return new LevelScreen (this);
	}
	public OptionScreen getOptionScreen()
	{
		return new OptionScreen (this);
	}
	public ProfileScreen getProfileScreen()
	{
		return new ProfileScreen (this);
	}
	public StartScreen getStartScreen()
	{
		return new StartScreen (this);
	}
	//----------------------------------Game
	@Override
    public void create()
    {
        Gdx.app.log( GameMarbleMaze.LOG, "Creating game" );
        fpsLogger = new FPSLogger();
        setScreen( getSplashScreen() );
    }

    @Override
    public void resize(
        int width,
        int height )
    {
        super.resize( width, height );
        Gdx.app.log( GameMarbleMaze.LOG, "Resizing game to: " + width + " x " + height );
    }

    @Override
    public void render()
    {
        super.render();

        // output the current FPS
        fpsLogger.log();
    }

    @Override
    public void pause()
    {
        super.pause();
        Gdx.app.log( GameMarbleMaze.LOG, "Pausing game" );
    }

    @Override
    public void resume()
    {
        super.resume();
        Gdx.app.log( GameMarbleMaze.LOG, "Resuming game" );
    }

    @Override
    public void setScreen(
        Screen screen )
    {
        super.setScreen( screen );
        Gdx.app.log( GameMarbleMaze.LOG, "Setting screen: " + screen.getClass().getSimpleName() );
    }

    @Override
    public void dispose()
    {
        super.dispose();
        Gdx.app.log( GameMarbleMaze.LOG, "Disposing game" );
    }
}

package com.mygames.marblemaze;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygames.marblemaze.GameMarbleMaze;


public class GameMarbleMazeLauncher
{
    public static void main( String[] args )
        {
            // create the listener that will receive the application events
            ApplicationListener listener = new GameMarbleMaze();

            // whether to use OpenGL ES 2.0
    		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
    		cfg.title = "MarbleMaze";
    		cfg.useGL20 = true;
    		cfg.width = 800;
    		cfg.height = 480;     
            // create the game
    		new LwjglApplication (listener, cfg);

        }
}

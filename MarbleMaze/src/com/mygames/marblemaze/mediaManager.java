package com.mygames.marblemaze;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class mediaManager 
{
	final public int iBucketWidth = 48 ;
	final public int iBucketHeight = 48;
	final public int iDropWidth = 48 ;
	final public int iDropHeight  = 48 ;
	final public int iScreenWidth = 800 ;
	final public int iScreenHeight  = 480 ;
	
	Texture dropImage ;
	Texture bucketImage ;
	Texture tile_wood_tex;
	Texture tile_glass_tex;
	Texture tile_glue_tex;
	Texture tile_standard_tex;
	Texture marble_tex;
	
	Sprite tile_wood;
	Sprite tile_glass;
	Sprite tile_glue;
	Sprite tile_standard;
	
	Sound dropSound;
	Music rainMusic ;
	public mediaManager ()
	{}
	public void loadDefault ()
	{
		dropImage = new Texture (Gdx.files.internal("data/droplet.png"));
		bucketImage = new Texture (Gdx.files.internal("data/bucket.png"));
		
		tile_wood_tex     = new Texture (Gdx.files.internal("data/tile_wood.png"));;
		tile_glass_tex    = new Texture (Gdx.files.internal("data/tile_glass.png"));;
		tile_glue_tex     = new Texture (Gdx.files.internal("data/tile_glue.png"));;
		tile_standard_tex = new Texture (Gdx.files.internal("data/tile_standard.png"));;
		marble_tex        = new Texture (Gdx.files.internal("data/marble.png"));;
		
		
		 tile_wood = new Sprite (tile_wood_tex);
		 tile_glass = new Sprite (tile_glass_tex);
		 tile_glue = new Sprite (tile_glue_tex);
		 tile_standard = new Sprite (tile_standard_tex);
		
		dropSound = Gdx.audio.newSound(Gdx.files.internal("data/drop.wav"));
		rainMusic = Gdx.audio.newMusic(Gdx.files.internal("data/rain.mp3"));	
		rainMusic.setLooping(true);
	}
	public void dispose ()
	{
		bucketImage.dispose();
		dropImage.dispose();
		dropSound.dispose();
		rainMusic.dispose();
		
		tile_wood_tex.dispose();     
		tile_glass_tex.dispose();    
		tile_glue_tex.dispose();     
		tile_standard_tex.dispose(); 
		marble_tex.dispose(); 
	}
	public Sprite getSpriteTile(enumTile tile) 
	{
		switch (tile)
		{
			case eTileVoid:
				return tile_standard ;
			case eTileStandard:
				return tile_standard ;
			case eTileGlass:
				return tile_glass;
			case eTileGlue:
				return tile_glue;
			case eTileWood:
				return tile_wood;
			default :
				return tile_standard ;	
		}
	}
}

package com.mygames.marblemaze;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Peripheral;
import com.badlogic.gdx.input.RemoteInput;
import com.badlogic.gdx.math.Vector2;

public class CControl 
{
	int Orientation ;
	final com.badlogic.gdx.Input.Orientation  NativeOrientation ;
	final boolean bAvailableAccelerometer ;
	final RemoteInput receiver ;
	float accelX ;
	float accelY ;
	float accelZ ;
	float speed ;
	public Vector2 direction;
	public CControl ()
	{
	    receiver = new RemoteInput(8191);
		
		bAvailableAccelerometer = Gdx.input.isPeripheralAvailable(Peripheral.Accelerometer);
		if (bAvailableAccelerometer)
		{
			NativeOrientation = Gdx.input.getNativeOrientation();
		}
		else
		{
			NativeOrientation = com.badlogic.gdx.Input.Orientation.Portrait ;
			Gdx.input = receiver ;

		}
		direction = new Vector2 ();
		direction.set(0, 0);
		speed = 0;
	}
	public void update (float delta)
	{
		//application in landscape mode
		if (bAvailableAccelerometer)
		{
			accelY = Gdx.input.getAccelerometerX();
			accelX = Gdx.input.getAccelerometerY()*-1;
			accelZ = Gdx.input.getAccelerometerZ();
		}
		else
		{
			accelY = receiver.getAccelerometerX();
			accelX = receiver.getAccelerometerY()*-1;
			
			/*accelX = Gdx.input.getDeltaX();
			accelY = Gdx.input.getDeltaY();*/
			accelZ = 0;
		}
		direction.set(accelX, accelY);
		direction = direction.nor().mul(-1);
		speed = 10-Math.abs(accelZ)*2;
	}
	public Vector2 getDirection ()
	{
		return direction ;
	}
	public float getSpeed ()
	{
		return speed ;
	}
	
}

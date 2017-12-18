package de.svdragster.evolution.entity;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Created by Sven on 18.12.2017.
 */
public abstract class Entity {
	
	float x;
	float y;
	
	public Entity(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public abstract void update();
	
	public abstract void render(ShapeRenderer renderer);
	
	public float getX() {
		return x;
	}
	
	public void setX(float x) {
		this.x = x;
	}
	
	public float getY() {
		return y;
	}
	
	public void setY(float y) {
		this.y = y;
	}
	
}

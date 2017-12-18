package de.svdragster.evolution.entity;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Created by Sven on 18.12.2017.
 */
public class EntityDot extends Entity {
	
	int color = 0;
	
	public EntityDot(float x, float y, int color) {
		super(x, y);
		this.color = color;
	}
	
	@Override
	public void update() {
	
	}
	
	@Override
	public void render(ShapeRenderer renderer) {
		if (color == 100) {
			renderer.setColor(1f, 1f, 1f, 1);
			renderer.circle(x, y, 2);
			return;
		} else if (color == 101) {
			renderer.setColor(0f, 0f, 0f, 1);
			renderer.circle(x, y, 2);
			return;
		}
		if (color == 1) {
			renderer.setColor(0f, 0.5f, 0.5f, 1);
		} else {
			renderer.setColor(0.5f, 0.0f, 0.5f, 1);
		}
		renderer.circle(x, y, 5);
	}
}

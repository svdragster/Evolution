package de.svdragster.evolution.entity;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import de.svdragster.evolution.entity.components.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sven on 18.12.2017.
 */
public class EntityLiving extends Entity {

	private float health = 100;
	private float food = 0;
	
	private int age = 0;
	
	private List<Component> componentList;
	
	public EntityLiving(float x, float y) {
		super(x, y);
		componentList = new ArrayList<>();
	}
	
	@Override
	public void update() {
		age++;
	}
	
	@Override
	public void render(ShapeRenderer renderer) {
		renderer.setColor(0f, 0.5f, 0.5f, 1);
		renderer.circle(x, y, 5);
	}
	
	public List<Component> getComponentList() {
		return componentList;
	}
	
	public void setComponentList(List<Component> componentList) {
		this.componentList = componentList;
	}
	
	public float getHealth() {
		return health;
	}
	
	public void setHealth(float health) {
		this.health = health;
	}
	
	public float getFood() {
		return food;
	}
	
	public void setFood(float food) {
		this.food = food;
	}
}

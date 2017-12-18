package de.svdragster.evolution.entity.components;

import de.svdragster.evolution.entity.EntityLiving;

/**
 * Created by Sven on 18.12.2017.
 */
public class ComponentMove extends Component {
	
	private float maxSpeed = 1;
	
	private int directionX = 1;
	private int directionY = 1;
	
	public ComponentMove(float maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	
	@Override
	public void update(EntityLiving entity) {
	
	}
}

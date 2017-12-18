package de.svdragster.evolution;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import de.svdragster.evolution.entity.Entity;
import de.svdragster.evolution.entity.EntityDot;
import de.svdragster.evolution.neural.Perceptron;
import de.svdragster.evolution.neural.Point;

import java.util.ArrayList;
import java.util.List;

public class Main extends ApplicationAdapter {
	
	public static Main instance;
	
	private OrthographicCamera cam;
	private List<Entity> entities = new ArrayList<>();
	private ShapeRenderer renderer;
	
	
	// Perceptron stuff
	Perceptron perceptron = new Perceptron(3);
	
	Point[] points = new Point[3000];
	
	private float lineX1 = -1;
	private float lineY1 = someFunction(lineX1);
	private float lineX2 = 1;
	private float lineY2 = someFunction(lineX2);
	
	public float someFunction(float x) {
		return -0.65f * x - 0.1245f;
	}
	
	@Override
	public void create () {
		instance = this;
		
		renderer = new ShapeRenderer();
		
		
		cam = new OrthographicCamera(100, 100);
		cam.zoom = 7;
		cam.position.set(250, 250, 0);
		//cam.position.set(cam.viewportWidth / 2f, cam.viewportHeight / 2f, 0);
		cam.update();
		
		//entities.add(new EntityLiving(0, 0));
		
		
		/////////////////////
		
		for (int i=0; i<points.length; i++) {
			points[i] = new Point();
		}
		for (Point p : points) {
			p.show();
		}
		/*for (Point p : points) {
			float[] input = new float[]{
					p.getX(),
					p.getY()
			};
			
			int guess = perceptron.guess(input);
			if (guess == p.getLabel()) {
				addDot(p.getX(), p.getY(), 100);
			} else {
				addDot(p.getX(), p.getY(), 101);
			}
		}*/
		
		
		
		//float[] inputs = new float[]{-1, 0.5f, 1};
		//int result = perceptron.guess(inputs);
		//System.out.println(result);
		
		/////////////////////
	}

	@Override
	public void render () {
		handleInput();
		
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		renderer.setProjectionMatrix(cam.combined);
		
		renderer.begin(ShapeRenderer.ShapeType.Filled);
		
		renderer.setColor(0.05f, 0.25f, 0.05f, 1);
		renderer.rect(0, 0, 500, 500);
		
		// line
		renderer.setColor(0.00f, 0.0f, 0.05f, 1);
		renderer.line((lineX1+1)*Point.WIDTH/2, (lineY1+1)*Point.HEIGHT/2, (lineX2+1)*Point.WIDTH/2, (lineY2+1)*Point.HEIGHT/2);
		
		renderer.setColor(1f, 1f, 1f, 1);
		renderer.line((lineX1+1)*Point.WIDTH/2,
				(perceptron.guessY(lineX1)+1)*Point.HEIGHT/2,
				(lineX2+1)*Point.WIDTH/2,
				(perceptron.guessY(lineX2)+1)*Point.HEIGHT/2);
		
		for (Entity entity : entities) {
			entity.render(renderer);
		}
		
		renderer.end();
		
	}
	
	public void trainAll() {
		entities.clear();
		for (Point p : points) {
			p.show();
		}
		for (Point p : points) {
			float[] input = new float[] {
					p.getX(),
					p.getY(),
					p.getBias()
			};
			perceptron.train(input,
					p.getLabel());
			
			int guess = perceptron.guess(input);
			if (guess == p.getLabel()) {
				addDot(p.getMappedX(), p.getMappedY(), 100);
			} else {
				addDot(p.getMappedX(), p.getMappedY(), 101);
			}
		}
		
	}
	
	private boolean lastSpace = false;
	private void handleInput() {
		if (Gdx.input.isKeyPressed(Input.Keys.E)) {
			cam.zoom += 0.04;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.Q)) {
			cam.zoom -= 0.04;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.A)) {
			cam.translate(-3, 0, 0);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.D)) {
			cam.translate(3, 0, 0);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.S)) {
			cam.translate(0, -3, 0);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.W)) {
			cam.translate(0, 3, 0);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.SPACE)/* && !lastSpace*/) {
			lastSpace = true;
			trainAll();
		}
		if (!Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
			lastSpace = false;
		}
		cam.update();
	}
	
	@Override
	public void dispose () {
		renderer.dispose();
	}
	
	public void addDot(float x, float y, int label) {
		entities.add(new EntityDot(x, y, label));
	}
}

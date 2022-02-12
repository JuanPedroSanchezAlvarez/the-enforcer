package com.theenforcer.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.theenforcer.game.screen.MainMenuScreen;

public class TheEnforcerGame extends Game {

	public SpriteBatch batch;
	public ShapeRenderer shape;
	public BitmapFont font;

	public void create () {
		batch = new SpriteBatch();
		shape = new ShapeRenderer();
		font = new BitmapFont(); // use libGDX's default Arial font 15pt
		this.setScreen(new MainMenuScreen(this));
	}

	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		shape.dispose();
		font.dispose();
	}

}

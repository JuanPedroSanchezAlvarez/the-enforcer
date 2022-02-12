package com.theenforcer.game.character;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;

public class MainCharacter extends Character {

    public MainCharacter(final Circle circle, final Texture image, final int velocity) {
        super(circle, image, velocity);
    }

    public void processInputs() {
        super.processInputs();
        if (Gdx.input.isKeyPressed(Input.Keys.A)) circle.x -= velocity * Gdx.graphics.getDeltaTime();
        if (Gdx.input.isKeyPressed(Input.Keys.D)) circle.x += velocity * Gdx.graphics.getDeltaTime();
        if (Gdx.input.isKeyPressed(Input.Keys.S)) circle.y -= velocity * Gdx.graphics.getDeltaTime();
        if (Gdx.input.isKeyPressed(Input.Keys.W)) circle.y += velocity * Gdx.graphics.getDeltaTime();
    }

    public void update() {
        super.update();
        if (circle.x < 15) circle.x = 15;
        if (circle.x > 800 - 15) circle.x = 800 - 15;
    }

    public void render(final SpriteBatch batch) {
        super.render(batch);
    }

}

package com.theenforcer.game.character;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Circle;

public abstract class Character {

    protected Circle circle;
    protected TextureRegion image;
    protected int speed;
    protected float rotationAngle;

    protected void processInputs() {}

    protected void update() {}

    protected void render(final SpriteBatch batch) {
        batch.draw(image, circle.x - circle.radius, circle.y - circle.radius, circle.radius, circle.radius, circle.radius * 2, circle.radius * 2, 1, 1, rotationAngle);
    }

}

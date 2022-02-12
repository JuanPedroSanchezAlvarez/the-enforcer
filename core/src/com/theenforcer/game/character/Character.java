package com.theenforcer.game.character;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;

public abstract class Character {

    protected final Circle circle;
    protected final Texture image;
    protected final float circleDiameter;
    protected final int velocity;

    protected Character(final Circle circle, final Texture image, final int velocity) {
        this.circle = circle;
        this.circleDiameter = circle.radius * 2;
        this.image = image;
        this.velocity = velocity;
    }

    protected void processInputs() {}

    protected void update() {}

    protected void render(final SpriteBatch batch) {
        batch.draw(image, circle.x - circle.radius, circle.y - circle.radius, circleDiameter, circleDiameter);
    }

}

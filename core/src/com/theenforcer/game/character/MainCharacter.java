package com.theenforcer.game.character;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Circle;

public class MainCharacter extends Character {

    private boolean movingLeft;
    private boolean movingRight;
    private boolean movingUp;
    private boolean movingDown;

    public MainCharacter() {
        this.circle = new Circle(0, 0, ConstantsCharacter.CHARACTER_RADIUS_SMALL);
        this.image = new TextureRegion(new Texture(Gdx.files.internal("characters/main-character.png")));
        this.speed = ConstantsCharacter.CHARACTER_SPEED_NORMAL;
        this.rotationAngle = 0;

        this.movingLeft = false;
        this.movingRight = false;
        this.movingUp = false;
        this.movingDown = false;
    }

    public void processInputs() {
        super.processInputs();
        movingLeft = Gdx.input.isKeyPressed(Input.Keys.A) && !Gdx.input.isKeyPressed(Input.Keys.D);
        movingRight = Gdx.input.isKeyPressed(Input.Keys.D) && !Gdx.input.isKeyPressed(Input.Keys.A);
        movingUp = Gdx.input.isKeyPressed(Input.Keys.W) && !Gdx.input.isKeyPressed(Input.Keys.S);
        movingDown = Gdx.input.isKeyPressed(Input.Keys.S) && !Gdx.input.isKeyPressed(Input.Keys.W);

        if (movingUp && !movingLeft && !movingRight) { rotationAngle = 0; }
        else if (movingUp && movingLeft) { rotationAngle = 45; }
        else if (movingLeft && !movingUp && !movingDown) { rotationAngle = 90; }
        else if (movingLeft && movingDown) { rotationAngle = 135; }
        else if (movingDown && !movingLeft && !movingRight) { rotationAngle = 180; }
        else if (movingDown && movingRight) { rotationAngle = 225; }
        else if (movingRight && !movingUp && !movingDown) { rotationAngle = 270; }
        else if (movingRight && movingUp) { rotationAngle = 315; }
    }

    public void update() {
        super.update();
        if (movingLeft) { circle.x -= speed * Gdx.graphics.getDeltaTime(); } else if (movingRight) { circle.x += speed * Gdx.graphics.getDeltaTime(); }
        if (movingDown) { circle.y -= speed * Gdx.graphics.getDeltaTime(); } else if (movingUp) { circle.y += speed * Gdx.graphics.getDeltaTime(); }

        if (circle.x < 15) circle.x = 15;
        if (circle.x > 800 - 15) circle.x = 800 - 15;
    }

    public void render(final SpriteBatch batch) {
        super.render(batch);
    }

}

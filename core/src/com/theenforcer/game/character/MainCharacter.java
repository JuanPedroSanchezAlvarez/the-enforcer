package com.theenforcer.game.character;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.theenforcer.game.configuration.ConstantsConfiguration;

public class MainCharacter extends Character {

    private boolean movingLeft;
    private boolean movingRight;
    private boolean movingUp;
    private boolean movingDown;
    private TextureRegion imageBody;
    private Vector2 vectorRotationBody;

    public MainCharacter() {
        this.circle = new Circle(0, 0, ConstantsCharacter.CHARACTER_RADIUS_SMALL);
        this.image = new TextureRegion(new Texture(Gdx.files.internal("img/characters/main-character.png")));
        this.speed = ConstantsCharacter.CHARACTER_SPEED_NORMAL;
        this.rotationAngle = 0;

        this.movingLeft = false;
        this.movingRight = false;
        this.movingUp = false;
        this.movingDown = false;
        this.imageBody = new TextureRegion(new Texture(Gdx.files.internal("img/characters/main-character2.png")));
        this.vectorRotationBody = new Vector2(0, 0);
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

        vectorRotationBody.set(Gdx.input.getX() - circle.x, ConstantsConfiguration.SCREEN_HEIGHT - Gdx.input.getY() - circle.y);
    }

    public void update() {
        super.update();
        if (movingLeft) { circle.x -= speed * Gdx.graphics.getDeltaTime(); } else if (movingRight) { circle.x += speed * Gdx.graphics.getDeltaTime(); }
        if (movingDown) { circle.y -= speed * Gdx.graphics.getDeltaTime(); } else if (movingUp) { circle.y += speed * Gdx.graphics.getDeltaTime(); }
    }

    public void render(final SpriteBatch batch) {
        super.render(batch);
        batch.draw(imageBody, circle.x - circle.radius, circle.y - circle.radius, circle.radius, circle.radius, circle.radius * 2, circle.radius * 2, 1, 1, vectorRotationBody.angleDeg() -90);
    }

}

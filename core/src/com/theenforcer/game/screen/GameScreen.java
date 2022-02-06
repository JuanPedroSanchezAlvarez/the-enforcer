package com.theenforcer.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.utils.ScreenUtils;
import com.theenforcer.game.TheEnforcerGame;
import com.theenforcer.game.configuration.ConstantsConfiguration;

public class GameScreen implements Screen {

    private final TheEnforcerGame game;
    private final OrthographicCamera camera;

    private final Texture imgMainCharacter;
    private final Circle mainCharacter;

    public GameScreen(final TheEnforcerGame game) {
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, ConstantsConfiguration.SCREEN_WIDTH, ConstantsConfiguration.SCREEN_HEIGHT);

        imgMainCharacter = new Texture(Gdx.files.internal("characters/main-character.png"));
        mainCharacter = new Circle(800 / 2 - 64 / 2, 20, 15);
    }

    @Override
    public void show() {}

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.GRAY);
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.batch.draw(imgMainCharacter, mainCharacter.x - 15, mainCharacter.y - 15, mainCharacter.radius * 2, mainCharacter.radius * 2);
        game.batch.end();

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.isKeyPressed(Input.Keys.A)) mainCharacter.x -= 200 * Gdx.graphics.getDeltaTime();
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.isKeyPressed(Input.Keys.D)) mainCharacter.x += 200 * Gdx.graphics.getDeltaTime();
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN) || Gdx.input.isKeyPressed(Input.Keys.S)) mainCharacter.y -= 200 * Gdx.graphics.getDeltaTime();
        if (Gdx.input.isKeyPressed(Input.Keys.UP) || Gdx.input.isKeyPressed(Input.Keys.W)) mainCharacter.y += 200 * Gdx.graphics.getDeltaTime();

        if (mainCharacter.x < 15) mainCharacter.x = 15;
        if (mainCharacter.x > 800 - 15) mainCharacter.x = 800 - 15;
    }

    @Override
    public void resize(int width, int height) {}

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose() {
        imgMainCharacter.dispose();
    }

}

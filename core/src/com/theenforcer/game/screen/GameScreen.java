package com.theenforcer.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.utils.ScreenUtils;
import com.theenforcer.game.TheEnforcerGame;
import com.theenforcer.game.character.MainCharacter;
import com.theenforcer.game.configuration.ConstantsConfiguration;
import com.theenforcer.game.util.MouseCursorUtils;

public class GameScreen implements Screen {

    private final TheEnforcerGame game;
    private final OrthographicCamera camera;

    private final Texture background;

    private final MainCharacter mainCharacter;

    public GameScreen(final TheEnforcerGame game) {
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, ConstantsConfiguration.SCREEN_WIDTH, ConstantsConfiguration.SCREEN_HEIGHT);

        background = new Texture(Gdx.files.internal("hephaestus.png"));

        Gdx.graphics.setCursor(MouseCursorUtils.getGameCursor());
        mainCharacter = new MainCharacter();
    }

    @Override
    public void show() {}

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.GRAY);
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        // PROCESS INPUT
        mainCharacter.processInputs();

        // UPDATE
        mainCharacter.update();

        // RENDER
        game.batch.begin();
        game.batch.draw(background, 0, 0);
        mainCharacter.render(game.batch);
        game.batch.end();

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
    public void dispose() {}

}

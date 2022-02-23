package com.theenforcer.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.theenforcer.game.TheEnforcerGame;
import com.theenforcer.game.button.ConstantsButton;
import com.theenforcer.game.button.TextButton;
import com.theenforcer.game.configuration.ConstantsConfiguration;
import com.theenforcer.game.util.MouseCursorUtils;

public class MainMenuScreen implements Screen {

    private final TheEnforcerGame game;
    private final OrthographicCamera camera;

    private final Texture background;
    private final TextButton startButton;

    public MainMenuScreen(final TheEnforcerGame game) {
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, ConstantsConfiguration.SCREEN_WIDTH, ConstantsConfiguration.SCREEN_HEIGHT);

        background = new Texture(Gdx.files.internal("img/menu/main-menu.png"));

        Gdx.graphics.setCursor(MouseCursorUtils.getMenuCursor());

        startButton = new TextButton(400, 400, 500, 200, ConstantsButton.BUTTON_COLOR, ConstantsButton.BORDER_COLOR, "START GAME");
    }

    @Override
    public void show() {}

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.shape.begin(ShapeRenderer.ShapeType.Filled);
        startButton.render(game.shape);
        game.shape.end();

        game.batch.begin();
        game.batch.draw(background, 0, 0);
        startButton.renderText(game.batch);
        game.batch.end();

        if (Gdx.input.isTouched()) {
            game.setScreen(new GameScreen(game));
            dispose();
        }
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

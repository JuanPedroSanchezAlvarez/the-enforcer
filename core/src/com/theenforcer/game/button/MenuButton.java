package com.theenforcer.game.button;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class MenuButton {

    private final float x, y, width, height;
    private final String text;

    public MenuButton(final float x, final float y, final float width, final float height, final String text) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text = text;
    }

    public void draw(final ShapeRenderer shape) {
        shape.setColor(ConstantsButton.BUTTON_COLOR);
        shape.rect(x, y, width, height);
        shape.setColor(ConstantsButton.BORDER_COLOR);
        shape.rect(x + ConstantsButton.BORDER_POSITION, y + ConstantsButton.BORDER_POSITION, width - ConstantsButton.BORDER_SIZE, height - ConstantsButton.BORDER_SIZE);
        shape.setColor(ConstantsButton.BUTTON_COLOR);
        shape.rect(x + ConstantsButton.INNER_POSITION, y + ConstantsButton.INNER_POSITION, width - ConstantsButton.INNER_SIZE, height - ConstantsButton.INNER_SIZE);
    }

    public void drawText(final BitmapFont font, final SpriteBatch batch) {
        font.draw(batch, text, x + width / 2 - text.length(), y + 15);
    }

}

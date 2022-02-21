package com.theenforcer.game.button;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.theenforcer.game.TheEnforcerGame;

public class TextButton extends AbstractButton {

    private Color color, borderColor;
    private Label label;

    public TextButton(final float x, final float y, final float width, final float height, final Color color, final Color borderColor, final String text) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.borderColor = borderColor;
        this.label = new Label(text, TheEnforcerGame.labelStyle);
        this.label.getGlyphLayout().setText(TheEnforcerGame.labelStyle.font, text);
        this.label.setPosition(x + (width - this.label.getGlyphLayout().width) / 2, y - this.label.getGlyphLayout().height + height / 2);
    }

    public void render(final ShapeRenderer shape) {
        shape.setColor(color);
        shape.rect(x, y, width, height);
        shape.setColor(borderColor);
        shape.rect(x + ConstantsButton.BORDER_POSITION, y + ConstantsButton.BORDER_POSITION, width - ConstantsButton.BORDER_SIZE, height - ConstantsButton.BORDER_SIZE);
        shape.setColor(color);
        shape.rect(x + ConstantsButton.INNER_POSITION, y + ConstantsButton.INNER_POSITION, width - ConstantsButton.INNER_SIZE, height - ConstantsButton.INNER_SIZE);
    }

    public void renderText(final SpriteBatch batch) {
        label.draw(batch, 1);
    }

}

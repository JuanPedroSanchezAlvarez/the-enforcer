package com.theenforcer.game.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.Pixmap;

public final class MouseCursorUtils {
    private MouseCursorUtils() {}

    private static Pixmap pixmap;
    private static Cursor cursor;

    public static Cursor getMenuCursor() {
        pixmap = new Pixmap(32, 32, Pixmap.Format.RGBA8888);
        pixmap.setBlending(Pixmap.Blending.None);
        pixmap.setColor(Color.BLUE);
        pixmap.fillTriangle(10, 1, 16, 14, 23, 1);
        pixmap.fillTriangle(10, 1, 17, 14, 23, 1);
        pixmap.fillTriangle(1, 10, 14, 16, 1, 23);
        pixmap.fillTriangle(1, 10, 14, 17, 1, 23);
        pixmap.fillTriangle(10, 32, 16, 19, 23, 32);
        pixmap.fillTriangle(10, 32, 17, 19, 23, 32);
        pixmap.fillTriangle(32, 10, 19, 16, 32, 23);
        pixmap.fillTriangle(32, 10, 19, 17, 32, 23);
        cursor = Gdx.graphics.newCursor(pixmap, 16, 16);
        return cursor;
    }

    public static Cursor getGameCursor() {
        pixmap = new Pixmap(32, 32, Pixmap.Format.RGBA8888);
        pixmap.setBlending(Pixmap.Blending.None);
        pixmap.setColor(Color.BLUE);
        pixmap.drawCircle(16, 16, 8);
        pixmap.drawCircle(17, 17, 8);
        pixmap.drawCircle(16, 17, 8);
        pixmap.drawCircle(17, 16, 8);
        pixmap.drawCircle(16, 16, 10);
        pixmap.drawCircle(17, 17, 10);
        pixmap.drawCircle(16, 17, 10);
        pixmap.drawCircle(17, 16, 10);
        pixmap.drawCircle(16, 16, 14);
        pixmap.drawCircle(17, 17, 14);
        pixmap.drawCircle(16, 17, 14);
        pixmap.drawCircle(17, 16, 14);
        pixmap.drawLine(16, 2, 16, 31);
        pixmap.drawLine(17, 2, 17, 31);
        pixmap.drawLine(2, 16, 31, 16);
        pixmap.drawLine(2, 17, 31, 17);
        cursor = Gdx.graphics.newCursor(pixmap, 16, 16);
        return cursor;
    }

}

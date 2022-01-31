package com.theenforcer.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.theenforcer.game.TheEnforcerGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "The Enforcer";
		config.width = 800;
		config.height = 480;
		new LwjglApplication(new TheEnforcerGame(), config);
	}
}

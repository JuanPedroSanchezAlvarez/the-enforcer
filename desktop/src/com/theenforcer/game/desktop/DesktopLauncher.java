package com.theenforcer.game.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.theenforcer.game.TheEnforcerGame;
import com.theenforcer.game.configuration.ConstantsConfiguration;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = ConstantsConfiguration.GAME_TITLE;
		config.addIcon("img/favicon128.png", Files.FileType.Internal);
		config.addIcon("img/favicon32.png", Files.FileType.Internal);
		config.addIcon("img/favicon16.png", Files.FileType.Internal);
		config.width = ConstantsConfiguration.SCREEN_WIDTH;
		config.height = ConstantsConfiguration.SCREEN_HEIGHT;
		new LwjglApplication(new TheEnforcerGame(), config);
	}
}

package com.holmgren.ethan.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.holmgren.ethan.Kings;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		//System.setProperty("org.lwjgl.opengl.Window.undecorated", "true");
		config.width = 1760;
		config.height = 960;

		new LwjglApplication(new Kings(), config);
	}
}

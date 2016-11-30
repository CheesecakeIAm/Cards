package com.holmgren.ethan;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import Helpers.AssetLoader;
import Screens.GameScreen;

public class Kings extends Game {

	@Override
	public void create () {
		Gdx.app.log("Kings","Created");
		AssetLoader.load();
		setScreen(new GameScreen());
	}

	@Override
	public void dispose () {
		super.dispose();
		AssetLoader.dispose();
	}
}

package com.lobsterchops.abyssallogs.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class GameScreen implements Screen {
	
	private ScreenManager screenManager;
	
	private FitViewport viewport;
	
	private SpriteBatch batch;
	private BitmapFont font;
	private GlyphLayout layout;
	
	// graphics textures: background, submarine
	
	public GameScreen(ScreenManager screenManager) {
		this.screenManager = screenManager;
	}

	@Override
	public void show() {
		
	}

	@Override
	public void render(float delta) {
		
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void hide() {
		
	}

	@Override
	public void dispose() {
		
	}

}

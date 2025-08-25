package com.lobsterchops.abyssallogs.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class LaunchScreen implements Screen {
	
	private FitViewport viewport;
	
	private ScreenManager screenManager;
	private SpriteBatch batch;
	private BitmapFont font;
	private GlyphLayout layout;
    private float blinkTimer;
    private boolean showText;
    
    Texture launchScreenTexture;
    
    Music launchMenuMusic;
    
    public LaunchScreen(ScreenManager screenManager) {
    	this.screenManager = screenManager;
    	this.batch = new SpriteBatch();
    	this.font = new BitmapFont();
    	this.layout = new GlyphLayout();
    	this.blinkTimer = 0f;
    	this.showText = true;
    	
    	font.getData().setScale(2.0f);
    	font.setColor(Color.WHITE);
    }
	

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
		int screenWidth = Gdx.graphics.getWidth();
		int screenHeight = Gdx.graphics.getHeight();
		
		viewport = new FitViewport(screenWidth, screenHeight);
		
		launchScreenTexture = new Texture(""); // TODO: create dark blue launch menu bg texture
		
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}

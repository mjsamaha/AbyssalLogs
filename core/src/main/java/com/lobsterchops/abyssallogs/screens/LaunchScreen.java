package com.lobsterchops.abyssallogs.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
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
		
		int screenWidth = Gdx.graphics.getWidth();
		int screenHeight = Gdx.graphics.getHeight();
		
		viewport = new FitViewport(screenWidth, screenHeight);
		
		launchScreenTexture = new Texture(""); // TODO: create dark blue launch menu bg texture
		
	}

	@Override
	public void render(float delta) {
		handleInput();
		
		blinkTimer += delta;
		if (blinkTimer >= 0.8f) {
			showText = !showText;
			blinkTimer = 0f;
		}
		
		draw();
		
		
		
	}
	
	private void handleInput() {
		if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
			screenManager.setScreen(
					new GameScreen(screenManager),
					ScreenManager.TransitionType.SLIDE_LEFT, 0.7f
			);
		}
		
		if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
        } 
	}
	
	private void draw() {
		ScreenUtils.clear(Color.BLACK);
		viewport.apply();
		batch.setProjectionMatrix(viewport.getCamera().combined);
		
		batch.begin();
		
		float worldWidth = viewport.getWorldWidth();
		float worldHeight = viewport.getWorldHeight();
		
		// bg first
		
		// credits/developer
		
		// blinking prompt; to menu screen
		
		
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		viewport.update(width, height, true); // without true, centerCamera!
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

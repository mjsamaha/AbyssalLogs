package com.lobsterchops.abyssallogs.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class GameScreen implements Screen {
	
	private ScreenManager screenManager;
	private FitViewport viewport;
	private SpriteBatch batch;
	private BitmapFont font;
	private GlyphLayout layout;
	
	private float autoTransitionTimer;
    private static final float AUTO_TRANSITION_DURATION = 3.0f; // 3 seconds to allow viewing
	
	
	Texture mainMenuScreenTexture;
	
	
	// graphics textures: background, submarine
	
	public GameScreen(ScreenManager screenManager) {
		this.screenManager = screenManager;
		this.batch = new SpriteBatch();
		this.font = new BitmapFont();
		this.layout = new GlyphLayout();
		
		font.getData().setScale(2.0f);
		font.setColor(Color.WHITE);
	}

	@Override
	public void show() {
		int screenWidth = Gdx.graphics.getWidth();
		int screenHeight = Gdx.graphics.getHeight();
		
		viewport = new FitViewport(screenWidth, screenHeight);
		
		mainMenuScreenTexture = new Texture("background.png");
		
	}

	@Override
	public void render(float delta) {
		handleInput();
		
		// Auto-transition to MainMenuScreen after 3 seconds with long fade
        if (autoTransitionTimer >= AUTO_TRANSITION_DURATION) {
            screenManager.setScreen(
                new MainMenuScreen(screenManager),
                ScreenManager.TransitionType.FADE,
                2.0f  // 2 second fade duration
            );
        }
        
		draw();

	}
	
	private void handleInput() {
		if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
			screenManager.setScreen(new GameScreen(screenManager), ScreenManager.TransitionType.SLIDE_LEFT, 0.7f);
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

        batch.draw(mainMenuScreenTexture, 0, 0, worldWidth, worldHeight);
        
        batch.end();
		
	}

	@Override
	public void resize(int width, int height) {
		viewport.update(width, height, true);
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
		if (mainMenuScreenTexture != null) {
			mainMenuScreenTexture.dispose();
		}
	}

}

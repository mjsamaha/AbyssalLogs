package com.lobsterchops.abyssallogs.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class SplashScreen implements Screen {
    
    private ScreenManager screenManager;
    private SpriteBatch batch;
    private FitViewport viewport;
    private float timer;
    private static final float SPLASH_DURATION = 2.0f; // 2 seconds to allow for longer viewing
    
    public SplashScreen(ScreenManager screenManager) {
        this.screenManager = screenManager;
        this.batch = new SpriteBatch();
        this.timer = 0f;
    }
    
    @Override
    public void show() {
        int screenWidth = Gdx.graphics.getWidth();
        int screenHeight = Gdx.graphics.getHeight();
        viewport = new FitViewport(screenWidth, screenHeight);
    }
    
    @Override
    public void render(float delta) {
    	timer += delta;

        ScreenUtils.clear(Color.BLACK);
        viewport.apply();
        batch.setProjectionMatrix(viewport.getCamera().combined);

        batch.begin();
        // black screen only
        batch.end();

        // After SPLASH_DURATION, go to LaunchScreen
        if (timer >= SPLASH_DURATION) {
            screenManager.setScreen(
                new LaunchScreen(screenManager),
                ScreenManager.TransitionType.FADE,
                1.0f // fade duration
            );
        }
    }
    
    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }
    
    @Override
    public void pause() {}
    
    @Override
    public void resume() {}
    
    @Override
    public void hide() {}
    
    @Override
    public void dispose() {
        if (batch != null) {
            batch.dispose();
        }
    }
}

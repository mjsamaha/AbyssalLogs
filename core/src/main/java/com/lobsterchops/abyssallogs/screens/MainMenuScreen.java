package com.lobsterchops.abyssallogs.screens;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class MainMenuScreen implements Screen {

    private ScreenManager screenManager;
    private SpriteBatch batch;
    private FitViewport viewport;
    private BitmapFont font;
    private GlyphLayout layout;

    private String promptText = "Press ENTER to Play";

    public MainMenuScreen(ScreenManager screenManager) {
        this.screenManager = screenManager;
        this.batch = new SpriteBatch();
        this.font = new BitmapFont();
        this.layout = new GlyphLayout();

        // Configure font
        font.getData().setScale(2.0f);
        font.setColor(Color.WHITE);
    }

    @Override
    public void show() {
        int screenWidth = Gdx.graphics.getWidth();
        int screenHeight = Gdx.graphics.getHeight();
        viewport = new FitViewport(screenWidth, screenHeight);
    }

    @Override
    public void render(float delta) {
        // Clear screen to black as requested
        handleInput();
        ScreenUtils.clear(Color.BLACK);
        viewport.apply();
        batch.setProjectionMatrix(viewport.getCamera().combined);

        batch.begin();

        // Draw the prompt text centered on screen
        float worldWidth = viewport.getWorldWidth();
        float worldHeight = viewport.getWorldHeight();

        layout.setText(font, promptText);
        float textX = (worldWidth - layout.width) / 2;
        float textY = (worldHeight + layout.height) / 2; // Center vertically

        font.draw(batch, promptText, textX, textY);

        batch.end();
    }

    private void handleInput() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
            screenManager.setScreen(new MainMenuScreen(screenManager));
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
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
        if (font != null) {
            font.dispose();
        }
    }

}

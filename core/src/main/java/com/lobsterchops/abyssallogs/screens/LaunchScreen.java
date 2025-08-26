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

    private float autoTransitionTimer;
    private static final float AUTO_TRANSITION_DURATION = 1.0f; // ⬅ only wait 1 second

    private String productionText = "A LobsterChops Production";

    Texture launchScreenTexture;

    public LaunchScreen(ScreenManager screenManager) {
        this.screenManager = screenManager;
        this.batch = new SpriteBatch();
        this.font = new BitmapFont();
        this.layout = new GlyphLayout();
        this.autoTransitionTimer = 0f;

        font.getData().setScale(2.5f);
        font.setColor(Color.WHITE);
    }

    @Override
    public void show() {
        int screenWidth = Gdx.graphics.getWidth();
        int screenHeight = Gdx.graphics.getHeight();
        viewport = new FitViewport(screenWidth, screenHeight);

        launchScreenTexture = new Texture("background.png");
    }

    @Override
    public void render(float delta) {
        handleInput();
    	 update(delta);
    	 draw();
    }

    private void handleInput() {
    	if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
            screenManager.setScreen(new MainMenuScreen(screenManager));
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
        }
    }

    private void update(float delta) {
        autoTransitionTimer += delta;
        if (autoTransitionTimer >= AUTO_TRANSITION_DURATION) {
            screenManager.setScreen(new MainMenuScreen(screenManager), ScreenManager.TransitionType.FADE, 0.0f); // Instant transition
        }
        handleInput();
    }


    private void draw() {
    	ScreenUtils.clear(Color.BLACK);
        viewport.apply();
        batch.setProjectionMatrix(viewport.getCamera().combined);
        batch.begin();

        float worldWidth = viewport.getWorldWidth();
        float worldHeight = viewport.getWorldHeight();
        batch.draw(launchScreenTexture, 0, 0, worldWidth, worldHeight);
        layout.setText(font, productionText);
        float textX = (worldWidth - layout.width) / 2;
        float textY = (worldHeight + layout.height) / 2;
        font.draw(batch, productionText, textX, textY);

        batch.end();
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
        if (launchScreenTexture != null) launchScreenTexture.dispose();
        if (font != null) font.dispose();
    }
}

package com.lobsterchops.abyssallogs;

import com.badlogic.gdx.Game;
import com.lobsterchops.abyssallogs.screens.LaunchScreen;
import com.lobsterchops.abyssallogs.screens.ScreenManager;
import com.lobsterchops.abyssallogs.screens.SplashScreen;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends Game {
	
	private ScreenManager screenManager;
	
	
	@Override
    public void create() {
        screenManager = new ScreenManager(this);
        // Start with SplashScreen (black screen) instead of LaunchScreen
        screenManager.setScreen(new SplashScreen(screenManager));
    }

    public ScreenManager getScreenManager() {
        return screenManager;
    }

    @Override
    public void dispose() {
        super.dispose();
        if (screenManager != null && screenManager.getCurrentScreen() != null) {
            screenManager.getCurrentScreen().dispose();
        }
    }
}
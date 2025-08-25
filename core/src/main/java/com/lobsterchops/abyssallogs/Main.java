package com.lobsterchops.abyssallogs;

import com.badlogic.gdx.Game;
import com.lobsterchops.abyssallogs.screens.LaunchScreen;
import com.lobsterchops.abyssallogs.screens.ScreenManager;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends Game {
	
	private ScreenManager screenManager;
	
	
    @Override
    public void create() {
        screenManager = new ScreenManager(this);
        screenManager.setScreen(new LaunchScreen(screenManager));
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
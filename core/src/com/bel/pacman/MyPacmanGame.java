package com.bel.pacman;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bel.pacman.screen.GameScreen;

public class MyPacmanGame extends Game {
    public SpriteBatch batch;
//    public static final int WIDTH = 800;
//    public static final int HEIGHT = 520;


    @Override
    public void create() {
        batch = new SpriteBatch();
        setScreen(new GameScreen(this));

    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}

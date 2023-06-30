package com.bel.pacman.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.bel.pacman.MyPacmanGame;
import com.bel.pacman.model.Pacman;
import com.bel.pacman.model.World;
import com.bel.pacman.model.WorldRenderer;

public class GameScreen extends ScreenAdapter {
    public MyPacmanGame myPacmanGame;
    private World world;
    private WorldRenderer worldRenderer;


    public GameScreen(MyPacmanGame myPacmanGame) {
        this.myPacmanGame = myPacmanGame;
        world = new World(myPacmanGame);
        worldRenderer = new WorldRenderer(myPacmanGame, world);
    }

    @Override
    public void render(float delta) {
        updatePacmanDirection();
        worldRenderer.update(delta);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        worldRenderer.render(delta);
    }

    public void updatePacmanDirection() {
        Pacman pacman = world.getPacman();
        pacman.update();
        pacman.setNextDirection(Pacman.DIRECTION_STILL);
    }

}
